package com.example.lab3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class UsuarioController {
    @GetMapping("")
    String listaUsuario(){
        return "Empleados/newForm";
    }
}
