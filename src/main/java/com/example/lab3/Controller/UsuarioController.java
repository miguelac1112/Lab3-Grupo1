package com.example.lab3.Controller;

import com.example.lab3.Entity.Employee;
import com.example.lab3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class UsuarioController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/listar")
    String listaUsuario(Model model){
        model.addAttribute("listaEmpleados",employeeRepository.obtenerEmpleados());
        return "Empleados/list";
    }
}
