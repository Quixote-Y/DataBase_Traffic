package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Staff;
import com.tjl.dao.UserDao_imp;

public class SearchDriverDialog extends JFrame implements ActionListener {
	//定义窗口控件
		private JLabel ibNumber =new JLabel("请输入您的员工号");
		private JTextField tfNumber = new JTextField(30);
		private JLabel ibPNumber =new JLabel("请输入查询对象的员工号");
		private JTextField tfPNumber = new JTextField(30);

	    private JButton btOk =new JButton("输入完成");
	    
	    public SearchDriverDialog() {
	    	//界面初始化
	    	this.setLayout(new FlowLayout());
	    	this.add(ibNumber);
	    	this.add(tfNumber);
	    	this.add(ibPNumber);
	    	this.add(tfPNumber);
	    	this.add(btOk);
	    	this.setLocation(600, 200);
	    	this.setSize(400, 450);
	    	this.setResizable(true);
	    	this.setVisible(true);
	    	
	    	//按钮面板
			JPanel panel = new JPanel();
			JLabel lbl = new JLabel("查询员工详细信息（请确认您本人至少是路队长级别）");
			panel.add(lbl);
			panel.setPreferredSize(new Dimension(800,400));
			//窗口及框架的默认布局管理器是BorderLayout
			this.add("Center",panel);
	    	
	    	//增加监听
	    	btOk.addActionListener(this);
}
	    //重载监听
	    public void actionPerformed(ActionEvent e) {
	    	String Number = new String(tfNumber.getText());
	    	String PNumber = new String(tfPNumber.getText());
	    	
	    	 UserDao_imp userDao_imp = new UserDao_imp();
		     Staff staff=userDao_imp.SearchDriver(Number, PNumber);
		     JOptionPane.showMessageDialog(this,staff.toString());
		     
	    }
}
