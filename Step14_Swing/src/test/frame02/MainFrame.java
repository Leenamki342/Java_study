package test.frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame{
	// 생성자
	public MainFrame(String title) {
		super(title); // 부모생성자에 전달하기
		// 레이아웃 메니저 지정하기
		setLayout(new FlowLayout()); // 물 흐르듯이 배치되는 레이아웃
		// 버튼 3개를 만들고
		JButton sendBtn=new JButton("전송");
		sendBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this,"전송합니다.");
		});
		JButton updateBtn=new JButton("수정");
		updateBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this,"수정합니다.");
		});
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this,"삭제합니다.");
		});
		// 버튼을 프레임에 배치하기
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		
		
		
	}
	
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		// 위치와 크기 지정
		f.setBounds(100, 100, 500, 300);
		// 프레임을 닫으면 프로세스가 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면상에 출력
		f.setVisible(true);
	}
}
