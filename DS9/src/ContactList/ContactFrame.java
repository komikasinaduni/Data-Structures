package ContactList;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ContactFrame extends JFrame {
    private JLabel lbl_contacts = new JLabel("Contacts");
    private JList<String> list_contacts = new JList<>();
    private JScrollPane scr_contacts;

    private JLabel lbl_firstName = new JLabel("First Name:");
    private JTextField txt_firstName = new JTextField();

    private JLabel lbl_lastName = new JLabel("Last Name:");
    private JTextField txt_lastName = new JTextField();

    private JButton btn_save = new JButton("Save");
    private JButton btn_new = new JButton("New");

    private JButton btn_saveChanges = new JButton("Save Changes");
    private JButton btn_delete = new JButton("Delete Contact");

    private JLabel lbl_phone = new JLabel("Phone:");
    private JTextField txt_phone = new JTextField();

    private JLabel lbl_address = new JLabel("Address:");
    private JTextField txt_address = new JTextField();

    private ArrayList<Person> contacts = new ArrayList<>();
    private final String FILE_NAME = "contacts.txt";

    public ContactFrame() {
        super("Contact List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 500);

        lbl_contacts.setBounds(20, 20, 100, 20);
        add(lbl_contacts);

        scr_contacts = new JScrollPane(list_contacts);
        scr_contacts.setBounds(20, 40, 120, 300);
        scr_contacts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scr_contacts);

        list_contacts.addListSelectionListener(e -> selectionChange());

        lbl_firstName.setBounds(170, 20, 100, 20);
        add(lbl_firstName);
        txt_firstName.setBounds(170, 40, 180, 20);
        add(txt_firstName);

        lbl_lastName.setBounds(170, 60, 100, 20);
        add(lbl_lastName);
        txt_lastName.setBounds(170, 80, 180, 20);
        add(txt_lastName);

        lbl_phone.setBounds(170, 100, 100, 20);
        add(lbl_phone);
        txt_phone.setBounds(170, 120, 180, 20);
        ((AbstractDocument) txt_phone.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) super.insertString(fb, offset, string, attr);
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) super.replace(fb, offset, length, text, attrs);
            }
        });
        add(txt_phone);

        lbl_address.setBounds(170, 140, 100, 20);
        add(lbl_address);
        txt_address.setBounds(170, 160, 180, 20);
        add(txt_address);

        btn_save.setBounds(170, 200, 120, 30);
        btn_save.addActionListener(e -> saveNew());
        add(btn_save);

        btn_new.setBounds(170, 240, 120, 30);
        btn_new.addActionListener(e -> clearFields());
        add(btn_new);

        btn_saveChanges.setBounds(170, 200, 120, 30);
        btn_saveChanges.addActionListener(e -> saveChanges());
        btn_saveChanges.setVisible(false);
        add(btn_saveChanges);

        btn_delete.setBounds(170, 240, 120, 30);
        btn_delete.addActionListener(e -> delete());
        btn_delete.setVisible(false);
        add(btn_delete);

        loadContacts();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                saveContactsToFile();
            }
        });

        setVisible(true);
    }

    private void selectionChange() {
        int index = list_contacts.getSelectedIndex();
        if(index != -1){
            Person p = contacts.get(index);
            txt_firstName.setText(p.getFirstName());
            txt_lastName.setText(p.getLastName());
            txt_phone.setText(p.getPhone());
            txt_address.setText(p.getAddress());
            btn_save.setVisible(false);
            btn_new.setVisible(false);
            btn_saveChanges.setVisible(true);
            btn_delete.setVisible(true);
        } else {
            clearFields();
        }
    }

    private void saveNew() {
        if(txtFirstOrLastEmpty()) return;

        Person person = new Person(txt_firstName.getText(), txt_lastName.getText());
        person.setPhone(txt_phone.getText());
        person.setAddress(txt_address.getText());
        contacts.add(person);

        sortAndRefresh();
        clearFields();
    }

    private void saveChanges() {
        int index = list_contacts.getSelectedIndex();
        if(index == -1) return;
        if(txtFirstOrLastEmpty()) return;

        Person person = contacts.get(index);
        person.setFirstName(txt_firstName.getText());
        person.setLastName(txt_lastName.getText());
        person.setPhone(txt_phone.getText());
        person.setAddress(txt_address.getText());

        sortAndRefresh();
        list_contacts.clearSelection();
        clearFields();
    }

    private void delete() {
        int index = list_contacts.getSelectedIndex();
        if(index != -1){
            contacts.remove(index);
            sortAndRefresh();
            list_contacts.clearSelection();
            clearFields();
        }
    }

    private void clearFields() {
        txt_firstName.setText("");
        txt_lastName.setText("");
        txt_phone.setText("");
        txt_address.setText("");
        list_contacts.clearSelection();
        btn_save.setVisible(true);
        btn_new.setVisible(true);
        btn_saveChanges.setVisible(false);
        btn_delete.setVisible(false);
    }

    private boolean txtFirstOrLastEmpty() {
        if(txt_firstName.getText().isEmpty() || txt_lastName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You must enter both a first name and a last name.");
            return true;
        }
        return false;
    }

    private void sortAndRefresh() {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                Person p1 = contacts.get(j);
                Person p2 = contacts.get(j + 1);
                if (p1.getLastName().compareToIgnoreCase(p2.getLastName()) > 0) {
                    contacts.set(j, p2);
                    contacts.set(j + 1, p1);
                }
            }
        }        String[] arr = new String[contacts.size()];
        for(int i = 0; i < contacts.size(); i++){
            Person p = contacts.get(i);
            arr[i] = p.getLastName() + ", " + p.getFirstName();
        }
        list_contacts.setListData(arr);
    }

    private void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(Person p : contacts){
                writer.write(p.getFirstName() + "," + p.getLastName() + "," + p.getPhone() + "," + p.getAddress());
                writer.newLine();
            }
        } catch(Exception ignored){}
    }

    private void loadContacts() {
        contacts.clear();
        File f = new File(FILE_NAME);
        if(!f.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",", -1);
                if(parts.length == 4){
                    Person p = new Person(parts[0], parts[1]);
                    p.setPhone(parts[2]);
                    p.setAddress(parts[3]);
                    contacts.add(p);
                }
            }
        } catch(Exception ignored){}
        sortAndRefresh();
    }
}