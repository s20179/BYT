package Calculator;

public class Multiply implements Handler {

    private Handler nextHandler;

    @Override
    public void setHandler(Handler handler) {
        nextHandler = handler;
    }

    @Override
    public void calculate(Request request) {
        if (request.getOperator() == '*'){
            Response response = new Response(request.getNum1() * request.getNum2());
            request.setResponse(response);
        }else{
            nextHandler.calculate(request);
        }

    }
}
