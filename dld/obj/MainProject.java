package dld.obj;

import java.util.Scanner;

import dld.dao.StudentManager;
import dld.entity.Student;
import dld.inter.SortCompare;
import dld.test.Filter.MyFilter;

public class MainProject {
	
	 
	public static void main(String[] args) {
		//学生管理类
		StudentManager stm = new StudentManager();
		int stuID = 0;
		char ch = '\0';
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		Student stu1 = new Student("茂茂", 53, '男', 1, true, 14.9F, 139.9F, 149.9F, 99.9F);
		Student stu2 = new Student("茂茂", 16, '男', 1, true, 49.9F, 119.9F, 49.9F, 69.9F);
		Student stu3 = new Student("茂茂", 26, '女', 1, false, 9.9F, 143.9F, 179.9F, 199.9F);
		Student stu4 = new Student("茂茂", 66, '男', 1, true, 9.9F, 148.9F, 169.9F, 99.9F);
		Student stu5 = new Student("茂茂", 36, '女', 1, false, 449.9F, 49.9F, 449.9F, 299.9F);
		Student stu6 = new Student("茂茂", 96, '男', 1, true, 69.9F, 19.9F, 49.9F, 289.9F);
		Student stu7 = new Student("茂茂", 26, '女', 1, true, 49F, 14.9F, 9.9F, 299.9F);
		

		stm.addNewStudent(stu1);
		stm.addNewStudent(stu2);
		stm.addNewStudent(stu3);
		stm.addNewStudent(stu4);
		stm.addNewStudent(stu5);
		stm.addNewStudent(stu6);
		stm.addNewStudent(stu7);
		do {
			System.out.println("欢迎来到千锋国际IT培训学校");
			System.out.println("1. 查看所有学生");
			System.out.println("2. 添加学生");
			System.out.println("3. 根据ID删除学生");
			System.out.println("4. 根据ID修改学生信息");
			System.out.println("5. 根据ID查找学生信息");
			System.out.println("6. 按照条件展示数据");
			System.out.println("7. 按照条件排序学生信息");
			System.out.println("8. 退出");
			flag = sc.nextInt();
			switch (flag) {
			case 1:
				stm.show();
				
				break;
			case 2:
				
				
				break;
			case 3:
				System.out.println("请输入学生ID");
				stuID = sc.nextInt();
				sc.nextLine();
				Student stu = stm.findStudentInfoByID(stuID);
				
				System.out.println("是否删除该学生？ Y or N ");
				ch = sc.next().charAt(0);
				if (ch == 'Y' || ch == 'y') {
					stm.deleteStudentById(stuID);
				}
				System.out.println(stu);
				break;
				
			case 4:
				System.out.println("请输入学生ID");
				stuID = sc.nextInt();
				Student stu8 = stm.findStudentInfoByID(stuID);
				
				System.out.println("是否修改该学生? Y or N");
				if ('Y' == ch || 'y' == ch) {
					stm.modifyByID(stuID);
				}
				System.out.println(stu8);
				break;
				
			case 5:
				System.out.println("请输入学生ID");
				stuID = sc.nextInt();
				Student stu9 = stm.findStudentInfoByID(stuID);
				System.out.println(stu9);
				stm.findStudentInfoByID(stuID);
								
				break;
			case 6:
				System.out.println("请输入学生ID");
				stm.studentFilter(new MyFilter() {
					
					@Override
					public boolean myFilter(Student stu) {
						// TODO Auto-generated method stub						
						return stu.getEngScore() > 100 || stu.getGender() == '女';
					}
				});
	
				break;
			case 7:
				do { 
					System.out.println("1 ：按照语文升序");
					System.out.println("2 ：按照数学升序");
					System.out.println("3 ：按照英语升序");
					System.out.println("4：按照综合升序");
					System.out.println("default ：按照总分升序");
					
					flag = sc.nextInt();
					
					switch (flag) {
					case 1:
						
						stm.selectSortCompare(new SortCompare() {
							public boolean compare(Student stu1,Student stu2) {
								return stu1.getChnScore() > stu2.getChnScore();
							}
						}
								);
						
						break;
					case 2:
						
						stm.selectSortCompare(new SortCompare() {
							public boolean compare(Student stu1,Student stu2) {
								return stu1.getEngScore() > stu2.getMathScore();
							}
						}
								);
						break;
					case 3:
						
						stm.selectSortCompare(new SortCompare() {
							public boolean compare(Student stu1,Student stu2) {
								return stu1.getEngScore() > stu2.getEngScore();
							}
						}
								);

					case 4:
						stm.selectSortCompare(new SortCompare() {
							public boolean compare(Student stu1,Student stu2) {
								return stu1.getSynScore() > stu2.getSynScore();
							}
						}
								);
						break;
						
					default :
						stm.selectSortCompare(new SortCompare() {
							public boolean compare(Student stu1,Student stu2) {
								return stu1.getTotal() > stu2.getTotal();
							}
						}
								);
						break;
					
					}
					
					
				} while (flag != 4);
	
				break;


			case 8:
				System.out.println("退出");
				
				break;

			default:
				break;
			}
			
		} while (flag != 8);
	}
}
