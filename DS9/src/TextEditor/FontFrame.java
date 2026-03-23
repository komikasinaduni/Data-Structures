package TextEditor;

import javax.swing.*;
import java.awt.*;

public class FontFrame extends JFrame {
    private JComboBox<String> cmb_fonts = new JComboBox<>();
    private JTextField txt_size = new JTextField();
    private JButton btn_save = new JButton("Save");
    private JButton btn_cancel = new JButton("Cancel");

    public FontFrame(FileTab tab){
        setTitle("Font");
        setSize(300,200);
        setLayout(null);

        cmb_fonts.addItem("Arial");
        cmb_fonts.addItem("Courier New");
        cmb_fonts.addItem("Times New Roman");
        cmb_fonts.addItem("Verdana");
        cmb_fonts.addItem("Tahoma");
        cmb_fonts.setBounds(20,20,200,25);

        txt_size.setBounds(20,60,200,25);
        txt_size.setText(String.valueOf(tab.getTextArea().getFont().getSize()));
        txt_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && c != '\b') e.consume();
            }
        });

        btn_save.setBounds(20,100,80,25);
        btn_cancel.setBounds(120,100,80,25);

        add(cmb_fonts);
        add(txt_size);
        add(btn_save);
        add(btn_cancel);

        btn_save.addActionListener(e -> {
            String fontName = cmb_fonts.getSelectedItem().toString();
            int size = txt_size.getText().isEmpty() ? 12 : Integer.parseInt(txt_size.getText());
            tab.getTextArea().setFont(new Font(fontName, Font.PLAIN, size));
            tab.setSaved(false);
            tab.updateTabTitle();
            dispose();
        });

        btn_cancel.addActionListener(e -> dispose());
        setVisible(true);
    }
}