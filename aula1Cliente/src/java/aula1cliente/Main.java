
package aula1cliente;

import bean.Temporizador;
import javax.ejb.EJB;

public class Main {
    
    @EJB
    private static Temporizador t;

    public static void main(String[] args) {
        
        t.apagarluzes(10000);
        
    }
    
}
