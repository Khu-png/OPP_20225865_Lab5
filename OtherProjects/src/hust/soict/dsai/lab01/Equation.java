import javax.swing.JOptionPane;
import java.lang.Math;

public class Equation {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6, strNum7, strNum8, strNum9, strNum10, strNum11;
        double c, d, d1, d2, x, y, value1, value2, value3;
        double delta;
        JOptionPane.showMessageDialog(null, "Please enter a and b in ax + b:");
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        c = -num2 / num1;
        JOptionPane.showMessageDialog(null, c, "The answer is ", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Please enter the following:");
        strNum3 = JOptionPane.showInputDialog(null, "Please input a11: ", JOptionPane.INFORMATION_MESSAGE);
        double num3 = Double.parseDouble(strNum3);
        strNum4 = JOptionPane.showInputDialog(null, "Please input a12: ", JOptionPane.INFORMATION_MESSAGE);
        double num4 = Double.parseDouble(strNum4);
        strNum5 = JOptionPane.showInputDialog(null, "Please input a21: ", JOptionPane.INFORMATION_MESSAGE);
        double num5 = Double.parseDouble(strNum5);
        strNum6 = JOptionPane.showInputDialog(null, "Please input a22: ", JOptionPane.INFORMATION_MESSAGE);
        double num6 = Double.parseDouble(strNum6);
        strNum7 = JOptionPane.showInputDialog(null, "Please input b1: ", JOptionPane.INFORMATION_MESSAGE);
        double num7 = Double.parseDouble(strNum7);
        strNum8 = JOptionPane.showInputDialog(null, "Please input b2: ", JOptionPane.INFORMATION_MESSAGE);
        double num8 = Double.parseDouble(strNum8);

        d = num3 * num4 - (num5 * num4);
        d1 = num7 * num6 - (num8 * num4);
        d2 = num3 * num8 - (num5 * num7);
        x = d1 / d;
        y = d2 / d;

        JOptionPane.showMessageDialog(null, x, "The x is ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, y, "The y is ", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Please enter the following:");
        strNum9 = JOptionPane.showInputDialog(null, "Please input a: ", JOptionPane.INFORMATION_MESSAGE);
        double num9 = Double.parseDouble(strNum9);
        strNum10 = JOptionPane.showInputDialog(null, "Please input b: ", JOptionPane.INFORMATION_MESSAGE);
        double num10 = Double.parseDouble(strNum10);
        strNum11 = JOptionPane.showInputDialog(null, "Please input c: ", JOptionPane.INFORMATION_MESSAGE);
        double num11 = Double.parseDouble(strNum11);

        delta = num10 * num10 - 4 * num9 * num11;
        if (delta > 0) {
            value1 = (-num10 + Math.sqrt(delta)) / 2 * num9;
            value2 = (-num10 - Math.sqrt(delta)) / 2 * num9;
            JOptionPane.showMessageDialog(null, value1, "The x is ", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, value2, "The y is ", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            value3 = -num10 / (2 * num9);
            JOptionPane.showMessageDialog(null, value3, "x = y is ", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta < 0) {
            JOptionPane.showMessageDialog(null, "No suitable x, y can be found");
        }

        System.exit(0);
    }
}