
package bean;

import javax.ejb.Remote;

@Remote
public interface Casa {
    
    public String ligarLuzes();
    public String desligarLuzes();
}
