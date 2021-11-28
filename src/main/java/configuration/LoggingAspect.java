package configuration;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	/*
private static final Logger l = LogManager.getLogger(LoggingAspect.class);
@Before("execution(* tn.esprit.esponline.service.StockServiceImpl.*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
String name = joinPoint.getSignature().getName();
logger.info("In method " + name + " : ");
}
@After("........")
public void logMethodExit....*/
}
