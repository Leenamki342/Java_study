package test.frame05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	
	// 필드
	JTextField inputNum1, inputNum2;
	JLabel label_result;
	
	// 생성자
	public MainFrame(String title) {
		super(title);
		// 레이아웃 지정
		setLayout(new BorderLayout());
		// JTextField 객체를 생성해서 참조값을 필드에 저장
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		// 기능 버튼 4개 
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multipleBtn=new JButton("*");
		JButton divisionBtn=new JButton("/");
		// 레이블 2개
		JLabel label_eq=new JLabel("=");
		label_result=new JLabel();
		// 패널 1개
		JPanel panel=new JPanel();
		// 패널에 컴포넌트 배치
		panel.add(inputNum1);
		panel.add(plusBtn);
		panel.add(minusBtn);
		panel.add(multipleBtn);
		panel.add(divisionBtn);
		panel.add(inputNum2);
		panel.add(label_eq);
		panel.add(label_result);
		// 프레임에 페널을 북쪽에 배치
		add(panel, BorderLayout.NORTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		
	}
}