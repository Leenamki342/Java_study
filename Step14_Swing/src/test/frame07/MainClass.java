package test.frame07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainClass extends JFrame implements ActionListener{
	
	// 콤보박스의 문자열 아이템을 String[] 로 미리 준비하기
	String[] usergame= {"가위","바위","보"};
	JComboBox<String>combo;
	private JLabel lab1;
	private JLabel lab2;
	   
	public MainClass(String title) {
		super(title);
	      
		setLayout(new BorderLayout());
		combo= new JComboBox<String>(usergame);
		lab1 = new JLabel("");
		lab2 = new JLabel("");
	      
		add(combo,BorderLayout.NORTH);
		add(lab1, BorderLayout.WEST);
		add(lab2, BorderLayout.EAST);
	      
		combo.addActionListener(this);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
	   // 랜덤 객체 생성
	   Random ran=new Random();
	   // 값 0~2
	   int ranNum=ran.nextInt(3);
	   String[] com= {"가위","바위","보"};
	   lab2.setText("Computer: "+com[ranNum]);
	   String user=combo.getSelectedItem().toString();
	   lab1.setText("Player: "+user);
	   // 결과를 저장할 result 지역변수 지정
	   String result=null;
	   // 이긴경우, 비긴경우, 진경우
	   if(com.equals("가위") && user.equals("바위")) {
		   result="win";
	   }else if(com.equals("바위") && user.equals("보")){
		   result="win";
	   }else if(com.equals("보") && user.equals("가위")) {
		   result="win";
	   }else if(com.equals(user)) {
		   result="same";
	   }else {
		   result="lose";
	   }
	   JOptionPane.showMessageDialog(MainClass.this, result);
	}
	public static void main(String[] args) {
		MainClass f=new MainClass("가위,바위,보 게임");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
