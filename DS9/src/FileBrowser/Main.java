package FileBrowser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Main {
    public static void main(String[] args){
        /*

        JFileChooser openPicker = new JFileChooser("C:\\");
        openPicker.setFileFilter(fnef);
        int result = openPicker.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            File selectedFile = openPicker.getSelectedFile();
        }

        */
        JFileChooser savePicker = new JFileChooser("C:\\");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text Filter", "txt", "text");
        savePicker.setFileFilter(fnef);
        int result = savePicker.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = savePicker.getSelectedFile();
        }

    }
}
