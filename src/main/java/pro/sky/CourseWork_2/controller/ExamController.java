package pro.sky.CourseWork_2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWork_2.model.Question;
import pro.sky.CourseWork_2.service.api.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam")
    public Collection<Question> getQuestion(@RequestParam int amount) {
        return examinerService.getQuestion(amount);
    }


}
