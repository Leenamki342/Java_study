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

import test.dept.dto.DeptDto;
import tset.dept.dao.DeptDao;

/*
 *  1. test.dept.dto.DeptDto 클래스 만들기
 *  
 *  2. test.dept.dto.DeptDao 클래스 만들기
 * 
 *  3. DeptDto 를 완성하기
 *  
 *  4. DeptDao 를 완성하기
 *  
 *  5. 위에 완성된 DeptDao 를 이용해서 아래 DeptFrame 을 구현하기
 *  
 */
public class DeptFrame extends JFrame implements ActionListener{
	// 필드
	JTextField text_dname, text_loc;
	JTable table;
	DefaultTableModel model;
	
	public DeptFrame(String title) {
		super(title);
		//프레임의 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		//상단 페널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.GREEN);
		//페널을 상단에 배치하기 
		add(topPanel, BorderLayout.NORTH);
		//페널에 추가할 UI 객체를 생성해서 
		JLabel label_dname=new JLabel("직책");
		JLabel label_loc=new JLabel("지역");
		//아래 메소드에서 필요한값을 필드에 저장하기 
		text_dname=new JTextField(10);
		text_loc=new JTextField(10);
		JButton btn_add=new JButton("추가");
		//페널에 순서대로 추가하기
		topPanel.add(label_dname);
		topPanel.add(text_dname);
		topPanel.add(label_loc);
		topPanel.add(text_loc);
		topPanel.add(btn_add);
		//버튼에 Action command 지정
		btn_add.setActionCommand("add");
		//버튼에 리스너 등록
		btn_add.addActionListener(this);
		
		//회원 목록을 출력할 테이블
		table=new JTable();
		//칼럼명을 String[] 에 순서대로 준비하기
		String[] colNames= {"사원번호","직책","지역"};
		//테이블에 연결할 기본 모델 객체
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//모델을 테이블에 연결하기
		table.setModel(model);
		//테이블의 내용이 scroll 될수 있도록 스크롤 페널로 감싼다.
		JScrollPane scPane=new JScrollPane(table);
		//스크롤 페널을 프레임의 중앙에 배치하기
		add(scPane, BorderLayout.CENTER);
		//회원 목록을 테이블에 출력하기
		printDept();
		
		//삭제 버튼을 만들고 
		JButton btn_delete=new JButton("삭제");
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");
		
		//삭제 버튼을 상단 페널에 추가
		topPanel.add(btn_delete);
		
		// 회원목록을 주기적으로 업데이트하는 스레드 시작시키기
		new UpdateThread().start();
	}

	//회원 목록을 테이블에 출력하는 메소드
	public void printDept() {
		//기존에 출력된 내용 초기화
		model.setRowCount(0); // 0 개의 row 로 강제로 초기화 하고 
		
		//회원 목록 불러오기
		DeptDao dao=new DeptDao();
		List<DeptDto> list=dao.selectAll();
		
		//기존에 출력된 내용 초기화
		model.setRowCount(0); // 0 개의 row 로 강제로 초기화 하고 
		
		for(DeptDto tmp:list) {
			Vector<Object> row=new Vector<>();
			row.add(tmp.getDeptno());
			row.add(tmp.getDname());
			row.add(tmp.getLoc());
	
			model.addRow(row);
		}
	}
	
	//메인 메소드
	public static void main(String[] args) {
		DeptFrame f=new DeptFrame("회원정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 를 읽어온다.
		String command=e.getActionCommand();
		if(command.equals("add")) { //추가 버튼을 눌렀을때
			addDept();
		}else if(command.equals("delete")) {//삭제 버튼을 눌렀을때
			deleteDept();
		}
	}
	//회원정보를 삭제하는 메소드
	public void deleteDept() {
		//선택된 row 의 인덱스를 읽어온다.
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex == -1) {
			JOptionPane.showMessageDialog(this,"삭제할 row 를 선택해라");
			return;//메소드를 여기서 끝내라 
		}
		//선택한 row 의 0 번 칼럼의 값(번호)을 읽어와서 int 로 casting 하기 
		int num=(int)table.getValueAt(selectedIndex, 0);
		//삭제하기 전에 한번 확인하기
		int result=JOptionPane.showConfirmDialog(this, num+" 번을 정말 삭제하시겠습니까?");
		//만약 yes 를 눌렀을때
		if(result==JOptionPane.YES_OPTION) {
			//MemberDao 객체를 이용해서 삭제하기
			new DeptDao().delete(num);
			//UI 업데이트(목록 다시 출력하기)
			printDept();
		}
		//MemberDao 객체를 이용해서 삭제하기
		new DeptDao().delete(num);
		//UI 업데이트 (목록 다시 출력하기)
		printDept();
	}
	
	//회원정보를 추가하는 메소드 
	public void addDept() {
		
		//1. 입력한 이름과 주소를 읽어와서
		String dname=text_dname.getText();
		String loc=text_loc.getText();
		//2. DeptDto 객체에 담고
		DeptDto dto=new DeptDto();
		dto.setDname(dname);
		dto.setLoc(loc);
		//3. DeptDao 객체를 이용해서 DB 에 저장
		DeptDao dao=new DeptDao();
		//작업의 성공여부를 isSuccess 에 담기 
		boolean isSuccess=dao.insert(dto);
		//실제 저장되었는지 확인해 보세요.
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, dname+" 의 정보 추가성공");
			//테이블에 다시 목록 불러오기
			printDept();
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
	}
	// 화면을 주기적으로 update 해주는 스레드
	class UpdateThread extends Thread{
		@Override
		public void run() {
			// 바깥에 싸고 있는 클래스의 멤버 메소드 printDept() 메소드를
			// 5초마다 한번씩 주기적으로 호출하기
			while(true) { // 무한 루프
				try {
					// 5초 잠자다가
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 화면 업데이트
				printDept();
			}
		}
	}
}