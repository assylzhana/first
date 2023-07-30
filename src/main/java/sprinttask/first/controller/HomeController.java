package sprinttask.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sprinttask.first.db.DBManager;
import sprinttask.first.models.Student;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(Model model) {
        List<Student> students = DBManager.getStudents();
        for (Student student : students) {
            student.setMark(generateMark(student.getExam()));
        }
        model.addAttribute("student", students);
        return "home";
    }

    @PostMapping("/add-student")
    public String add(@RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      @RequestParam("exam") int exam) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        student.setMark(generateMark(exam));
        DBManager.addStudent(student);
        return "redirect:/";
    }

    private String generateMark(int exam) {
        if (exam >= 90 && exam <= 100) {
            return "A";
        } else if (exam >= 75 && exam <= 89) {
            return "B";
        } else if (exam >= 60 && exam <= 74) {
            return "C";
        } else if (exam >= 50 && exam <= 59) {
            return "D";
        } else {
            return "F";
        }
    }
}
