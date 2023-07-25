package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Staff;
import com.tjl.dao.UserDao_imp;

public class EnterDriverDialog extends JFrame implements ActionListener {
	//定义窗口控件
	private JLabel ibNumber =new JLabel("请输入工号");
	private JTextField tfNumber = new JTextField(30);
	private JLabel ibName =new JLabel("请输入姓名");
	private JTextField tfName = new JTextField(15);
	private JLabel ibSex = new JLabel("请选择性别");
	private JRadioButton rbSex1 = new JRadioButton("男",true);
	private JRadioButton rbSex2 = new JRadioButton("女",false);
    private ButtonGroup bgSex =new ButtonGroup();
    private JLabel ibBirthday = new JLabel("请输入出生年月日");
    private JTextField tfBirthday =new JTextField(20);
    private JButton btOk =new JButton("输入完成");
    
    public EnterDriverDialog() {
    	//界面初始化
    	this.setLayout(new FlowLayout());
    	this.add(ibNumber);
    	this.add(tfNumber);
    	this.add(ibName);
    	this.add(tfName);
    	bgSex.add(rbSex1);
    	bgSex.add(rbSex2);
    	this.add(ibSex);
    	this.add(rbSex1);
    	this.add(rbSex2);
    	this.add(ibBirthday);
    	this.add(tfBirthday);
    	this.add(btOk);
    	this.setLocation(600, 200);
    	this.setSize(400, 450);
    	this.setResizable(true);
    	this.setVisible(true);
    	
    	//增加监听
    	btOk.addActionListener(this);
      	
    }
    //重载监听
    public void actionPerformed(ActionEvent e) {
    	String Number = new String(tfNumber.getText());
    	String Name = new String(tfName.getText());
    	String sex;
    	if(rbSex1.isSelected())
    		sex=(String)rbSex1.getText();
    	else
    		sex=(String)rbSex2.getText();
        String Birthday = new String(tfBirthday.getText());
        Staff staff = new Staff(Number,Name,sex,Birthday);
        UserDao_imp userDao_imp = new UserDao_imp();
        boolean res = userDao_imp.EnterDriver(staff);
        if(res==true)
           JOptionPane.showMessageDialog(this,Name+"录入成功");
        else
        	 JOptionPane.showMessageDialog(this,Name+"录入失敗");
    }

    
}
