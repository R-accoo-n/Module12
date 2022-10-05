import classes.Operator;

public class Dispatcher {
    public static void main(String[] args) throws InterruptedException {
        Operator o = new Operator();
        o.task1();
        o.task2(16);
    }
}
