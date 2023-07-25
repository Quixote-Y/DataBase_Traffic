package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Peccant;
import com.tjl.dao.UserDao_imp;

public class EnterPeccantDialog extends JFrame implements ActionListener {
	//定义窗口控件
		private JLabel ibSPNumber =new JLabel("请输入违章人员工号");
		private JTextField tfSPNumber = new JTextField(30);
		private JLabel ibPNumber =new JLabel("违章记录编号");
		private JTextField tfPNumber = new JTextField(30);
		private JLabel ibPName = new JLabel("违章名");
		private JTextField tfPName = new JTextField(30);
	    private JLabel ibPTime = new JLabel("请输入发生时间");
	    private JTextField tfPTime =new JTextField(20);
	    private JLabel ibPPlace = new JLabel("请输入发生地点");
	    private JTextField tfPPlace =new JTextField(20);
		private JLabel ibNumber =new JLabel("请输入记录人员工号");
		private JTextField tfNumber = new JTextField(30);
	    private JButton btOk =new JButton("输入完成");
	    
	    public EnterPeccantDialog() {
	    	//界面初始化
	    	this.setLayout(new FlowLayout());
	    	this.add(ibNumber);
	    	this.add(tfNumber);
	    	this.add(ibSPNumber);
	    	this.add(tfSPNumber);
	    	this.add(ibPNumber);
	    	this.add(tfPNumber);
	    	this.add(ibPName);
	    	this.add(tfPName);
	    	this.add(ibPTime);
	    	this.add(tfPTime);
	    	this.add(ibPPlace);
	    	this.add(tfPPlace);
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
	    	String Number = new String(tfNumber.getText());//记录员工工号
	    	String SPNumber = new String(tfSPNumber.getText());//违章员工工号
	    	String pNumber = new String(tfPNumber.getText());//违章记录编号
	    	int PNumber =Integer.parseInt(pNumber);
	    	String PName = new String(tfPName.getText());//违章记录名
	    	String PTime = new String(tfPTime.getText());
	    	String PPlace = new String(tfPPlace.getText());
	    	
	    	Peccant pec = new Peccant(PNumber,PName,SPNumber,PTime,PPlace,Number);
	    	
	        UserDao_imp userDao_imp = new UserDao_imp();
	        boolean res = userDao_imp.EnterSPeccant(pec);
	        if(res==true)
	           JOptionPane.showMessageDialog(this,PName+"录入成功");
	        else
	        	 JOptionPane.showMessageDialog(this,PName+"录入失敗");
	    }

}
