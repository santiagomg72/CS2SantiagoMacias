
package app.dto;


public class MensajeCreateDTO {
    private Long pilarId;
    private String contenidoFragmentado;

    public MensajeCreateDTO() {}
    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { this.contenidoFragmentado = contenidoFragmentado; }
    
}
