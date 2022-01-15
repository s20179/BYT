package Calculator;

public class Addition implements Handler {
    private Handler handler;

    @Override
    public void setHandler(Handler nextHandler){
        handler = nextHandler;
    }

    @Override
    public void calculate(Request request){
        if (request.getOperator() == '+'){
            Response response = new Response(request.getNum1() + request.getNum2());
            request.setResponse(response);
        }else {
            handler.calculate(request);
        }
    }
}
