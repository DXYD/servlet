package servlet;

import Dao.QuestionDao;
import bean.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 28182
 */
public class QuestionFind extends HttpServlet {
    QuestionDao dao = new QuestionDao();
    Question question = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List list = dao.findAll();
            req.setAttribute("info", list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            req.getRequestDispatcher("/info.jsp").forward(req,resp);
        }
    }
}
