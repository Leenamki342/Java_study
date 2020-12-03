package test.main;

import java.io.IOException;
import java.io.InputStream;

/*
 *   [ InputOutput 기본상식 ]
 *   
 *   - 여기서 이동되는 정보는 byte 알갱이들이다.
 *   - 1byte 는 이진법 8자리이다. ( 00001111 )
 *   
 *   input = keyboard  ->  console  입력받고 콘솔창에 출력
 *                     ->  file     문서에 작업 후 저장
 *                     ->  network  입력받고 네트워크로 출력 ( 카톡 )
 *           file      ->  network  파일 업로드
 *           network   ->  file     파일 다운로드
 *           
 *   memory
 *           
 *   output = console
 *            file
 *            network
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작 되었습니다.");
		// 키보드로부터 입력 받을  수 있는 객체의 참조값을 kbd 라는 지역변수에 담기
		InputStream kbd=System.in;
		try {	// println 이 아닌 print 를 생성하면 입력받는게 가능하다.
			System.out.print("문자 1개 입력 : ");
			int code=kbd.read();
			// 입력받은 코드값 출력하기
			System.out.println("code : "+code);
			// 코드에 대응되는 문자 1개 얻어내기
			char ch=(char)code;
			System.out.println("ch : "+ch);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
