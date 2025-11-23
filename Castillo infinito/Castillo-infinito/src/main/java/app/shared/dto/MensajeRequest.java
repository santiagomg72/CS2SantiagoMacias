
package app.shared.dto;


public class MensajeRequest {
    private Long pilarId;
    private String contenidoFragmentado;

    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { this.contenidoFragmentado = contenidoFragmentado; }
    
}
