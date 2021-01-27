package servlet;

import Dao.QuestionDao;
import bean.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 28182
 */
public class QuestionAdd extends HttpServlet {
    QuestionDao dao = new QuestionDao();
    Question question = null;
    int result = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title, optionA, optionB, optionC, optionD, answer;
        title = req.getParameter("title");
        optionA = req.getParameter("questionA");
        optionB = req.getParameter("questionB");
        optionC = req.getParameter("questionC");
        optionD = req.getParameter("questionD");
        answer = req.getParameter("answer");

        question = new Question(1, title, optionA, optionB, optionC, optionD, answer);

        try {
            result = dao.add(question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
