package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LoggingAdvice {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before())")
	public void beforeTrace() {
		System.out.println("before trace");
	}
	
	
	@After("execution(public * *.*.*After())")
	public void afterTrace() {
		System.out.println("after trace");
	}
	
	@Around("\"execution(public * *.MessageBeanImpl.*Print())")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("입실");
//		
//		joinPoint.proceed();
//		//핵심코드를 수행하는 메소드 호출
//
//		System.out.println("퇴실");
		
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 " + methodName);
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
//		joinPoint.proceed();
		Object ob = joinPoint.proceed();
		System.out.println("반환값 " + ob);
		
		stopWatch.stop();
		System.out.println("처리시간 : " + stopWatch.getTotalTimeMillis()/1000 + "초");
	}
	
	
}
