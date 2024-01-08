import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.List;

import static java.util.Collections.min;
import static java.util.stream.Collectors.groupingBy;

public record Student<courseType>(String firstName, String lastName, int age, courseType course,int grade, int studentId) {


    /**
     * method to print all the students in the arraylist and groups them by course
     *
     * @param students
     */
    public static void PrintStudentsByCourseTypeFun(List<Student> students) {
        students.stream()// create a stream
                .collect(groupingBy(Student::course))//group the students by course
                .forEach((c, s) -> System.out.println("Course is " + c + " Student Is " + s));//print the course and the student
    }

    // prints students by course type using an oo approach
    public static void PrintStudentsByCourseTypeOo(List<Student> students) {
        HashMap<CourseType, ArrayList<Student>> studentMap = new HashMap<>();//create a hashmap

        for (Student s : students) {//loop through the students arraylist
            if (studentMap.containsKey(s.course())) {//check if the hashmap contains the course
                studentMap.get(s.course()).add(s);//add the student to the student map if the course is already in the hashmap
            } else {
                ArrayList<Student> temp = new ArrayList<>();//create a new arraylist
                temp.add(s);//add the student to the arraylist
                studentMap.put((CourseType) s.course(), temp);//put the course and the arraylist in the hashmap
            }
        }

        for (Map.Entry<CourseType, ArrayList<Student>> entry : studentMap.entrySet()) {//loop through the hashmap
            System.out.println(entry.getKey() + " " + entry.getValue());//print the key and the value
        }

    }


    /**
     * method to map the student age and print the min age
     *
     * @param students
     */
    public static void mapStudentAgeMin(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .min()//get the min age
                .ifPresent(System.out::println);//print the min age
    }


    /**
     * @param students method to map the student age and prints all the ages
     */
    public static void mapStudentAge(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .forEach(System.out::println);//print the age
    }

