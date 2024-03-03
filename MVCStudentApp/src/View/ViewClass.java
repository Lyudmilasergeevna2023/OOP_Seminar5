package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;


/**
 * Класс ViewClass описывает структуру для работы со списком объектов на русском языке
 */
public class ViewClass implements iGetView {
    
    /**
     * Выводит в консоль список объектов
     * @param students - список объектов для вывода
     */

    public void printAllStudents(List<Student> students){
        System.out.println("--------------------Список студентов-------------------");
        for(Student s: students){
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
    
    
    /**
     * Метод запроса информации от пользователя
     * @param message - сообщение для пользователя
     * @return данные типа String введенные пользователем
     */

    public String prompt(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
