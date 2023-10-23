package 随手test例子;

public class Test13 {
    public static void main(String[] args) {
        Door door = new AlarmDoor();
        door.get();
    }
}

abstract class Door {
    public static void get() {
        System.out.print("随手test例子.Door");
    }
}

class AlarmDoor extends Door {
    public static void get() {
        System.out.print("随手test例子.AlarmDoor");
    }

}
