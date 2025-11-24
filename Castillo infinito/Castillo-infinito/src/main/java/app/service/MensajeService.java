
package app.service;

import app.aplication.port.input.MensajeUseCase;
import app.domain.model.MensajeTactico;
import app.domain.repository.MensajeRepositoryPort;
import app.domain.repository.PilarRepositoryPort;
import app.shared.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class MensajeService implements MensajeUseCase {

    private final MensajeRepositoryPort mensajeRepository;
    private final PilarRepositoryPort pilarRepository;

    public MensajeService(MensajeRepositoryPort mensajeRepository, PilarRepositoryPort pilarRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pilarRepository = pilarRepository;
    }

    @Override
    public MensajeTactico registrarMensaje(MensajeTactico mensaje) {
        pilarRepository.findById(mensaje.getPilarId())
                .orElseThrow(() -> new NotFoundException("Pilar no existe: " + mensaje.getPilarId()));
        mensaje.setTimestamp(LocalDateTime.now());
        return mensajeRepository.save(mensaje);
    }

    @Override
    public Optional<MensajeTactico> reconstruirMensaje(Long id, String contenidoReconstruido) {
        return mensajeRepository.findById(id)
                .map(m -> {
                    m.setContenidoReconstruido(contenidoReconstruido);
                    return mensajeRepository.save(m);
                });
    }

    @Override
    public Optional<MensajeTactico> findById(Long id) {
        return mensajeRepository.findById(id);
    }

    @Override
    public List<MensajeTactico> findAll() {
        return mensajeRepository.findAll();
    }

    @Override
    public MensajeTactico createMensaje(Long pilarId, String contenidoFragmentado) {
        pilarRepository.findById(pilarId)
                .orElseThrow(() -> new NotFoundException("Pilar no existe: " + pilarId));
        MensajeTactico mensaje = new MensajeTactico();
        mensaje.setPilarId(pilarId);
        mensaje.setContenidoFragmentado(contenidoFragmentado);
        mensaje.setContenidoReconstruido(null);
        mensaje.setTimestamp(LocalDateTime.now());
        return mensajeRepository.save(mensaje);
    }
}
