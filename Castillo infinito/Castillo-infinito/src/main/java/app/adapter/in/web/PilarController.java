
package app.adapter.in.web;

import app.aplication.port.input.PilarUseCase;
import app.domain.model.Pilar;
import app.shared.dto.PilarUpdateRequest;
import app.shared.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {

    private final PilarUseCase pilarUseCase;

    public PilarController(PilarUseCase pilarUseCase) {
        this.pilarUseCase = pilarUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPilar(@PathVariable Long id) {
        try {
            Pilar pilar = pilarUseCase.obtenerPilar(id);
            return ResponseEntity.ok().body(pilar);
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/actualizar-posicion")
    public ResponseEntity<?> actualizarPosicion(@RequestBody PilarUpdateRequest req) {
        if (req.getPilarId() == null)
            return ResponseEntity.badRequest().body("pilarId es requerido");

        try {
            Pilar actualizado = pilarUseCase.actualizarPosicion(
                    req.getPilarId(),
                    req.getPosX(),
                    req.getPosY(),
                    req.getEstado()
            );
            return ResponseEntity.status(201).body(
                    java.util.Map.of("mensaje", "Posición actualizada exitosamente.", "pilar", actualizado)
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }
}
