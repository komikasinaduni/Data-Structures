package TextEditor;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TextEditorFrame extends JFrame {
    private JTabbedPane tabs = new JTabbedPane();
    private ArrayList<FileTab> files = new ArrayList<>();
    private File saveDir = new File("Saves");
    private JMenuBar bar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem mi_create = new JMenuItem("Create");
    private JMenuItem mi_open = new JMenuItem("Open");
    private JMenuItem mi_save = new JMenuItem("Save");
    private JMenuItem mi_saveAs = new JMenuItem("Save As");
    private JMenuItem mi_close = new JMenuItem("Close");
    private JMenuItem mi_exit = new JMenuItem("Exit");
    private JMenu editMenu = new JMenu("Edit");
    private JMenuItem mi_font = new JMenuItem("Font");
    private JMenuItem mi_replace = new JMenuItem("Replace");
    private JMenuItem mi_wordCount = new JMenuItem("Word Count");
    public TextEditorFrame(){
        setTitle("Text Editor");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        tabs.setBounds(0,0,600,450);
        add(tabs);
        setJMenuBar(bar);
        bar.add(fileMenu);
        fileMenu.add(mi_create);
        fileMenu.add(mi_open);
        fileMenu.add(mi_save);
        fileMenu.add(mi_saveAs);
        fileMenu.add(mi_close);
        fileMenu.add(mi_exit);
        bar.add(editMenu);
        editMenu.add(mi_font);
        editMenu.add(mi_replace);
        editMenu.add(mi_wordCount);
        mi_create.addActionListener(e -> create());
        mi_open.addActionListener(e -> open());
        mi_save.addActionListener(e -> save());
        mi_saveAs.addActionListener(e -> saveAs());
        mi_close.addActionListener(e -> closeTab());
        mi_exit.addActionListener(e -> exit());
        mi_font.addActionListener(e -> openFont());
        mi_replace.addActionListener(e -> openReplace());
        mi_wordCount.addActionListener(e -> wordCount());
        tabs.addChangeListener(e -> updateMenuState());
        updateMenuState();
        setVisible(true);
    }

    public void updateMenuState(){
        boolean hasTabs = tabs.getTabCount()>0;
        mi_save.setEnabled(hasTabs);
        mi_saveAs.setEnabled(hasTabs);
        mi_close.setEnabled(hasTabs);
        mi_font.setEnabled(hasTabs);
        mi_replace.setEnabled(hasTabs);
        mi_wordCount.setEnabled(hasTabs);
    }

    public FileTab getCurrent(){
        int i = tabs.getSelectedIndex();
        if(i == -1){
            return null;
        }
        return files.get(i);
    }

    public int getNextUnnamed(){
        int num = 1;
        while(true){
            boolean exists = false;
            for(int i=0;i<tabs.getTabCount();i++){
                if(tabs.getTitleAt(i).equals("Unnamed" + num)){
                    exists = true;
                }
            }
            File f = new File(saveDir, "Unnamed" + num);
            if(f.exists()){
                exists = true;
            }
            if(!exists){
                return num;
            }
            num++;
        }
    }

    public void create(){
        int num = getNextUnnamed();
        FileTab tab = new FileTab();
        files.add(tab);
        tabs.addTab("Unnamed" + num, tab.getScrollPane());
        updateMenuState();
    }

    public void open(){
        JFileChooser chooser = new JFileChooser(saveDir);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder text = new StringBuilder();
                String line;
                while((line = br.readLine()) != null){
                    text.append(line).append("\n");
                }
                FileTab tab = new FileTab();
                tab.getTextArea().setText(text.toString());
                tab.setFile(file);
                files.add(tab);
                tabs.addTab(file.getName(), tab.getScrollPane());
                updateMenuState();
            }catch(Exception e){

            }
        }
    }

    public void save(){
        FileTab tab = getCurrent();
        if(tab == null){
            return;
        }
        if(tab.getFile() == null){
            File file = new File(saveDir, tabs.getTitleAt(tabs.getSelectedIndex()));
            try{
                FileWriter fw = new FileWriter(file);
                fw.write(tab.getTextArea().getText());
                fw.close();
                tab.setFile(file);
            }catch(Exception e){

            }
        } else {
            try{
                FileWriter fw = new FileWriter(tab.getFile());
                fw.write(tab.getTextArea().getText());
                fw.close();
            }catch(Exception e){

            }
        }
    }

    public void saveAs(){
        FileTab tab = getCurrent();
        if(tab == null){
            return;
        }
        JFileChooser chooser = new JFileChooser(saveDir);
        if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            tab.setFile(file);
            tabs.setTitleAt(tabs.getSelectedIndex(), file.getName());
            save();
        }
    }

    public void closeTab(){
        int i = tabs.getSelectedIndex();
        if(i==-1){
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Unsaved data will be lost. Are you sure you want to close this file?", "Warning", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            files.remove(i);
            tabs.remove(i);
        }
        updateMenuState();
    }

    public void exit(){

        int confirm = JOptionPane.showConfirmDialog(this,
                "There are files that have not been saved, unsaved data will be lost. Are you sure you want to exit?", "Warning", JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    public void openFont(){
        FileTab tab = getCurrent();
        if(tab != null){
            new FontFrame(tab);
        }
    }
    public void openReplace(){
        FileTab tab = getCurrent();
        if(tab != null){
            new ReplaceFrame(tab);
        }
    }
    public void wordCount(){
        FileTab tab = getCurrent();
        if(tab == null){
            return;
        }
        String text = tab.getTextArea().getText().trim();
        int count = text.isEmpty() ? 0 : text.split("\\s+").length;
        JOptionPane.showMessageDialog(this, "Words: " + count);
    }
}