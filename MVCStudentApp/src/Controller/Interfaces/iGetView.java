package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * Интерфейс для работы с просмотрщиком View
 */
public interface iGetView {
    public void printAllStudents(List<Student> students); // метод вывода в консоль списка объектов
    public String prompt(String msg); // метод запроса информации от пользователя
}
