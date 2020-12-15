package todo.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import todo.dao.TodoDao;
import todo.dto.TodoDto;

public class TodoFrame extends JFrame 
implements ActionListener,PropertyChangeListener{
	// 필드
	JTextField text_content;
	JTable table;
	DefaultTableModel model;
	// 생성자
	public TodoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.ORANGE);
		add(topPanel, BorderLayout.NORTH);
		JLabel label_content=new JLabel("할일");
		text_content=new JTextField(10);
		JButton btn_add=new JButton("추가");
		topPanel.add(label_content);
		topPanel.add(text_content);
		topPanel.add(btn_add);
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		
		table=new JTable();
		String[] colNames= {"순서","할일","날짜"};
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column==0) {
					return false;
				}else if(column==2){
					return false;
				}else {
					return true;
				}
			}
		};
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane, BorderLayout.CENTER);
		printTodo();
		
		JButton btn_delete=new JButton("삭제");
		btn_delete.setActionCommand("delete");
		btn_delete.addActionListener(this);
		topPanel.add(btn_delete);
		
		table.addPropertyChangeListener(this);
		
	}
	
	public void printTodo() {
		TodoDao dao=new TodoDao();
		List<TodoDto> list=dao.selectAll();
		model.setRowCount(0);
		for(TodoDto tmp:list) {
			Vector<Object> row=new Vector<>();
			row.add(tmp.getNum());
			row.add(tmp.getContent());
			row.add(tmp.getRegdate());
			
			model.addRow(row);
		}
		
	}
	
	public static void main(String[] args) {
		TodoFrame f=new TodoFrame("할일 목록");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addTodo();
		}else if(command.equals("delete")) {
			deleteTodo();
		}
	}
	
	public void deleteTodo() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row 선택");
			return;
		}
		int num=(int)table.getValueAt(selectedIndex, 0);
		int result=JOptionPane.showConfirmDialog(this, num+" 번을 정말 삭제하시겠습니까?");
		if(result==JOptionPane.YES_OPTION) {
			new TodoDao().delete(num);
			printTodo();
		}
		new TodoDao().delete(num);
		printTodo();
	}
	
	public void addTodo() {
		String content=text_content.getText();
		TodoDto dto=new TodoDto();
		dto.setContent(content);
		TodoDao dao=new TodoDao();
		boolean isSuc=dao.insert(dto);
		if(isSuc) {
			JOptionPane.showMessageDialog(this, "할일 : "+content+" 추가");
			printTodo();
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
	}
	// table 칼럼이 수정중인지 여부
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change!");
		System.out.println(evt.getPropertyName());
		System.out.println(evt.getOldValue()+"|"+evt.getNewValue());
		// 만약 table 칼럼에서 발생한 이벤트라면 
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				// 수정된 row 를 읽어와서 DB 에 반영한다.
				int selectIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectIndex, 0);
				String content=(String)model.getValueAt(selectIndex, 1);
				String regdate=(String)model.getValueAt(selectIndex, 2);
				TodoDto dto=new TodoDto(num, content, regdate);
				new TodoDao().update(dto);
			}
			// isEditing 의 값을 반대로 바꿔준다. true=>false, false=>true
			isEditing=!isEditing; // 스위칭
		}
	}

}
