package test;

public class test {
	public static void main(String[] args) {
		String[] friends=new String[5];
		friends[0]="김구라";
		friends[1]="해골";
		friends[2]="덩아리";
		friends[3]="친구";
		friends[4]="프랜드";
		
		for(int i=0; i<friends.length; i++) {
			friends[i]=null;
		}
	}
}
