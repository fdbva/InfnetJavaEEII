/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Remote;

/**
 *
 * @author md10
 */
@Remote
public interface Teste {
    
    public void setTitulo(String titulo);
    public void setSalario(double salario);
    
    public void metodoInterceptado();
    public double calculaAumento();
    
}
