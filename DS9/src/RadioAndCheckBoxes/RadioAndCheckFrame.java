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
    private JComboBox<Integer> cmb_grade;

    private JLabel lbl_nameFormat = new JLabel("Name Format:");
    private JRadioButton rad_lastFirst = new JRadioButton("Last, First");
    private JRadioButton rad_firstLast = new JRadioButton("First, Last");

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

    }

}
