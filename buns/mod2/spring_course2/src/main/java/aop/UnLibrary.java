package aop;

import org.springframework.stereotype.Component;

@Component
public class UnLibrary extends AbstractLibrary{
    @Override
    public void getBook(){
        System.out.println("Мы берем книгу из UnLibrary");
    }

    void returnBook(){
        System.out.println("Мы возвращаем книгу в UnLibrary");
    }
    public void getMagazine(){
        System.out.println("Мы берем журнал из UnLibrary");
    }
}
