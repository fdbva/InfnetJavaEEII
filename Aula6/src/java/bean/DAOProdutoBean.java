/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fva
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//usando o servico JTS(Java Transaction Service do EJB Container)
public class DAOProdutoBean implements DaoProduto {
    @PersistenceContext(unitName="Aula6PU")
    private EntityManager em;
    @Override
    public void cadastrar(Produto p){
        em.persist(p);
    }
    public List<Produto> obterProdutos(){
        return em.createQuery("select p from Produto p").getResultList();
    }
    public void excluir(Produto p){
        em.remove(em.find(Produto.class, p.getCodigo()));
    }
    public void alterar(Produto p){
        em.merge(p);
    }
}
