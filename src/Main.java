import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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




        Student.PrintStudentsByCourseTypeFun(students);

    }



















//Predicate <ArrayList<Student >> ageOver18 = age -> x.age











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
