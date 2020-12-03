package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File myFile=new File("c:/");
		File[] files=myFile.listFiles();
		// 반복문 돌면서 하나씩 참조해서 작업하기
		for(File tmp:files) {
			// 디렉토리 아니면 파일
			if(tmp.isDirectory()) { // 만일 디렉토리라면
				System.out.println("[" + tmp.getName()+"]");
			}else { // 파일이라면
				System.out.println(tmp.getName());
			}
		}
	}
}
