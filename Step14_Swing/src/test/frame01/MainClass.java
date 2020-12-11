package test.frame01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		// 제목
		f.setTitle("나의 프레임");
		// 크기
		f.setSize(500, 300);
		// 위치
		f.setLocation(100, 100);
		// 창닫기(X) 를 누르면 자동으로 프로세스가 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 배치매니저를 사용하지 않겠다.( 절대 좌표에 절대 크기로 배치 )
		f.setLayout(new BorderLayout());
		
		// 버튼 객체 생성
		JButton btn=new JButton("눌러보셈");
		// 버튼의 위치와 크기 지정
		btn.setBounds(50, 50, 100, 40);
		// 프레임에 버튼 추가
		f.add(btn);
		// 버튼 객체 생성
		JButton btn2=new JButton("메롱");
		// 버튼의 위치와 크기 지정
		btn2.setBounds(200, 50, 100, 40);
		// 프레임에 버튼 추가
		f.add(btn2);
		// 프레임을 보이게 한다.
		f.setVisible(true);
//		
//		btn2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(f,"약올리지마!");
//				
//			}			
//		});
		
		// 람다식을 이용하면 아래와 같다 ( 오버라이드 내용이 하나뿐일때 사용 )
//		btn2.addActionListener((e)->{
//			JOptionPane.showMessageDialog(f,"버튼을 눌렀넹?");
//		});
		
		// ActionListener 인터페이스 타입의 참조값 얻기
		ActionListener listener=new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 눌렀네");
				JOptionPane.showMessageDialog(f,"버튼을 눌렀넹?");
			}
		};
		
		ActionListener listener2=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f,"약올리지마!");
			}
		};
		// 버튼에 액션 리스너 등록하기
		btn.addActionListener(listener);
		btn2.addActionListener(listener2);
	}
}
