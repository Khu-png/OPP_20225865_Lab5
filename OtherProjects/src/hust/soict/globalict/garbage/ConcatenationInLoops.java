package hust.soict.globalict.garbage;
import java.util.Random;
public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Random
        Random r = new Random(123);

        // Sử dụng String để nối chuỗi
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println((System.currentTimeMillis() - start));

        // Sử dụng StringBuilder để nối chuỗi
        r = new Random(123); // Reset Random với cùng seed
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        System.out.println((System.currentTimeMillis() - start));
    }
}
