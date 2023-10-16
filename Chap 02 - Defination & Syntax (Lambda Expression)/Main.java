import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
          List<Contact> contacts = Arrays.asList(new Contact("Mohammad", "mohammad@gmail.com", 24, Gender.MALE),
                  new Contact("alamin", "alamin@gmail.com", 30, Gender.MALE),
                  new Contact("Bazlur", "bazlur@gmail.com", 45, Gender.MALE));



        contacts.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));

          for (Contact contact : contacts) {
              System.out.println(contact);
          }

    }
}
enum Gender {
    MALE ,
    FEMALE,
    OTHER;
}
class Contact implements Comparator<Contact> {
    private String name;
    private String email;
    private int age;
    private Gender gender ;

    public Contact(String name, String email, int age, Gender gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareTo(o2.getName());
    }
}