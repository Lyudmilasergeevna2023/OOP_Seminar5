package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * интерфейс для работы с хранилищем данных Model
 */
public interface iGetModel {
    public List<Student> getAllStudents(); // список объектов из хранилища данных
    public boolean deleteStudent(Integer idStudent); // метод удаления записи объекта из хранилища данных
    public boolean isStudentExist(Integer idStudent); // метод для проверки наличия объекта в хранилище данных
}
