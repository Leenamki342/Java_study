package test.pac;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class MyFrame extends JFrame implements ActionListener{
	public MyFrame(String a) {
		super(a);

		JTextField f=new JTextField(10);
		f.setText("안녕");
	}
	
	public static void main(String[] args) {
		MyFrame f=new MyFrame("메인 프레임");
		// 위치와 크기 지정
		f.setBounds(100, 100, 500, 300);
		// 프레임을 닫으면 프로세스가 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면상에 출력
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
