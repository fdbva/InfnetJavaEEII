/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

/**
 *
 * @author md10
 */
@Stateful
@DeclareRoles({"usuarios", "admin"})
public class CarrinhoCompraBean implements CarrinhoCompra{
    
    private Map<String, Integer> listaCompras;
    
    public CarrinhoCompraBean()
    {
        listaCompras=new HashMap<String, Integer>();
    }

    @Override
    @RolesAllowed({"usuarios", "admin"})
    public void comprar(String produto, int qtd) {
        
        Integer n = listaCompras.get(produto);
        
        if (n==null) {
            listaCompras.put(produto, qtd);
        }
        else
        {
            listaCompras.replace(produto, n+qtd);
        }
    }

    @Override
    @RolesAllowed("admin")
    public Map<String, Integer> listarCompras() {
        return listaCompras;
    }

    @Override
    @RolesAllowed({"usuarios", "admin"})
    public String devolver(String produto, int qtd) {
        
        Integer n = listaCompras.get(produto);
        
        if (n==null) {
            return "Falha ao devolver: Produto Inexistente";
        }
        else
        {
            listaCompras.replace(produto, n-qtd);
        }
        return "Produto Devolvido com sucesso";
    }
    
    @Override
    @RolesAllowed({"usuarios", "admin"})
    public String remover(String produto)
    {
        Integer n = listaCompras.get(produto);
        
        if (n==null) {
            return "Falha ao remover: Produto Inexistente";
        }
        else
        {
            listaCompras.remove(produto);
        }
        return "Produto Removido com sucesso";
    }
    
}
