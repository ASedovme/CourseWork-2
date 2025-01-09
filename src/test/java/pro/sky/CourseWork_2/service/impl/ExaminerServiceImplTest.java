package pro.sky.CourseWork_2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWork_2.exception.BadRequestException;
import pro.sky.CourseWork_2.model.Question;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl questionService;
    private final Question test = new Question("1", "1");
    private final Question test1 = new Question("2", "2");
    private final Question test2 = new Question("3", "3");

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestion() {
        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(test, test1, test2);
        Mockito.when(questionService.getAll())
                .thenReturn(Arrays.asList(test, test1, test2));
        Collection<Question> question = examinerService.getQuestion(3);
        assertTrue(question.containsAll(Arrays.asList(test, test1, test2)));

    }

    @Test
    void getQuestionAmountToBig() {
        assertThrows(BadRequestException.class, ()-> examinerService.getQuestion(1));


    }
}