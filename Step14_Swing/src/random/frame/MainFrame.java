package random.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	
	// 생성자
	public MainFrame(String title) {
		super(title);
		
		// 레이아웃 지정
		setLayout(new BorderLayout());
		
		// 버튼객체 생성
		JButton rock=new JButton("바위");
		JButton scis=new JButton("가위");
		JButton paper=new JButton("보");
		
		// 패널 생성
		JPanel panel=new JPanel();
		
		// 패널에 컴포넌스 추가
		panel.add(paper);
		panel.add(scis);
		panel.add(rock);
		
		// 패널을 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		// 버튼에 리스너 등록
		rock.addActionListener(this);
		scis.addActionListener(this);
		paper.addActionListener(this);
		
		// 버튼의 Action command 지정
		rock.setActionCommand("바위");
		scis.setActionCommand("가위");
		paper.setActionCommand("보");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// 랜덤한 값을 얻기위한 객체 생성
		Random ran=new Random();
		// 0~2 사이의 랜덤한 정수
		int ranNum=ran.nextInt(3); // 0=바위 1=가위 2=보
		String myHand=e.getActionCommand();
		String com="";
		String result="";
		if(myHand.equals("가위")) {
			if(ranNum==0) {
				result="졌다";
				com="바위";
			}else if(ranNum==1) {
				result="비겼다";
				com="가위";
			}else if(ranNum==2) {
				result="이겼다";
				com="보";
			}
		}else if(myHand.equals("바위")) {
			if(ranNum==0) {
				result="비겼다";
				com="바위";
			}else if(ranNum==1) {
				result="이겼다";
				com="가위";
			}else if(ranNum==2) {
				result="졌다";
				com="보";
			}
		}else if(myHand.equals("보")) {
			if(ranNum==0) {
				result="이겼다";
				com="바위";
			}else if(ranNum==1) {
				result="졌다";
				com="가위";
			}else if(ranNum==2) {
				result="비겼다";
				com="보";
			}
		}
		// 결과값 출력
		JOptionPane.showMessageDialog(MainFrame.this, result);
	}
	
	
	public static void main(String[] args) {
		MainFrame f=new MainFrame("가위바위보 게임");
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
