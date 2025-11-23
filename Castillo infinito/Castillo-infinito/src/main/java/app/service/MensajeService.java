
package app.service;

import app.dto.MensajeCreateDTO;
import app.dto.MensajeReconstruirDTO;
import app.entity.Mensaje;
import app.exception.ResourceNotFoundException;
import app.repository.MensajeRepository;
import app.repository.PilarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensajeService {
    private final MensajeRepository mensajeRepository;
    private final PilarRepository pilarRepository;

    public MensajeService(MensajeRepository mensajeRepository, PilarRepository pilarRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pilarRepository = pilarRepository;
    }

    public Mensaje createMensaje(MensajeCreateDTO dto) {
        if (dto.getPilarId() == null || dto.getContenidoFragmentado() == null) {
            throw new IllegalArgumentException("Datos inválidos");
        }
        // verificar que pilar existe
        pilarRepository.findById(dto.getPilarId())
                .orElseThrow(() -> new ResourceNotFoundException("Pilar no existe con id " + dto.getPilarId()));

        Mensaje m = new Mensaje(dto.getPilarId(), dto.getContenidoFragmentado(), LocalDateTime.now());
        return mensajeRepository.save(m);
    }

    public Mensaje reconstruirMensaje(Long id, MensajeReconstruirDTO dto) {
        if (dto.getContenidoReconstruido() == null) {
            throw new IllegalArgumentException("contenidoReconstruido es requerido");
        }
        Mensaje m = mensajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrado con id " + id));
        m.setContenidoReconstruido(dto.getContenidoReconstruido());
        return mensajeRepository.save(m);
    }
    
}
