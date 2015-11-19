/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3cliente;

import bean.Teste;
import javax.ejb.EJB;


public class Main {
    
    @EJB
    private static Teste t;

    public static void main(String[] args) {
        System.out.println(t.servico());
    }
    
}
