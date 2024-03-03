package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/**
 * Класс с хранилищем типа HashMap<int,Student>
 */
public class ModelClassHash implements iGetModel {
    private HashMap<Integer, Student> mapStudents;

    public ModelClassHash(List<Student> listStudents) {
        this.mapStudents = new HashMap<>();
        for (Student student : listStudents) {
            this.mapStudents.put(student.getId(), student);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(mapStudents.values());
    }

    @Override
    public boolean deleteStudent(Integer idStudent) {
        if (!isStudentExist(idStudent)) {
            return false;
        }
        mapStudents.remove(idStudent);
        return true;
    }


    @Override
    public boolean isStudentExist(Integer idStudent) {
        return mapStudents.containsKey(idStudent);
    }


    
}
