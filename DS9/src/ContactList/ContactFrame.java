package ContactList;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactFrame extends JFrame {
    private JLabel lbl_contacts = new JLabel("Contacts");

    private JList<Person> list_contacts = new JList<>();
    private JScrollPane scr_contacts;

    private JLabel lbl_firstName = new JLabel("First Name:");
    private JTextField txt_firstName = new JTextField();

    private JLabel lbl_lastName = new JLabel("Last Name:");
    private JTextField txt_lastName = new JTextField();

    private JButton btn_save = new JButton("Save");
    private JButton btn_delete = new JButton("Delete");
    private JButton btn_clearSelection = new JButton("Clear");

    private ArrayList<Person> contacts = new ArrayList<>();

    public ContactFrame(){
        super("Contact List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 400);

        lbl_contacts.setBounds(20, 20, 100, 20);
        add(lbl_contacts);

        scr_contacts = new JScrollPane(list_contacts);
        scr_contacts.setBounds(20, 40, 120, 200);
        scr_contacts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scr_contacts);
        
        list_contacts.addListSelectionListener(e -> selectionChange());

        btn_clearSelection.setBounds(40, 250, 80, 30);
        btn_clearSelection.addActionListener(e -> clearSelection());
        btn_clearSelection.setEnabled(false);
        add(btn_clearSelection);

        lbl_firstName.setBounds(170, 20, 100, 20);
        add(lbl_firstName);
        txt_firstName.setBounds(170, 40, 180, 20);
        add(txt_firstName);

        lbl_lastName.setBounds(170, 60, 100, 20);
        add(lbl_lastName);
        txt_lastName.setBounds(170, 80, 180, 20);
        add(txt_lastName);

        btn_save.setBounds(170, 120, 80, 30);
        btn_save.addActionListener(e -> save());
        add(btn_save);

        btn_delete.setBounds(270, 120, 80, 30);
        btn_delete.addActionListener(e -> delete());
        btn_delete.setEnabled(false);
        add(btn_delete);

        setVisible(true);
    }

    private void selectionChange() {
        if(list_contacts.getSelectedIndex()==-1){
            btn_clearSelection.setEnabled(false);
            btn_delete.setEnabled(false);
            txt_firstName.setText("");
            txt_lastName.setText("");
        } else {
            btn_clearSelection.setEnabled(true);
            btn_delete.setEnabled(true);
            txt_firstName.setText(list_contacts.getSelectedValue().getFirstName());
            txt_lastName.setText(list_contacts.getSelectedValue().getLastName());
        }
    }

    public void save() {
        if(txt_firstName.getText().isEmpty()||txt_lastName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must enter both a first name and a last name.");
            return;
        }
        if(list_contacts.getSelectedIndex()==-1){
            Person person = new Person(txt_firstName.getText(), txt_lastName.getText());
            contacts.add(person);
            list_contacts.setListData(contacts.toArray(new Person[0]));
        } else{
            Person person = list_contacts.getSelectedValue();
            person.setFirstName(txt_firstName.getText());
            person.setLastName(txt_lastName.getText());
            list_contacts.setListData(contacts.toArray(new Person[0]));
        }
        txt_firstName.setText("");
        txt_lastName.setText("");
    }

    public void clearSelection() {
        list_contacts.clearSelection();

    }

    public void delete(){
        contacts.remove(list_contacts.getSelectedIndex());
        list_contacts.setListData(contacts.toArray(new Person[0]));

    }

}
