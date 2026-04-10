package com.universidad.universidad.model;

import com.universidad.universidad.interfaces.Autenticable;
import com.universidad.universidad.interfaces.Evaluador;
import com.universidad.universidad.interfaces.Notificable;

public class Profesor extends Persona implements Notificable, Autenticable, Evaluador {

    private String especialidad;

    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación para profesor " + getNombre() + ": " + mensaje);
    }

    @Override
    public boolean login(String usuario, String password) {
        return usuario != null && !usuario.isBlank()
                && password != null && !password.isBlank();
    }

    @Override
    public void evaluar(Estudiante estudiante, double nota) {
        System.out.println("Profesor " + getNombre() +
                " evaluó al estudiante " + estudiante.getNombre() +
                " con nota " + nota);
    }
}