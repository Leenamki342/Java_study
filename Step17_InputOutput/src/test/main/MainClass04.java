package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
/*   Text Input        Text Output
 *   InputStream  <=>  OutputStream
 *   InputStreamReader  <=>  OutputStreamWriter
 *   BufferedReader <=>  BufferedWriter
 *   
 *   문자열을 읽어 올때 File Reader
 *   
 */

public class MainClass04 {
	public static void main(String[] args) {
		// 콘솔창에 출력할 수 있는 객체의 참조값을 ps 라는 지역변수에  담기
		PrintStream ps=System.out;
		// PrintStream 객체를 부모 type OutputStream 변수에 담기
		OutputStream os=ps;
		// 2byte 처리
		OutputStreamWriter osw=new OutputStreamWriter(os);
		// 기능을 좀 더 up 시키면
		BufferedWriter bw=new BufferedWriter(osw);
		try {
			bw.write("안녕하세요");
			bw.newLine();  // 개행 기호를 출력해준다.
			bw.write("안녕하세요");
			bw.newLine();  // 개행 기호를 출력해주는 기능
			bw.write("안녕하세요");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
