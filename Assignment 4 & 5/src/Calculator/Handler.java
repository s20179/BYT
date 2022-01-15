package Calculator;

public interface Handler {

    void setHandler(Handler handler);
    void calculate(Request request);

}
