
package app.domain.repository;

import app.domain.model.Pilar;
import java.util.List;
import java.util.Optional;


public interface PilarRepositoryPort {
    Optional<Pilar> findById(Long id);
    Pilar save(Pilar pilar);
    List<Pilar> findAll();
    
}
