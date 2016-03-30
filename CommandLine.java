package cn.edu.nju.wjq15;

import java.util.ArrayList;
import java.util.List;


public class CommandLine {
	
	
	public static void main(String[] args){
		List<String> strings = new ArrayList<String>();
		strings.add(new String("neal"));
		strings.add(new String("s"));
		strings.add(new String("stu"));
		strings.add(new String("j"));
		strings.add(new String("rich"));
		strings.add(new String("bob"));
		strings.add(new String("aaa"));
		
		CommandLine cl = new CommandLine();
		String result = cl.LetterUpper(strings);
		
		System.out.println(result);
		
	}
	
	public String LetterUpper(List<String> str){
		String result = null;
		int n = 0;
		
		for(String temp:str){
			n++;
			if(temp.length()==1){
				continue;
			}
			
			else{
				char first = temp.charAt(0);
				first = (char)(first + (int)'A' - (int)'a');
				if(result!=null){
					result = result + first + temp.substring(1);
				}else{
					result = first + temp.substring(1);
				}
			}
			
			if(n!=str.size()){
				result = result + ",";
			}
			
		}
		
		return result;
	}

}

