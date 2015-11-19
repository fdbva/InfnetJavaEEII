/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author fva
 */
@Stateless
public class Conversor implements ConversorLocal {
    private double dollar = 3.81;
    private double euro = 4.06;
    private double libra = 5.82;
    
    @Override
    @Interceptors({InterceptaConversor.class})
    public String realToDollar(String real) {
        return Double.toString(Double.parseDouble(real)*dollar);
    }

    @Override
    @Interceptors({InterceptaConversor.class})
    public String realToEuro(String real) {
        return Double.toString(Double.parseDouble(real)*euro);
    }

    @Override
    @Interceptors({InterceptaConversor.class})
    public String realToLibra(String real) {
        return Double.toString(Double.parseDouble(real)*libra);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
