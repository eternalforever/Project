package dld.dao;

import java.util.Scanner;

import dld.entity.Student;
import dld.inter.SortCompare;
import dld.test.Filter.MyFilter;

//In Java development, classes of different packages in a 
//project need to be used through a package guide,
//and classes under the same package name can be called directly
public class StudentManager {
	//you need array to hold student information
	private Student[] allStu = new Student[10];
	
	//Static privatized member variable defined within 
	//the class to count how many valid student information is in the current array!!
	
	private static int itemCount = 0;
	
	
	//Constructor
	public StudentManager() {}
	/*
	 * add new student
	 * delete student by student ID
	 * modify student infomation by ID
	 * query  ...
	 * Searching student infomation acorrding
	 * arts or classes or sciences
	 * */
	
	public boolean addNewStudent(Student newStuToAdd) {
		//parameter legitimacy judgment.
		if (null == newStuToAdd) {
			System.out.println("学生信息为空，不能添加数据");
			return false;
			
		}
		if (this.allStu.length == itemCount) {
			//这里要进行扩容操作
			grow(this.allStu.length);
		}
		this.allStu[itemCount++] = newStuToAdd;
		return true;
	}
	
	public void show() {
		for (int i = 0; i < itemCount; i++) {
			System.out.println(this.allStu[i]);
			
		}
	}
	/**
	 * privatize the member method ,which is provided only for use within the class,
	 *for otheer methods,for query operationns,to find the currently specifield ID.
	 * @param stuID specify student ID
	 * @return if 
	 */
	private int findStudentIndexByID(int stuID) {
		int index = -1;
		if (stuID < 1) {
			System.out.println("Not Found");
			return index;
		}
		
		for (int i = 0; i < itemCount ; i++) {
			if (this.allStu[i].getStuID() == stuID) {
				index = i;
				break;
				
			}
			
			
		}
		return index;
	}
	
	public void deleteStudentById(int stuID) {
	//Call the privatiztion method within the class to find the subscript position of the specified student
		int index = findStudentIndexByID(stuID);
		
		//Judge index's price
		if (-1 == index) {
			System.out.println("cann't delete");
			return;
		}
		for (int i = index ;i < itemCount - 1;i++) {
			this.allStu[i] = this.allStu[i+1];
			
		}
		//At the end of deletion, the number of valid elements is -1, and the original
		//last valid element is assigned null, referring to the "0" value of the data type
		this.allStu[++itemCount] = null;
	}
	

	
	
