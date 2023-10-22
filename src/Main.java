import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.





public class Main {


    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Alan", "Cray", 12, CourseType.CS, 1));
        students.add(new Student("Bonny", "Tom", 18, CourseType.CSG, 2));
        students.add(new Student("Jeff", "Mathetew", 12, CourseType.SE, 3));
        students.add(new Student("John", "King", 22, CourseType.SE, 4));
        students.add(new Student("Tom", "bobby", 32, CourseType.SE, 5));
        students.add(new Student("Alisha", "reed", 12, CourseType.SE, 6));
        students.add(new Student("Terry", "Johnson", 14, CourseType.SE, 7));
        students.add(new Student("Thomas", "Goldson", 16, CourseType.SE, 8));
        students.add(new Student("Harry", "Johnson", 18, CourseType.SE, 9));
        students.add(new Student("Danny", "Roberts", 17, CourseType.SE, 10));
        students.add(new Student("teff", "bobby", 14, CourseType.SE, 11));




        //Student.printALl(students);




        //Student.PrintStudentsByCourseTypeFun(students);

        System.out.print("enter student first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        System.out.print("enter student last name: ");
        String lastName = scanner.nextLine();

        System.out.print("enter student age: ");
        int age = scanner.nextInt();

        System.out.print("enter student course: ");
        CourseType course = CourseType.valueOf(scanner.next().toUpperCase());

        System.out.print("enter student id: ");
        int studentId = scanner.nextInt();
        Student.addStudent(students, firstName, lastName, age, course, studentId);


        Student.printStudentsGroupedByCourseType(students);
    }



















//Predicate <ArrayList<Student >> ageOver18 = age -> x.age
















}
