package cn.edu.nju.wjq15;

import java.io.*;

public class SyllabusTest {

	public static void main(String[] args) {
		/*新建一个课程表。
	星期四；三，四节；计算与软件工程；仙2-407；
	通过命令行方式完成对课程的增、删、改、查、显示。
	Add 星期四；三，四节；计算与软件工程；仙2-407；//如果成功 显示“已添加到文件中”
	Remove 星期四；三，四节；计算与软件工程；仙2-407；//如果成功 显示“已从文件删除”
	Update 星期四；三，四节；计算与软件工程；仙2-408；//如果成功 显示“已更新文件”
	Find 星期四；三，四节； //如存在课程 显示 “课程名；上课地点”
	Show //显示所有课程，按照时间排序
	数据保存在文件里。
	CurriculumSchedule.txt
	Deadline：4月6日 23:59:59, 提交源代码和运行截图*/
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
		
		//将命令和课程分开

		if(order.equals("Show")){
			s.show();
		}else{
			course = course.substring(1);
			s.perform(order,course);
		}
	}

}


