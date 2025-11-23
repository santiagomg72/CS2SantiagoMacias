
package app.aplication.usecase;

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
public class MensajeUseCaseImpl implements MensajeUseCase {

    private final MensajeRepositoryPort mensajeRepository;
    private final PilarRepositoryPort pilarRepository;

    public MensajeUseCaseImpl(MensajeRepositoryPort mensajeRepository, PilarRepositoryPort pilarRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pilarRepository = pilarRepository;
    }

    @Override
    public MensajeTactico createMensaje(Long pilarId, String contenidoFragmentado) {
        pilarRepository.findById(pilarId).orElseThrow(() -> new NotFoundException("Pilar no existe: " + pilarId));
        MensajeTactico m = new MensajeTactico();
        m.setPilarId(pilarId);
        m.setContenidoFragmentado(contenidoFragmentado);
        m.setContenidoReconstruido(null);
        m.setTimestamp(LocalDateTime.now());
        return mensajeRepository.save(m);
    }

    @Override
    public Optional<MensajeTactico> reconstruirMensaje(Long mensajeId, String contenidoReconstruido) {
        return mensajeRepository.findById(mensajeId)
            .map(m -> {
                m.setContenidoReconstruido(contenidoReconstruido);
                return mensajeRepository.save(m);
            });
    
    }

    @Override
        public List<MensajeTactico> findAll() {
            return mensajeRepository.findAll();
    }
        
    @Override
        public Optional<MensajeTactico> findById(Long id) {
            return mensajeRepository.findById(id);
    }
       
    @Override
    public MensajeTactico registrarMensaje(MensajeTactico mensaje) {
        return mensajeRepository.save(mensaje);
    

    }
}