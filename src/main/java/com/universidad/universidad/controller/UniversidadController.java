package com.universidad.universidad.controller;

import com.universidad.universidad.model.Administrativo;
import com.universidad.universidad.model.Estudiante;
import com.universidad.universidad.model.Profesor;
import com.universidad.universidad.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {

    private final UniversidadService universidadService;

    @Autowired
    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    @PostMapping("/login/estudiante")
    public boolean loginEstudiante(@RequestBody Estudiante estudiante,
                                   @RequestParam String usuario,
                                   @RequestParam String password) {
        return universidadService.loginEstudiante(estudiante, usuario, password);
    }

    @PostMapping("/login/profesor")
    public boolean loginProfesor(@RequestBody Profesor profesor,
                                 @RequestParam String usuario,
                                 @RequestParam String password) {
        return universidadService.loginProfesor(profesor, usuario, password);
    }

    @PostMapping("/login/administrativo")
    public boolean loginAdministrativo(@RequestBody Administrativo administrativo,
                                       @RequestParam String usuario,
                                       @RequestParam String password) {
        return universidadService.loginAdministrativo(administrativo, usuario, password);
    }

    @PostMapping("/notificar/estudiante")
    public String notificarEstudiante(@RequestBody Estudiante estudiante,
                                      @RequestParam String mensaje) {
        universidadService.notificarEstudiante(estudiante, mensaje);
        return "Notificación enviada al estudiante";
    }

    @PostMapping("/notificar/profesor")
    public String notificarProfesor(@RequestBody Profesor profesor,
                                    @RequestParam String mensaje) {
        universidadService.notificarProfesor(profesor, mensaje);
        return "Notificación enviada al profesor";
    }

    @PostMapping("/notificar/administrativo")
    public String notificarAdministrativo(@RequestBody Administrativo administrativo,
                                          @RequestParam String mensaje) {
        universidadService.notificarAdministrativo(administrativo, mensaje);
        return "Notificación enviada al administrativo";
    }

    @PostMapping("/evaluar")
    public String evaluarEstudiante(@RequestBody Profesor profesor,
                                    @RequestParam String nombreEstudiante,
                                    @RequestParam String correoEstudiante,
                                    @RequestParam String codigoEstudiante,
                                    @RequestParam double nota) {

        Estudiante estudiante = new Estudiante(nombreEstudiante, correoEstudiante, codigoEstudiante);
        universidadService.evaluarEstudiante(profesor, estudiante, nota);
        return "Estudiante evaluado correctamente";
    }

    @PostMapping("/aprobar")
    public String aprobarSolicitud(@RequestBody Administrativo administrativo,
                                   @RequestParam String codigoSolicitud) {
        universidadService.aprobarSolicitud(administrativo, codigoSolicitud);
        return "Solicitud aprobada correctamente";
    }
}