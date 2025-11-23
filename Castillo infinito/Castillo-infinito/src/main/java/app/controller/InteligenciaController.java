
package app.controller;

import app.service.InteligenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inteligencia")
public class InteligenciaController {
    private final InteligenciaService inteligenciaService;

    public InteligenciaController(InteligenciaService inteligenciaService) {
        this.inteligenciaService = inteligenciaService;
    }

    @GetMapping("/triangulacion")
    public ResponseEntity<?> triangulacion() {
        return ResponseEntity.ok(inteligenciaService.estimarTriangulacion());
    }
    
}
