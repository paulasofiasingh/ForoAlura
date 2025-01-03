package foro.hub.foro.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

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
    public Topico(TopicoDto topicoDto) {

        this.nombreCurso = String.valueOf(topicoDto.nombreCurso());
        this.mensaje = topicoDto.mensaje();
        this.titulo = topicoDto.titulo();
    }
    public Topico() {
    }

    public Long getId() {
        return id;
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
