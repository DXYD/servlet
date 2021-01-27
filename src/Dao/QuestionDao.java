package Dao;

import Util.JdbcUtil;
import bean.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 28182
 */
public class QuestionDao {
    JdbcUtil util = new JdbcUtil();

    /**
     * 增删改查操作
     * @param question
     */

    /**
     * 添加问题
     */
    public int add(Question question) throws SQLException {
        String sql = "insert into questionform(title,questionA,questionB,questionC,questionD,answer) values(?,?,?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.creatPreparedStatement(sql);
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAmswer());
            result = ps.executeUpdate();
            System.out.println("add,成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    /**
     * 删除问题
     * 根据问题编号删除问题
     */
    public int delete(Question question) throws SQLException {
        String sql = "delete from questionform where questionId=?";
        int result = 0;
        PreparedStatement ps = util.creatPreparedStatement(sql);
        ps.setInt(1, question.getQuestionId());
        result = ps.executeUpdate();
        System.out.println("delete,成功");
        util.close();
        return result;
    }

    /**
     * 更新数据
     */
    public int update(Question question) throws SQLException {
        String sql = "update questionform set title=?,questionA=?,questionB=?,questionC=?,questionD=?,answer=? where questionId=?";
        int result = 0;
        PreparedStatement ps = util.creatPreparedStatement(sql);

        ps.setString(1, question.getTitle());
        ps.setString(2, question.getOptionA());
        ps.setString(3, question.getOptionB());
        ps.setString(4, question.getOptionC());
        ps.setString(5, question.getOptionD());
        ps.setString(6, question.getAmswer());
        ps.setInt(7, question.getQuestionId());
        result = ps.executeUpdate();
        System.out.println("update,成功");
        util.close();
        return result;
    }

    /**
     * 查找数据
     * 查询所以
     */
    public List findAll() throws SQLException {
        String sql = "select * from questionform";
        ResultSet rs = util.executeQ(sql);
        List list = new ArrayList();
        try {
            while (rs.next()) {
                int questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String OptionA = rs.getString("questionA");
                String OptionB = rs.getString("questionB");
                String OptionC = rs.getString("questionC");
                String OptionD = rs.getString("questionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId,title,OptionA,OptionB,OptionC,OptionD,answer);
                list.add(question);
            }
            System.out.println("rs,成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
            util.close(rs);
        }
        return list;
    }
}
