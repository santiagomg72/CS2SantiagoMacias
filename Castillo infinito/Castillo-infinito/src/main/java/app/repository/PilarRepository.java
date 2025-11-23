
package app.repository;


import app.entity.Pilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilarRepository extends JpaRepository<Pilar, Long> {
    
}
