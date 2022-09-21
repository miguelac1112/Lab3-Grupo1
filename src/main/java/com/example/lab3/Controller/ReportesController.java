package com.example.lab3.Controller;

import com.example.lab3.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping("/inicio")
    public String inicio(){
        return "reporte/reporteInicio";
    }

    @GetMapping("/salario")
    public String salarioss(Model model){
        model.addAttribute("listaSalarios",jobRepository.salarios());
        return "reporte/salario";
    }
}
