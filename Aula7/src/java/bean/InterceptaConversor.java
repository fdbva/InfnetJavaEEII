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
 * @author fva
 */
public class InterceptaConversor {
    @AroundInvoke
    public Object interceptMethod(InvocationContext ic) throws Exception{
        
        return Double.parseDouble((String)ic.getParameters()[0]) < 0 ? "0": ic.proceed();
    }
}
