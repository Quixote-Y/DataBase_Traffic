package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.tjl.bean.Car;
import com.tjl.dao.UserDao_imp;

public class EnterCarDialog extends JFrame implements ActionListener {
	//���崰�ڿؼ�
	private JLabel ibNumber =new JLabel("�����복�ƺ�");
	private JTextField tfNumber = new JTextField(25);
	private JLabel ibCNumber =new JLabel("������λ��");
	private JTextField tfCNumber = new JTextField(15);
    private JButton btOk =new JButton("�������");
    
    public EnterCarDialog() {
    	//�����ʼ��
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
    	
    	//���Ӽ���
    	btOk.addActionListener(this);
      	
    }
    //���ؼ���
    public void actionPerformed(ActionEvent e) {
    	String Number = new String(tfNumber.getText());
    	String CNumber = new String(tfCNumber.getText());
    	int cnumber = Integer.parseInt(CNumber);
    	

    	Car car = new Car(Number,cnumber);
        UserDao_imp userDao_imp = new UserDao_imp();
        boolean res = userDao_imp.EnterCar(car);
        if(res==true)
           JOptionPane.showMessageDialog(this,Number+"¼��ɹ�");
        else
        	 JOptionPane.showMessageDialog(this,Number+"¼��ʧ��");
    }

    
}
