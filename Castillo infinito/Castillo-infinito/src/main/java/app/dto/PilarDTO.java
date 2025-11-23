
package app.dto;


public class PilarDTO {
    private Long id;
    private String nombre;
    private int posX;
    private int posY;
    private String estado;

    public PilarDTO() {}

    public PilarDTO(Long id, String nombre, int posX, int posY, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
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
    
}
