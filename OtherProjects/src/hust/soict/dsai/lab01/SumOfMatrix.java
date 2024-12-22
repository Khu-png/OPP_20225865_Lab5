import javax.swing.JOptionPane;

public class SumOfMatrix {

    public static void main(String[] args) {
        // Nhập kích thước của ma trận
        boolean validInput = false;
        int rows = 0, cols = 0;
        while (!validInput) {
            // Nhập số dòng
            String rowInput = JOptionPane.showInputDialog(null, "Nhập số dòng của ma trận:", "Nhập số dòng",
                    JOptionPane.QUESTION_MESSAGE);

            // Kiểm tra nếu người dùng nhấn "Cancel"
            if (rowInput == null) {
                JOptionPane.showMessageDialog(null, "Bạn đã hủy nhập liệu.", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            // Nhập số cột
            String colInput = JOptionPane.showInputDialog(null, "Nhập số cột của ma trận:", "Nhập số cột",
                    JOptionPane.QUESTION_MESSAGE);

            // Kiểm tra nếu người dùng nhấn "Cancel"
            if (colInput == null) {
                JOptionPane.showMessageDialog(null, "Bạn đã hủy nhập liệu.", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            try {
                // Chuyển đổi sang số nguyên
                rows = Integer.parseInt(rowInput.trim());
                cols = Integer.parseInt(colInput.trim());

                // Kiểm tra xem số dòng và cột có hợp lệ hay không
                if (rows <= 0 || cols <= 0) {
                    JOptionPane.showMessageDialog(null, "Số dòng và cột phải lớn hơn 0.", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                    continue; // Quay lại vòng lặp để yêu cầu nhập lại
                }

                validInput = true; // Đầu vào hợp lệ
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên cho dòng và cột.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Khởi tạo hai ma trận
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        // Nhập các phần tử cho ma trận đầu tiên
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String elementInput = JOptionPane.showInputDialog(null,
                        "Nhập phần tử [" + (i + 1) + "][" + (j + 1) + "] của ma trận 1:", "Nhập phần tử",
                        JOptionPane.QUESTION_MESSAGE);
                matrix1[i][j] = Integer.parseInt(elementInput);
            }
        }

        // Nhập các phần tử cho ma trận thứ hai
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String elementInput = JOptionPane.showInputDialog(null,
                        "Nhập phần tử [" + (i + 1) + "][" + (j + 1) + "] của ma trận 2:", "Nhập phần tử",
                        JOptionPane.QUESTION_MESSAGE);
                matrix2[i][j] = Integer.parseInt(elementInput);
            }
        }

        // Tính tổng của hai ma trận
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Tạo chuỗi hiển thị cho kết quả
        StringBuilder result = new StringBuilder("Tổng của hai ma trận:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.append(sumMatrix[i][j]).append("\t");
            }
            result.append("\n");
        }

        // Hiển thị kết quả
        JOptionPane.showMessageDialog(null, result.toString(), "Kết quả", JOptionPane.INFORMATION_MESSAGE);

        // Thoát chương trình
        System.exit(0);
    }
}
