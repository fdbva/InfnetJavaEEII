/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.Conversor;
import bean.ConversorLocal;
import java.io.IOException;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 *
 * @author fva
 */
@ManagedBean
@RequestScoped
public class ConversorControle {
    private static final String LOCALHOST_CONVERSOR_WS = "http://localhost:8080/ConversorWSService/ConversorWS";
    private static final String REAL_TO_LIBRA = "realToLibra";
    private static final String REAL_TO_EURO = "realToEuro";
    private static final String REAL_TO_DOLLAR = "realToDollar";
    private String real;
    private String resDollar;
    private String resEuro;
    private String resLibras;
    
    @EJB
    private ConversorLocal con;
    
    public ConversorControle(){
        con = new Conversor();
        real = "0.0";
    }
    public void calcular(){
        resDollar = con.realToDollar(real);
        resEuro = con.realToEuro(real);
        resLibras = con.realToLibra(real);
    }
    public void calcularDollarWS() throws SOAPException, IOException{
        resDollar = soapExtractResponse(soapMessageRequest(REAL_TO_DOLLAR));
        resEuro = soapExtractResponse(soapMessageRequest(REAL_TO_EURO));
        resLibras = soapExtractResponse(soapMessageRequest(REAL_TO_LIBRA));
    }

    private String soapExtractResponse(SOAPMessage soapMtoMethod) throws SOAPException, UnsupportedOperationException {
        SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
        SOAPConnection c = cf.createConnection();
        SOAPMessage response = 
                c.call(soapMtoMethod, LOCALHOST_CONVERSOR_WS);
        SOAPBody corpo = response.getSOAPBody();
        Iterator it = corpo.getChildElements();
        SOAPElement e = (SOAPElement)it.next();
        Iterator i1 = e.getChildElements();
        SOAPElement e1 = (SOAPElement)i1.next();
        return e1.getValue();
    }
    private SOAPMessage soapMessageRequest(String metodo) throws SOAPException, IOException
    {
        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage mensagem = mf.createMessage();
        SOAPPart parte = mensagem.getSOAPPart();
        SOAPEnvelope envelope = parte.getEnvelope();
        SOAPBody corpo = envelope.getBody();
        corpo.addNamespaceDeclaration("ns2","http://bean/");
        SOAPElement elemento = corpo.addChildElement(metodo, "ns2");
        SOAPElement arg = elemento.addChildElement("arg0");
        arg.addTextNode(real);
        mensagem.saveChanges();
        return mensagem;
    }
    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getResDollar() {
        return resDollar;
    }

    public void setResDollar(String resDollar) {
        this.resDollar = resDollar;
    }

    public String getResEuro() {
        return resEuro;
    }

    public void setResEuro(String resEuro) {
        this.resEuro = resEuro;
    }

    public String getResLibras() {
        return resLibras;
    }

    public void setResLibras(String resLibras) {
        this.resLibras = resLibras;
    }
    
}
