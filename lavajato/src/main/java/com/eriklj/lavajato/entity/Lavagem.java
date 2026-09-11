package com.eriklj.lavajato.entity;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.*;

@Entity
@Table(name = "tb_lavagem") 
public class Lavagem {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    @Nonnull 
    private LocalTime hora;
    private double valor;

    @Enumerated(EnumType.STRING)
    private TipoLavagem tipo;

    @ManyToOne 
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    public Lavagem(LocalDate data, LocalTime hora, Usuario cliente, double valor, TipoLavagem tipo){
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.valor = valor;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoLavagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoLavagem tipo) {
        this.tipo = tipo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

}
