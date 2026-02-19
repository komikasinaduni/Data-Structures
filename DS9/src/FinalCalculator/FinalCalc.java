package FinalCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FinalCalc extends JFrame{
    private JLabel lbl_numTerms = new JLabel("Number of terms:");
    private JComboBox<Integer> cnb_numTerms;
    private JTextField txt_term1 = new JTextField();
    private JTextField txt_term2 = new JTextField();
    private JTextField txt_term3 = new JTextField();
    private JTextField txt_term4 = new JTextField();
    private JTextField txt_term5 = new JTextField();
    private JLabel lbl_term1 = new JLabel("Term 1 Grade:");
    private JLabel lbl_term2 = new JLabel("Term 2 Grade:");
    private JLabel lbl_term3 = new JLabel("Term 3 Grade:");
    private JLabel lbl_term4 = new JLabel("Term 4 Grade:");
    private JLabel lbl_term5 = new JLabel("Term 5 Grade:");


    public FinalCalc(){
        super("Final Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 400);

        lbl_numTerms.setBounds(20, 30, 100, 30);
        add(lbl_numTerms);

        Integer[] numbers = {1, 2, 3, 4, 5};
        cnb_numTerms = new JComboBox<>(numbers);
        cnb_numTerms.setBounds(120, 30, 100, 30);
        cnb_numTerms.addActionListener(e-> changeTerms());
        add(cnb_numTerms);

        lbl_term1.setBounds(20, 70, 100, 30);
        add(lbl_term1);
        txt_term1.setBounds(120, 70, 100, 30);
        add(txt_term1);

        lbl_term2.setBounds(20, 110, 100, 30);
        add(lbl_term2);
        txt_term2.setBounds(120, 110, 100, 30);
        add(txt_term2);

        lbl_term3.setBounds(20, 150, 100, 30);
        add(lbl_term3);
        txt_term3.setBounds(120, 150, 100, 30);
        add(txt_term3);

        lbl_term4.setBounds(20, 190, 100, 30);
        add(lbl_term4);
        txt_term4.setBounds(120, 190, 100, 30);
        add(txt_term4);

        lbl_term5.setBounds(20, 110, 100, 30);
        add(lbl_term5);
        txt_term5.setBounds(120, 110, 100, 30);
        add(txt_term5);

        lbl_term2.setEnabled(false);
        txt_term2.setEnabled(false);
        txt_term2.setText("");

        lbl_term3.setEnabled(false);
        txt_term3.setEnabled(false);
        txt_term3.setText("");

        lbl_term4.setEnabled(false);
        txt_term4.setEnabled(false);
        txt_term4.setText("");

        lbl_term5.setEnabled(false);
        txt_term5.setEnabled(false);
        txt_term5.setText("");


        setVisible(true);
    }

    public void changeTerms(){
        if(((Integer) cnb_numTerms.getSelectedItem())==1){
            txt_term2.setText("");
            txt_term2.setEnabled(false);
            lbl_term2.setEnabled(false);
        } else{
            txt_term2.setEnabled(true);
            lbl_term2.setEnabled(true);
        }
        if(((Integer) cnb_numTerms.getSelectedItem())==2){
            txt_term3.setText("");
            txt_term3.setEnabled(false);
            lbl_term3.setEnabled(false);
        } else{
            txt_term3.setEnabled(true);
            lbl_term3.setEnabled(true);
        }
        if(((Integer) cnb_numTerms.getSelectedItem())==3){
            txt_term4.setText("");
            txt_term4.setEnabled(false);
            lbl_term4.setEnabled(false);
        } else{
            txt_term4.setEnabled(true);
            lbl_term4.setEnabled(true);
        }
        if(((Integer) cnb_numTerms.getSelectedItem())==4){
            txt_term5.setText("");
            txt_term5.setEnabled(false);
            lbl_term5.setEnabled(false);
        } else{
            txt_term5.setEnabled(true);
            lbl_term5.setEnabled(true);
        }

    }
}
