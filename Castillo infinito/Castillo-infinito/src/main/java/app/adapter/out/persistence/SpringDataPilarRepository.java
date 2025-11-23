
package app.adapter.out.persistence;

import app.adapter.out.persistences.entity.PilarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataPilarRepository extends JpaRepository<PilarEntity, Long> {
    
}
