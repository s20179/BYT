package Mediator;

public class ClassRoom {

    public static void introduce(Students students, String presentation){

        System.out.println("Hello, my name is " + students.getName() + " and I'm from " + students.getCountry() + ". " + presentation);
    }
}
