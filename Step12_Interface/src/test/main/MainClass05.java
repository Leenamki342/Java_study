package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 3개 뚫어요");
			}
			
		});
		// 위에 있는 오버라이드를 간략하게 만드는 것
		useDrill(()->{
			System.out.println("천장에 구멍을 2개 뚫어요");
		});
		
		Drill d1=()->{
			System.out.println("천장에 구멍뚫기");
		};
		useDrill(d1);

	}
	

	public static void useDrill(Drill d) {
		d.hole();
	}
}
