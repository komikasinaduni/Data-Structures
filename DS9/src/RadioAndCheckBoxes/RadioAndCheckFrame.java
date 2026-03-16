package RadioAndCheckBoxes;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RadioAndCheckFrame extends JFrame{
    private JLabel lbl_firstName = new JLabel("First Name:");
    private JTextField txt_firstName = new JTextField();

    private JLabel lbl_lastName = new JLabel("Last Name:");
    private JTextField txt_lastName = new JTextField();

    private JLabel lbl_id = new JLabel("ID:");
    private JTextField txt_id = new JTextField();

    private JLabel lbl_grade = new JLabel("Grade:");
    private JComboBox<Integer> cmb_grade = new JComboBox<>();

    private JLabel lbl_nameFormat = new JLabel("Name Format:");
    private JRadioButton rad_lastFirst = new JRadioButton("Last, First");
    private JRadioButton rad_firstLast = new JRadioButton("First, Last");
    private ButtonGroup btnGrp_format = new ButtonGroup();

    private JLabel lbl_include = new JLabel("Include:");
    private JCheckBox ck_grade = new JCheckBox("Grade");
    private JCheckBox ck_id = new JCheckBox("ID");

    private JButton btn_generateID = new JButton("Generate");

    private JLabel lbl_studentInfo = new JLabel("Student Information:");

    public RadioAndCheckFrame(){
        super("Radio & Checkbox Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 400);

        lbl_firstName.setBounds(20, 10, 100, 20);
        add(lbl_firstName);
        txt_firstName.setBounds(120, 10, 100, 20);
        add(txt_firstName);

        lbl_lastName.setBounds(20, 35, 100, 20);
        add(lbl_lastName);
        txt_lastName.setBounds(120, 35, 100, 20);
        add(txt_lastName);

        lbl_id.setBounds(20, 60, 100, 20);
        add(lbl_id);
        txt_id.setBounds(120, 60, 100, 20);
        add(txt_id);

        lbl_grade.setBounds(20, 85, 100, 20);
        add(lbl_grade);
        Integer[] numbers = {9, 10, 11, 12};
        cmb_grade.setBounds(120, 85, 100, 20);
        add(cmb_grade);

        lbl_nameFormat.setBounds(20, 110, 200, 20);
        add(lbl_nameFormat);
        rad_lastFirst.setBounds(40, 135, 100, 20);
        add(rad_lastFirst);
        rad_firstLast.setBounds(40, 160, 100, 20);
        add(rad_firstLast);
        btnGrp_format.add(rad_lastFirst);
        btnGrp_format.add(rad_firstLast);
        rad_lastFirst.setSelected(true);
        rad_lastFirst.setActionCommand("LM");
        rad_firstLast.setActionCommand("FM");
        rad_lastFirst.addActionListener(e -> nameEvent(e));
        rad_firstLast.addActionListener(e -> nameEvent(e));

        lbl_include.setBounds(20, 185, 200, 20);
        add(lbl_include);
        ck_grade.setBounds(40, 210, 100, 20);
        add(ck_grade);
        ck_id.setBounds(40, 235, 100, 20);
        add(ck_id);

        btn_generateID.setBounds(20, 260, 100, 20);
        add(btn_generateID);
        btn_generateID.addActionListener(e -> studentInfo());

        lbl_studentInfo.setBounds(20, 285, 300, 20);
        add(lbl_studentInfo);

        setVisible(true);

    }

    public void studentInfo(){
        String s = "";
        if(rad_lastFirst.isSelected())
            s+=txt_lastName.getText() + ", " + txt_firstName.getText();
        else
            s+=txt_firstName.getText() + " " + txt_lastName.getText();
        if(ck_id.isSelected())
            s+=":"+txt_id.getText();
        if(ck_grade.isSelected())
            s+="("+cmb_grade.getSelectedItem()+")";
        lbl_studentInfo.setText("Student Information: "+s);
    }

    public void nameEvent(ActionEvent e){
        System.out.println(e.getActionCommand());

    }

}
