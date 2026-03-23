package TextEditor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;

public class FileTab {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private File file;
    private boolean saved = true;

    public FileTab() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { changed(); }
            public void removeUpdate(DocumentEvent e) { changed(); }
            public void changedUpdate(DocumentEvent e) { changed(); }
            private void changed() {
                if (saved) {
                    saved = false;
                    updateTabTitle();
                }
            }
        });
    }

    public JTextArea getTextArea() { return textArea; }
    public JScrollPane getScrollPane() { return scrollPane; }
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }
    public boolean isSaved() { return saved; }
    public void setSaved(boolean saved) { this.saved = saved; updateTabTitle(); }

    public void updateTabTitle() {
        TextEditorFrame frame = (TextEditorFrame) SwingUtilities.getWindowAncestor(scrollPane);
        if (frame == null) return;
        int index = frame.getTabs().indexOfComponent(scrollPane);
        if (index == -1) return;
        String name = file != null ? file.getName() : frame.getTabs().getTitleAt(index);
        if (!saved && !name.endsWith("*")) name += "*";
        if (saved && name.endsWith("*")) name = name.substring(0, name.length() - 1);
        frame.getTabs().setTitleAt(index, name);
    }
}