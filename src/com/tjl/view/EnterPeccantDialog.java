package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Peccant;
import com.tjl.dao.UserDao_imp;

public class EnterPeccantDialog extends JFrame implements ActionListener {
	//���崰�ڿؼ�
		private JLabel ibSPNumber =new JLabel("������Υ����Ա����");
		private JTextField tfSPNumber = new JTextField(30);
		private JLabel ibPNumber =new JLabel("Υ�¼�¼���");
		private JTextField tfPNumber = new JTextField(30);
		private JLabel ibPName = new JLabel("Υ����");
		private JTextField tfPName = new JTextField(30);
	    private JLabel ibPTime = new JLabel("�����뷢��ʱ��");
	    private JTextField tfPTime =new JTextField(20);
	    private JLabel ibPPlace = new JLabel("�����뷢���ص�");
	    private JTextField tfPPlace =new JTextField(20);
		private JLabel ibNumber =new JLabel("�������¼��Ա����");
		private JTextField tfNumber = new JTextField(30);
	    private JButton btOk =new JButton("�������");
	    
	    public EnterPeccantDialog() {
	    	//�����ʼ��
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
	    	
	    	//���Ӽ���
	    	btOk.addActionListener(this);
}
	    //���ؼ���
	    public void actionPerformed(ActionEvent e) {
	    	String Number = new String(tfNumber.getText());//��¼Ա������
	    	String SPNumber = new String(tfSPNumber.getText());//Υ��Ա������
	    	String pNumber = new String(tfPNumber.getText());//Υ�¼�¼���
	    	int PNumber =Integer.parseInt(pNumber);
	    	String PName = new String(tfPName.getText());//Υ�¼�¼��
	    	String PTime = new String(tfPTime.getText());
	    	String PPlace = new String(tfPPlace.getText());
	    	
	    	Peccant pec = new Peccant(PNumber,PName,SPNumber,PTime,PPlace,Number);
	    	
	        UserDao_imp userDao_imp = new UserDao_imp();
	        boolean res = userDao_imp.EnterSPeccant(pec);
	        if(res==true)
	           JOptionPane.showMessageDialog(this,PName+"¼��ɹ�");
	        else
	        	 JOptionPane.showMessageDialog(this,PName+"¼��ʧ��");
	    }

}
