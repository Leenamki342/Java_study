package test.main;

import java.io.File;

public class MainClass11 {
	public static void main(String[] args) {
		// c:/myFolder 삭제
		File f=new File("c:/myFolder");
		File[] files=f.listFiles();
		for(File tmp:files) {
			tmp.delete();
		}
		System.out.println("c:/myFolder 하위에 있는 모든 내용을 삭제하였습니다.");
	}
}
