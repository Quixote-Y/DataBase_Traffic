package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JFrame{
	/*��ʵ���л�����������ת����Byte����Ȼ�����ܷ����л���ԭʼ���ࡣ����������д��䣬
	 * Ҳ���Ա����ڴ����У�����SUID֮����ô������л������Ѿ��������ڱ����У�
	 * ��;����������SUID���ˣ���ô�����л���ʱ��Ͳ�����ԭʼ�����ˣ��������쳣��
	 * ��Ҫ�������ڰ汾���ơ�*/
	private static final long serialVersionUID=1L;
	private JButton jEnterDriver,jEnterCar,jEnterPeccant,jSearchDriver,jSearchPeccantT,jSearchPeccantTs;
	//��Menu��Ϊ��ڳ���
	public static void main(String[] args)throws IOException
	{
		new Menu().showMe();
		
	}

	
	private void createToolBar()
	{
		JToolBar toolBar = new JToolBar();//����������
		
		jEnterDriver = new JButton("¼��˾����Ϣ");
		jEnterCar = new JButton("¼��������Ϣ");
		jEnterPeccant = new JButton("¼��Υ����Ϣ");
		jSearchDriver = new JButton("��ѯ˾����Ϣ");
		jSearchPeccantT = new JButton("��ѯ˾��ʱ�����Υ����ϸ��Ϣ");
		jSearchPeccantTs =new JButton("��ѯ˾��ʱ�����Υ���ܴ���");
		//����ť�ӵ���������
		toolBar.add(jEnterCar);
		toolBar.add(jEnterDriver);
		toolBar.add(jEnterPeccant);
		toolBar.add(jSearchDriver);
		toolBar.add(jSearchPeccantT);
		toolBar.add(jSearchPeccantTs);
		
		//���������ӵ�������
		this.add("North",toolBar);
		
	}
	public void showMe()
	{
		//���ô��ڶ���
		this.Init();
		//�˵�����Ӽ���
		this.addEventHandler();
		this.setTitle("��ͨ����ϵͳ");
		this.setBounds(300,200,800,400);//���ô��ڳ���λ��
		this.pack();//ʹ���ڴ�С�պ���ʾ�������
		this.setVisible(true);//�ɼ�
		//ʹ�û��������ڹرհ�ť��ֹ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void Init() {
		// �����˵����˴��ޣ�\
		
		//����������
		createToolBar();
		
		//��ť���
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel("��ӭʹ�ý�ͨ����ϵͳ");
		panel.add(lbl);
		panel.setPreferredSize(new Dimension(800,400));
		//���ڼ���ܵ�Ĭ�ϲ��ֹ�������BorderLayout
		this.add("Center",panel);
		
	}


	public void addEventHandler()
	{
		//�˵���Ӽ���(�˴���)
		
		//��������Ӽ���
		jEnterCar.addActionListener(new EnterCarHandler());
		jEnterDriver.addActionListener(new EnterDriverHandler());
		jEnterPeccant.addActionListener(new EnterPeccantHandler());
		jSearchDriver.addActionListener(new SearchDriverHandler());
		jSearchPeccantT.addActionListener(new SearchPeccantTHandler());
		jSearchPeccantTs.addActionListener(new SearchPeccantTsHandler());
	}
	
	private class EnterCarHandler implements ActionListener{
		//�Լ����Ķ�����ӳ��������
		public void actionPerformed(ActionEvent events) {
			new EnterCarDialog();
		}
	}
	private class EnterDriverHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new EnterDriverDialog();
		}
	}
	private class EnterPeccantHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new EnterPeccantDialog();
		}
	}
	private class SearchDriverHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new SearchDriverDialog();
		}
	}
	private class SearchPeccantTHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new SearchPeccantDialog();
		}
	}
	private class SearchPeccantTsHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new SearchPeccantTsDialog();
		}
	}

}
