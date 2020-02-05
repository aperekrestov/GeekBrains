package MyCalculator;
import com.sun.codemodel.internal.fmt.JTextFile;

import javax.swing.*;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


public class MyCalculator extends JFrame {
    private JTextFile textField;
    private String doing = "+";

    private JButton addition = new JButton("+");
    private JButton subtraction = new JButton("-");
    private JButton multiplication = new JButton("*");
    private JButton division = new JButton("/");
    private JButton factorial = new JButton("!");

    private JButton result = new JButton("=");
    private JButton clean = new JButton(("C"));

    private int firstArg;
    private int secondArg;

    public MyCalculator() {
        super("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();
        JTextField textField = new JTextField(18);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        contents.add(textField);

        contents.add(addition);
        contents.add(subtraction);
        contents.add(multiplication);
        contents.add(division);
        contents.add(factorial);
        contents.add(clean);
        contents.add(result);

        setContentPane(contents);
        setSize(260, 170);
        setVisible(true);

        KeyListener textFieldKeyListener = new KeyListener() {
            String s = "";

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 49 || e.getKeyCode() == 50 || e.getKeyCode() == 51 || e.getKeyCode() == 52
                        || e.getKeyCode() == 53 || e.getKeyCode() == 54 || e.getKeyCode() == 55 || e.getKeyCode() == 56
                        || e.getKeyCode() == 57 || e.getKeyCode() == 48) {

                } else {
                    s = textField.getText();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 49 || e.getKeyCode() == 50 || e.getKeyCode() == 51 || e.getKeyCode() == 52
                        || e.getKeyCode() == 53 || e.getKeyCode() == 54 || e.getKeyCode() == 55 || e.getKeyCode() == 56
                        || e.getKeyCode() == 57 || e.getKeyCode() == 48) {

                } else {
                    textField.setText(s + "");
                }
            }
        };
        ActionListener textFieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String localResult = "";

                try {
                    Integer.parseInt(textField.getText());
                    secondArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    secondArg = 0;
                }

                switch (doing) {
                    case "+":
                        localResult = "" + (firstArg + secondArg);
                        break;
                    case "-":
                        localResult = "" + (firstArg - secondArg);
                        break;
                    case "*":
                        localResult = "" + (firstArg * secondArg);
                        break;
                    case "/":
                        if(secondArg != 0) {
                            localResult = "" + (firstArg / secondArg);
                        } else {
                            localResult = "error int";
                        }
                        break;
                }
                textField.setText(localResult);
                textField.requestFocus();
                firstArg = 0;
                secondArg = 0;
            }
        };
        ActionListener cleanListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstArg = 0;
                secondArg = 0;
                textField.setText("");
                textField.requestFocus();
            }
        };
        ActionListener resultListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String localResult = "";

                try {
                    Integer.parseInt(textField.getText());
                    secondArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    secondArg = 0;
                }

                switch (doing) {
                    case "+":
                        localResult = "" + (firstArg + secondArg);
                        break;
                    case "-":
                        localResult = "" + (firstArg - secondArg);
                        break;
                    case "*":
                        localResult = "" + (firstArg * secondArg);
                        break;
                    case "/":
                        if(secondArg != 0) {
                            localResult = "" + (firstArg / secondArg);
                        } else {
                            localResult = "error int";
                        }
                        break;
                }
                textField.setText(localResult);
                textField.requestFocus();
                firstArg = 0;
                secondArg = 0;
            }
        };

        ActionListener additionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    firstArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    firstArg = 0;
                }
                textField.setText("");
                textField.requestFocus();
                doing = addition.getText();
            }
        };
        ActionListener subtractionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    firstArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    firstArg = 0;
                }
                textField.setText("");
                textField.requestFocus();
                doing = subtraction.getText();
                System.out.println(doing);
            }
        };
        ActionListener multiplicationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    firstArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    firstArg = 0;
                }
                textField.setText("");
                textField.requestFocus();
                doing = multiplication.getText();
            }
        };
        ActionListener divisionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    firstArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    firstArg = 0;
                }
                textField.setText("");
                textField.requestFocus();
                doing = division.getText();
            }
        };
        ActionListener factorialListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(textField.getText());
                    firstArg = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    firstArg = 0;
                }

                int f = firstArg;
                for (int i = 1; i < firstArg; i++) {
                    f = f * i;
                    System.out.println(f);
                }
                textField.setText("" + f);
            }
        };

        addition.addActionListener(additionListener);
        subtraction.addActionListener(subtractionListener);
        multiplication.addActionListener(multiplicationListener);
        division.addActionListener(divisionListener);
        factorial.addActionListener(factorialListener);

        clean.addActionListener(cleanListener);
        result.addActionListener(resultListener);
        textField.addActionListener(textFieldListener);
        textField.addKeyListener(textFieldKeyListener);

        // todo магия
//        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new MyDocumentFilter());
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new MyCalculator();
    }

    class MyDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            string = string.replaceAll("[13579]", "");
            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            text = text.replaceAll("[13579]", "");
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
