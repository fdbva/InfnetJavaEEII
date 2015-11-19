
package bean;

import javax.ejb.Remote;
import javax.ejb.Timer;

@Remote
public interface Temporizador {
    
    public void setTemporizador(long t);
    public void timeout(Timer timer);
    public void ligarLuzes();
    public void apagarluzes(long t);
    public void ligarHidromassagem();
    public void desligarHidromassagem();
 
}
