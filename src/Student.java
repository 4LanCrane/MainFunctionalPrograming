import java.util.ArrayList;
import java.util.stream.Collectors;

public record Student<courseType>(String firstName, String lastName, int age, courseType course, int studentId){

    public static void PrintStudentsByCourseTypeFun(ArrayList<Student> students){
        students.stream()
                .collect(Collectors.<Student, Object>groupingBy(Student::course))
                .forEach((c,s) -> System.out.println("Course is " +c + " Student Is " + s));
    }

//method to print all from the students arraylist
    public static void printALl(ArrayList<Student> students) {
        students.forEach(s -> System.out.println(s));

    }

    public static void getStudentById(ArrayList<Student> students,int studentId){
        students.stream().filter(s->s.studentId() == studentId).forEach(s -> System.out.println(s));
    }


    //method to add a studnet by adding name, age, course and student id
public static void addStudent(ArrayList<Student> students, String firstName, String lastName, int age, CourseType course, int studentId) {
        students.add(new Student(firstName, lastName, age, course, studentId));
    }


    //method to add a student to the students arraylist
    public static void addStudent(ArrayList<Student> students, Student student) {
        students.add(student);
    }

    //method to remove a student from the students arraylist by student id
public static void removeStudent(ArrayList<Student> students, int studentId) {
        students.removeIf(s -> s.studentId() == studentId);
    }

}

