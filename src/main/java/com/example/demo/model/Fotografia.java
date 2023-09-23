package com.example.demo.model;


import javax.persistence.*;
/*
El flujo de trabajo sería:

    Se crea una cita para el cliente, que le indica cuándo tendrá su sesión fotográfica.
    Una vez tomadas las fotos, se cargan en el sistema. Por defecto, todas las fotos tendrán una marca de agua.
    El cliente ingresa a su cuenta y ve todas las fotos (con marca de agua). Puede seleccionar cierto número de fotos.
    Cuando el cliente paga, la marca de agua de las fotos seleccionadas se elimina, permitiendo la descarga.
 */

@Entity // @Entity indica que esta clase es una entidad y será mapeada a una tabla en la base de datos.
@Table(name = "fotografias") // @Table define el nombre de la tabla en la base de datos.
public class Fotografia {

    @Id  // @Id indica que el atributo es una llave primaria.
    @GeneratedValue //@GeneratedValue indica que el valor de este campo será generado automáticamente.
    private long id;
    @Column (name = "url_imagen")// @Column se usa para especificar detalles del mapeo de columna.
    private String urlImagen; // Suponiendo que las imágenes se almacenen en algún servicio de almacenamiento y solo guardemos su URL en la BD.

    @ManyToOne  // Una fotografía está asociada con una cita.
    @JoinColumn (name = "cita_id") //
    private Cita cita;

    @Column(name = "seleccionada")
    private Boolean seleccionada; // Si el cliente ha seleccionado esta foto

    @Column(name = "marca_agua")
    private Boolean marcaAgua; // Si la foto tiene marca de agua o no.

    @Column(name = "saldo")
    private Double saldo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public Boolean getMarcaAgua() {
        return marcaAgua;
    }

    public void setMarcaAgua(Boolean marcaAgua) {
        this.marcaAgua = marcaAgua;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
