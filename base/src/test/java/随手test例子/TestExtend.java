package 随手test例子;

public class TestExtend {
}
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name = name;
    }
    public void play() {
        //接口中创建的接口变量实际上是public static final Ball ball....
        //ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}
