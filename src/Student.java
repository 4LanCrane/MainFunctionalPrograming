import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.min;

public record Student<courseType>(String firstName, String lastName, int age, courseType course, int studentId){

    public static void PrintStudentsByCourseTypeFun(ArrayList<Student> students){
        students.stream()
                .collect(Collectors.<Student, Object>groupingBy(Student::course))
                .forEach((c,s) -> System.out.println("Course is " +c + " Student Is " + s));
    }



    public static void mapStudentAgeMin(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age())
                .min()
                .ifPresent(System.out::println);
    }



    public static void mapStudentAge(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age())
                .forEach(System.out::println);
    }

    public static void mapStudentAgeSorted(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age()).sorted()
                .forEach(System.out::println);
    }

    public static void mapStudentAddAllAges(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age())
                .reduce((a,b) -> a+b)
                .ifPresent(System.out::println);
    }

    public static void mapStudentAgeMax(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age())
                .max()
                .ifPresent(System.out::println);
    }

    public static void mapStudentAgeAverage(ArrayList<Student> students){
        students
                .stream()
                .mapToInt(s -> s.age())
                .average()
                .ifPresent(System.out::println);
    }

    public static void returnAllCsStudents(ArrayList<Student> students){
       boolean result = students
                .stream()
                .allMatch(s -> s.course().equals(CourseType.CS));
        System.out.println(result);
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


    //method to remove a student from the students arraylist by student id
public static void removeStudent(ArrayList<Student> students, int studentId) {
        students.removeIf(s -> s.studentId() == studentId);
    }


    public static void printStudentsGroupedByCourseType(ArrayList<Student> students){
        //a hashmap and group students by course with course as the key
        HashMap<CourseType,ArrayList<Student>> studentMap = new HashMap<>();

        for (Student s : students){
            if (studentMap.containsKey(s.course())){
                studentMap.get(s.course()).add(s);
            }else{
                ArrayList<Student> temp = new ArrayList<>();
                temp.add(s);
                studentMap.put((CourseType) s.course(),temp);
            }
        }

        for (Map.Entry<CourseType,ArrayList<Student>> entry : studentMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}

