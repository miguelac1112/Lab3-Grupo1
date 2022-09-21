package com.example.lab3.Controller;

import com.example.lab3.Entity.Department;
import com.example.lab3.Entity.Employee;
import com.example.lab3.Repository.DepartmentRepository;
import com.example.lab3.Repository.EmployeeRepository;
import com.example.lab3.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lab3.Entity.Employee;
import com.example.lab3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/empleado")
public class UsuarioController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @GetMapping("/listar")
    String listaUsuario(Model model){
        model.addAttribute("listaEmpleados",employeeRepository.obtenerEmpleados());
        return "Empleados/list";
    }



    @GetMapping(value={"/nuevo"})
    public String nuevoEmployee(Model model){
        model.addAttribute("listaJefes",employeeRepository.buscaJefes());
        model.addAttribute("listaJobs",jobRepository.findAll());
        model.addAttribute("listaDepartment",departmentRepository.findAll());

        return "Empleados/newForm";
    }

    @PostMapping(value = {"/guardar"})
    public String guardarEmployee(Employee employee, RedirectAttributes attr){
        employeeRepository.save(employee);
        employeeRepository.GuardarContrasena(employee.getPassword(),employee.getId());
        if(employee.getId()!=0){
            attr.addFlashAttribute("guardado","El empleado se ha editado exitosamente");
        }else{
            attr.addFlashAttribute("guardado","El empleado se ha creado exitosamente");
        }
        return "redirect:/empleado";
    }

    @GetMapping("/edit")
    public String editarEmpleado(Model model,
                                      @RequestParam("id") int id) {

        System.out.println(id);

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("empleado", employee);
            model.addAttribute("listaTrabajo",jobRepository.findAll());
            model.addAttribute("listaJefe",employeeRepository.findAll());
            return "Empleados/editFrm";
        } else {
            return "redirect:/empleado/listar";
        }
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@RequestParam("id") int id,
                                     @RequestParam("idmanager") String idmanager,
                                     @RequestParam("idjob") int idjob,
                                            RedirectAttributes redirectAttributes) {

        String texto;
        texto = "Transportista actualizado exitosamente";

        employeeRepository.actualizarEmpleado(idmanager,idjob,id);

        redirectAttributes.addFlashAttribute("msg", texto);

        return "redirect:/empleado/listar";
    }



}
