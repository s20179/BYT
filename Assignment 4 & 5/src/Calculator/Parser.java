package Calculator;

public class Parser {

    static Request parser(String equation){
        Request request = null;
        try{
            String[] split = equation.split(" ");
            char operator = split[1].charAt(0);
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[2]);
            request = new Request(first,second,operator);
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Insert space between characters");
        }catch (NumberFormatException exception){
            System.out.println("Only numbers accepted");
        }
        return request;
    }
}
