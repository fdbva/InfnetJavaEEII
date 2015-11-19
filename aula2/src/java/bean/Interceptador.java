/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author md10
 */
public class Interceptador {
    
    @AroundInvoke
    public Object metodoInterceptador(InvocationContext ic) throws Exception
    {
        TesteBean tb=(TesteBean) ic.getTarget();
        
        double aumento =0;
        
        if(tb.getTitulo().equals("Especialista"))
        {
            aumento=tb.getSalario()*0.10;
            System.out.println("aumento:"+aumento);
            tb.setAumento(aumento);
            
            return aumento;
        }
        
        System.out.println("Objeto Interceptado: " + ic.getTarget());
        System.out.println("Metodo Interceptado: " + ic.getMethod().getName());
        
        return ic.proceed();
    }
}
