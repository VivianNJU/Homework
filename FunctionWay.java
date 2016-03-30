package cn.edu.nju.wjq15;

import java.util.ArrayList;
import java.util.List;

public class FunctionWay {

	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<String>();
		strings.add(new String("neal"));
		strings.add(new String("s"));
		strings.add(new String("stu"));
		strings.add(new String("j"));
		strings.add(new String("rich"));
		strings.add(new String("bob"));
		strings.add(new String("aaa"));
		
		String result = null;
		
		for(String temp:strings){
			result = strings.stream().filter(str->temp.length()>1).map(str->(temp.substring(0).toUpperCase()+temp.substring(1))+",").toString();
		}
		System.out.println(result);

	}

}
