package cn.edu.nju.wjq15;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Syllabus {
	
	public void perform(String order, String course){
		switch(order){
		case "Add":
			add(course);
			break;
		case "Remove":
			remove(course);
			break;
		case "Update":
			update(course);
			break;
		case "Find":
			find(course);
			break;
		default:
			System.out.println("û������ָ��");
		}
	}
	
	void add(String course){
		
		try{
			FileReader fr = new FileReader("CurriculumSchedule.txt");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("CurriculumSchedule.txt",true);
			BufferedWriter bf = new BufferedWriter(fw);
			if(br.readLine()!=null){
				bf.newLine();
			}
			
			bf.write(course);
			br.close();
			bf.close();
			System.out.println("����ӵ��ļ���");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	
	void remove(String course){
		
		List<String> file = readFile();
		file.remove(course);
		
		try{
			FileWriter fw = new FileWriter("CurriculumSchedule.txt");
			BufferedWriter bf = new BufferedWriter(fw);
			for(String str:file){
				bf.write(str);
				bf.newLine();
			}
			bf.close();
			System.out.println("�Ѵ��ļ�ɾ��");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	void update(String course){
		String[] parts1 = course.split("��");
		List<String> file = readFile();
		

		for(String temp:file){
			String[] parts2 = temp.split("��");
			if(parts1[0].equals(parts2[0])&&parts1[1].equals(parts2[1])&&parts1[2].equals(parts2[2])){
				file.remove(temp);
				file.add(course);
			}
		}
		
		try{
			FileWriter fw = new FileWriter("CurriculumSchedule.txt");
			BufferedWriter bf = new BufferedWriter(fw);
			for(String str:file){
				bf.write(str);
				bf.newLine();
			}
			bf.close();
			System.out.println("�Ѹ����ļ�");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	void find(String course){
		String[] parts1 = course.split("��");
		List<String> file = readFile();
		

		for(String temp:file){
			String[] parts2 = temp.split("��");
			if(parts1[0].equals(parts2[0])&&parts1[1].equals(parts2[1])){
				System.out.println(parts2[2]+"��"+parts2[3]);
			}
		}
	}
	
	void show(){
		List<String> file = readFile();
		for(int i = 0;i < (file.size()-1);i++){
			for(int j = i+1;j < file.size();j++){
				if(biggerThan(file.get(i),file.get(j))){
					Collections.swap(file, i, j);
				}
			}
		}
		
		try{
			FileWriter fw = new FileWriter("CurriculumSchedule.txt");
			BufferedWriter bf = new BufferedWriter(fw);
			for(String str:file){
				bf.write(str);
				bf.newLine();
			}
			bf.close();
			System.out.println("�Ѹ����ļ�");
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		for(String temp:file){
			System.out.println(temp);
		}
	}
	
	List<String> readFile(){
		String temp;
		List<String> file = new ArrayList<String>();
		try{
			FileReader fr = new FileReader("CurriculumSchedule.txt");
			BufferedReader br = new BufferedReader(fr);
			while((temp=br.readLine())!=null){
		        file.add(temp);
			}
			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return file;
	}
	
	boolean biggerThan(String a, String b){
		String[] parts1 = a.split("��");
		String[] parts2 = b.split("��");
		
		int day1 = dayInt(parts1[0]);
		int day2 = dayInt(parts2[0]);
		int piece1 = pieceInt(parts1[1]);
		int piece2 = pieceInt(parts2[1]);		
		
		if(day1==0||day2==0||piece1==0||piece2==0){
			System.out.println("��ʽ����");
		}
		else if(day1>day2||(day1==day2&&piece1>piece2)){
			return true;
		}
		return false;
	}
	
	int dayInt(String a){
		switch(a){
		case "����һ":
			return 1;
		case "���ڶ�":
			return 2;
		case "������":
			return 3;
		case "������":
			return 4;
		case "������":
			return 5;
		default:
			return 0;
		}
	}
	
	int pieceInt(String a){
		switch(a){
		case "һ������":
			return 1;
		case "�����Ľ�":
			return 2;
		case "�壬����":
			return 3;
		case "�ߣ��˽�":
			return 4;
		default:
			return 0;
		}
	}
	
}


