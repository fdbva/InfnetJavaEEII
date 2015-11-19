/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2client;

import bean.Teste;
import javax.ejb.EJB;

/**
 *
 * @author md10
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @EJB
    private static Teste t;
    
    public static void main(String[] args) {
        
        t.setTitulo("Doutor");
        t.setSalario(1000);
        
        System.out.println(t.calculaAumento());
        
    }
    
}
