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
@Fisica
public class PessoaFisica implements Pessoa{

    @Override
    public String getTipo() {
        return "Pessoa Fisica";
    }
    
}