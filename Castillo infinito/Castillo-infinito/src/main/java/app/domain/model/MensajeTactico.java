
package app.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;


public class MensajeTactico {
   private Long id;
    private Long pilarId;
    private String contenidoFragmentado;
    private String contenidoReconstruido;
    private LocalDateTime timestamp;

    public MensajeTactico() {}

    public MensajeTactico(Long id, Long pilarId, String contenidoFragmentado, String contenidoReconstruido, LocalDateTime timestamp) {
        this.id = id;
        this.pilarId = pilarId;
        this.contenidoFragmentado = contenidoFragmentado;
        this.contenidoReconstruido = contenidoReconstruido;
        this.timestamp = timestamp;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MensajeTactico)) return false;
        MensajeTactico that = (MensajeTactico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
