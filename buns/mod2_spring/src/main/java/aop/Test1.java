package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        UnLibrary unlibrary = context.getBean("unlibrary", UnLibrary.class);
       Book book =  context.getBean("book", Book.class);

        unlibrary.getBook();
        unlibrary.addBook("Zaur", book);
        unlibrary.addMagazine();
//        unlibrary.addBook();
//        unlibrary.returnBook();


//        SchoolLibrary schoolLibrary = context.getBean("schoollibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
        context.close();
    }
}
