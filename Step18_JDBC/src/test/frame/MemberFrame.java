package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
	// 필드
	JTextField text_name, text_addr;
	DefaultTableModel model;
	JTable table;
	
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
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		// 페널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		// 버튼에 Action command 지정
		btn_add.setActionCommand("add");
		// 버튼에 리스너 지정
		btn_add.addActionListener(this);
		
		// 회원목록을 출력할 테이블
		table=new JTable();
		// 칼럼명을 String[] 에 순서대로 준비하기
		String[] colNames= {"번호","이름","주소"};
		// 테이블에 연결할 기본모델 객체
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				// 모두 수정불가
				return false;
			}
		};
		// 모델을 테이블에 연결하기
		table.setModel(model);
		// 테이블의 내용이 scroll 될 수 있도록 스크롤 페널로 감싼다.
		JScrollPane scPane=new JScrollPane(table);
		// 스크롤 페널을 프레임의 가운데 배치하기
		add(scPane, BorderLayout.CENTER);
		// 회원목록을 테이블에 추가
		printMember();
		
		// 삭제 버튼 만들기
		JButton btn_delete=new JButton("삭제");
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");
		
		// 삭제버튼을 상단 페널에 추가
		topPanel.add(btn_delete);
	}
		
	public void printMember() {
		// 기존에 출력된 내용 초기화
		model.setRowCount(0); // 0 개의 row 로 강제로 초기화 하고
		
		MemberDao dao=new MemberDao();
		List<MemberDto> list=dao.selectAll();
		for(MemberDto tmp:list) {
			// Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			Vector<Object> row=new Vector<>();
			model.addRow(row);
		}
		
		// 모델의 메소드 확인하기
		Object[] row1= {1,"김구라", "노량진"};
		Object[] row2= {2,"해골", "행신동"};
		model.addRow(row1);
		model.addRow(row2);
		
		// Vector 은 약간 무거운(성능이 많은) ArrayList 라고 생각하면 된다.
		Vector<Object> vec1=new Vector<>();
		vec1.add(3);
		vec1.add("원숭이");
		vec1.add("상오동");
		model.addRow(vec1);
		
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
			this.addMember();
		}else if(command.equals("delete")) { // 삭제버튼을 눌렀을 때
			// 선택된 row 의 인덱스를 읽어온다.
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택하세요");
				return; // 메소드를 여기서 끝내라
			}
			// 선택한 row 의 0번 칼럼의 값(번호)을 읽어와서 int 로 캐스팅 하기
			int num=(int)table.getValueAt(selectedIndex, 0); // 원래 오브젝트 타입
			// MemberDao에 있는 delete문 사용하기
			new MemberDao().delete(num);
			// UI 업데이트 (목록 다시 출력하기)
			printMember();
		}
	}
	// 회원정보를 추가하는 메소드
	public void addMember() {
		
		// 1. 입력한 이름과 주소를 읽어와서
		String name=text_name.getText();
		String addr=text_addr.getText();
		// 2. MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		// 3. MemberDao 객체를 이용해서 DB 에 저장
		MemberDao dao=new MemberDao();
		// 4. 실제 저장되어있는지 확인
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showConfirmDialog(this, "저장되었습니다.");
			// 테이블에 다시 목록 불러오기
			printMember();
		}else {
			JOptionPane.showConfirmDialog(this, "저장에 실패하였습니다.");
		}
	}
}
