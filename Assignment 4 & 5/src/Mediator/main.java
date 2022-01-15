package Mediator;

public class main {

    public static void main(String[] args) {
        Students student_1 = new Students("John","England");
        Students student_2 = new Students("Erica", "Canada");
        Students student_3 = new Students("Paula", "Mexico");

        student_3.introduce("Nice to meet you all");
        student_1.introduce("Hi Paula, nice to meet you!");
        student_2.introduce("Hi John and Paula, nice to meet you!");

    }
}
