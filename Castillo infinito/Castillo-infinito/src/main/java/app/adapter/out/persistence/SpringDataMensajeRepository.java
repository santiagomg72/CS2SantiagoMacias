
package app.adapter.out.persistence;

import app.adapter.out.persistences.entity.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataMensajeRepository extends JpaRepository<MensajeEntity, Long>{
    
}
