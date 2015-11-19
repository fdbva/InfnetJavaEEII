
package bean;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class CasaBean implements Casa{

    @WebMethod
    @Override
    public String ligarLuzes() {
        
        return "Luzes Ligadas";
    }

    @WebMethod
    @Override
    public String desligarLuzes() {
        
        return "Luzes Apagadas";
    }
    
}
