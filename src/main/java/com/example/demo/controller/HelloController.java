package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String hello(@RequestBody Pessoa pessoa) {
        return "Olá, " + pessoa.getNome() + 
               ". Você tem " + pessoa.getIdade() + " anos.";
    }
}
