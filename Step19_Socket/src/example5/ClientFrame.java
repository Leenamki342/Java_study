package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener, KeyListener{
	// 필요한 필드 정의하기
	JTextField tf;
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	JTextArea ta;
	String chatName; // 대화명을 저장할 필드
	
	//생성자
	public ClientFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		//페널을 만들어서 프레임의 위쪽에 배치하기 
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		add(topPanel, BorderLayout.NORTH);
		
		//프레임에 UI 배치하기
		tf=new JTextField(10);
		JButton sendBtn=new JButton("Send");
		topPanel.add(tf);
		topPanel.add(sendBtn);
		//버튼 리스너 등록하기
		sendBtn.addActionListener(this);
		// 채팅 메세지를 출력할 TextArea 객체를 생성해서
		ta=new JTextArea();
		// 스크롤 가능한 UI 에 포장 후
		JScrollPane scPane=new JScrollPane(ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// 스크롤 가능한 UI 를 프레임의 가운데에 배치한다.
		add(scPane, BorderLayout.CENTER);
		// 오직 출력용도로 사용하기 위해 편집은 false 처리 한다.
		ta.setEditable(false);
		// JTextField 에 KeyListener 등록하기
		tf.addKeyListener(this);
		
		// 소켓 접속하기
		connect();
	}
	
	public static void main(String[] args) {
		//프레임객체 생성하면서 프레임의 제목을 chatting 으로 지정하기 
		ClientFrame f=new ClientFrame("chatting");
		//프레임의 x좌표, y좌표, width, height 설정하기
		f.setBounds(100, 100, 500, 500);
		//프레임을 닫을때 프로세스도 종료 되도록 한다. 
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//프레임을 화면상에 보이게 하기 
		f.setVisible(true);
		
	}
	
	// Socket 서버에 접속하는 메소드
	public void connect() {
		try {
			chatName=JOptionPane.showInputDialog(this, "대화명을 입력하세요.");
			if(chatName==null || chatName.equals("")) {
				chatName="바보";
			}
			
			// 소켓객체 (14.63.164.99)
			socket=new Socket("14.63.164.99", 5000);
			// 서버에 문자열을 출력할 객체
			bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버가 전송하는 문자열을 읽어들일 객체
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 새로운 스레드를 시작시켜서 서버에서 문자열이 도착하는지 지속적으로 대기
			new ClientThread().start();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	// 전송버튼을 눌렀을 때
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=tf.getText();
		//2. BufferedWriter 객체를 이용해서 출력한다.
		try {
			bw.write(chatName+" : "+msg);
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		//3. JTextField 에 입력한 문자열 삭제
		tf.setText("");
	}
	// 서버에서 문자열이 전송되는지 지속적으로 대기하는 스레드 객체를 생성할 클래스 설계
	class ClientThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					// 대기하다가 문자열이 도착하면 메소드가 리턴한다.
					String line=br.readLine();
					// 도착된 메세지를 JTextArea 에 개행기호와 함께 추가하기
					ta.append(line+"\r\n");
					// 출력할 문서의 높이
					int height=ta.getDocument().getLength();
					// 높이 만큼 JTextArea 를 스크롤시켜서 가장 아래에 있는 문자열이 보이게
					ta.setCaretPosition(height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// enter 키를 눌렀다면
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			//1. JTextField 에 입력한 문자열을 읽어와서
			String msg=tf.getText();
			//2. BufferedWriter 객체를 이용해서 출력한다.
			try {
				bw.write(chatName+" : "+msg);
				bw.newLine();
				bw.flush();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			//3. JTextField 에 입력한 문자열 삭제
			tf.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}

