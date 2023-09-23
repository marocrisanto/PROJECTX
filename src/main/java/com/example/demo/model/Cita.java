package com.example.demo.model;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity // Esta anotación indica que esta clase es una entidad que se mapeará a una tabla en la base de datos.
@Table(name ="citas") // define el nombre de la tabla en la base de datos a la que estará mapeada la entidad.
public class Cita {

    @Id //indica que el atributo es una llave primaria.
    @GeneratedValue //@GeneratedValue indica que el valor de este campo será generado automáticamente.
    private Long id;

    @Column(name = "fecha_hora")//Column se usa para especificar detalles del mapeo de columna
    private LocalDateTime fechaHora;

    @ManyToOne // @ManyToOne indica una relación de muchos a uno.  En este caso, mochas citas pueden estar asociadas a un evento específico.
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne //Una cita está asociada con un empleado (por ejemplo, el fotógrafo que tomará las fotografías).
    @JoinColumn //@JoinColumn define el nombre de la columna que actúa como llave foránea en esta relación.
    private Usuario empleado;

    @Column(name = "tipo_cita") //Este campo representará el tipo de cita: 'individual' o 'grupal'
    private String tipoCita;

    @Column(name = "recordatorio")   // Mensaje recordatorio para el cliente.
    private String recordatorio; // "Foto individual", "Foto grupal", etc.

    private boolean confirmada;

    private boolean cancelada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
}


