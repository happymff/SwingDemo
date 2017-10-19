/**
 * Created by mff on 2017/10/19.
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TestForDB extends JFrame implements ActionListener {

    public static void main(String[] args) {
        TestForDB t1 = new TestForDB();
        t1.setVisible(true);       //设置窗体可见

    }

    JButton button1;
    JButton button2;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;

    public TestForDB() {
        super();
        this.setTitle("查询基本信息");
        this.setBounds(200, 200, 350, 260);   //setSize(int width,int hight);setBounds(x,y,width,hight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container p = getContentPane();
        p.setLayout(null);

        JLabel label1 = new JLabel("姓名：");
        label1.setBounds(80, 10, 40, 20);
        p.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(130, 8, 120, 20);
        p.add(textField1);

        button1 = new JButton("查询");
        button1.setBounds(100, 40, 60, 20);
        button1.addActionListener(this);  //添加鼠标响应事件
        p.add(button1);

        button2 = new JButton("重置");
        button2.setBounds(180, 40, 60, 20);
        button2.addActionListener(this);
        p.add(button2);

        JPanel resultPanel = new JPanel();
        resultPanel.setBounds(40, 90, 260, 100);

        //定义指定颜色，指定标题的边框
        TitledBorder tb = new TitledBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)), "查询结果");
        tb.setTitleColor(Color.blue);//设置标题颜色

        resultPanel.setBorder(tb);    //将标题边框添加到面板中
        //resultPanel.setBackground(Color.yellow);
        resultPanel.setLayout(null);
        JLabel label2 = new JLabel("姓名：");
        label2.setBounds(80, 110, 40, 20);
        p.add(label2);
        textField2 = new JTextField();
        textField2.setBounds(130, 108, 120, 20);
        p.add(textField2);
        JLabel label3 = new JLabel("密码");
        label3.setBounds(80, 140, 40, 20);
        p.add(label3);
        textField3 = new JTextField();
        textField3.setBounds(130, 140, 120, 20);
        p.add(textField3);

        p.add(resultPanel);
    }

    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == button1) {
            String name = textField1.getText();
            String password = search(name);
            textField2.setText(name);
            textField3.setText(password);
        }
        if (jb == button2) {
            textField1.setText("");
        }

    }

    public String search(String name) {
        String password = "";
        try {
            Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select Pwd from userInfo where Name='" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                password = rs.getString(1);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}