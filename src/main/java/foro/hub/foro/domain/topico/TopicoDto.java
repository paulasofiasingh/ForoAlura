package foro.hub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.time.LocalDateTime;

public record TopicoDto(Long id, @NotBlank String titulo, @NotBlank String mensaje, @NotBlank String nombreCurso, @NotBlank String autor,
LocalDateTime fechaCreacion, Status status) {
    public TopicoDto(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(), topico.getAutor(), topico.getFechaCreacion(), topico.getStatus());
    }
}
