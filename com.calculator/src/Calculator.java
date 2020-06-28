import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Calculator extends JPanel {
    //instance variables
    private static JTextField value1;
    private static JButton division;
    private static JButton multiply;
    private static JButton addition;
    private static JButton minus;
    private static JButton equals;
    private static JButton clear;
    private static JLabel resultLabel;
    private static JLabel img;

    static double num;
    static double ans;
    static int calculation;

    public Calculator() {
    }


    public static void arithmetic_operation() {
        switch (calculation) {
            case 1: //Addition
//                ans = num + Double.parseDouble(value1.getText());
                value1.setText(Double.toString(num += Double.parseDouble(value1.getText())));
                break;
            case 2: // Subtraction
//                ans = num - Double.parseDouble(value1.getText());
                value1.setText(Double.toString(num -= Double.parseDouble(value1.getText())));
                break;
            case 3: // Multiplication
                ans = num * Double.parseDouble(value1.getText());
                value1.setText(Double.toString(ans));
                break;
            case 4: // Division
                ans = num / Double.parseDouble(value1.getText());
                value1.setText(Double.toString(ans));
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedImage myImage;
        JFrame frame = new JFrame("Calculator");
        JPanel Calculator = new JPanel();

        try {

        Calculator.setLayout(null);

        resultLabel = new JLabel("");
        resultLabel.setForeground(Color.RED);
        resultLabel.setBounds(240, 5, 50, 25);
        resultLabel.setHorizontalAlignment(JLabel.RIGHT);
        Calculator.add(resultLabel);

        value1 = new JTextField();
        value1.setBounds(50, 20, 250, 50);
        value1.setHorizontalAlignment(JTextField.CENTER);
        Calculator.add(value1);

        addition = new JButton("+");
        addition.setForeground(Color.RED);
//        addition.setBorder(new RoundedBorder(70));
        addition.setBounds(50, 90, 50, 50);
        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(value1.getText());
                calculation = 1;
                value1.setText("");
                resultLabel.setText(num + "+");

            }
        });
        Calculator.add(addition);

        minus = new JButton("-");
        minus.setForeground(Color.RED);
//        addition.setBorder(new RoundedBorder(70));
        minus.setBounds(110, 90, 50, 50);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(value1.getText());
                calculation = 2;
                value1.setText("");
                resultLabel.setText(num + "-");
            }
        });
        Calculator.add(minus);

        multiply = new JButton("*");
        multiply.setForeground(Color.RED);
//        addition.setBorder(new RoundedBorder(70));
        multiply.setBounds(190, 90, 50, 50);
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(value1.getText());
                calculation = 3;
                value1.setText("");
                resultLabel.setText(num + "*");
            }
        });
        Calculator.add(multiply);

        division = new JButton("/");
        division.setForeground(Color.RED);
//        addition.setBorder(new RoundedBorder(70));
        division.setBounds(250, 90, 50, 50);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(value1.getText());
                calculation = 4;
                value1.setText("");
                resultLabel.setText(num + "/");
            }
        });
        Calculator.add(division);

        clear = new JButton("C");
        clear.setBounds(50, 160, 110, 50);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1.setText("");
            }
        });
        Calculator.add(clear);

        // Equals button
        equals = new JButton("=");
        equals.setBounds(190, 160, 110, 50);
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arithmetic_operation();
                resultLabel.setText("");
            }
        });
        Calculator.add(equals);

        myImage = ImageIO.read(Calculator.class.getResource("resources/images/A+A.jpeg"));
        img = new JLabel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(myImage, 0, 0, 350, 300, this);
            }
        };
        frame.setLocation(500, 250);
        frame.setSize(360, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(resultLabel);
        frame.add(value1);
        frame.add(addition);
        frame.add(division);
        frame.add(multiply);
        frame.add(minus);
        frame.add(clear);
        frame.add(equals);
        frame.add(img);

        frame.setVisible(true);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
