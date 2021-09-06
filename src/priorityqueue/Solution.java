package priorityqueue;

import java.util.*;

/*
https://www.hackerrank.com/challenges/java-priority-queue
*/

/*
 * Create the Student and Priorities classes here.
 */

class Student {

    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {


    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() != o2.getCgpa()) {
            return o1.getCgpa() > o2.getCgpa() ? -1 : 1;
        }
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        }
        return Integer.compare(o1.getId(), o2.getId());
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(events.size(), new StudentComparator());
        List<Student> students = new ArrayList<>();

        for (String s : events) {
            Scanner scanner = new Scanner(s);
            if (scanner.next().equals("ENTER")) {
                String name = scanner.next();
                double cgpa = Double.parseDouble(scanner.next());
                int id = Integer.parseInt(scanner.next());
                priorityQueue.add(new Student(id, name, cgpa));
            } else {
                priorityQueue.poll();
            }
            scanner.close();
        }

        if (priorityQueue.isEmpty()) {
            return Collections.emptyList();
        } else {
            while (!priorityQueue.isEmpty()) {
                students.add(priorityQueue.poll());
            }
        }
        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }

}
