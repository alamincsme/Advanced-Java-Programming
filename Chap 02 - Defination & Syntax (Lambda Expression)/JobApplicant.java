package learn_alamin_functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class JobApplicant {
    private String name;
    private int yearsOfExperience;
    private boolean knowJava;

    public JobApplicant(String name, int yearsOfExperience, boolean knowJava) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.knowJava = knowJava;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public boolean isKnowJava() {
        return knowJava;
    }

}


class Main {
    public static BiPredicate<Integer, Boolean > applicantFilter = (yearsOfExperience , knowJava) -> yearsOfExperience >= 4 && knowJava;

    public static void main(String[] args) {
        List<JobApplicant> applicants = Arrays.asList(new JobApplicant("Alamin", 4, true),
                                         new JobApplicant("Mohammad", 3, true),
                                         new JobApplicant("Abu siam", 2, true),
                                         new JobApplicant("Sabi Al Hassan", 1, false));

        System.out.println("Qualified Applicants: ");

        for (JobApplicant applicant : applicants) {
            if (applicantFilter.test(applicant.getYearsOfExperience(), applicant.isKnowJava())) {
                System.out.println("Name: " + applicant.getName()+
                        ", Years Of Experience: " + applicant.getYearsOfExperience() +
                        ", Knows Java:  ");
            }
        }
    }
}
