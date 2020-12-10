package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
	
	JTextField text_name=null;
	JTextField text_addr=null;
	// 생성자
	public MemberFrame(String title) {
		super(title);
		// 프레임의 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		// 상단 페널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		// 페널을 상단에 배치하기
		add(topPanel, BorderLayout.NORTH);
		// 페널에 추가할 UI 객체를 생성해서 
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		JTextField text_name=new JTextField(10);
		JTextField text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		// 페널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		// 버튼에 Action command 지정
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
	}
	// 메인메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 command 를 읽어온다.
		String command=e.getActionCommand();
		if(command.equals("add")) { // 추가버튼을 눌렀을 때
			// 1. 입력한 이름과 주소를 읽어와서
			String name=text_name.getText();
			String addr=text_addr.getText();
			// 2. MemberDto 객체에 담고
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			// 3. MemberDto 객체를 이용해서 DB 에 저장
			MemberDao dao=new MemberDao();
			dao.insert(dto);
			// 4. 실제 저장되어있는지 확인
			boolean isSuccess=false;
			if(isSuccess) {
				JOptionPane.showConfirmDialog(this, "저장되었습니다.");
			}else {
				JOptionPane.showConfirmDialog(this, "저장에 실패하였습니다.");
			}	
		}
	}
}
