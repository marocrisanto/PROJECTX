package com.example.demo.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id // @Id indica que el atributo es una llave primaria.
    @GeneratedValue //@GeneratedValue indica que el valor de este campo será generado automáticamente.
    private long id;

    @Column(name = "fecha_contratacion")
    private Date fechaContratacion; // Fecha cuando se crea la factura.

    @Column(unique = true)
    private int folio; // El folio único de la factura.

    @Column
    private String descripcionPaquete; // Por ejemplo: "PAQUETE ORO"

    @Column(name = "monto_inicial_contratado")
    private double montoInicialContratado; // Monto total acordado al contratar.

    @Column(name = "saldo")
    private Double saldo;  // Monto pendiente por pagar.

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public double getMontoInicialContratado() {
        return montoInicialContratado;
    }

    public void setMontoInicialContratado(double montoInicialContratado) {
        this.montoInicialContratado = montoInicialContratado;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
