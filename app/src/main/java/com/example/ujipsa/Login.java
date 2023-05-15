package com.example.ujipsa;

import javax.swing.*;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 */
import java.net.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

//+변경후
public class Login{
    /*
    private JTextField txtId;
    private JTextField txtPwd;
    private JButton OKButton;
    private JPanel mainPanel;
    private JLabel regLabel;
    private JButton REGbutton;
    private JLabel alert;

    String inputID ;
    String inputPW ;
*/
    public Login() {


// 수정
        // 수정 222
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con=null;



                String dbURL = "jdbc:mysql://localhost:3307/main";

                String user_name = "root"; //  MySQL 서버 아이디
                String password = "0000"; // MySQL 서버 비밀번호

                // 1.드라이버 로딩
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    System.err.println(" !! <JDBC 오류> Driver load 오류: " + e1.getMessage());
                    e1.printStackTrace();
                }

                // 2.연결
                try {
                    con = DriverManager.getConnection(dbURL /*+ "?useSSL=false"*/, user_name, password);
                    System.out.println("정상적으로 연결되었습니다.");
                } catch(SQLException e2) {
                    System.err.println("con 오류:" + e2.getMessage());
                    e2.printStackTrace();
                }

                Statement stmt = null;

                ResultSet rs=null;

                try {
                    stmt = con.createStatement();
                } catch (SQLException e3) {
                    throw new RuntimeException(e3);
                }
                String sql = "select userID, userPassword,userNO from userinfo";
                try {
                    rs = stmt.executeQuery(sql);
                } catch (SQLException e4) {
                    throw new RuntimeException(e4);
                }
                System.out.println("ID: " + txtId.getText() + "\tPWD: " + txtPwd.getText() + "\n");

                inputID = txtId.getText();
                inputPW = txtPwd.getText();

                String id = null; //DB에서 받아와야함
                String pw = null;
                Integer NO = null;

                while (true) {
                    try {
                        if (!rs.next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
/*
                    try {
                        System.out.println(rs.getString(1));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
*/

                    try {
                        id = rs.getString(1);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        pw = rs.getString(2);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        NO = Integer.valueOf(rs.getString(3));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (id.equals(txtId.getText()))
                    {
                        if (pw.equals(txtPwd.getText()))
                        {
                            // System.out.println("MainPage view 직전");
                            MainPage view = new MainPage(NO);
                            dispose();
                        } else
                        {
                            alert.setHorizontalAlignment(JLabel.CENTER);
                            alert.setText("<HTML><font color = 'red'><text-align:right>PassWord is wrong</HTML>");

                        }
                    }
                    else
                    {
                        alert.setHorizontalAlignment(JLabel.CENTER);
                        alert.setText("<HTML><font color = 'red'><text-align:right>There is no account</HTML>");
                    }
                }


                // 3.해제
                try {
                    if(con != null)
                        con.close();
                    if(stmt!=null && !stmt.isClosed())
                        stmt.close();
                    if(rs!=null)
                        rs.close();
                } catch (SQLException e6) {e6.printStackTrace();}
            }
        });





        REGbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register view = new Register();
            }
        });

        setContentPane(mainPanel);

        setSize(700, 425);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instagram");
        setVisible(true);






    }
}









