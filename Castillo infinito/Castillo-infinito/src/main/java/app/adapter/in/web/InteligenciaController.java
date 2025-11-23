
package app.adapter.in.web;

import app.aplication.port.input.MensajeUseCase;
import app.aplication.port.input.PilarUseCase;
import app.domain.model.MensajeTactico;
import app.domain.model.Pilar;
import app.shared.dto.MensajeReconstructRequest;
import app.shared.dto.MensajeRequest;
import app.shared.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class InteligenciaController {

    private final PilarUseCase pilarUseCase;
    private final MensajeUseCase mensajeUseCase;

    public InteligenciaController(PilarUseCase pilarUseCase, MensajeUseCase mensajeUseCase) {
        this.pilarUseCase = pilarUseCase;
        this.mensajeUseCase = mensajeUseCase;
    }

    @GetMapping("/inteligencia/triangulacion")
    public ResponseEntity<?> triangulacion() {
        List<Pilar> found = new ArrayList<>();
        for (long i = 1; i <= 3; i++) {
            try {
                Pilar p = pilarUseCase.obtenerPilar(i);
                found.add(p);
            } catch (NotFoundException e) {
                
            }
        }

        if (found.isEmpty()) {
            return ResponseEntity.ok(Map.of(
                "posiblePosicionMuzan", Map.of("x", 0, "y", 0),
                "nivelConfianza", 0.0,
                "descripcion", "No hay datos suficientes."
            ));
        }

        double avgX = found.stream().mapToDouble(Pilar::getPosX).average().orElse(0.0);
        double avgY = found.stream().mapToDouble(Pilar::getPosY).average().orElse(0.0);
        double confianza = Math.min(1.0, 0.5 + found.size() * 0.15);

        Map<String, Object> resp = new HashMap<>();
        resp.put("posiblePosicionMuzan", Map.of("x", (int) Math.round(avgX), "y", (int) Math.round(avgY)));
        resp.put("nivelConfianza", Math.round(confianza * 100.0) / 100.0);
        resp.put("descripcion", "Proyección basada en coordenadas de pilares disponibles.");
        return ResponseEntity.ok(resp);
    }


}