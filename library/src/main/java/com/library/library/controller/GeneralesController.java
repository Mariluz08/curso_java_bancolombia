package com.library.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.model.Libreria;

@RestController
@RequestMapping("generales")
public class GeneralesController {

    private Libreria libreria;

    public GeneralesController() {
        libreria = new Libreria();
        libreria.setDireccion("centro");
        libreria.setHorario("9 a 12");
        libreria.setNombre("central");
        libreria.setTelefono("9898989");
    }

    @GetMapping("/")
    public Libreria info() {
        return libreria;
    }

    @GetMapping("/nombre")
    public String nombre() {
        return libreria.getNombre();
    }

    @GetMapping("/direccion")
    public String direccion() {
        return libreria.getDireccion();
    }
}
