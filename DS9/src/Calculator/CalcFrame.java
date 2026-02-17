package Calculator;
import javax.swing.*;

public class CalcFrame extends JFrame {
    private JTextField txt_operand1 = new JFormattedTextField();
    private JLabel lbl_operation = new JLabel();
    private JLabel lbl_operand2 = new JLabel();

    private JButton btn_one = new JButton("1");
    private JButton btn_two = new JButton("2");
    private JButton btn_three = new JButton("3");
    private JButton btn_four = new JButton("4");
    private JButton btn_five = new JButton("5");
    private JButton btn_six = new JButton("6");
    private JButton btn_seven = new JButton("7");
    private JButton btn_eight = new JButton("8");
    private JButton btn_nine = new JButton("9");
    private JButton btn_zero = new JButton("0");
    private JButton btn_minus = new JButton("-");
    private JButton btn_divide = new JButton("/");
    private JButton btn_multiply = new JButton("*");
    private JButton btn_negative = new JButton("-/+");
    private JButton btn_clear = new JButton("C");
    private JButton btn_decimal = new JButton(".");

    private JButton btn_plus = new JButton("+");
    private JButton btn_equal = new JButton("=");


    public CalcFrame(){
        super("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lbl_operand2.setBounds(20, 20, 210, 20);
        add(lbl_operand2);

        lbl_operation.setBounds(210, 40, 20, 20);
        add(lbl_operation);

        txt_operand1.setBounds(20, 60, 210, 30);
        txt_operand1.setEditable(false);
        add(txt_operand1);

        btn_one.setBounds(20, 100, 45, 45);
        add(btn_one);
        btn_one.addActionListener(e -> oneClicked());

        btn_two.setBounds(75, 100, 45, 45);
        add(btn_two);
        btn_two.addActionListener(e -> twoClicked());



        btn_three.setBounds(20, 153, 45, 45);
        add(btn_three);
        btn_three.addActionListener(e -> threeClicked());

        btn_four.setBounds(75, 153, 45, 45);
        add(btn_four);
        btn_four.addActionListener(e -> fourClicked());

        btn_five.setBounds(130, 153, 45, 45);
        add(btn_five);
        btn_five.addActionListener(e -> fiveClicked());

        btn_six.setBounds(185, 153, 45, 45);
        add(btn_six);
        btn_six.addActionListener(e -> sixClicked());

        btn_seven.setBounds(75, 100, 45, 45);
        add(btn_seven);
        btn_seven.addActionListener(e -> sevenClicked());

        btn_eight.setBounds(75, 100, 45, 45);
        add(btn_eight);
        btn_eight.addActionListener(e -> eightClicked());

        btn_nine.setBounds(75, 100, 45, 45);
        add(btn_nine);
        btn_nine.addActionListener(e -> nineClicked());

        btn_zero.setBounds(75, 100, 45, 45);
        add(btn_zero);
        btn_zero.addActionListener(e -> zeroClicked());

        btn_plus.setBounds(130, 100, 45, 45);
        add(btn_plus);
        btn_plus.addActionListener(e -> plusClicked());

        btn_equal.setBounds(185, 100, 45, 45);
        add(btn_equal);
        btn_equal.addActionListener(e -> equalClicked());

        setVisible(true);
    }

    public void oneClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "1");
    }
    public void twoClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "2");
    }
    public void threeClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "3");
    }
    public void fourClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "4");
    }
    public void fiveClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "5");
    }
    public void sixClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "6");
    }
    public void sevenClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "7");
    }
    public void eightClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "8");
    }
    public void nineClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "9");
    }

    public void zeroClicked(){
        txt_operand1.setText(txt_operand1.getText()+ "0");
    }

    public void plusClicked(){
        if(!lbl_operand2.getText().equals("") && !txt_operand1.getText().equals("")){
            double v1 = Double.parseDouble(txt_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            lbl_operand2.setText(""+(v1+v2));
            lbl_operation.setText("+");
            txt_operand1.setText("");
        } else if(!txt_operand1.getText().equals("")){
            lbl_operand2.setText(txt_operand1.getText());
            lbl_operation.setText("+");
            txt_operand1.setText("");
        }
    }
    public void equalClicked(){
        if(!lbl_operand2.getText().equals("") && !txt_operand1.getText().equals("")){
            double v1 = Double.parseDouble(txt_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            txt_operand1.setText(""+(v1+v2));
            lbl_operation.setText("");
            lbl_operand2.setText("");
        }
    }

}
