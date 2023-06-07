package com.exams.system.services;

import com.exams.system.model.Category;
import com.exams.system.model.Exam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ExamService {
    Optional<Exam> addExam(Exam exam);
    Optional<Exam> updateExam(Exam exam);
    Set<Exam> obtainExams();
    Optional<Exam> obtainExam(Long examId);
    void deleteExam(Long examId);
    List<Exam> listExamsOfCategory(Category category);
    List<Exam> obtainExamsActives();
    List<Exam> obtainExamsActivesOfCategory(Category category);
}
