
package bean;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class TemporizadorBean implements Temporizador{
    
    private static Logger log=Logger.getLogger("bean.TemporizadorBean");
    
    @Resource
    private TimerService ts;

    @Override
    public void setTemporizador(long t) {
        Timer timer=ts.createTimer(t, "Iniciar o temporizador");
        while(timer.getTimeRemaining()>0)
        {
            log.info("Tempo:"+timer.getTimeRemaining());
        }
    }

    @Override
    @Timeout
    public void timeout(Timer timer) {
        log.info("Temporizador finalizado");
    }
    
    @PostConstruct
    public void ejbConstruido()
    {
        log.info("ejb construido");
    }
    
    @PreDestroy
    public void ejbDestruido()
    {
        log.info("ejb destruido");
    }
    
    @Override
    public void ligarLuzes() {
        log.info("Luz Ligada");
    }

    @Override
    public void apagarluzes(long t) {
        log.info("Luz Apagada");
        
        Timer timer=ts.createTimer(t, "Hidro desligará em: 10 segundos");
        while(timer.getTimeRemaining()>0)
        {
            log.info("Hidro desligará em:"+timer.getTimeRemaining());
        }
        desligarHidromassagem();
    }

    @Override
    public void ligarHidromassagem() {
        log.info("Hidromassagem Ligada");
    }

    @Override
    public void desligarHidromassagem() {
        log.info("Hidromassagem Desligada");
    }

}
