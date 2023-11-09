package lab4_student;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) {
	Student st1 = new Student("Nam", 10);
	Student st2 = new Student("Nam", 10);
	Student st3 = new Student("Nam", 10);
	
	PriorityQueue<Student>	 q = new PriorityQueue<>(new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.getAge() - o2.getAge();
		}
	});
	q.add(st1);
	q.add(st2);
	q.add(st3);
	st3.setAge(13);
	
	System.out.println(q.poll());
	System.out.println(q.poll());

	System.out.println(q.poll());

	}
}
