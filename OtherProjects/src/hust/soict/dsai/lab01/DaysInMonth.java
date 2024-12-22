import javax.swing.JOptionPane;

public class DaysInMonth {

    // Kiểm tra xem có phải năm nhuận hay không
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        // Nếu năm đó chia hết cho bốn và không chia hết cho 100 mà chia hết cho 400
    }

    // Phương thức lấy số ngày trong tháng
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // Tháng 1
            case 3: // Tháng 3
            case 5: // Tháng 5
            case 7: // Tháng 7
            case 8: // Tháng 8
            case 10: // Tháng 10
            case 12: // Tháng 12
                return 31;
            case 4: // Tháng 4
            case 6: // Tháng 6
            case 9: // Tháng 9
            case 11: // Tháng 11
                return 30;
            case 2: // Tháng 2
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1; // Tháng không hợp lệ
        }
    }

    // Chuyển đổi các cách viết khác của tháng thành số nguyên

    public static int getMonthNumber(String monthInput) {
        monthInput = monthInput.toLowerCase().trim();
        switch (monthInput) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun.":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul.":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sep.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        int month = -1;
        int year = -1;

        // Vòng lặp để lấy giá trị tháng hợp lệ
        while (month == -1) {
            String monthInput = JOptionPane.showInputDialog(null,
                    "Vui lòng nhập tháng (tên, viết tắt hoặc số):", "Nhập tháng", JOptionPane.QUESTION_MESSAGE);

            if (monthInput == null) {
                System.exit(0);
            }

            month = getMonthNumber(monthInput);

            if (month == -1) {
                JOptionPane.showMessageDialog(null,
                        "Tháng không hợp lệ. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Vòng lặp để lấy giá trị năm hợp lệ
        while (year < 0) {
            String yearInput = JOptionPane.showInputDialog(null,
                    "Vui lòng nhập năm (ví dụ: 1999):", "Nhập năm", JOptionPane.QUESTION_MESSAGE);

            if (yearInput == null) {
                System.exit(0);
            }

            try {
                year = Integer.parseInt(yearInput);
                if (yearInput.length() != 4 || year < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Năm không hợp lệ. Vui lòng nhập một năm có 4 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    year = -1;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Không hợp lệ. Vui lòng nhập một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Tính số ngày trong tháng đã nhập
        int days = getDaysInMonth(month, year);

        // Hiển thị kết quả
        if (days != -1) {
            JOptionPane.showMessageDialog(null, "Tháng bạn nhập có " + days + " ngày.", "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tháng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        // Thoát chương trình
        System.exit(0);
    }
}
