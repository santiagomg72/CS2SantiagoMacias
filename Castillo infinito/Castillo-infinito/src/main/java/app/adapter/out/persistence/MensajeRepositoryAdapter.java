
package app.adapter.out.persistence;

import app.adapter.out.persistences.entity.MensajeEntity;
import app.domain.model.MensajeTactico;
import app.domain.repository.MensajeRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;


@Component
public class MensajeRepositoryAdapter implements MensajeRepositoryPort {

    private final SpringDataMensajeRepository springMensajeRepo;

    public MensajeRepositoryAdapter(SpringDataMensajeRepository springMensajeRepo) {
        this.springMensajeRepo = springMensajeRepo;
    }

    private MensajeTactico mapToDomain(MensajeEntity e) {
        return new MensajeTactico(
                e.getId(),
                e.getPilarId(),
                e.getContenidoFragmentado(),
                e.getContenidoReconstruido(),
                e.getTimestamp()
        );
    }

    private MensajeEntity mapToEntity(MensajeTactico m) {
        MensajeEntity e = new MensajeEntity();
        e.setId(m.getId());
        e.setPilarId(m.getPilarId());
        e.setContenidoFragmentado(m.getContenidoFragmentado());
        e.setContenidoReconstruido(m.getContenidoReconstruido());
        e.setTimestamp(m.getTimestamp() != null ? m.getTimestamp() : LocalDateTime.now());
        return e;
    }

    @Override
    public MensajeTactico save(MensajeTactico mensaje) {
        MensajeEntity e = mapToEntity(mensaje);
        MensajeEntity saved = springMensajeRepo.save(e);
        return mapToDomain(saved);
    }

    @Override
    public Optional<MensajeTactico> findById(Long id) {
        return springMensajeRepo.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<MensajeTactico> findAll() {
        return springMensajeRepo.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
    }
    
}
