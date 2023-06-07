package com.exams.system.controller;

import com.exams.system.model.Category;
import com.exams.system.model.Exam;
import com.exams.system.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Optional<Exam>> saveExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.addExam(exam));
    }

    @PutMapping("/")
    public ResponseEntity<Optional<Exam>> updateExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.updateExam(exam));
    }

    @GetMapping("/")
    public ResponseEntity<?> listExams(){
        return ResponseEntity.ok(examService.obtainExams());
    }

    @GetMapping("/{examId}")
    public Optional<Exam> listExam(@PathVariable("examId") Long examId){
        return examService.obtainExam(examId);
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable("examId") Long examId){
        examService.deleteExam(examId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Exam> listExamsOfCategory(@PathVariable("categoryId") Long categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.listExamsOfCategory(category);
    }

    @GetMapping("/active")
    public List<Exam> listExamsActives(){
        return examService.obtainExamsActives();
    }

    @GetMapping("/category/active/{categoryId}")
    public List<Exam> listExamsActivesOfCategory(@PathVariable("categoryId") Long categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.obtainExamsActivesOfCategory(category);
    }
}
