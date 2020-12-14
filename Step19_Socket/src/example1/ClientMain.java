package example1;

import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			// new Socket("접속할 ip 주소", 포트번호);
			socket=new Socket("127.0.0.1", 5000); // my ip address
			System.out.println("서버에 Socket 접속 성공!");
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
