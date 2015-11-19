/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fva
 */
@Local
public interface DaoProduto {

    void cadastrar(Produto p);

    void alterar(Produto p);

    void excluir(Produto p);

    List<Produto> obterProdutos();
    
}
