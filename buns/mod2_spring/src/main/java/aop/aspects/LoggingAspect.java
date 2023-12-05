package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

// 1
//    @Pointcut("execution (* aop.UnLibrary.*(..))")
//    private void allMethodsFromUnLibrary() {
//    }
//    @Pointcut("execution(public void aop.UnLibrary.returnMagazine())")
//    private void returnMagazineFromUnLibrary(){}
//
//    @Pointcut("allMethodsFromUnLibrary() && !returnMagazineFromUnLibrary()")
//    private void allMethodsExceptReturnMagazineFromUnLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUnLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineFromUnLibrary(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromUnLibrary: log #10");
//    }

// 2
//    @Pointcut("execution(* aop.UnLibrary.get*())")
//    private void allGetMethodsFromUnLibrary(){
//    }
//
//    @Pointcut("execution(* aop.UnLibrary.return*())")
//    private void allReturnMethodsFromUnLibrary(){
//    }
//
//    @Pointcut("allGetMethodsFromUnLibrary() || allReturnMethodsFromUnLibrary())")
//    private void allGetAndReturnMethodsFromUnLibrary(){
//    }
//
//    @Before("allGetMethodsFromUnLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing log #1");
//    }
//
//    @Before("allReturnMethodsFromUnLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUnLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
//    }





    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = "
                + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = "
                + methodSignature.getName());

//        if(methodSignature.getName().equals("addBook")){
//            Object[] arguments = joinPoint.getArgs();
//            for(Object obj:arguments){
//                if(obj instanceof Book){
//                    Book myBook = (Book) obj;
//                    System.out.println("Информация о книге: название -  = "
//                            + myBook.getName() + ", автор - " + myBook.getAuthor() +
//                                    ", год издания - " + myBook.getYearOfPublication());
//                }
//                else if (obj instanceof String){
//                    System.out.println("книгу в библиотеку добавляет" + obj);
//                }
//            }
//        }
        System.out.println("beforeGetLoggingAdvice: логирование" +
                "попытки получить книгу");
        System.out.println("------------------------");
    }
}
