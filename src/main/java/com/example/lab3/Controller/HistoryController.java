package com.example.lab3.Controller;

import com.example.lab3.Entity.Employee;
import com.example.lab3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/History")
public class HistoryController {
    //Nombre completo, puesto, Departamento, Jefe, Fecha inicio, Fecha fin, mas nuevo a mas antiguo
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/listar")

    public String historialLista(Model model){
        List<Employee> lista_empleados = employeeRepository.findAll();
        model.addAttribute("shipperList", lista_empleados);

    }


}
