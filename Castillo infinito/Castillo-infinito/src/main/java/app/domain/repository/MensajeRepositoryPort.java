
package app.domain.repository;

import app.domain.model.MensajeTactico;
import java.util.List;
import java.util.Optional;


public interface MensajeRepositoryPort {
    MensajeTactico save(MensajeTactico mensaje);
    Optional<MensajeTactico> findById(Long id);
    List<MensajeTactico> findAll();
    
}
