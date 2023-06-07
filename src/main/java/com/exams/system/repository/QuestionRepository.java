package com.exams.system.repository;


import com.exams.system.model.Exam;
import com.exams.system.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByExam(Exam exam);
}
