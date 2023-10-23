package 算法;

public class Solution3 {
    public static void main(String[] args) {
        char[] message = {'w', 'h', 'e', 'r', 'e', ' ', 'a', 'r', 'e', ' ', 'y', 'o', 'u', 'r', ' ', 'b', 'i', 'r',
                'd'};

        reverse(message);

        System.out.println(message);
    }

    public static void reverse(char[] message) {
        int start = 0;
        int end = message.length - 1;

        while (start < end) {
            char temp = message[start];
            message[start] = message[end];
            message[end] = temp;

            start++;
            end--;
        }
    }
}
