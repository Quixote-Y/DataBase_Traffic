package com.tjl.view;

import java.awt.*;

import com.tjl.dao.UserDao;
import com.tjl.dao.UserDao_imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchPeccantDialog extends JFrame implements ActionListener {
	//���崰�ڿؼ�
		private JLabel ibPNumber =new JLabel("����������Ա����");
		private JTextField tfPNumber = new JTextField(30);
		private JLabel ibNumber =new JLabel("�������ѯ�����Ա����");
		private JTextField tfNumber = new JTextField(30);
		private JLabel ibTime =new JLabel("�������ѯʱ�����䣨2000-01-01--2001-01-02��");
		private JTextField tfTime = new JTextField(30);

	    private JButton btOk =new JButton("�������");
	    
	    
	    public SearchPeccantDialog () {
	    	//�����ʼ��
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
	    	//��ť���
			JPanel panel = new JPanel();
			JLabel lbl = new JLabel("��ѯԱ��Υ����Ϣ����ȷ��������������·�ӳ�����");
			panel.add(lbl);
			panel.setPreferredSize(new Dimension(800,400));
			//���ڼ���ܵ�Ĭ�ϲ��ֹ�������BorderLayout
			this.add("Center",panel);
	    	
	    	//���Ӽ���
	    	btOk.addActionListener(this);
}
	    //���ؼ���
	    public void actionPerformed(ActionEvent e) {
	    	String Number = new String(tfNumber.getText());//����ѯ��Ա����
	    	String PNumber = new String(tfPNumber.getText());//��ѯ��Ա����
	    	String Time = new String(tfTime.getText());//��ѯʱ������

	    	UserDao_imp userDao_imp = new UserDao_imp();
	    	String res=userDao_imp.SearchPeccant(Number, PNumber, Time);
	    	JOptionPane.showMessageDialog(this,res);
	       
	    }
}