	//根据学生ID查询学生信息；
	public Student findStudentInfoByID(int stuID) {
		int index = findStudentIndexByID(stuID);
		if (-1 ==index) {
			System.out.println("NObody");
		}
		System.out.println(this.allStu[index]);
		return this.allStu[index];
		
		
	}
	
	
	//根据学生信息过滤
	public void studentFilter(MyFilter m) {
		if (null == m) {
			System.out.println("invalid");
			return;
		}
		int count = 0;
		Student[] temps = new Student[itemCount];
		for (int i = 0; i < itemCount;i++) {
			if (m.myFilter(this.allStu[i])) {
				temps[count++] = this.allStu[i];
				}
		}
		for (int i = 0; i < count; i++) {
			System.out.println(temps[i]);
			
		}
	}
	
	
	
	
	//修改学生信息根据ID
	/**
	 * 
	 * @param stuID根据ID查询的下标找到对象位置
	 * @return 返回要修改的学生对象
	 */
	public void modifyByID(int stuID) {
		
		int index = findStudentIndexByID(stuID);
		if (-1 == index) {
			return ;
		}
		
		int choose = 0;
		Scanner sc = new Scanner(System.in);
		Student temp = this.allStu[index];
		
		do {
			//展示学生信息
			System.out.println("修改" + temp.getName() + "的信息");
			System.out.println("## ID:" + temp.getStuID() +  " 性别:" + temp.getGender());
			System.out.println("## 年龄:" + temp.getAge() + " 班级:" + temp.getClassNum() + " " + temp.isChoose());
			System.out.println("## 语文:" + temp.getChnScore() + " 数学:" + temp.getMathScore() + " 英语:" + temp.getEngScore());
			System.out.println("## 综合:" + temp.getSynScore() + " 总分:" + temp.getTotal());
			System.out.println("");
			System.out.println("1. 修改学生姓名");
			System.out.println("2. 修改学生性别");
			System.out.println("3. 修改学生年龄");
			System.out.println("4. 修改学生班级");
			System.out.println("5. 修改学生文理");
			System.out.println("6. 修改学生语文成绩");
			System.out.println("7. 修改学生数学成绩");
			System.out.println("8. 修改学生英语成绩");
			System.out.println("9. 修改学生综合成绩");
			System.out.println("10. 保存退出");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("请输入要修改的名字： ");
				String name = sc.next();
				temp.setName(name);
				break;
			
			case 2:
				System.out.println("请输入性别： ");
				
				char gender = sc.next().charAt(0);
				if (gender != '男' && gender != '女') {
					gender = '女';
					System.out.println("invalid param");
				
				}
				
				temp.setGender(gender);
				break;
			
			
			case 3:
				System.out.println("请输入年龄");
				int age = sc.nextInt();
				if (age < 0 && age >200) {
					age = 0;
					System.out.println("无效范围");
				}
				temp.setAge(age);
				break;
			
			case 4:
				System.out.println("请输入班级：");
				int classNum = sc.nextInt();
				if (classNum < 0) {
					System.out.println("输入错误");
				}
				temp.setClassNum(classNum);
				break;
			
			case 5:
				 
				
				
			
			case 6:
				System.out.println("请输入语文成绩： ");
				int chnScore = sc.nextInt();
				if (chnScore < 0 || chnScore > 150) {
					chnScore = 0;
					System.out.println("输入无效");
				}
				temp.setChnScore(chnScore);
				break;
			
			case 7:
				System.out.println("请输入数学成绩： ");
				int mathScore = sc.nextInt();
				if (mathScore < 0 || mathScore > 150) {
					mathScore = 0;
					System.out.println("输入无效");
				}
				temp.setMathScore(mathScore);
				break;
				
			case 8:
				System.out.println("请输入英语成绩： ");
				int engScore = sc.nextInt();
				if (engScore < 0 || engScore > 150) {
					engScore = 0;
					System.out.println("输入无效");
				}
				temp.setEngScore(engScore);
				break;
			
			case 9:
				System.out.println("请输入理综或文综成绩： ");
				int synScore = sc.nextInt();
				if (synScore < 0 || synScore > 300) {
					synScore = 0;
					System.out.println("输入无效");
				}
				temp.setSynScore(synScore);
				break;
			
			case 10:
				System.out.print("保存退出");
				
				break;
			
			default:
				
				break;
			
									
			}
			
		} while ( choose != 10);
		
				
			
	}
	
	
	
	
	
	
	//定义比较器
	/**
	 * 
	 * @param stu1
	 * @param stu6
	 */
	public void selectSortCompare(SortCompare s) {
		//排序算法时，保证数据安全，要备份数据展示
		Student[] sortTemp = new Student[itemCount];
		// 复制数组到temp
		for (int i = 0; i < sortTemp.length; i++) {
			sortTemp[i] = this.allStu[i];
		}
		//排序算法
		int index = 0;
		for (int i = 0; i < itemCount - 1; i++ ) {
			index = i;
			for(int j = i + 1; j < itemCount; j++) {
				if (s.compare(sortTemp[index] ,sortTemp[j])) {
					index = j;
				}
			}
			if (index != i) {
				Student temp = sortTemp[i];
				sortTemp[i] = sortTemp[index];
				sortTemp[index] = temp;
			}
		}
		
		//展示数据 。。
		for (int i = 0; i < itemCount; i++) {
			System.out.println(sortTemp[i]);
		}
	}
	
	
		
	
	private void grow(int minCapacity) {
		/*The array is created to determine the capacity off hte data,
		 * so the array cannot be changed
		 * Here we need to create a now Array
		 * newCapacity :Creating a new array require the capacity of array.
		 * The new capacity calculated
		 */
		//1 Calculate the new capacity
		int oldCapacity = this.allStu.length;
		
		//2.the new capacity is bigger than old
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		
		//Judge the data and determine whether the capacity of current capacity 
		//expansion meets	the minimum capacity
		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
		}
		//4.Create new array;
		Student[] newArray = new Student[newCapacity];
		//Copy the old data to the newArray
		for (int i = 0; i < itemCount; i++) {
			newArray[i] = this.allStu[i];
			
		}
		//6. exchange address
		this.allStu = newArray;
		
		
		
	}
	
	
}
