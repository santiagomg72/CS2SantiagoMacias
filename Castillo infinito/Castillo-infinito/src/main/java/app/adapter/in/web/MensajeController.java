
package app.adapter.in.web;

import app.aplication.port.input.MensajeUseCase;
import app.domain.model.MensajeTactico;
import app.shared.exception.NotFoundException;
import java.util.Map;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
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

    private final MensajeUseCase mensajeUseCase;

    public MensajeController(MensajeUseCase mensajeUseCase) {
        this.mensajeUseCase = mensajeUseCase;
    }

    @PostMapping
    public ResponseEntity<MensajeTactico> createMensaje(@RequestBody Map<String, Object> payload) throws BadRequestException {
        try {
            Long pilarId = ((Number) payload.get("pilarId")).longValue();
            String contenidoFragmentado = (String) payload.get("contenidoFragmentado");
            MensajeTactico creado = mensajeUseCase.createMensaje(pilarId, contenidoFragmentado);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (NullPointerException | ClassCastException e) {
            throw new BadRequestException("Error en datos enviados");
        }
    }
    

   @PutMapping("/{id}/reconstruir")
public ResponseEntity<MensajeTactico> reconstruir(
        @PathVariable Long id,
        @RequestBody Map<String, Object> payload) throws BadRequestException {

    String contenidoReconstruido = (String) payload.get("contenidoReconstruido");
    if (contenidoReconstruido == null) {
        throw new BadRequestException("contenidoReconstruido es requerido");
    }

    MensajeTactico actualizado = mensajeUseCase.reconstruirMensaje(id, contenidoReconstruido)
            .orElseThrow(() -> new NotFoundException("No existe mensaje con ese ID"));

    return ResponseEntity.ok(actualizado);
}

    
    
}
