package servlet;

import bean.Students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 28182
 */

//查询学生信息
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students s1 = new Students("zhangsan123",true,15);
        Students s2 = new Students("ziwansan123",false,17);

        List stuList = new ArrayList();
        stuList.add(s1);
        stuList.add(s2);

        req.setAttribute("key",stuList);

        //通过请求转发方案，向tomcat申请4调用user_show,jsp
        //同时将req和resp 通过tomcat转发给user_show.jsp使用
        req.getRequestDispatcher("/user_show.jsp").forward(req,resp);
    }
}