    /**
     * @param students method to map the student and then sort the age and print it
     */
    public static void mapStudentAgeSorted(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age()).sorted()//map the age and sort it
                .forEach(System.out::println);//print the sorted age
    }

    /**
     * @param students method to map the student ages and then add all the ages and print it
     */
    public static void mapStudentAddAllAges(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .reduce((a, b) -> a + b)//add all the ages
                .ifPresent(System.out::println);//print the sum
    }

    /**
     * @param students method to map the student ages and get the max age and print it
     */
    public static void mapStudentAgeMax(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .max()//get the max age
                .ifPresent(System.out::println);//print the max Student age
    }

    /**
     * @param students method to map the student ages and get the average age and print it
     */
    public static void mapStudentAgeAverage(List<Student> students) {
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .average()//get the average age
                .ifPresent(System.out::println);//print the average age
    }


    /**
     * @param students method to return all Computer Science Students using allMatch
     */
    public static void returnAllCsStudents(List<Student> students) {
        boolean result = students//create a boolean variable
                .stream()//create a stream
                .allMatch(s -> s.course().equals(CourseType.CS));//check if all the students are in the CS course
        System.out.println(result);//print the result
    }


    /**
     * @param students method to print all students
     */
    public static void printALl(List<Student> students) {
        students.forEach(s -> System.out.println(s));//print all the students
    }

    //prints all students using an oo approach
    public static void printAllStudentsOo(List<Student> students) {
        for (int s =0; s< students.size();s++ ) {//loop through the students arraylist
            System.out.println(students.get(s));//print the student
        }
    }


    /**
     * @param students method to get Student by id
     */
    public static void getStudentById(List<Student> students) {
        Scanner scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student id to get: ");//ask the user to enter the id
        int studentId = scanner.nextInt();//get the id from the user
        students.stream().filter(s -> s.studentId() == studentId).forEach(s -> System.out.println(s));//filter the students by id and print them
    }

    //gets student by id using an oo approach
    public static void getStudentByIdOo(List<Student> students) {
        Scanner scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student id to get: ");//ask the user to enter the id
        int studentId = scanner.nextInt();//get the id from the user
        for (Student s : students) {//loop through the students arraylist
            if (s.studentId() == studentId) {//check if the student id is equal to the id from the user
                System.out.println(s);//print the student
            }
        }
    }


    // add a new student using the functional approach


    /**
     * @param students method to add a student to the students arraylist
     */
    public static void addStudent(List<Student> students) {
        System.out.print("enter student first name: ");

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        //check if the name contains a number else ask again
        while (firstName.matches(".*\\d.*")) {
            System.out.println("Invalid name, please enter a valid name");
            firstName = scanner.nextLine();
        }

        System.out.print("enter student last name: ");
        String lastName = scanner.nextLine();
        //check if the name contains a number else ask again
        while (lastName.matches(".*\\d.*")) {
            System.out.println("Invalid name, please enter a valid name");
            lastName = scanner.nextLine();
        }

        System.out.print("enter student age: ");
        //check if the age is a number else ask again
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid age, please enter a valid age");
            scanner.next();
        }
        int age = scanner.nextInt();


        System.out.print("enter student course: ");
        //check if the courseType is valid else ask again using try and catch
        CourseType course = null; //initialize course to null
        while (course == null) {//loop until the course is valid
            String courseString = scanner.next();//get the course from the user
            try {
                course = CourseType.valueOf(courseString.toUpperCase());//convert the string to uppercase
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid course type, please enter a valid course type");
            }
        }
        System.out.print("enter student grade: ");
        //check if the age is a number else ask again
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid age, please enter a grade");
            scanner.next();
        }
        int grade = scanner.nextInt();
        int studentId = highestId(students);//get the highest value of id in the arraylist and add 1 to it

        students.add(new Student(firstName, lastName, age, course, grade, studentId));//add the student to the arraylist
    }


    public static void addStudentFP(List<Student> students) {

        Scanner scanner = new Scanner(System.in);

        String firstName = getUserInput("Enter student first name: ", s ->doesNotContainDigits(s), scanner);
        String lastName = getUserInput("Enter student last name: ", Student::doesNotContainDigits, scanner);
        int age = Integer.parseInt(getUserInput("Enter student age: ", s -> !doesNotContainDigits(s), scanner));
        String course = getUserInput("Enter student course: ", s -> isValidCourse(s), scanner);
        int grade = Integer.parseInt(getUserInput("Enter student grade: ", s -> !doesNotContainDigits(s), scanner));
        int studentId = students.stream().mapToInt(Student::studentId).max().getAsInt() + 1;


        students.add(new Student(firstName, lastName, age, course, grade, studentId));
    }






    public static int highestId(List<Student> students){
        int highestId = 0;//initialize the highest id to 0
        for (int s =0; s< students.size();s++ ) {//loop through the students arraylist
            if (students.get(s).studentId() > highestId) {//check if the student id is greater than the highest id
                highestId = students.get(s).studentId();//set the highest id to the student id
            }
        }
        return  highestId + 1;//return the highest id plus 1
    }


    /**
     * @param course method to check if the course is valid
     * @return
     */
    private static boolean isValidCourse(String course) {
        try {
            CourseType.valueOf(course.toUpperCase());//convert the string to uppercase
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }



    private static String getUserInput(String prompt, Predicate<String> validator, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!validator.test(input)) {
            System.out.println("Invalid input, please try again.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }



    private static boolean doesNotContainDigits(String input) {
        return !input.matches(".*\\d.*");
    }



    // function to work out the average age of all students
    public static void averageAge(List<Student> students) {
        double average = students.stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .average()//get the average age
                .getAsDouble();//convert the average to a double
        System.out.println(average);//print the average age
    }





    /**
     * @param students method to remove a student from the students arraylist
     */
public static void removeStudent(List<Student> students) {
    Scanner  scanner = new Scanner(System.in);
    System.out.println("Enter student id to remove: ");
    int studentId = scanner.nextInt();//get the id from the user
        students.removeIf(s -> s.studentId() == studentId);//remove the student from the arraylist
    }



    //removes a student from the arraylist using an oo approach
    public static void removeStudentOo(List<Student> students){
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Enter student id to remove: ");
        int studentId = scanner.nextInt();//get the id from the user
        for (int s = 0; s< students.size(); s++){//loop through the students arraylist
            if (s == studentId){//check if the student id is equal to the id from the user
                students.remove(s);//remove the student from the arraylist
            }
        }
    }



    //Gets all students on a given module from user input and sort entries in descending order, based on marks.
    public static void getStudentsByCourseType(List<Student> students){
        System.out.println("please enter the course type: ");
        Scanner scanner = new Scanner(System.in);
            String courseString = scanner.next();
        CourseType finalCourse = CourseType.valueOf(courseString);
        students.stream()//create a stream
                .filter(s -> s.course().equals(finalCourse))//filter the students by course
                .sorted((s1,s2) -> s2.grade() - s1.grade())//sort the students by grade
                .forEach(System.out::println);//print the students
    }



    //Gets all students on a given module from user input and sort entries in descending order, based on marks using an oo approach
    public static void getStudentsByCourseTypeOo2(List<Student> students){
        System.out.println("please enter the course type: ");
        Scanner scanner = new Scanner(System.in);
        String courseString = scanner.next();
        CourseType course = CourseType.valueOf(courseString);


        ArrayList<Student> temp = new ArrayList<>();//create a new arraylist
        for (Student s : students){//loop through the students arraylist
            if (s.course().equals(course)){//check if the student course is equal to the course from the user
                temp.add(s);//add the student to the arraylist
            }
        }
        temp.sort((s1,s2) -> s2.grade() - s1.grade());//sort the students by grade
        for (Student s : temp){//loop through the temp arraylist
            System.out.println(s);//print the student
        }
    }

    // getStudentsByCourseTypeOo but sort the entries in ascending order, based on marks without using sort or any functioal programming
    public static void getStudentsByCourseTypeOo3(List<Student> students){
        System.out.println("please enter the course type: ");
        Scanner scanner = new Scanner(System.in);
        String courseString = scanner.next();
        CourseType course = CourseType.valueOf(courseString);

        ArrayList<Student> SortedArrayList = new ArrayList<>();//create a new arraylist
        for (Student s : students){//loop through the students arraylist
            if (s.course().equals(course)){//check if the student course is equal to the course from the user
                SortedArrayList.add(s);//add the student to the arraylist
            }
        }
        for (int i = 0; i <  SortedArrayList.size(); i++) {//loop through the temp arraylist
            for (int j = i + 1; j <  SortedArrayList.size(); j++) {//loop through the temp arraylist
                if ( SortedArrayList.get(i).grade() >  SortedArrayList.get(j).grade()) {//check if the student grade is greater than the next student grade
                    Student tempStudent =  SortedArrayList.get(i);//set the temp student to the current student
                    SortedArrayList.set(i,  SortedArrayList.get(j));//set the current student to the next student
                    SortedArrayList.set(j, tempStudent);//set the next student to the temp student
                }
            }
        }
        for (Student s :  SortedArrayList){//loop through the temp arraylist
            System.out.println(s);//print the student
        }
    }


    // getStudentsByCourseTypeOo but sort the entries in descending order, based on marks without using sort or any functioal programming
    public static void getStudentsByCourseTypeOo(List<Student> students){
        System.out.println("please enter the course type: ");
        Scanner scanner = new Scanner(System.in);
        String courseString = scanner.next();
        CourseType course = CourseType.valueOf(courseString);

        ArrayList<Student> SortedArrayList = new ArrayList<>();//create a new arraylist
        for (Student s : students){//loop through the students arraylist
            if (s.course().equals(course)){//check if the student course is equal to the course from the user
                SortedArrayList.add(s);//add the student to the arraylist
            }
        }
        for (int i = 0; i <  SortedArrayList.size(); i++) {//loop through the temp arraylist
            for (int j = i + 1; j <  SortedArrayList.size(); j++) {//loop through the temp arraylist
                if ( SortedArrayList.get(i).grade() <  SortedArrayList.get(j).grade()) {//check if the student grade is less than the next student grade
                    Student tempStudent =  SortedArrayList.get(i);//set the temp student to the current student
                    SortedArrayList.set(i,  SortedArrayList.get(j));//set the current student to the next student
                    SortedArrayList.set(j, tempStudent);//set the next student to the temp student
                }
            }
        }
        for (Student s :  SortedArrayList){//loop through the temp arraylist
            System.out.println(s);//print the student
        }
    }






    //gets all students whose name starts with a given letter from user input
    public static void getStudentByFirstLetter(List<Student> students){
        System.out.println("please enter the first letter of the name: ");
        Scanner scanner = new Scanner(System.in);//create a scanner object
        String firstLetter = scanner.next().toUpperCase();//get the letter from the user and convert it to uppercase
        students.stream()//create a stream
                .filter(s -> s.firstName().startsWith(firstLetter))//filter the students by first letter
                .forEach(System.out::println);//print the students
    }

    //gets all students whose name starts with a given letter from user input using an oo approach
    public static void getStudentByFirstLetterOo(List<Student> students){
        System.out.println("please enter the first letter of the name: ");
        Scanner scanner = new Scanner(System.in);//create a scanner object
        String firstLetter = scanner.next().toUpperCase();//get the letter from the user and convert it to uppercase
        for (Student s : students){//loop through the students arraylist
            if (s.firstName().startsWith(firstLetter)){//check if the student name starts with the letter from the user
                System.out.println(s);//print the student
            }
        }
    }

    //gets all students whose name is a given name from user input
    public static void getStudentByName(List<Student> students){
        Scanner  scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student name to get: ");//ask the user to enter the name
        String name = scanner.next();//get the name from the user
        students.stream()//create a stream
                .filter(s -> s.firstName().equals(name))//filter the students by name
                .forEach(System.out::println);//print the students
    }

    //gets all students whose name is a given name from user input using an oo approach
    public static void getStudentByNameOo(List<Student> students){
        Scanner  scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student name to get: ");//ask the user to enter the name
        String name = scanner.next();//get the name from the user
        for (Student s : students){//loop through the students arraylist
            if (s.firstName().equals(name)){//check if the student name is equal to the name from the user
                System.out.println(s);//print the student
            }
        }
    }


    //gets all students whose name is a given name from user input using an oo approach using a for loop
    public static void getStudentByNameOo2(List<Student> students){
        Scanner  scanner = new Scanner(System.in);//create a scanner object
        System.out.println("Enter student name to get: ");//ask the user to enter the name
        String name = scanner.next();//get the name from the user
        for (int s = 0; s< students.size(); s++){//loop through the students arraylist
            if (students.get(s).firstName().equals(name)){//check if the student name is equal to the name from the user
                System.out.println(students.get(s));//print the student
            }
        }
    }







}

