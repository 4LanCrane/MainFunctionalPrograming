import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.min;

public record Student<courseType>(String firstName, String lastName, int age, courseType course,int grade, int studentId){


    /** method to print all the students in the arraylist and groups them by course
     *
     * @param students
     */
    public static void PrintStudentsByCourseTypeFun(ArrayList<Student> students){
        students.stream()// create a stream
                .collect(Collectors.<Student, Object>groupingBy(Student::course))//group the students by course
                .forEach((c,s) -> System.out.println("Course is " +c + " Student Is " + s));//print the course and the student
    }


    /** method to map the student age and print the min age
     *
     * @param students
     */
    public static void mapStudentAgeMin(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .min()//get the min age
                .ifPresent(System.out::println);//print the min age
    }


    /**
     *
     * @param students method to map the student age and prints all the ages
     */
    public static void mapStudentAge(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .forEach(System.out::println);//print the age
    }

    /**
     * @param students method to map the student and then sort the age and print it
     */
    public static void mapStudentAgeSorted(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age()).sorted()//map the age and sort it
                .forEach(System.out::println);//print the sorted age
    }

    /**
     * @param students method to map the student ages and then add all the ages and print it
     */
    public static void mapStudentAddAllAges(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .reduce((a,b) -> a+b)//add all the ages
                .ifPresent(System.out::println);//print the sum
    }

    /**
     * @param students method to map the student ages and get the max age and print it
     */
    public static void mapStudentAgeMax(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .max()//get the max age
                .ifPresent(System.out::println);//print the max Student age
    }

    /**
     * @param students method to map the student ages and get the average age and print it
     */
    public static void mapStudentAgeAverage(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .average()//get the average age
                .ifPresent(System.out::println);//print the average age
    }



    /**
     * @param students method to return all Computer Science Students using allMatch
     */
    public static void returnAllCsStudents(ArrayList<Student> students){
       boolean result = students//create a boolean variable
                .stream()//create a stream
                .allMatch(s -> s.course().equals(CourseType.CS));//check if all the students are in the CS course
        System.out.println(result);//print the result
    }


    /**
     * @param students method to print all students
     */
    public static void printALl(ArrayList<Student> students) {
        students.forEach(s -> System.out.println(s));//print all the students

    }


    /**
     * @param students method to get Student by id
     */
    public static void getStudentById(ArrayList<Student> students){
        Scanner scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student id to get: ");//ask the user to enter the id
        int studentId = scanner.nextInt();//get the id from the user
        students.stream().filter(s->s.studentId() == studentId).forEach(s -> System.out.println(s));//filter the students by id and print them
    }


    /**
     * @param students method to add a student to the students arraylist
     */
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
    while (course == null){//loop until the course is valid
        String courseString = scanner.next();//get the course from the user
        try{
            course = CourseType.valueOf(courseString.toUpperCase());//convert the string to uppercase
        }catch (IllegalArgumentException e){
            System.out.println("Invalid course type, please enter a valid course type");
        }
    }

    System.out.print("enter student grade: ");
    //check if the age is a number else ask again
    if(!scanner.hasNextInt()){
        System.out.println("Invalid age, please enter a grade");
        scanner.next();
    }
    int grade = scanner.nextInt();


    //get the highest value of id in the arraylist and add 1 to it
    int studentId = students.stream().mapToInt(s -> s.studentId()).max().getAsInt() + 1;//get the highest value of id in the arraylist and add 1 to it

        students.add(new Student(firstName, lastName, age, course,grade, studentId));//add the student to the arraylist
    }


    /**
     * @param students method to remove a student from the students arraylist
     */
public static void removeStudent(ArrayList<Student> students) {
    Scanner  scanner = new Scanner(System.in);
    System.out.println("Enter student id to remove: ");
    int studentId = scanner.nextInt();//get the id from the user
        students.removeIf(s -> s.studentId() == studentId);//remove the student from the arraylist
    }


    /**
     * @param students method to group the students by course and print them. using containsKey
     */
    public static void printStudentsGroupedByCourseType(ArrayList<Student> students){
        HashMap<CourseType,ArrayList<Student>> studentMap = new HashMap<>();//create a hashmap

        for (Student s : students){//loop through the students arraylist
            if (studentMap.containsKey(s.course())){//check if the hashmap contains the course
                studentMap.get(s.course()).add(s);//add the student to the student map if the course is already in the hashmap
            }else{
                ArrayList<Student> temp = new ArrayList<>();//create a new arraylist
                temp.add(s);//add the student to the arraylist
                studentMap.put((CourseType) s.course(),temp);//put the course and the arraylist in the hashmap
            }
        }

        for (Map.Entry<CourseType,ArrayList<Student>> entry : studentMap.entrySet()){//loop through the hashmap
            System.out.println(entry.getKey() + " " + entry.getValue());//print the key and the value
        }

    }


    //Gets all students on a given module from user input and sort entries in descending order, based on marks.
    public static void getStudentsByCourseType(ArrayList<Student> students){
        System.out.println("please enter the course type: ");
        Scanner scanner = new Scanner(System.in);
        CourseType course = null;
        while (course == null){
            String courseString = scanner.next();
            try{
                course = CourseType.valueOf(courseString.toUpperCase());//convert the string to uppercase
            }catch (IllegalArgumentException e){
                System.out.println("Invalid course type, please enter a valid course type");
            }
        }
        CourseType finalCourse = course;
        students.stream()//create a stream
                .filter(s -> s.course().equals(finalCourse))//filter the students by course
                .sorted((s1,s2) -> s2.grade() - s1.grade())//sort the students by grade
                .forEach(System.out::println);//print the students
    }

    //gets all students whose name starts with a given letter from user input
    public static void getStudentByFirstLetter(ArrayList<Student> students){
        System.out.println("please enter the first letter of the name: ");
        Scanner scanner = new Scanner(System.in);//create a scanner object
        String firstLetter = scanner.next().toUpperCase();//get the letter from the user and convert it to uppercase
        students.stream()//create a stream
                .filter(s -> s.firstName().startsWith(firstLetter))//filter the students by first letter
                .forEach(System.out::println);//print the students
    }

    //gets all students whose name is a given name from user input
    public static void getStudentByName(ArrayList<Student> students){
        Scanner  scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student name to get: ");//ask the user to enter the name
        String name = scanner.next();//get the name from the user
        students.stream()//create a stream
                .filter(s -> s.firstName().equals(name))//filter the students by name
                .forEach(System.out::println);//print the students
    }
    

}

