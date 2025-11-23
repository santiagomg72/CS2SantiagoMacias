
package app.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;


public class Pilar {
    private Long id;
    private String nombre;
    private int posX;
    private int posY;
    private String estado;
    private LocalDateTime updatedAt;

    public Pilar() {}

    public Pilar(Long id, String nombre, int posX, int posY, String estado, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }

    public int getPosY() { return posY; }
    public void setPosY(int posY) { this.posY = posY; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilar)) return false;
        Pilar pilar = (Pilar) o;
        return Objects.equals(id, pilar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
