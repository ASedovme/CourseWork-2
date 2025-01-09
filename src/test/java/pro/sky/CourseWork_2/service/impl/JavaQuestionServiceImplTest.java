package pro.sky.CourseWork_2.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.CourseWork_2.exception.BadRequestException;
import pro.sky.CourseWork_2.model.Question;
import pro.sky.CourseWork_2.service.api.QuestionService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
class JavaQuestionServiceImplTest {

    private final JavaQuestionServiceImpl questionService = new JavaQuestionServiceImpl();
    private final Question test = new Question("1","1");
    private final Question test1 = new Question("2","2");

    @Test
    void add() {
        assertTrue(questionService.getAll().isEmpty());
        questionService.add(test);
        assertFalse(questionService.getAll().isEmpty());
    }

    @Test
    void testAdd() {
        questionService.add(test);
        assertFalse(questionService.getAll().isEmpty());
        questionService.add(test);
        assertEquals(1, questionService.getAll().size());
        questionService.add(test1);
        assertEquals(2, questionService.getAll().size());
    }

    @Test
    void remove() {
        questionService.add(test);
        assertFalse(questionService.getAll().isEmpty());
        questionService.remove(test);
        assertTrue(questionService.getAll().isEmpty());


    }

    @Test
    void getAll() {
        questionService.add(test);
        Collection<Question> all = questionService.getAll();
        assertFalse(all.isEmpty());
        assertTrue(all.contains(test));
    }

    @Test
    void getRandomQuestion() {
        questionService.add(test);
        Question randomQuestion = questionService.getRandomQuestion();
        assertEquals(test, randomQuestion);
    }
}