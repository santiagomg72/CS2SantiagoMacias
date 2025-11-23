
package app.service;

import app.dto.PilarDTO;
import app.dto.PositionUpdateDTO;
import app.entity.Pilar;
import app.exception.ResourceNotFoundException;
import app.repository.PilarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PilarService {
    private final PilarRepository pilarRepository;

    public PilarService(PilarRepository pilarRepository) {
        this.pilarRepository = pilarRepository;
    }

    public PilarDTO getPilarById(Long id) {
        Pilar p = pilarRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pilar no encontrado con id " + id));
        return new PilarDTO(p.getId(), p.getNombre(), p.getPosX(), p.getPosY(), p.getEstado());
    }

    @Transactional
    public PilarDTO updatePosition(PositionUpdateDTO dto) {
        if (dto.getPilarId() == null || dto.getPosX() == null || dto.getPosY() == null || dto.getEstado() == null) {
            throw new IllegalArgumentException("Datos incompletos para actualizar posición");
        }

        Pilar p = pilarRepository.findById(dto.getPilarId())
                .orElseThrow(() -> new ResourceNotFoundException("Pilar no encontrado con id " + dto.getPilarId()));

        p.setPosX(dto.getPosX());
        p.setPosY(dto.getPosY());
        p.setEstado(dto.getEstado());

        pilarRepository.save(p);

        return new PilarDTO(p.getId(), p.getNombre(), p.getPosX(), p.getPosY(), p.getEstado());
    }

    public List<Pilar> getAllPilares() {
        return pilarRepository.findAll();
    }
    
}
