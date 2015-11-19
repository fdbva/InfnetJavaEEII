/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.Fisica;
import modelo.Juridica;
import modelo.Pessoa;
import modelo.Tinto;
import modelo.Vinho;

/**
 *
 * @author md10
 */
@Stateless
public class TesteBean implements Teste{
    
    @Inject
    @Fisica
    private Pessoa p1;
    
    @Inject
    @Juridica
    private Pessoa p2;

    @Override
    public String servico() {
        
        return p2.getTipo();
    }
    
}
