package com.universidad.universidad.model;

import com.universidad.universidad.interfaces.Autenticable;
import com.universidad.universidad.interfaces.Notificable;

public class Estudiante extends Persona implements Notificable, Autenticable {

    private String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        super(nombre, correo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación para estudiante " + getNombre() + ": " + mensaje);
    }

    @Override
    public boolean login(String usuario, String password) {
        return usuario != null && !usuario.isBlank()
                && password != null && !password.isBlank();
    }
}