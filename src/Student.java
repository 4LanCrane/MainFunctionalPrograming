import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public static void mapStudentAgeAverage(ArrayList<Student> students){
        students
                .stream()//create a stream
                .mapToInt(s -> s.age())//map the age
                .average()//get the average age
                .ifPresent(System.out::println);//print the average age
    }

    public static void returnAllCsStudents(ArrayList<Student> students){
       boolean result = students//create a boolean variable
                .stream()//create a stream
                .allMatch(s -> s.course().equals(CourseType.CS));//check if all the students are in the CS course
        System.out.println(result);//print the result
    }


//method to print all from the students arraylist
    public static void printALl(ArrayList<Student> students) {
        students.forEach(s -> System.out.println(s));//print all the students

    }

    public static void getStudentById(ArrayList<Student> students,int studentId){
        students.stream().filter(s->s.studentId() == studentId).forEach(s -> System.out.println(s));//filter the students by id and print them
    }


    //method to add a studnet by adding name, age, course and student id
public static void addStudent(ArrayList<Student> students, String firstName, String lastName, int age, CourseType course,int grade, int studentId) {
        students.add(new Student(firstName, lastName, age, course,grade, studentId));//add the student to the arraylist
    }


    //method to remove a student from the students arraylist by student id
public static void removeStudent(ArrayList<Student> students, int studentId) {
        students.removeIf(s -> s.studentId() == studentId);//remove the student from the arraylist
    }

    public static void printStudentsGroupedByCourseType(ArrayList<Student> students){
        //a hashmap and group students by course with course as the key
        HashMap<CourseType,ArrayList<Student>> studentMap = new HashMap<>();//create a hashmap

        for (Student s : students){//loop through the students arraylist
            if (studentMap.containsKey(s.course())){//check if the hashmap contains the course
                studentMap.get(s.course()).add(s);//add the student to the arraylist
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
    public static void getStudentsByCourseType(ArrayList<Student> students, CourseType courseType){
        students.stream()//create a stream
                .filter(s -> s.course().equals(courseType))//filter the students by course
                .sorted((s1,s2) -> s2.grade() - s1.grade())//sort the students by grade
                .forEach(System.out::println);//print the students
    }

    //gets all students whose name starts with a given letter from user input
    public static void getStudentByFirstLetter(ArrayList<Student> students, String firstLetter){
        students.stream()//create a stream
                .filter(s -> s.firstName().startsWith(firstLetter))//filter the students by first letter
                .forEach(System.out::println);//print the students
    }

    public static void getStudentByName(ArrayList<Student> students, String name){
        students.stream()//create a stream
                .filter(s -> s.firstName().equals(name))//filter the students by name
                .forEach(System.out::println);//print the students
    }



}

