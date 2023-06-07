package com.exams.system.services;

import com.exams.system.model.Exam;
import com.exams.system.model.Question;

import java.util.Optional;
import java.util.Set;

public interface QuestionService {
    Optional<Question> addQuestion(Question question);
    Optional<Question> updateQuestion(Question question);
    Set<Question> obtainQuestions();
    Optional<Question> obtainQuestion(Long questionId);
    void deleteQuestion(Long questionId);
    Set<Question> obtainQuestionsOfExam(Exam exam);

}
