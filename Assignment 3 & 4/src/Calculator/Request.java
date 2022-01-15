package Calculator;

public class Request {

    private int num1;
    private int num2;
    private char operator;
    private Response response = null;

    public Request(int num1, int num2, char operator){
        super();
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public char getOperator() {
        return operator;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
