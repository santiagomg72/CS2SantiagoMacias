
package app.shared.dto;


public class PilarUpdateRequest {
    private Long pilarId;
    private int posX;
    private int posY;
    private String estado;

    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }
    public int getPosY() { return posY; }
    public void setPosY(int posY) { this.posY = posY; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
}
