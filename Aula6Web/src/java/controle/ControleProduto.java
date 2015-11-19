/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.DAOProduto2;
import bean.DaoProduto;
import bean.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.transaction.SystemException;

/**
 *
 * @author fva
 */
@ManagedBean
@RequestScoped
public class ControleProduto {
    private Produto p;
    private List<Produto> lp;
    private List<Produto> lp2;
    private Produto p2;
    @EJB
    private DaoProduto daopb;
    
    @EJB
    private DAOProduto2 daopb2;
    public ControleProduto() {
        p = new Produto();
        p2 = new Produto();
    }

    public void cadastrar(){
        daopb.cadastrar(p);
    }
    public void excluir(){
        daopb.excluir(p);
    }
    public void alterar(){
        daopb.alterar(p);
    }
    public List<Produto> obterProdutos(){
        return lp = daopb.obterProdutos();
    }
    public Produto getP() {
        return p;
    }
    public void setP(Produto p) {
        this.p = p;
    }

    public void cadastrar2() throws IllegalStateException, SecurityException, SystemException{
        daopb2.cadastrar(p2);
    }
    public void excluir2() throws IllegalStateException, SecurityException, SystemException{
        daopb2.excluir(p);
    }
    public void alterar2() throws IllegalStateException, SecurityException, SystemException{
        daopb2.alterar(p);
    }
    public List<Produto> obterProdutos2(){
        return lp2 = daopb2.obterProdutos();
    }
    public Produto getP2() {
        return p2;
    }
    public void setP2(Produto p2) {
        this.p2 = p2;
    }
    
}
