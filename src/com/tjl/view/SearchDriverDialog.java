package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Staff;
import com.tjl.dao.UserDao_imp;

public class SearchDriverDialog extends JFrame implements ActionListener {
	//���崰�ڿؼ�
		private JLabel ibNumber =new JLabel("����������Ա����");
		private JTextField tfNumber = new JTextField(30);
		private JLabel ibPNumber =new JLabel("�������ѯ�����Ա����");
		private JTextField tfPNumber = new JTextField(30);

	    private JButton btOk =new JButton("�������");
	    
	    public SearchDriverDialog() {
	    	//�����ʼ��
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
	    	
	    	//��ť���
			JPanel panel = new JPanel();
			JLabel lbl = new JLabel("��ѯԱ����ϸ��Ϣ����ȷ��������������·�ӳ�����");
			panel.add(lbl);
			panel.setPreferredSize(new Dimension(800,400));
			//���ڼ���ܵ�Ĭ�ϲ��ֹ�������BorderLayout
			this.add("Center",panel);
	    	
	    	//���Ӽ���
	    	btOk.addActionListener(this);
}
	    //���ؼ���
	    public void actionPerformed(ActionEvent e) {
	    	String Number = new String(tfNumber.getText());
	    	String PNumber = new String(tfPNumber.getText());
	    	
	    	 UserDao_imp userDao_imp = new UserDao_imp();
		     Staff staff=userDao_imp.SearchDriver(Number, PNumber);
		     JOptionPane.showMessageDialog(this,staff.toString());
		     
	    }
}
