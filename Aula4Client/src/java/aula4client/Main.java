/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4client;

import bean.CarrinhoCompra;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;

/**
 *
 * @author md10
 */
public class Main {

    @EJB
    private static CarrinhoCompra cc; 
            
    public static void main(String[] args) {
        
        try
        {
            cc.comprar("memoria", 4);
            cc.comprar("HD", 5);
            cc.comprar("memoria", 2);
            System.out.println(cc.devolver("memoria", 2));
            System.out.println(cc.devolver("produto X", 2));
            System.out.println(cc.remover("HD"));
            System.out.println(cc.remover("Produto Y"));
            
            Map<String,Integer>listaCompra=cc.listarCompras();
            
            for (String produto:listaCompra.keySet()) {
                System.out.println("Produto: " +produto);
                System.out.println("Quantide: " +listaCompra.get(produto));
                System.out.println("");
            }
        }
        catch (EJBAccessException e)
        {
            System.out.println("Sem Permissão");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
