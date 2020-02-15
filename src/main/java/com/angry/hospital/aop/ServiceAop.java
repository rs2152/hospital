///*
//package com.angry.hospital.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.CodeSignature;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Aspect
//@Slf4j
//public class ServiceAop {
//
//    @Around("execution(* com.solar.gini.serviceImp.*.*(..))")
//    public Object serviceImp(ProceedingJoinPoint joinPoint) throws Throwable {
//        return getObject(joinPoint, "Service");
//    }
//
//    @Around("execution(* com.solar.gini.controller.*.*.*(..))")
//    public Object controllerAop(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object object = getObject(joinPoint, "Controller");
//        long endTime = System.currentTimeMillis();
//        log.info("Total Execution time : " + (double)(endTime-startTime)/1000 +" second");
//        return object;
//    }
//
//    @AfterThrowing(pointcut = "execution(* com.solar.gini.serviceImp.*.*(..))", throwing = "ex")
//    public void logErrorService(Exception ex) {
//        log.error("Exception in Service Methods");
//        log.error("Exception : "+ ex.getMessage());
//    }
//
//    @AfterThrowing(pointcut = "execution(* com.solar.gini.controller.implementor.*.*(..))", throwing = "ex")
//    public void logErrorController(Exception ex) {
//        log.error("Exception in Controller Methods");
//        log.error("Exception : "+ ex.getMessage());
//    }
//
//    private Object getObject(ProceedingJoinPoint joinPoint, String name) throws Throwable {
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
//        openMethod(joinPoint, methodSignature, name);
//        Object object = joinPoint.proceed();
//        closeMethod(methodSignature, object, name);
//
//        return object;
//    }
//
//    private void closeMethod(MethodSignature methodSignature, Object object, String name){
//        log.info("Closing "+name+" Method : "+ methodSignature.getMethod());
//        log.info("Result : "+ object);
//    }
//
//    private void openMethod(ProceedingJoinPoint joinPoint, MethodSignature methodSignature, String name){
//        Object[] signatureArgs = joinPoint.getArgs();
//        log.info("Entering "+name+" Method : "+ methodSignature.getMethod());
//        log.info("Input Parameters : " +methodSignature.getName());
//
//        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//        String[] sigParamNames = codeSignature.getParameterNames();
//        for (int i = 0; i < signatureArgs.length; i++) {
//            log.info(sigParamNames[i]+"   :  "+ signatureArgs[i]);
//        }
//    }
//}
//*/
