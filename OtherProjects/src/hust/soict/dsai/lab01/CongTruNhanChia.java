import javax.swing.JOptionPane;

public class CongTruNhanChia {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double Tong, Hieu, Tich, Thuong;

        // Nhập số thứ nhất
        strNum1 = JOptionPane.showInputDialog(null, "Điền vào số thứ nhất: ", "Nhập số",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        // Nhập số thứ hai
        strNum2 = JOptionPane.showInputDialog(null, "Điền vào số thứ hai: ", "Nhập số",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        // Tính toán
        Tong = num1 + num2;
        Hieu = num1 - num2;
        Tich = num1 * num2;

        // Kiểm tra chia cho 0
        if (num2 != 0) {
            Thuong = num1 / num2;
        } else {
            Thuong = Double.NaN; // Chia cho 0, sử dụng NaN (Not a Number)
            JOptionPane.showMessageDialog(null, "Không thể chia cho 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        // Hiển thị kết quả
        JOptionPane.showMessageDialog(null, "Tổng là: " + Tong, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Hiệu là: " + Hieu, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Tích là: " + Tich, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Thương là: " + (num2 != 0 ? Thuong : "Không xác định (chia cho 0)"),
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);

        // Thoát chương trình
        System.exit(0);
    }
}
