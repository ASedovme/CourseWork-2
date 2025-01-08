package pro.sky.CourseWork_2.service.api;


import pro.sky.CourseWork_2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);


}
