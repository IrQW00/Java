package aop;

import org.springframework.stereotype.Component;

@Component
public class UnLibrary extends AbstractLibrary{

    public void getBook(){
        System.out.println("Мы берем книгу из UnLibrary");
        System.out.println("------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UnLibrary");
        return "Война и мир";
    }
    public void getMagazine(){
        System.out.println("Мы берем журнал из UnLibrary");
        System.out.println("------------------------");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UnLibrary");
        System.out.println("------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Мы добавляем книгу в UnLibrary");
        System.out.println("------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UnLibrary");
        System.out.println("------------------------");
    }
}
