package foro.hub.foro.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="topicos")
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String nombreCurso;
    private LocalDateTime fechaCreacion;
    private Status status;

    private String autor;
    public Topico(TopicoDto topicoDto) {

        this.nombreCurso = String.valueOf(topicoDto.nombreCurso());
        this.mensaje = topicoDto.mensaje();
        this.titulo = topicoDto.titulo();
        this.fechaCreacion = LocalDateTime.now(); // Asignar fecha de creación automáticamente
        this.status = Status.ACTIVO;
        this.autor = topicoDto.autor();
    }
    public Topico() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void actualizarTopico(@Valid ActualizarTopicoDto actualizarTopicoDto) {
        if (actualizarTopicoDto.nombreCurso()!= null){
            this.nombreCurso = String.valueOf(actualizarTopicoDto.nombreCurso());
        }
        if (actualizarTopicoDto.mensaje()!= null){
            this.mensaje = actualizarTopicoDto.mensaje();
        }
        if (actualizarTopicoDto.titulo()!= null){
            this.titulo = actualizarTopicoDto.titulo();
        }
    }
}
