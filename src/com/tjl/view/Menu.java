package com.tjl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JFrame{
	/*其实序列化的作用是能转化成Byte流，然后又能反序列化成原始的类。能在网络进行传输，
	 * 也可以保存在磁盘中，有了SUID之后，那么如果序列化的类已经保存了在本地中，
	 * 中途你更改了类后，SUID变了，那么反序列化的时候就不会变成原始的类了，还会抛异常，
	 * 主要就是用于版本控制。*/
	private static final long serialVersionUID=1L;
	private JButton jEnterDriver,jEnterCar,jEnterPeccant,jSearchDriver,jSearchPeccantT,jSearchPeccantTs;
	//由Menu作为入口程序
	public static void main(String[] args)throws IOException
	{
		new Menu().showMe();
		
	}

	
	private void createToolBar()
	{
		JToolBar toolBar = new JToolBar();//创建工具栏
		
		jEnterDriver = new JButton("录入司机信息");
		jEnterCar = new JButton("录入汽车信息");
		jEnterPeccant = new JButton("录入违章信息");
		jSearchDriver = new JButton("查询司机信息");
		jSearchPeccantT = new JButton("查询司机时间段内违章详细信息");
		jSearchPeccantTs =new JButton("查询司机时间段内违章总次数");
		//将按钮加到工具栏上
		toolBar.add(jEnterCar);
		toolBar.add(jEnterDriver);
		toolBar.add(jEnterPeccant);
		toolBar.add(jSearchDriver);
		toolBar.add(jSearchPeccantT);
		toolBar.add(jSearchPeccantTs);
		
		//将工具栏加到窗口里
		this.add("North",toolBar);
		
	}
	public void showMe()
	{
		//设置窗口对象
		this.Init();
		//菜单项添加监听
		this.addEventHandler();
		this.setTitle("交通管理系统");
		this.setBounds(300,200,800,400);//设置窗口出现位置
		this.pack();//使窗口大小刚好显示所有组件
		this.setVisible(true);//可见
		//使用户单机窗口关闭按钮终止程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void Init() {
		// 创建菜单（此处无）\
		
		//创建工具栏
		createToolBar();
		
		//按钮面板
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel("欢迎使用交通管理系统");
		panel.add(lbl);
		panel.setPreferredSize(new Dimension(800,400));
		//窗口及框架的默认布局管理器是BorderLayout
		this.add("Center",panel);
		
	}


	public void addEventHandler()
	{
		//菜单项加监听(此处无)
		
		//工具栏项加监听
		jEnterCar.addActionListener(new EnterCarHandler());
		jEnterDriver.addActionListener(new EnterDriverHandler());
		jEnterPeccant.addActionListener(new EnterPeccantHandler());
		jSearchDriver.addActionListener(new SearchDriverHandler());
		jSearchPeccantT.addActionListener(new SearchPeccantTHandler());
		jSearchPeccantTs.addActionListener(new SearchPeccantTsHandler());
	}
	
	private class EnterCarHandler implements ActionListener{
		//对监听的动作反映函数重载
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
