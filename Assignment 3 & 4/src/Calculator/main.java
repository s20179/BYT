package Calculator;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter equation to be calculated");
        String equation = scanner.nextLine();
        scanner.close();
        Request request = Parser.parser(equation);
        if (request != null){
            Handler handlerAddition = new Addition();
            Handler handlerDivision = new Division();
            Handler handlerMultiply = new Multiply();
            Handler handlerSubtraction = new Subtraction();
            handlerAddition.setHandler(handlerDivision);
            handlerDivision.setHandler(handlerMultiply);
            handlerMultiply.setHandler(handlerSubtraction);
            handlerAddition.calculate(request);
            System.out.println("= " + request.getResponse().getResponse());
        }
    }
}
