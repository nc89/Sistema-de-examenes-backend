package com.exams.system.services.impl;

import com.exams.system.model.Category;
import com.exams.system.model.Exam;
import com.exams.system.repository.ExamRepository;
import com.exams.system.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Override
    public Optional<Exam> addExam(Exam exam) {
        return Optional.of(examRepository.save(exam));
    }

    @Override
    public Optional<Exam> updateExam(Exam exam) {
        return Optional.of(examRepository.save(exam));
    }

    @Override
    public Set<Exam> obtainExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Optional<Exam> obtainExam(Long examId) {
        return Optional.of(examRepository.findById(examId).get());
    }

    @Override
    public void deleteExam(Long examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        examRepository.delete(exam);
    }
    @Override
    public List<Exam> listExamsOfCategory(Category category) {
        return this.examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> obtainExamsActives() {
        return examRepository.findByActive(true);
    }

    @Override
    public List<Exam> obtainExamsActivesOfCategory(Category category) {
        return examRepository.findByCategoryAndActive(category,true);
    }
}
