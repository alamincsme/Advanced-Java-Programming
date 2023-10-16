package learn.alamin;

public class AnonymousClass {
    public static void main(String[] args) {
        Human baby = new Human() {
            public void talk() {
                System.out.println("a - ga a - da");
            }
        };

        baby.talk();
    }
}
class Human {
    public void talk() {
        System.out.println("Hello world.");
    }
}
