package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity // Esta anotación indica que esta clase es una entidad que se mapeará a una tabla en la base de datos.
@Table(name ="eventos") // define el nombre de la tabla en la base de datos a la que estará mapeada la entidad.
public class Evento {

    @Id //indica que el atributo es una llave primaria.
    @GeneratedValue //@GeneratedValue indica que el valor de este campo será generado automáticamente.
    private Long Id;

    @Column(name = "nombre")//Column se usa para especificar detalles del mapeo de columna
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "ubicacion")
    private String ubicacion;

    @ManyToOne //Indica una relación de muchos a uno. Muchos eventos pueden estar asociados a un usuario. Esto podría representar al administrador o empleado que creó el evento.
    @JoinColumn(name = "usuario_id")//@JoinColumn define el nombre de la columna que actúa como llave foránea en esta relación.
    private Usuario usuario;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
