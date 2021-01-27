package Dao;

import bean.Question;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 28182
 */

public class Test {
    public static void main(String[] args) throws SQLException {
        QuestionDao dao = new QuestionDao();
        Question question = new Question(28, "my love is who?", "where?", "text2", "text3", "text4", "000");
        try {
            dao.add(question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Test test = new Test();
        test.exec(dao);
    }

    void exec(QuestionDao dao) throws SQLException {
        List<Question> list = dao.findAll();
        for (Question question : list) {
            System.out.println(question.getQuestionId());
            System.out.println(question.getOptionA());
            System.out.println(question.getOptionB());
            System.out.println(question.getOptionC());
            System.out.println(question.getOptionD());
            System.out.println(question.getAmswer());
        }
    }
}
