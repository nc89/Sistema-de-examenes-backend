package com.exams.system.controller;

import com.exams.system.model.Exam;
import com.exams.system.model.Question;
import com.exams.system.services.ExamService;
import com.exams.system.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Optional<Question>> saveQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Optional<Question>> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> listQuestionsOfExam(@PathVariable("examId") Long examId){
        Optional<Exam> exam = examService.obtainExam(examId); //2
        Set<Question> questions = exam.get().getQuestions();// 6

        List exams = new ArrayList(questions);//6
        if(exams.size() > Integer.parseInt(exam.get().getNumOfQuestions())){
            exams = exams.subList(0,Integer.parseInt(exam.get().getNumOfQuestions() + 1));
        }//6 = 6.sublist(0,3) posicion 0 es la primera pregunta
        Collections.shuffle(exams);
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{questionId}")
    public Optional<Question> listQuestionById(@PathVariable("questionId") Long questionId){
        return questionService.obtainQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId){
        questionService.deleteQuestion(questionId);
    }

    @GetMapping("/exam/all/{examId}")
    public ResponseEntity<?> listQuestionOfExamWithAdmin(@PathVariable("examId") Long examId){
        Exam exam = new Exam();
        exam.setExamId(examId);
        Set<Question> questions = questionService.obtainQuestionsOfExam(exam);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/evaluate-exam")
    public ResponseEntity<?> evaluateExam(@RequestBody List<Question> questions){
        double maxPoints = 0;
        Integer validAnswers = 0;
        Integer nt = 0;

        for(Question p : questions){
            Optional<Question> question = this.questionService.obtainQuestion(p.getQuestionId());
            if(question.get().getAnswer().equals(p.getCorrectAnswer())){
                validAnswers ++;
                double points = Double.parseDouble(questions.get(0).getExam().getMaxPoints())/questions.size();
                maxPoints += points;
            }
            if(p.getCorrectAnswer() != null){
                nt ++;
            }
        }

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("maxPoints",maxPoints);
        respuestas.put("validAnswers",validAnswers);
        respuestas.put("tries",nt);
        return ResponseEntity.ok(respuestas);
    }
}
