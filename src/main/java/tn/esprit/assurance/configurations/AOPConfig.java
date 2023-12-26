package tn.esprit.assurance.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AOPConfig {

    @After("execution(* tn.esprit.assurance.services.AllServices.get*(..))")
    public void messageAfterGetReq(){
        log.info("Bon courage !");
    }
}
