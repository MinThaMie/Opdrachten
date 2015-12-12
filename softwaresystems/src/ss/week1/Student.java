package ss.week1;

public class Student {
	public Student(){};

	public boolean passed(int score){
		return (score>=70);
	}
	
	public static void main(String[] args) {
		Student harry = new Student();
		
		System.out.println(harry.passed(50));		
		System.out.println(harry.passed(75));

	}

}
