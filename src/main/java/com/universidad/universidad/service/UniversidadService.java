package com.universidad.universidad.service;

import com.universidad.universidad.model.Administrativo;
import com.universidad.universidad.model.Estudiante;
import com.universidad.universidad.model.Profesor;
import org.springframework.stereotype.Service;

@Service
public class UniversidadService {

    public boolean loginEstudiante(Estudiante estudiante, String usuario, String password) {
        return estudiante.login(usuario, password);
    }

    public boolean loginProfesor(Profesor profesor, String usuario, String password) {
        return profesor.login(usuario, password);
    }

    public boolean loginAdministrativo(Administrativo administrativo, String usuario, String password) {
        return administrativo.login(usuario, password);
    }

    public void notificarEstudiante(Estudiante estudiante, String mensaje) {
        estudiante.enviarNotificacion(mensaje);
    }

    public void notificarProfesor(Profesor profesor, String mensaje) {
        profesor.enviarNotificacion(mensaje);
    }

    public void notificarAdministrativo(Administrativo administrativo, String mensaje) {
        administrativo.enviarNotificacion(mensaje);
    }

    public void evaluarEstudiante(Profesor profesor, Estudiante estudiante, double nota) {
        profesor.evaluar(estudiante, nota);
    }

    public void aprobarSolicitud(Administrativo administrativo, String codigoSolicitud) {
        administrativo.aprobarSolicitud(codigoSolicitud);
    }
}