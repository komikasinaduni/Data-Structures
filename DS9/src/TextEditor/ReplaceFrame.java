package TextEditor;
import javax.swing.*;

public class ReplaceFrame extends JFrame {

    private JTextField txt_find = new JTextField();
    private JTextField txt_replace = new JTextField();
    private JButton btn_replace = new JButton("Replace");
    private JButton btn_cancel = new JButton("Cancel");

    public ReplaceFrame(FileTab tab){
        setTitle("Replace");
        setSize(300,200);
        setLayout(null);
        txt_find.setBounds(20,20,200,25);
        txt_replace.setBounds(20,60,200,25);
        btn_replace.setBounds(20,100,80,25);
        btn_cancel.setBounds(120,100,80,25);
        add(txt_find);
        add(txt_replace);
        add(btn_replace);
        add(btn_cancel);
        btn_replace.addActionListener(e -> {
            String text = tab.getTextArea().getText();
            text = text.replace(txt_find.getText(), txt_replace.getText());
            tab.getTextArea().setText(text);
            dispose();
        });
        btn_cancel.addActionListener(e -> dispose());
        setVisible(true);
    }
}