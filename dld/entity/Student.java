package dld.entity;


/*学生类对象
 * */
    public class Student {
	//Field
	private int stuID;
	private String name;
	private int age;
	private char gender;
	private int classNum;
	private boolean choose;
	private float mathScore;
	private float chnScore;
	private float engScore;
	private float synScore;
	private float total;
	//Count statistics to create the number of student class objects
	private static int count = 1;
	
	//the construction block initializes student ID atrribute
	{
		this.stuID = count++;
	}
	//connstructorr
	public Student() {}
	

	public Student(String name, int age, char gender, int classNum, boolean choose, float mathScore, float chnScore,
			float engScore, float synScore) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.classNum = classNum;
		this.choose = choose;
		this.mathScore = mathScore;
		this.chnScore = chnScore;
		this.engScore = engScore;
		this.synScore = synScore;
		this.total = mathScore + chnScore + engScore + synScore;
	}


	public int getStuID() {
		return stuID;
	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getClassNum() {
		return classNum;
	}


	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}


	public boolean isChoose() {
		return choose;
	}


	public void setChoose(boolean choose) {
		this.choose = choose;
	}


	public float getMathScore() {
		return mathScore;
	}


	public void setMathScore(float mathScore) {
		this.total = this.mathScore;
		this.mathScore = mathScore;
		this.total = mathScore;
	}


	public float getChnScore() {
		return chnScore;
	}


	public void setChnScore(float chnScore) {
		this.total = this.chnScore;
		this.chnScore = chnScore;
		this.total = chnScore;
	}


	public float getEngScore() {
		return engScore;
	}


	public void setEngScore(float engScore) {
		this.total = this.engScore;
		this.engScore = engScore;
		this.total = engScore;
	}


	public float getSynScore() {
		return synScore;
	}


	public void setSynScore(float synScore) {
		this.total -= this.synScore;
		this.synScore = synScore;
		this.total += synScore;
	}


	public float getTotal() {
		return total;
	}


	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}


	@Override
	public String toString() {
		return "Student [stuID=" + stuID + ", name=" + name + ", age=" + age + ", gender=" + gender + ", classNum="
				+ classNum + ", choose=" + choose + ", mathScore=" + mathScore + ", chnScore=" + chnScore
				+ ", engScore=" + engScore + ", synScore=" + synScore + ", total=" + total + "]";
	}


	
	

}


