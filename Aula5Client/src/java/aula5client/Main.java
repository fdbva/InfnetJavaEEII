
package aula5client;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class Main {
    
//    <?xml version="1.0" encoding="UTF-8"?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
//        <SOAP-ENV:Header/>
//        <S:Body>
//            <ns2:ligarLuzes xmlns:ns2="http://bean/"/>
//        </S:Body>
//    </S:Envelope>
    
    public static SOAPMessage criarMensagem(String metodo) throws SOAPException, IOException
    {
        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage mensagem = mf.createMessage();
        SOAPPart parte = mensagem.getSOAPPart();
        SOAPEnvelope envelope = parte.getEnvelope();
        SOAPBody corpo = envelope.getBody();
        corpo.addNamespaceDeclaration("ns2","http://bean/");
        SOAPElement elemento = corpo.addChildElement(metodo, "ns2");
        mensagem.saveChanges();
        
        
        //teste
        System.out.println("\n XML: ");
        mensagem.writeTo(System.out);
        System.out.println("\n");
        
        return mensagem;
                
    }


    public static void main(String[] args) throws SOAPException, IOException {
        
        System.out.println("Entre com a Opção 1 para Ligar ou 2 para Desligar as Luzes");
        Scanner sr = new Scanner(System.in);
        int i = sr.nextInt();
         SOAPMessage soapm = null;
        
        if (i == 1) {
            soapm = criarMensagem("ligarLuzes");
        }
        if(i == 2)
        {
            soapm = criarMensagem("desligarLuzes");
        }
        
        SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
        SOAPConnection c = cf.createConnection();
        SOAPMessage response = 
                c.call(soapm, "http://localhost:8080/CasaBeanService/CasaBean");
        
        SOAPBody corpo = response.getSOAPBody();
        
        Iterator it = corpo.getChildElements();
        
        SOAPElement e = (SOAPElement)it.next();
        
        Iterator i1 = e.getChildElements();
        
        SOAPElement e1 = (SOAPElement)i1.next();
        
        System.out.println("Resposta: " + e1.getValue() + "\n");
        
    }
    
}
