/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Local;

/**
 *
 * @author fva
 */
@Local
public interface ConversorLocal {
    public String realToDollar(String real);
    public String realToEuro(String real);
    public String realToLibra(String real);
    
}
