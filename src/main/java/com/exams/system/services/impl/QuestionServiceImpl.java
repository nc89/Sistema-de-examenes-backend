package com.exams.system.services.impl;

import com.exams.system.model.Exam;
import com.exams.system.model.Question;
import com.exams.system.repository.QuestionRepository;
import com.exams.system.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Optional<Question> addQuestion(Question question) {
        return Optional.of(questionRepository.save(question));
    }

    @Override
    public Optional<Question> updateQuestion(Question question) {
        return Optional.of(questionRepository.save(question));
    }

    @Override
    public Set<Question> obtainQuestions() {
        return (Set<Question>) questionRepository.findAll();
    }

    @Override
    public Optional<Question> obtainQuestion(Long questionId) {
        return Optional.of(questionRepository.findById(questionId).get());
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuestionId(questionId);
        questionRepository.delete(question);
    }

    @Override
    public Set<Question> obtainQuestionsOfExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }
}
