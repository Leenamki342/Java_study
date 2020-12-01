package test.frame06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener{
	// 생성자
	public MainFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		JButton genBtn=new JButton("0~9 랜덤 정수 얻기");
		add(genBtn);
		genBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 랜덤한 값을 얻기위한 객체 생성
		Random ran=new Random();
		// 0~9 사이의 랜덤한 정수
		int ranNum=ran.nextInt(10);
		JOptionPane.showMessageDialog(this, "발생된 랜덤 정수 : "+ranNum);
	}
	
	public static void main(String[] args) {
		MainFrame f=new MainFrame("랜덤생성기");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
