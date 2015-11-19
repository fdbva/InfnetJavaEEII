/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author md10
 */
@Remote
public interface CarrinhoCompra {
    public void comprar(String produto, int qtd);
    public Map<String, Integer> listarCompras();
    public String devolver(String produto, int qtd);
    public String remover(String produto);    
}
