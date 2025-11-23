
package app.service;

import app.entity.Pilar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class InteligenciaService {
    private final PilarService pilarService;

    public InteligenciaService(PilarService pilarService) {
        this.pilarService = pilarService;
    }


    public Map<String, Object> estimarTriangulacion() {
        List<Pilar> pilares = pilarService.getAllPilares();

        Map<String, Object> result = new HashMap<>();

        if (pilares.isEmpty()) {
            result.put("posiblePosicionMuzan", Map.of("x", 0, "y", 0));
            result.put("nivelConfianza", 0.0);
            result.put("descripcion", "No hay datos de pilares.");
            return result;
        }

        double sumX = 0;
        double sumY = 0;
        for (Pilar p : pilares) {
            sumX += p.getPosX();
            sumY += p.getPosY();
        }
        double avgX = sumX / pilares.size();
        double avgY = sumY / pilares.size();

        double nivelConfianza = Math.min(1.0, 0.3 + 0.25 * (pilares.size())); // 1 pilar -> 0.55, 3 pilares -> 1.0 satura en 1.0
        if (nivelConfianza > 1.0) nivelConfianza = 1.0;

        String descripcion = "Estimación basada en posiciones actuales de " + pilares.size() + " pilares.";

        result.put("posiblePosicionMuzan", Map.of("x", Math.round(avgX), "y", Math.round(avgY)));
        result.put("nivelConfianza", Math.round(nivelConfianza * 100.0) / 100.0);
        result.put("descripcion", descripcion);

        return result;
    }
    
}
