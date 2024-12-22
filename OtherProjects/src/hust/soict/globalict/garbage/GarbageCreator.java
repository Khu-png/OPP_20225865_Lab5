package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Đặt tên tệp
        byte[] inputBytes = {}; // Khởi tạo mảng byte trống
        long startTime, endTime;

        try {
            // Đọc tất cả bytes từ tệp
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis(); // Ghi lại thời gian bắt đầu
            String outputString = ""; // Khởi tạo chuỗi kết quả

            // Duyệt qua tất cả các byte và chuyển đổi chúng thành ký tự
            for (byte b : inputBytes) {
                outputString += (char) b; // Dồn chuỗi
            }

            endTime = System.currentTimeMillis(); // Ghi lại thời gian kết thúc
            System.out.println((endTime - startTime)); // In thời gian thực hiện
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý ngoại lệ khi không thể đọc tệp
        }
    }
}

