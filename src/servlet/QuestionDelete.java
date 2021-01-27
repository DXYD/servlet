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
public class QuestionDelete extends HttpServlet {
    QuestionDao dao = new QuestionDao();
    int result = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer deleteId = Integer.valueOf(req.getParameter("QuestionDeleteId"));
        Question question = new Question(deleteId);
        try {
            result = dao.delete(question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/index.html").forward(req, resp);

    }

}
