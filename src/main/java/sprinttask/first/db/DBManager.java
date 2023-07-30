package sprinttask.first.db;

import lombok.Getter;
import sprinttask.first.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager{
    @Getter
    private static List<Student> students = new ArrayList<>();
    static Long id= 5L;

    static{
        students.add(new Student(1L,"Karakat","Almasova",99,"A"));
        students.add(new Student(2L,"Assylzhan","Kabibulla",80,"B"));
        students.add(new Student(3L,"Albina","Yermek",74,"C"));
        students.add(new Student(4L,"Medat","Zeinkulov",48,"F"));
    }
    public static void addStudent(Student s){
        s.setId(id);
        id++;
        students.add(s);
    }
}

