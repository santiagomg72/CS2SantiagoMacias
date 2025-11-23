
package app.controller;

import app.dto.PilarDTO;
import app.dto.PositionUpdateDTO;
import app.service.PilarService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {
    private final PilarService pilarService;

    public PilarController(PilarService pilarService) {
        this.pilarService = pilarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilarDTO> getPilar(@PathVariable Long id) {
        PilarDTO dto = pilarService.getPilarById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/actualizar-posicion")
    public ResponseEntity<?> actualizarPosicion(@RequestBody PositionUpdateDTO dto) {
        PilarDTO updated = pilarService.updatePosition(dto);
        return ResponseEntity.status(201).body(Map.of("mensaje", "Posición actualizada exitosamente.", "pilar", updated));
    }
    
}
