package pro.sky.CourseWork_2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork_2.exception.QuestionNotFoundException;
import pro.sky.CourseWork_2.model.Question;
import pro.sky.CourseWork_2.service.api.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
    }
}
