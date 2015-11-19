/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.transaction.SystemException;

/**
 *
 * @author fva
 */
public interface DAOProduto2 {

    void cadastrar(Produto p) throws IllegalStateException, SecurityException, SystemException;

    void alterar(Produto p) throws IllegalStateException, SecurityException, SystemException;

    void excluir(Produto p) throws IllegalStateException, SecurityException, SystemException;

    List<Produto> obterProdutos();
    
}
