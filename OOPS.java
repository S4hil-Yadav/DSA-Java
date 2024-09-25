public class OOPS {

}

class Student {
	String name;
	int rollNo;
	// int[] marks;
	int[] marks = new int[2];
	// Student(Student s) {								// Shallow Copy Constructor
	// 	this.name = s.name;
	// 	this.rollNo = s.rollNo;
	// 	this.marks = s.marks;
	// }
	Student(Student s) {								// Deep Copy Constructor
		name = s.name;
		rollNo = s.rollNo;
		marks = new int[s.marks.length];
		for(int i=0; i<marks.length; i++) {
			marks[i] = s.marks[i];
		}
	}													// HW :- Lazy Copy (not important for placement though)
	Student() {
		this.marks = new int[6];
	}
	Student(String name) {
		this.name = name;
	}
	Student(int rollNo) {
		this.rollNo = rollNo;
	}
}

class Pen {
	String color;
	int tip;
	void setColor(String newColor) {
		color = newColor;
		return;
	}
	void setTip(int newTip) {
		tip = newTip;
		return;
	}
}

class Calculator {
	int sum(int a, int b) {
		return (a + b);
	}															// Function
	float sum(float a, float b) {								// overloading
		return (a + b);
	}
	int sum(int a, int b, int c) {
		return (a + b + c);
	}
}

class Animal {
	void eat() {
		System.out.println("Eats food");
	}
}

class Deer {
	void eat() {
		System.out.println("Eats grass");						// D1.eat() >>> Eats grass
	}															// Function overriding
}

// Constructor chaining