package json;

import org.json.JSONArray;
/*
 *   JSON => Java Script Object Notation
 *   JSON 에서는
 *   10
 *   "kim"
 *   ture or false
 *   {}
 *   []
 *   null 만 입력 가능하다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		
		JSONArray arr=new JSONArray();
		arr.put(10);
		arr.put(20);
		arr.put(30);
		// JSONArray 객체 안에 있는 정보를 JSON 표기법에 맞는 문자열로 얻기
		String result1=arr.toString();
		System.out.println("result1 : "+result1);
		
		JSONArray arr2=new JSONArray();
		arr2.put("kim");
		arr2.put("lee");
		arr2.put("park");
		String result2=arr2.toString();
		System.out.println("result2 : "+result2);

	}
}
