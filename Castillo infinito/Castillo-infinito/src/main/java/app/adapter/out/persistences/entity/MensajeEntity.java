
package app.adapter.out.persistences.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "mensajes_tacticos")
public class MensajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pilar_id")
    private Long pilarId;

    @Column(name = "contenido_fragmentado", columnDefinition = "TEXT")
    private String contenidoFragmentado;

    @Column(name = "contenido_reconstruido", columnDefinition = "TEXT")
    private String contenidoReconstruido;

    private LocalDateTime timestamp;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }

    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { this.contenidoFragmentado = contenidoFragmentado; }

    public String getContenidoReconstruido() { return contenidoReconstruido; }
    public void setContenidoReconstruido(String contenidoReconstruido) { this.contenidoReconstruido = contenidoReconstruido; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
}
