package example3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ClientMain extends JFrame implements ActionListener{
	// 필드
	JTextField text_chating;
	
	// 생성자
	public ClientMain (String title) {
		super(title);
		//프레임의 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		//상단 페널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.CYAN);
		//페널을 상단에 배치하기 
		add(topPanel, BorderLayout.NORTH);
		//페널에 추가할 UI 객체를 생성해서 
		JLabel label_chating=new JLabel("채팅");
		//아래 메소드에서 필요한값을 필드에 저장하기 
		text_chating=new JTextField(30);
		JButton btn_add=new JButton("추가");
		//페널에 순서대로 추가하기
		topPanel.add(label_chating);
		topPanel.add(text_chating);
		topPanel.add(btn_add);
		//버튼에 Action command 지정
		btn_add.setActionCommand("add");
		//버튼에 리스너 등록
		btn_add.addActionListener(this);
	}
	
	
	
	public static void main(String[] args) {
		ClientMain f=new ClientMain("chatting");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		// 1. Socket 을 통해서 출력할 문자열을 콘솔로 입력 받기
//		Scanner scan=new Scanner(System.in);
//		System.out.println("전송할 문자열 입력 : ");
//		String msg=scan.nextLine();
		
		String msg=text_chating.getText();
		Socket socket=null;
		try {
			// new Socket("접속할 ip 주소", 포트번호);
			socket=new Socket("14.63.164.99",5000); // my ip address
			System.out.println("서버에 Socket 접속 성공!");
			// 2. Socket 을 통해서 출력하기
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			osw.write(msg); // 입력한 문자열 출력
			osw.write("\r\n"); // 개행기호
			osw.flush(); // 방출
			osw.close(); // 닫기
			socket.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
