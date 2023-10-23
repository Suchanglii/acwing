package 随手test例子;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SocketClient {
    private final static String HOST = "192.168.3.143";
    private final static int PORT = 9999;
    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);//发起服务器的链接

        //读取
        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String msg = reader.readLine();
                    System.out.println(FORMAT.format(new Date()) + ":" + msg);
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("与服务器断开链接，请联系管理员");
            }
        }).start();


        //写
        new Thread(() -> {
            try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String msg = scanner.nextLine();
                    writer.println(msg);
                    writer.flush();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}
