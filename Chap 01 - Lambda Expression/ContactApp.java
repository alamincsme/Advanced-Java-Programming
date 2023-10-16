package learn.alamin;

import java.util.ArrayList;
import java.util.List;

public class ContactApp {

    public static void main(String[] args) {

        List<Contact> contactList = List.of( new Contact("Mohammad Alamin", "alamin@gmail.com", 24, Gender.MALE),
                new Contact("Matte", "matt@gmail.com", 50, Gender.MALE),
                new Contact("Zerin","zerin@gmail.com", 20, Gender.FEMALE),
                new Contact("Sabit", "sabit@gmail.com", 19, Gender.MALE));


        ContactService contactService = new ContactService();
        FilterCriteria filterCriteria = (Contact contact) -> contact.getAge() >= 18 && contact.getAge() <= 20;
        List<Contact> contactAged18to20 = contactService.findContactAgeBetwwen18And20(contactList, filterCriteria);

        System.out.println(contactAged18to20);
//        output:
//        [Contact{name='Zerin', email='zerin@gmail.com', age=20, gender=FEMALE}, Contact{name='Sabit', email='sabit@gmail.com', age=19, gender=MALE}
    }


}

interface FilterCriteria {
    public boolean match (Contact contact) ;
}

class ContactService {
    public List<Contact> findContactAgeBetwwen18And20(List<Contact> contacts, FilterCriteria filterCriteria) {
        List<Contact> matchContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (filterCriteria.match(contact)) {
                matchContacts.add(contact);
            }
        }
        return matchContacts;
    }
}

enum Gender {
    MALE,
    FEMALE,
    OTHER;
}
class Contact {
    private String name;
    private String email;
    private int age;
    private Gender gender;

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
}