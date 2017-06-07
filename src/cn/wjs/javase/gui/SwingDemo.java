package cn.wjs.javase.gui;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingDemo extends JFrame{
	JLabel label;
	public SwingDemo(){
		super("Hello Swing");
		label = new JLabel("A label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
	}
	static SwingDemo sd;
	public static void main(String[] args) throws Exception{
//		JFrame frame = new JFrame("hello world");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		final JLabel label = new JLabel("A label");
//		frame.setSize(800, 600);
//		frame.setVisible(true);
//		frame.add(label);
//		TimeUnit.SECONDS.sleep(1);
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				label.setText("it is defferent");
//			}
//		});
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd = new SwingDemo();
			}
		});
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.label.setText("It is change");
			}
		});
		
	}
}

