package JTable;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;

public class JTableDemo extends JFrame {
    private ArrayList<Person> people = new ArrayList<>();

    private JLabel lbl_people = new JLabel();
    private JTable tbl_people;
    private JScrollPane scr_people;
    private JButton btn_add = new JButton("Add Random");
    private JButton btn_delete = new JButton("Delete");

    private ArrayList<String> headings = new ArrayList<>();

    public JTableDemo() {
        super("JTable Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        headings.add("First Name");
        headings.add("Last Name");
        headings.add("Age");

        lbl_people.setBounds(20, 10, 200, 20);
        add(lbl_people);
        tbl_people = new JTable(new String[0][3], headings.toArray());
        scr_people = new JScrollPane(tbl_people);
        scr_people.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scr_people.setBounds(20, 35, 300, 250);
        add(scr_people);


        btn_add.setBounds(20, 310, 150, 20);
        add(btn_add);
        btn_add.addActionListener(e -> addRandomPerson());

        btn_delete.setBounds(20, 335, 150, 20);
        add(btn_delete);
        btn_delete.addActionListener(e -> delete());
        btn_delete.setEnabled(false);

        setVisible(true);
    }

    public void addRandomPerson()
    {
        people.add(new Person(randomText(), randomText(), randomAge()));
        updateTable();
        btn_delete.setEnabled(false);
    }

    public void delete()
    {
        if(tbl_people.getSelectedRow() != -1)
            people.remove(tbl_people.getSelectedRow());
        updateTable();
        btn_delete.setEnabled(false);
    }

    public void updateTable()
    {
        String[][] data = new String[people.size()][3];
        int row=0;
        for(Person p:people)
        {
            data[row][0]=p.getFirstName();
            data[row][1]=p.getLastName();
            data[row][2]=""+p.getAge();
            row++;
        }
        scr_people.remove(tbl_people);
        tbl_people = new JTable(data, headings.toArray());
        tbl_people.getSelectionModel().addListSelectionListener(e ->selected());
        scr_people.setViewportView(tbl_people);
        scr_people.revalidate();
    }
    public String randomText()
    {
        String s = "";
        int numLetters = (int)(Math.random()*5)+3;
        for(int x=0; x<numLetters; x++)
            s+=(char)((Math.random()*26)+65);
        return s;
    }

    public int randomAge()
    {
        return (int)(Math.random()*50)+16;
    }
    public void selected()
    {
        if(tbl_people.getSelectedRow() != -1)
            btn_delete.setEnabled(true);
        else
            btn_delete.setEnabled(false);
    }
}