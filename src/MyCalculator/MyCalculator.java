package MyCalculator;
import com.sun.codemodel.internal.fmt.JTextFile;

import javax.swing.*;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


public class MyCalculator extends JFrame {
    private JTextFile textField;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;

    public MyCalculator() {
        super("Test ContentPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();
        JTextField textField = new JTextField(18);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        contents.add(textField);

        JButton addition = new JButton("+");
        contents.add(addition);

        contents.add(new JButton("-"));
        contents.add(new JButton("*"));
        contents.add(new JButton("/"));
        contents.add(new JButton("!"));
        contents.add(new JButton("="));

        setContentPane(contents);
        setSize(260, 130);
        setVisible(true);

        ActionListener textFieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println();
            }
        };
        ActionListener additionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addition.getText());
            }
        };

        addition.addActionListener(additionListener);
        textField.addActionListener(textFieldListener);

        // todo магия
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new MyDocumentFilter());
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
