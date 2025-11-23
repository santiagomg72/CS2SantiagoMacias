
package app.aplication.usecase;

import app.aplication.port.input.PilarUseCase;
import app.domain.model.Pilar;
import app.domain.repository.PilarRepositoryPort;
import app.shared.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PilarUseCaseImpl implements PilarUseCase {

    private final PilarRepositoryPort pilarRepository;

    public PilarUseCaseImpl(PilarRepositoryPort pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

    @Override
    public Pilar obtenerPilar(Long id) {
        return pilarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un Pilar con id " + id));
    }

    @Override
    public Pilar actualizarPosicion(Long pilarId, int posX, int posY, String estado) {
        Pilar pilar = pilarRepository.findById(pilarId)
                .orElseThrow(() -> new NotFoundException("No existe un Pilar con id " + pilarId));
        pilar.setPosX(posX);
        pilar.setPosY(posY);
        pilar.setEstado(estado);
        pilar.setUpdatedAt(LocalDateTime.now());
        return pilarRepository.save(pilar);
    }

    @Override
    public List<Pilar> getAllPilares() {
        return pilarRepository.findAll();
    }
    
}
