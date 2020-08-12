package test5;

import com.isoft.db.DBConnection;

import java.sql.*;

public class Test5 {
    public static void main(String args[])throws SQLException {
        long start = System.currentTimeMillis();
        Connection conn = DBConnection.getInstance().getConn();
        conn.setAutoCommit(false);
        PreparedStatement ps = null;
        String sql = "insert into tb_stu values (null,?,?,?,?,?)";
        String sql2 = "insert into tb_class values (?,?,?,?,?,?)";
        String sql3 = "insert into tb_score values (?,?,?,?,?)";
        ps = conn.prepareStatement(sql3); // 批量插入时ps对象必须放到for循环外面
        String[] tname={"张","王","嫖","刘","白","赵"};
        String[] college = {"华信" , "计科" , "管院"};
        String phone = "188922110";
        String[] sname = {"js","java","c++","c","c#","php"};
        int [] classid = {1,2,3,4,5,6};
        int[] age = {18,17,22,21,23,19};
        //插入班级信息tb_class
//        for (int i = 0; i < 6; i++) {
//            int j = (int) (Math.random()*6);
//            int k = (int) (Math.random()*3);
//            ps.setInt(1,classid[j]);
//            ps.setString(2,j+"班");
//            ps.setInt(3,(i+1));
//            ps.setInt(4,(2001+i));
//            ps.setString(5,tname[j]+"老师");
//            ps.setString(6,college[k]+"学院");
//            ps.addBatch();
//        }
//插入学生信息tb_stu
//        for (int i=0;i < 20;i++){
//            int j = (int) (Math.random()*4);
//            int k = (int) (Math.random()*6);
//            ps.setString(1, tname[j]+"同学");
//            ps.setInt(2,age[k]);
//            ps.setString(3,phone+i);
//            ps.setInt(4,classid[k]);
//            ps.setInt(5,classid[k]);
//            ps.addBatch();
//            // 每1000条记录插入一次
//            if (i % 10 == 0){
//                ps.executeBatch();
//                conn.commit();
//                ps.clearBatch();
//            }
//        }
        for (int i=0;i < 50;i++){
            int j = (int) (Math.random()*4);
            int k = (int) (Math.random()*6);
            ps.setInt(1,i+1);
            ps.setString(2, sname[k]);
            ps.setInt(3,age[k]);
            ps.setString(4, String.valueOf(i));
            ps.setInt(5,classid[k]);
            ps.addBatch();
            // 每1000条记录插入一次
            if (i % 10 == 0){
                ps.executeBatch();
                conn.commit();
                ps.clearBatch();
            }
        }
        
        // 剩余数量不足1000
        System.out.println(ps);
        ps.executeBatch();
        conn.commit();
        ps.clearBatch();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
