package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.dao.UserDao_imp;

public class SearchPeccantTsDialog extends JFrame implements ActionListener {
	//定义窗口控件
		private JLabel ibPNumber =new JLabel("请输入您的员工号");
		private JTextField tfPNumber = new JTextField(30);
		private JLabel ibNumber =new JLabel("请输入查询对象的员工号");
		private JTextField tfNumber = new JTextField(30);
		private JLabel ibTime =new JLabel("请输入查询时间区间（2000-01-01-1:00-2001-01-01-3:00）");
		private JTextField tfTime = new JTextField(30);

	    private JButton btOk =new JButton("输入完成");
	    
	    
	    public SearchPeccantTsDialog () {
	    	//界面初始化
	    	this.setLayout(new FlowLayout());
	    	this.add(ibNumber);
	    	this.add(tfNumber);
	    	this.add(ibPNumber);
	    	this.add(tfPNumber);
	    	this.add(ibTime);
	    	this.add(tfTime);
	    	this.add(btOk);
	    	this.setLocation(600, 200);
	    	this.setSize(400, 450);
	    	this.setResizable(true);
	    	this.setVisible(true);
	    	//按钮面板
			JPanel panel = new JPanel();
			JLabel lbl = new JLabel("查询员工违章信息（请确认您本人至少是路队长级别）");
			panel.add(lbl);
			panel.setPreferredSize(new Dimension(800,400));
			//窗口及框架的默认布局管理器是BorderLayout
			this.add("Center",panel);
	    	
	    	//增加监听
	    	btOk.addActionListener(this);
}
	    //重载监听
	    public void actionPerformed(ActionEvent e) {
	    	String Number = new String(tfNumber.getText());//被查询者员工号
	    	String PNumber = new String(tfPNumber.getText());//查询者员工号
	    	String Time = new String(tfTime.getText());//查询时间区间

	    	UserDao_imp userDao_imp = new UserDao_imp();
	    	String res=userDao_imp.SearchPeccantTs(Number, PNumber, Time);
	    	JOptionPane.showMessageDialog(this,res);
	    }
}