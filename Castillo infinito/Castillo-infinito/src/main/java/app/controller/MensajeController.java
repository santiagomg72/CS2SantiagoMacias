
package app.controller;

import app.dto.MensajeCreateDTO;
import app.dto.MensajeReconstruirDTO;
import app.entity.Mensaje;
import app.service.MensajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {
    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearMensaje(@RequestBody MensajeCreateDTO dto) {
        Mensaje creado = mensajeService.createMensaje(dto);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}/reconstruir")
    public ResponseEntity<Mensaje> reconstruirMensaje(@PathVariable Long id, @RequestBody MensajeReconstruirDTO dto) {
        Mensaje actualizado = mensajeService.reconstruirMensaje(id, dto);
        return ResponseEntity.ok(actualizado);
    }
    
}
