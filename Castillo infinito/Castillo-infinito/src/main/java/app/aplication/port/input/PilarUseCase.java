
package app.aplication.port.input;

import app.domain.model.Pilar;
import java.util.List;


public interface PilarUseCase {
    Pilar obtenerPilar(Long id);
    Pilar actualizarPosicion(Long pilarId, int posX, int posY, String estado);
    List<Pilar> getAllPilares();
    
}
