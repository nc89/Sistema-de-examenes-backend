package com.exams.system.repository;

import com.exams.system.model.Category;
import com.exams.system.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> findByCategory(Category category);
    List<Exam> findByActive(Boolean status);
    List<Exam> findByCategoryAndActive(Category category, Boolean status);
}
