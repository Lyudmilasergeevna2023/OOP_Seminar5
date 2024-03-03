package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class ControllerClass {

    //private iGetModel model;
    private List<iGetModel> models;
    private iGetView view;
    private List<Student> bufferStudentList = new ArrayList<>();
    private HashMap<String, iGetView> languageViewMap = new HashMap<>();

    public ControllerClass(List<iGetModel> models, String language) {
        languageViewMap.put("EN", new ViewClassEng());
        languageViewMap.put("RU", new ViewClass());
        this.models = models;
        if (languageViewMap.containsKey(language.toUpperCase())) {
            this.view = languageViewMap.get(language.toUpperCase());
        } else {
            this.view = languageViewMap.get("EN");
        }
    }


    /**
     * Проверка наличия данных об объектах
     * 
     * @param students - текущий список объектов из хранилища данных
     * @return true или false - результат проверки наличия каких-либо данных
     */
    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
     * Обновление буффера данных об объектах
     */
    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP        
        bufferStudentList = new ArrayList<>();
        for (iGetModel model : models) {
            bufferStudentList.addAll(model.getAllStudents());
        }
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            System.out.println("Список студентов пуст!");
        }
    }

    
    /**
     * Запуск основного рабочего цикла для взаимодействия с пользователем
     */
    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    update();
                    //view.printAllStudents(model.getAllStudents());
                    break;
                case DELETE:
                    operationDelete();
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }


    /**
     * Метод для команды удаления записи
     */
    private void operationDelete() {
        Integer idStudent = Integer.parseInt(
                view.prompt("Введите id студента для удаления: "));
        boolean isDeleted = false;
        for (iGetModel model : models) {
            if (model.deleteStudent(idStudent)) {
                isDeleted = true;
                break;
            }
        }
        if (isDeleted) {
            System.out.println("Студент с id=" + idStudent + " успешно удалён.");
        } else {
            System.out.println("Студент с id=" + idStudent + " не существует.");
        }
    }


}
