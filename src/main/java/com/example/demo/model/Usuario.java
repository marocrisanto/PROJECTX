package com.example.demo.model;


import javax.persistence.*;

//entidad Usuario que tenga un campo de "rol" para determinar si es Owner, Admin, Empleado o Cliente.
@Entity // Esta anotación indica que esta clase es una entidad que se mapeará a una tabla en la base de datos.
@Table(name = "usuarios") // define el nombre de la tabla en la base de datos a la que estará mapeada la entidad.
public class Usuario {

    @Id //indica que el atributo es una llave primaria.
    @GeneratedValue //@GeneratedValue indica que el valor de este campo será generado automáticamente.
    private Long id;

    @Column (name = "nombre")//Column se usa para especificar detalles del mapeo de columna
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email", unique = true) //La propiedad unique = true dentro de la anotación @Column asegura que el valor de esa columna en particular es único en toda la tabla. En otras palabras, no puede haber dos registros en la tabla que tengan el mismo valor para esa columna.
    private String email;

    @Column(name = "password")
    private String password;

    @Column
    private String confirmationToken;

    @Column(name = "rol")
    private String rol; // Podría ser 'owner', 'admin', 'empleado', o 'cliente'
    //Owner =  soy yo como desarrollador
    //admin = el cliente (algun otro desarrollador o empleado backend)
    //admin = el cliente (Ej. higinio)
    //empleado = sus empleados

    @Column
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }
}
