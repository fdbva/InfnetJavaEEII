/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author fva
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
//o controle das transações é feito programaticamente
public class DAOProdutoBean2 implements DAOProduto2{
    @PersistenceContext(unitName="Aula6PU")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
    @Override
    public void cadastrar(Produto p) throws IllegalStateException, SecurityException, SystemException{
        try{
            ut.begin();
            em.persist(p);
            ut.commit();
        }catch(Exception e){
            ut.rollback();
        }
    }
    public List<Produto> obterProdutos(){
        return em.createQuery("select p from Produto p").getResultList();
    }
    public void excluir(Produto p) throws IllegalStateException, SecurityException, SystemException{
        try{
            ut.begin();
            em.remove(em.find(Produto.class, p.getCodigo()));
            ut.commit();
        }catch(Exception e){
            ut.rollback();
        }
    }
    public void alterar(Produto p) throws IllegalStateException, SecurityException, SystemException{
        try{
            ut.begin();
            em.merge(p);
            ut.commit();
        }catch(Exception e){
            ut.rollback();
        }
    }
}
