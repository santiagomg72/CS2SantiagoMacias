
package app.adapter.out.persistence;

import app.adapter.out.persistences.entity.PilarEntity;
import app.domain.model.Pilar;
import app.domain.repository.PilarRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;


@Component
public class PilarRepositoryAdapter implements PilarRepositoryPort {

    private final SpringDataPilarRepository springPilarRepo;

    public PilarRepositoryAdapter(SpringDataPilarRepository springPilarRepo) {
        this.springPilarRepo = springPilarRepo;
    }

    private Pilar mapToDomain(PilarEntity e) {
        return new Pilar(e.getId(), e.getNombre(), e.getPosX(), e.getPosY(), e.getEstado(), e.getUpdatedAt());
    }

    private PilarEntity mapToEntity(Pilar p) {
        PilarEntity e = new PilarEntity();
        e.setId(p.getId());
        e.setNombre(p.getNombre());
        e.setPosX(p.getPosX());
        e.setPosY(p.getPosY());
        e.setEstado(p.getEstado());
        e.setUpdatedAt(p.getUpdatedAt() != null ? p.getUpdatedAt() : LocalDateTime.now());
        return e;
    }

    @Override
    public Optional<Pilar> findById(Long id) {
        return springPilarRepo.findById(id).map(this::mapToDomain);
    }

    @Override
    public Pilar save(Pilar pilar) {
        PilarEntity e = mapToEntity(pilar);
        PilarEntity saved = springPilarRepo.save(e);
        return mapToDomain(saved);
    }

    @Override
public List<Pilar> findAll() {
    return springPilarRepo.findAll() // esto devuelve List<PilarEntity>
            .stream()               // ✅ stream sobre la lista, no sobre un Pilar
            .map(this::mapToDomain) // convertir cada PilarEntity a Pilar
            .collect(Collectors.toList());
    }
    
}
