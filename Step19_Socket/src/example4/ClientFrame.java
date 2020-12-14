package example4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener{
	// 필드
	JTextField tf;
	
	// 생성자
	public ClientFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		add(topPanel, BorderLayout.NORTH);
		
		tf=new JTextField(10);
		JButton sendBtn=new JButton("send");
		topPanel.add(tf);
		topPanel.add(sendBtn);
		
		//버튼에 Action command 지정
		sendBtn.setActionCommand("add");
		//버튼에 리스너 등록
		sendBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// 프레임 객체를 생성하면서 프레임의 제목을 chatting 으로 지정하기
		ClientFrame f=new ClientFrame("chatting");
		// 프레임의 x,y, width, height 설정
		f.setBounds(100, 100, 300, 200);
		// 프레임을 닫을 때 프로세스도 종료되도록 한다.
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임을 화면상에 보이게 하기.
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. JTextField 에 입력한 문자열을 읽어와서
		String msg=tf.getText();
		// 2. Socket 접속을 해서 전송한다.
		Socket socket=null;
		try {
			// local 호스트 번호 : 127.0.0.1
			// new Socket("접속할 ip 주소", 포트번호);
			socket=new Socket("127.0.0.1",5000); 
			System.out.println("서버에 Socket 접속 성공!");
			// 2. Socket 을 통해서 출력하기
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			osw.write(msg); // 입력한 문자열 출력
			osw.write("\r\n"); // 개행기호
			osw.flush(); // 방출
//			osw.close(); // 닫기
			
			// 3. Socket 을 통해서 입력받기
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			// 서버가 전송한 문자열 읽어오기
			String line=br.readLine();
			System.out.println(line);
//			br.close();
			
			socket.close();
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		// 3. 입력한 문자열 삭제
		tf.setText(msg);		
	}
}
