package pro.sky.CourseWork_2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork_2.exception.BadRequestException;
import pro.sky.CourseWork_2.model.Question;
import pro.sky.CourseWork_2.service.api.ExaminerService;
import pro.sky.CourseWork_2.service.api.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > service.getAll().size()) {
            throw new BadRequestException();
        }
        Set<Question> questions = new HashSet<>();
        while (amount > questions.size()) {
            questions.add(service.getRandomQuestion());
        }
        return questions;
    }
}
