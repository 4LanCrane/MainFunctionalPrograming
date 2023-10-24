import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<Student>();//create an arraylist of students
        //add students to the arraylist
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

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        //check if the name contains a number else ask again
        while (firstName.matches(".*\\d.*")){
            System.out.println("Invalid name, please enter a valid name");
            firstName = scanner.nextLine();
        }


        System.out.print("enter student last name: ");
        String lastName = scanner.nextLine();
        //check if the name contains a number else ask again
        while (lastName.matches(".*\\d.*")){
            System.out.println("Invalid name, please enter a valid name");
            lastName = scanner.nextLine();
        }

        System.out.print("enter student age: ");
        //check if the age is a number else ask again
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
        int id = scanner.nextInt();//get the id from the user
        Student.removeStudent(students, id);//call the removeStudent method in the Student class
        Student.printALl(students);//print all the students
    }

    public static void getStudentById(ArrayList<Student> students){
        Scanner  scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student id to get: ");//ask the user to enter the id
        int id = scanner.nextInt();//get the id from the user
        Student.getStudentById(students, id);//call the getStudentById method in the Student class
        enter();//call the enter method to pause the program
    }


    public static void enter(){
        System.out.println("Press enter to continue");//ask the user to press enter to continue
        Scanner scanner = new Scanner(System.in);//create a scanner object
        scanner.nextLine();//continue when the user presses enter
    }


    public static void menu(ArrayList<Student> students){

        //print the option menu
        System.out.println("Please Select the function you want to perform: ");
        System.out.println("1. Add a student");
        System.out.println("2. Remove a student");
        System.out.println("3. Print all students");
        System.out.println("4. Print all students grouped by course type");
        System.out.println("5. Get student by id");


        Scanner scanner = new Scanner(System.in);//create a scanner object
        int select = scanner.nextInt();//get the user input
        switch(select){//switch the user input
            case 1:
                addStudent(students);//call the addStudent method
                menu(students);//call the menu method
                break;

            case 2:
                removeStudent(students);//call the removeStudent method
                menu(students);//call the menu method
                break;

            case 3:
                Student.printALl(students);//call the printAll method
                enter();//call the enter method
                menu(students);//call the menu method
                break;

            case 4:
                Student.printStudentsGroupedByCourseType(students);//call the printStudentsGroupedByCourseType method
                enter();//call the enter method
                menu(students);//call the menu method
                break;

            case 5:
                getStudentById(students);//call the getStudentById method
                enter();//call the enter method
                menu(students);//call the menu method
                break;

            default:
                System.out.println("Invalid input");
                menu(students);//call the menu method
                break;
        }


    }
}
