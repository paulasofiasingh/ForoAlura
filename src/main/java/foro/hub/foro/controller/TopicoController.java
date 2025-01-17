package foro.hub.foro.controller;

import foro.hub.foro.domain.topico.ActualizarTopicoDto;
import foro.hub.foro.domain.topico.Topico;
import foro.hub.foro.domain.topico.TopicoDto;
import foro.hub.foro.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid TopicoDto topicoDto) {
        topicoRepository.save(new Topico(topicoDto));
    }

    @GetMapping
    public List<Topico> listadoTopicos() {
        return topicoRepository.findAll();
    }

    // Nuevo endpoint para obtener los detalles de un tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> obtenerTopicoPorId(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var topico = topicoOptional.get();
        var detalleDto = new TopicoDto(
                topico.getId(),
                topico.getMensaje(),
                topico.getNombreCurso(),
                topico.getTitulo(),
                topico.getAutor(),
                topico.getFechaCreacion(),
                topico.getStatus()
        );

        return ResponseEntity.ok(detalleDto);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Void> actualizarTopico(@RequestBody @Valid ActualizarTopicoDto actualizarTopicoDto) {
        var topicoOptional = topicoRepository.findById(actualizarTopicoDto.id());

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no existe
        }

        var topico = topicoOptional.get();
        topico.actualizarTopico(actualizarTopicoDto); // Aplica los cambios al objeto
        topicoRepository.save(topico); // Guarda los cambios en la base de datos

        return ResponseEntity.noContent().build(); // Retorna 204 (sin contenido)
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si el tópico no existe
        }

        topicoRepository.deleteById(id); // Elimina directamente usando deleteById
        return ResponseEntity.noContent().build(); // Retorna 204 al eliminar exitosamente
    }


}

