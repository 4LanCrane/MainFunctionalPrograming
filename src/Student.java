import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

