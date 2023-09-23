package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pagos")
public class Pago {

    /* Cada Pago se relaciona con una Factura.
    Al generar un recibo o factura en formato PDF, puedes recopilar información de la entidad Factura y agregar todos los pagos relacionados con esa factura específica.
    Para obtener el saldo pendiente, simplemente resta la suma de todos los pagos del monto total de la factura

    */
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    @Column(name = "monto_pagado")
    private Double montoPagado;

    @Column(name = "forma_pago")
    private String formaPago; // Ejemplos: "efectivo", "transferencia", etc.

    //Este atributo es para asociar con la factura
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
