package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Car;
import com.tjl.dao.UserDao_imp;

public class EnterCarDialog extends JFrame implements ActionListener {
	//定义窗口控件
	private JLabel ibNumber =new JLabel("请输入车牌号");
	private JTextField tfNumber = new JTextField(25);
	private JLabel ibCNumber =new JLabel("请输座位数");
	private JTextField tfCNumber = new JTextField(15);
    private JButton btOk =new JButton("输入完成");
    
    public EnterCarDialog() {
    	//界面初始化
    	this.setLayout(new FlowLayout());
    	this.add(ibNumber);
    	this.add(tfNumber);
    	this.add(ibCNumber);
    	this.add(tfCNumber);

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
    	String CNumber = new String(tfCNumber.getText());
    	int cnumber = Integer.parseInt(CNumber);
    	

    	Car car = new Car(Number,cnumber);
        UserDao_imp userDao_imp = new UserDao_imp();
        boolean res = userDao_imp.EnterCar(car);
        if(res==true)
           JOptionPane.showMessageDialog(this,Number+"录入成功");
        else
        	 JOptionPane.showMessageDialog(this,Number+"录入失敗");
    }

    
}
