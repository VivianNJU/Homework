package cn.edu.nju.wjq15;

import java.io.*;

public class SyllabusTest {

	public static void main(String[] args) {
		/*�½�һ���γ̱�
	�����ģ������Ľڣ�������������̣���2-407��
	ͨ�������з�ʽ��ɶԿγ̵�����ɾ���ġ��顢��ʾ��
	Add �����ģ������Ľڣ�������������̣���2-407��//����ɹ� ��ʾ������ӵ��ļ��С�
	Remove �����ģ������Ľڣ�������������̣���2-407��//����ɹ� ��ʾ���Ѵ��ļ�ɾ����
	Update �����ģ������Ľڣ�������������̣���2-408��//����ɹ� ��ʾ���Ѹ����ļ���
	Find �����ģ������Ľڣ� //����ڿγ� ��ʾ ���γ������Ͽεص㡱
	Show //��ʾ���пγ̣�����ʱ������
	���ݱ������ļ��
	CurriculumSchedule.txt
	Deadline��4��6�� 23:59:59, �ύԴ��������н�ͼ*/
		Syllabus s = new Syllabus();
		char[] temp = null;
		String order = null;
		String course = null;
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			temp = br.readLine().toCharArray();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		for(char i:temp){
			if((('a'<=i)&&(i<='z'))||(('A'<=i)&&(i<='Z'))){
				if(order==null){  
					order = ""+i;
				}
				else{
					order = order + i;
				}
			}else{
				if(course==null){  
					course = ""+i;
				}
				else{
					course = course + i;
				}
			}
		}
		
		//������Ϳγ̷ֿ�

		if(order.equals("Show")){
			s.show();
		}else{
			course = course.substring(1);
			s.perform(order,course);
		}
	}

}


