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



          menu(students);//Start the menu function

    }

    public static void addStudent(ArrayList<Student> students) {
        System.out.print("enter student first name: ");
        //check if the first name does not contain a number
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        while (firstName.matches(".*\\d.*")){
            System.out.println("Invalid name, please enter a valid name");
            firstName = scanner.nextLine();
        }


        System.out.print("enter student last name: ");
        String lastName = scanner.nextLine();
        while (lastName.matches(".*\\d.*")){
            System.out.println("Invalid name, please enter a valid name");
            lastName = scanner.nextLine();
        }

        System.out.print("enter student age: ");
        if(!scanner.hasNextInt()){
            System.out.println("Invalid age, please enter a valid age");
            scanner.next();
        }
        int age = scanner.nextInt();


        System.out.print("enter student course: ");
        //check if the courseType is valid else ask again using try and catch
        CourseType course = null; //initialize course to null
        while (course == null){
            String courseString = scanner.next();
            try{
                course = CourseType.valueOf(courseString.toUpperCase());//convert the string to uppercase
            }catch (IllegalArgumentException e){
                System.out.println("Invalid course type, please enter a valid course type");
            }
        }

        //get the highest value of id in the arraylist and add 1 to it
        int studentId = students.stream().mapToInt(s -> s.studentId()).max().getAsInt() + 1;
        Student.addStudent(students, firstName, lastName, age, course, studentId);

    }

    public static void removeStudent(ArrayList<Student> students){
      Scanner  scanner = new Scanner(System.in);
        System.out.println("Enter student id to remove: ");
        int id = scanner.nextInt();
        Student.removeStudent(students, id);
        Student.printALl(students);
    }

    public static void getStudentById(ArrayList<Student> students){
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Enter student id to get: ");
        int id = scanner.nextInt();
        Student.getStudentById(students, id);
        enter();
    }


    public static void enter(){
        System.out.println("Press enter to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public static void menu(ArrayList<Student> students){

        System.out.println("Please Select the function you want to perform: ");
        System.out.println("1. Add a student");
        System.out.println("2. Remove a student");
        System.out.println("3. Print all students");
        System.out.println("4. Print all students grouped by course type");
        System.out.println("5. Get student by id");


        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch(select){
            case 1:
                addStudent(students);
                menu(students);
                break;

            case 2:
                removeStudent(students);
                menu(students);
                break;

            case 3:
                Student.printALl(students);
                enter();
                menu(students);
                break;

            case 4:
                Student.printStudentsGroupedByCourseType(students);
                enter();
                menu(students);
                break;

            case 5:
                getStudentById(students);
                enter();
                menu(students);
                break;

            default:
                System.out.println("Invalid input");
                menu(students);
                break;
        }


    }
}
