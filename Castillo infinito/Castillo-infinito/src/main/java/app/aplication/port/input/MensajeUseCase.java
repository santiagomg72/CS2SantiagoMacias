
package app.aplication.port.input;

import app.domain.model.MensajeTactico;
import java.util.List;
import java.util.Optional;


public interface MensajeUseCase {
    MensajeTactico registrarMensaje(MensajeTactico mensaje);
    Optional<MensajeTactico> reconstruirMensaje(Long id, String contenidoReconstruido);
    Optional<MensajeTactico> findById(Long id);
    List<MensajeTactico> findAll();
    MensajeTactico createMensaje(Long pilarId, String contenidoFragmentado);
}
