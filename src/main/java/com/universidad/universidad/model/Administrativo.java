package com.universidad.universidad.model;

import com.universidad.universidad.interfaces.Aprobador;
import com.universidad.universidad.interfaces.Autenticable;
import com.universidad.universidad.interfaces.Notificable;

public class Administrativo extends Persona implements Notificable, Autenticable, Aprobador {

    private String area;

    public Administrativo(String nombre, String correo, String area) {
        super(nombre, correo);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void aprobarSolicitud(String codigoSolicitud) {
        System.out.println("Administrativo " + getNombre() +
                " aprobó la solicitud con código: " + codigoSolicitud);
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación para administrativo " + getNombre() + ": " + mensaje);
    }

    @Override
    public boolean login(String usuario, String password) {
        return usuario != null && !usuario.isBlank()
                && password != null && !password.isBlank();
    }
}