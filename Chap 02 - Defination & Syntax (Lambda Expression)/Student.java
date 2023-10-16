package learn_alamin_functional_interface;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

enum Gender {
    MALE,
    FEMALE;
}
public class Student {
    private String name;
    private int age;
    private Gender gender ;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}


class StudentProcessor {
    public List<String> process (List<Student> students , Function<Student, String> function) {

        ArrayList<String> list = new ArrayList<>();

        for (Student student : students) {
            String name = function.apply(student);
            list.add(name);
        }

        return list;
    }


    public List<Student> filter (List<Student> students , Predicate<Student> predicate) {
        ArrayList<Student> list = new ArrayList<>();

        for (Student student : students) {
            if (predicate.test(student)) {
                list.add(student);
            }
        }

        return list ;
    }
}


class Functional_Interface_Demo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Alamin", 34, Gender.MALE),
                                 new Student("Mohammad", 44, Gender.MALE),
                                 new Student("Newton", 65, Gender.MALE),
                                 new Student("Ada", 21, Gender.FEMALE));

        Function<Student, String> name_function = (Student student) -> student.getName();
        Function<Student, String> age_function = (Student student) -> String.valueOf(student.getAge());
        Function<Student, String> gender_function = (Student student) -> student.getGender().toString();

        StudentProcessor studentProcessor = new StudentProcessor();
        List<String> names = studentProcessor.process(students, name_function);
        List<String> ages = studentProcessor.process(students, age_function);
        List<String>  genders = studentProcessor.process(students, gender_function);

        System.out.println(names +" " + ages + " " + genders);


        Predicate<Student> olderThan50 = (Student student) -> student.getAge() > 50 ;
        Predicate<Student> femaleOnly =  (Student student) ->  student.getGender()== Gender.FEMALE ;

        List<Student> studentOlderThan50 = studentProcessor.filter(students , olderThan50);
        List<Student> femaleStudent = studentProcessor.filter(students, femaleOnly);

        System.out.println(studentOlderThan50 + "  " + femaleStudent);
    }
}