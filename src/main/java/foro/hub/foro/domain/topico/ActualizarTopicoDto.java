package foro.hub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDto(@NotNull Long id, String titulo, String mensaje, String nombreCurso) {
}