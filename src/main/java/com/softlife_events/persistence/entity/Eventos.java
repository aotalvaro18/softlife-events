package com.softlife_events.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity

public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer idEvento;

    private String nombre;

    @Column(name = "fecha_ini")
    private Timestamp fechaInicial;

    @Column(name = "fecha_fin")
    private Timestamp fechaFinal;

    @Column(name = "categoria_id")
    private Integer idCategoria;

    private double valor;

    private Boolean estado;

    //GETTERS Y SETTERS


    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Timestamp getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Timestamp fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
