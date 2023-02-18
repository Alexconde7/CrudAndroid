package com.example.crudandroid.modelo;

import java.util.Objects;

public class Usuario {

    private String email;
    private String nombre;
    private String apellidos;
    private String contra;
    private String confirmarContra;

    public Usuario(String email, String nombre, String apellidos, String contra, String confirmarContra) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contra = contra;
        this.confirmarContra = confirmarContra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getConfirmarContra() {
        return confirmarContra;
    }

    public void setConfirmarContra(String confirmarContra) {
        this.confirmarContra = confirmarContra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nombre, apellidos);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contra='" + contra + '\'' +
                ", confirmarContra='" + confirmarContra + '\'' +
                '}';
    }
}
