/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author md10
 */
@ApplicationScoped
@Tinto
public class VinhoTinto implements Vinho{

    @Override
    public String getCor() {
        
        return "Tinto";
    }
    
}
