package Model;

import java.sql.*;

public class DBUtil6157 {
    private Connection connection;
    private static DBUtil6157 dbUtil;
    private String url = "";
    private String driver = "";
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    //构造函数建立数据库连接
    private DBUtil6157() throws ClassNotFoundException, SQLException {
            // 1、加载数据库驱动
            Class.forName("org.sqlite.JDBC");
            // 2、连接数据库
            connection = DriverManager.getConnection("jdbc:sqlite:211906157+陈茜乐图片爬虫系统数据库");
    }
    //获取数据库对象方法
    public static DBUtil6157 getDbUtil() throws SQLException, ClassNotFoundException {
        if (dbUtil == null) {
            dbUtil = new DBUtil6157();
        }
        return dbUtil;
    }
    //通过账号密码找到用户昵称，并返回
    public static String findUser(int id,String str) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            connection = DBUtil6157.getDbUtil().connection;
            //SQL语句
            pstmt = connection.prepareStatement("SELECT user_name FROM user WHERE user_id = ? AND user_password = ?");
            // 执行查询语句
            pstmt.setInt(1,id);
            pstmt.setString(2,str);
            result = pstmt.executeQuery();
            result.getString("user_name");
            if(result.wasNull()){
                return "false";
            } else {
                return result.getString("user_name");
            }

        } catch (SQLException e) {
            System.out.println("数据库加载出错1");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载出错2");
        }finally {
            pstmt.close();
            // connection.close();
            result.close();
        }
        return "false";
    }
    //向user表里面增加用户
    public static Boolean addUser(int id,String name,String password) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            //得到数据库的连接
            connection = DBUtil6157.getDbUtil().connection;
            //SQL语句
            pstmt = connection.prepareStatement("INSERT INTO user(user_id,user_name,user_password) values(?,?,?) ");
            // 执行查询语句
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,password);
            result = pstmt.executeUpdate();
            System.out.println("语句执行结果:"+result);
        } catch (SQLException e) {
            //加提醒
            // JOptionPane.showMessageDialog(null, "添加用户失败！请注意格式：账号只能用数字");
            System.out.println("error:101");
            // e.printStackTrace();
        }finally {
            pstmt.close();
        }
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

}
