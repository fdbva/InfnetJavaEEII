/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author md10
 */
@Stateless
public class TesteBean implements Teste{
    
    private String titulo;
    private double salario;
    double aumento =0;

    public double getAumento() {
        return aumento;
    }

    public void setAumento(double aumento) {
        this.aumento = aumento;
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    @Interceptors({Interceptador.class})
    public void metodoInterceptado() {
        System.out.println("TesteBean Interceptado");
    }

    @Override
    @Interceptors({Interceptador1.class, Interceptador2.class, Interceptador3.class})
    public double calculaAumento() {
        System.out.println("Bean Interceptado");
        return aumento;
    }
    
}
