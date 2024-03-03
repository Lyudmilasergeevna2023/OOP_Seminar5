package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/**
 * Класс ViewClassEng описывает структуру для работы со списком объектов на английском языке
 */
public class ViewClassEng implements iGetView {

    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("--- List students ---");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("--- --- ---");
    }


    @Override
    public String prompt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }    
}
