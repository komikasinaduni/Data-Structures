package Calculator;

import javax.swing.*;

public class CalcFrame extends JFrame {
    private JTextField txt_operand1 = new JFormattedTextField();
    private JLabel lbl_operation = new JLabel();
    private JLabel lbl_operand2 = new JLabel();
    public CalcFrame(){
        super("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        lbl_operand2.setBounds(20, 20, 200, 20);
        add(lbl_operand2);
        lbl_operation.setBounds(200, 40, 20, 20);
        setVisible(true);
    }
}
