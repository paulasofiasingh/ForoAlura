package foro.hub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoDto(Long id, @NotBlank String titulo, @NotBlank String mensaje, @NotBlank String nombreCurso) {
    public TopicoDto(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso());
    }
}
