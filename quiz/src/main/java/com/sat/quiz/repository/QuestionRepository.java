package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findByModuleId(Long id);

    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findByTextQuestionId(Long id);
    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAllByTextQuestionIdNotNull();



    List<Question> findAllByTextQuestionIdIsNull();


    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAllByOrderByIdAsc();

    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAllByQuizIdAndModuleIdAndTextQuestionIsNull(Long quizId,Long moduleId);

    @EntityGraph(attributePaths = {"textQuestion","answers","answers.variant","module","module.section","quiz"})
    Question findByQuizIdAndModuleIdAndOrderNumber(Long quizId,Long moduleId,int orderNumber);

    //@EntityGraph(attributePaths = {"textQuestion","answers","answers.variant","module","module.section","quiz"})
    @Query(value = "SELECT order_number FROM question where quiz_id=? and module_id=? ", nativeQuery = true)
    List<Object> findAllOrderNumberByQuizIdAndModuleId(Long quizId, Long moduleId);


    @EntityGraph(attributePaths = {"textQuestion","answers","answers.variant","module","module.section","quiz"})
    Question findByQuizIdAndModuleIdAndOrderNumberOrderByAnswers_Variant_Id(Long quizId, Long moduleId, int orderNumber);
}
