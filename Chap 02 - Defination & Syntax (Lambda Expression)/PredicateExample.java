package learn_alamin_functional_interface;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static Predicate<Integer> predicate = (yearsOfExperience) -> yearsOfExperience >= 4 ;

    public static void main(String[] args) {
        List<Integer> yearsOfExperienceList = List.of(2, 5, 4, 7, 6, 9);
        System.out.println("Applicants with yearsOfExperience: ");
        for (Integer yearsOfExperience : yearsOfExperienceList) {
            if (predicate.test(yearsOfExperience)) {
                System.out.println("Year Of Experience: " + yearsOfExperience);
            }
        }
    }
}
