package TextEditor;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SimpleListener implements DocumentListener {
    private Runnable run;
    public SimpleListener(Runnable run) {
        this.run = run;
    }
    public void insertUpdate(DocumentEvent e){ run.run(); }
    public void removeUpdate(DocumentEvent e){ run.run(); }
    public void changedUpdate(DocumentEvent e){ run.run(); }
}