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
    private JTextField txt_termweight = new JTextField();
    private JTextField txt_finalweight = new JTextField();
    private JTextField txt_gradewanted = new JTextField();
    private JLabel lbl_term1 = new JLabel("Term 1 Grade:");
    private JLabel lbl_term2 = new JLabel("Term 2 Grade:");
    private JLabel lbl_term3 = new JLabel("Term 3 Grade:");
    private JLabel lbl_term4 = new JLabel("Term 4 Grade:");
    private JLabel lbl_term5 = new JLabel("Term 5 Grade:");
    private JLabel lbl_termweight = new JLabel("Total Term Weight:");
    private JLabel lbl_finalweight = new JLabel("Final Weight:");
    private JLabel lbl_gradewanted = new JLabel("Grade Wanted:");
    private JButton calculate = new JButton("Calculate");
    private JButton clear = new JButton("Clear");
    private JLabel gradeRequiredOnFinal = new JLabel("Calculate Grade Required on Final");
    private  JLabel getGradeRequiredOnFinal = new JLabel();

    public FinalCalc(){
        super("Final Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 450);

        lbl_termweight.setBounds(20, 30, 140, 30);
        add(lbl_termweight);
        txt_termweight.setBounds(145, 30, 140, 30);
        txt_termweight.setText(85+"");
        add(txt_termweight);


        lbl_finalweight.setBounds(20, 60, 140, 30);
        add(lbl_finalweight);
        txt_finalweight.setBounds(145, 60, 140, 30);
        txt_finalweight.setText(""+15);
        add(txt_finalweight);

        lbl_numTerms.setBounds(20, 90, 140, 30);
        add(lbl_numTerms);

        Integer[] numbers = {(Integer) 1, (Integer) 2, (Integer) 3, (Integer) 4, (Integer) 5};
        cnb_numTerms = new JComboBox<>(numbers);
        cnb_numTerms.setBounds(145, 90, 140, 30);
        cnb_numTerms.addActionListener(e-> changeTerms());
        add(cnb_numTerms);

        lbl_gradewanted.setBounds(20, 120, 140, 30);
        add(lbl_gradewanted);
        txt_gradewanted.setBounds(145, 120, 140, 30);
        txt_gradewanted.setText(""+90);
        add(txt_gradewanted);

        lbl_term1.setBounds(20, 160, 140, 30);
        add(lbl_term1);
        txt_term1.setBounds(145, 160, 140, 30);
        add(txt_term1);

        lbl_term2.setBounds(20, 190, 140, 30);
        add(lbl_term2);
        txt_term2.setBounds(145, 190, 140, 30);
        add(txt_term2);

        lbl_term3.setBounds(20, 220, 140, 30);
        add(lbl_term3);
        txt_term3.setBounds(145, 220, 140, 30);
        add(txt_term3);

        lbl_term4.setBounds(20, 250, 140, 30);
        add(lbl_term4);
        txt_term4.setBounds(145, 250, 140, 30);
        add(txt_term4);

        lbl_term5.setBounds(20, 280, 140, 30);
        add(lbl_term5);
        txt_term5.setBounds(145, 280, 140, 30);
        add(txt_term5);

        gradeRequiredOnFinal.setBounds(40, 380, 400, 20);
        add(gradeRequiredOnFinal);

        getGradeRequiredOnFinal.setBounds(40, 400, 400, 500);
        add(getGradeRequiredOnFinal);

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

        calculate.setBounds(10, 320, 270, 30);
        add(calculate);
        calculate.addActionListener(e -> calculateClicked());

        clear.setBounds(10, 350, 270, 30);
        add(clear);
        clear.addActionListener(e -> clearClicked());

        setVisible(true);
    }

    public void changeTerms(){
        Integer selected = (Integer) cnb_numTerms.getSelectedItem();
        if(selected<2){
            txt_term2.setText("");
            txt_term2.setEnabled(false);
            lbl_term2.setEnabled(false);
        } else{
            txt_term2.setEnabled(true);
            lbl_term2.setEnabled(true);
        }
        if(selected<3){
            txt_term3.setText("");
            txt_term3.setEnabled(false);
            lbl_term3.setEnabled(false);
        } else{
            txt_term3.setEnabled(true);
            lbl_term3.setEnabled(true);
        }
        if(selected<4){
            txt_term4.setText("");
            txt_term4.setEnabled(false);
            lbl_term4.setEnabled(false);
        } else{
            txt_term4.setEnabled(true);
            lbl_term4.setEnabled(true);
        }
        if(selected<5){
            txt_term5.setText("");
            txt_term5.setEnabled(false);
            lbl_term5.setEnabled(false);
        } else{
            txt_term5.setEnabled(true);
            lbl_term5.setEnabled(true);
        }
    }

    public void calculateClicked(){
        int selected = (Integer) cnb_numTerms.getSelectedItem();
        String termWeightText = txt_termweight.getText();
        String finalWeightText = txt_finalweight.getText();
        String gradeWantedText = txt_gradewanted.getText();
        if(termWeightText.equals("") || finalWeightText.equals("") || gradeWantedText.equals("")){
            getGradeRequiredOnFinal.setText("Invalid input.");
            return;
        }
        String[] fields = {termWeightText, finalWeightText, gradeWantedText};
        for(int i = 0; i < fields.length; i++){
            int decimalCount = 0;
            for(int j = 0; j < fields[i].length(); j++){
                char c = fields[i].charAt(j);
                if(c == '.'){
                    decimalCount++;
                    if(decimalCount > 1){
                        getGradeRequiredOnFinal.setText("Invalid input.");
                        return;
                    }
                }
                else if(c == '-'){
                    if(j != 0){
                        getGradeRequiredOnFinal.setText("Invalid input.");
                        return;
                    }
                }
                else if(!Character.isDigit(c)){
                    getGradeRequiredOnFinal.setText("Invalid input.");
                    return;
                }
            }
        }
        JTextField[] terms = {txt_term1, txt_term2, txt_term3, txt_term4, txt_term5};
        for(int i = 0; i < selected; i++){
            String text = terms[i].getText();
            if(text.equals("")){
                getGradeRequiredOnFinal.setText("Invalid input.");
                return;
            }
            int decimalCount = 0;
            for(int j = 0; j < text.length(); j++){
                char c = text.charAt(j);

                if(c == '.'){
                    decimalCount++;
                    if(decimalCount > 1){
                        getGradeRequiredOnFinal.setText("Invalid input.");
                        return;
                    }
                }
                else if(c == '-'){
                    if(j != 0){
                        getGradeRequiredOnFinal.setText("Invalid input.");
                        return;
                    }
                }
                else if(!Character.isDigit(c)){
                    getGradeRequiredOnFinal.setText("Invalid input.");
                    return;
                }
            }
        }
        double termWeight = Double.parseDouble(termWeightText);
        double finalWeight = Double.parseDouble(finalWeightText);
        double gradeWanted = Double.parseDouble(gradeWantedText);
        double sum = 0;
        if(selected >= 1) sum += Double.parseDouble(txt_term1.getText());
        if(selected >= 2) sum += Double.parseDouble(txt_term2.getText());
        if(selected >= 3) sum += Double.parseDouble(txt_term3.getText());
        if(selected >= 4) sum += Double.parseDouble(txt_term4.getText());
        if(selected >= 5) sum += Double.parseDouble(txt_term5.getText());
        double currentAverage = sum / selected;
        double requiredFinal = (gradeWanted * 100 - currentAverage * termWeight)/finalWeight;
        getGradeRequiredOnFinal.setText(String.format("You need %.2f on the final.", requiredFinal));
    }

    public void clearClicked(){
        txt_term1.setText("");
        txt_term2.setText("");
        txt_term3.setText("");
        txt_term4.setText("");
        txt_term5.setText("");
        txt_gradewanted.setText("");
        cnb_numTerms.setSelectedIndex(0);
        changeTerms();
    }
}
