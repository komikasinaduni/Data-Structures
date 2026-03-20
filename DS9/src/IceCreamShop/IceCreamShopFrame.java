package IceCreamShop;
import javax.swing.*;
import java.util.ArrayList;
public class IceCreamShopFrame extends JFrame {
    private ArrayList<IceCreamOrder> orders = new ArrayList<>();
    private JRadioButton rad_bowl = new JRadioButton("Bowl ($0.50)");
    private JRadioButton rad_waffleBowl = new JRadioButton("Waffle Bowl ($2.00)");
    private JRadioButton rad_waffleCone = new JRadioButton("Waffle Cone ($2.00)");
    private JRadioButton rad_chocoCone = new JRadioButton("Chocolate Waffle Cone ($3.50)");
    private ButtonGroup grp_container = new ButtonGroup();
    private JComboBox<String> cmb_flavor = new JComboBox<>();
    private JComboBox<String> cmb_scoops = new JComboBox<>();
    private JCheckBox ck_choc = new JCheckBox("Chocolate Syrup (.75)");
    private JCheckBox ck_caramel = new JCheckBox("Caramel Syrup (.75)");
    private JCheckBox ck_mms = new JCheckBox("M&M's (1.00)");
    private JCheckBox ck_oreo = new JCheckBox("Oreos (1.00)");
    private JCheckBox ck_pb = new JCheckBox("Peanut Butter Cup (1.25)");
    private JCheckBox ck_chip = new JCheckBox("Chocolate Chip (1.00)");
    private JCheckBox ck_sprinkles = new JCheckBox("Sprinkles (.75)");
    private JTable tbl_orders;
    private JScrollPane scr_orders;
    private ArrayList<String> headings = new ArrayList<>();
    private JButton btn_addSave = new JButton("Add");
    private JButton btn_delete = new JButton("Delete");
    private JTextField txt_subtotal = new JTextField();
    private JTextField txt_tax = new JTextField();
    private JTextField txt_total = new JTextField();

    public IceCreamShopFrame(){

        super("Ice Cream Shop");
        setSize(700,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        grp_container.add(rad_bowl);
        grp_container.add(rad_waffleBowl);
        grp_container.add(rad_waffleCone);
        grp_container.add(rad_chocoCone);

        rad_bowl.setSelected(true);

        rad_bowl.setBounds(20,40,250,20);
        rad_waffleBowl.setBounds(20,60,250,20);
        rad_waffleCone.setBounds(20,80,250,20);
        rad_chocoCone.setBounds(20,100,300,20);

        add(rad_bowl);
        add(rad_waffleBowl);
        add(rad_waffleCone);
        add(rad_chocoCone);

        cmb_flavor.addItem("Vanilla");
        cmb_flavor.addItem("Cookies and Cream");
        cmb_flavor.addItem("Chocolate");
        cmb_flavor.addItem("Butter Pecan");
        cmb_flavor.addItem("Strawberry");
        cmb_flavor.addItem("Chocolate Chip Cookie Dough");
        cmb_flavor.addItem("Coffee");
        cmb_flavor.addItem("Cinnamon");

        cmb_flavor.setBounds(400,40,200,20);
        add(cmb_flavor);

        cmb_scoops.addItem("1 ($3.00)");
        cmb_scoops.addItem("2 ($5.50)");
        cmb_scoops.addItem("3 ($7.00)");

        cmb_scoops.setBounds(400,70,200,20);
        add(cmb_scoops);

        ck_choc.setBounds(20,140,200,20);
        ck_caramel.setBounds(20,160,200,20);
        ck_mms.setBounds(20,180,200,20);
        ck_oreo.setBounds(20,200,200,20);
        ck_pb.setBounds(20,220,200,20);
        ck_chip.setBounds(20,240,200,20);
        ck_sprinkles.setBounds(20,260,200,20);

        add(ck_choc);
        add(ck_caramel);
        add(ck_mms);
        add(ck_oreo);
        add(ck_pb);
        add(ck_chip);
        add(ck_sprinkles);

        headings.add("Container");
        headings.add("Flavor");
        headings.add("# Scoops");
        headings.add("Toppings");
        headings.add("Cost");

        tbl_orders = new JTable(new String[0][5], headings.toArray()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };

        tbl_orders.getSelectionModel().addListSelectionListener(e -> selectedRow());

        scr_orders = new JScrollPane(tbl_orders);
        scr_orders.setBounds(250,120,400,250);
        scr_orders.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scr_orders);

        btn_addSave.setBounds(250,400,100,25);
        btn_delete.setBounds(360,400,100,25);

        add(btn_addSave);
        add(btn_delete);

        btn_delete.setEnabled(false);

        btn_addSave.addActionListener(e -> addOrSave());
        btn_delete.addActionListener(e -> deleteOrder());

        txt_subtotal.setBounds(250,450,100,20);
        txt_tax.setBounds(250,480,100,20);
        txt_total.setBounds(250,510,100,20);
        txt_subtotal.setEnabled(false);
        txt_tax.setEnabled(false);
        txt_total.setEnabled(false);
        add(txt_subtotal);
        add(txt_tax);
        add(txt_total);
        setVisible(true);
    }

    public double calculateCost(){

        double cost=0;

        if(rad_bowl.isSelected()){
            cost+=.50;
        }

        if(rad_waffleBowl.isSelected()){
            cost+=2.00;
        }

        if(rad_waffleCone.isSelected()){
            cost+=2.00;
        }

        if(rad_chocoCone.isSelected()){
            cost+=3.50;
        }

        if(cmb_scoops.getSelectedIndex()==0){
            cost+=3.00;
        }

        if(cmb_scoops.getSelectedIndex()==1){
            cost+=5.50;
        }

        if(cmb_scoops.getSelectedIndex()==2){
            cost+=7.00;
        }

        if(ck_choc.isSelected()){
            cost+=.75;
        }

        if(ck_caramel.isSelected()){
            cost+=.75;
        }

        if(ck_mms.isSelected()){
            cost+=1.00;
        }

        if(ck_oreo.isSelected()){
            cost+=1.00;
        }

        if(ck_pb.isSelected()){
            cost+=1.25;
        }

        if(ck_chip.isSelected()){
            cost+=1.00;
        }

        if(ck_sprinkles.isSelected()){
            cost+=.75;
        }
        return cost;
    }

    public void addOrSave(){
        if(tbl_orders.getSelectedRow() == -1){
            addOrder();
        }else{
            saveOrder();
        }
    }

    public void addOrder(){
        String container="";
        if(rad_bowl.isSelected()){
            container="Bowl";
        }

        if(rad_waffleBowl.isSelected()){
            container="Waffle Bowl";
        }

        if(rad_waffleCone.isSelected()){
            container="Waffle Cone";
        }

        if(rad_chocoCone.isSelected()){
            container="Chocolate Waffle Cone";
        }

        String flavor=cmb_flavor.getSelectedItem().toString();
        String scoops=cmb_scoops.getSelectedItem().toString();

        String toppings="";

        if(ck_choc.isSelected()){
            toppings+="Chocolate ";
        }

        if(ck_caramel.isSelected()){
            toppings+="Caramel ";
        }

        if(ck_mms.isSelected()){
            toppings+="M&M ";
        }

        if(ck_oreo.isSelected()){
            toppings+="Oreos ";
        }

        if(ck_pb.isSelected()){
            toppings+="PB Cup ";
        }

        if(ck_chip.isSelected()){
            toppings+="Chips ";
        }

        if(ck_sprinkles.isSelected()){
            toppings+="Sprinkles ";
        }

        double cost=calculateCost();

        orders.add(new IceCreamOrder(container,flavor,scoops,toppings,cost));

        updateTable();
        updateTotals();
        resetFields();
    }

    public void saveOrder(){

        int row = tbl_orders.getSelectedRow();

        if(row != -1){

            String container="";

            if(rad_bowl.isSelected()){
                container="Bowl";
            }

            if(rad_waffleBowl.isSelected()){
                container="Waffle Bowl";
            }

            if(rad_waffleCone.isSelected()){
                container="Waffle Cone";
            }

            if(rad_chocoCone.isSelected()){
                container="Chocolate Waffle Cone";
            }

            String flavor=cmb_flavor.getSelectedItem().toString();
            String scoops=cmb_scoops.getSelectedItem().toString();

            String toppings="";

            if(ck_choc.isSelected()){
                toppings+="Chocolate ";
            }

            if(ck_caramel.isSelected()){
                toppings+="Caramel ";
            }

            if(ck_mms.isSelected()){
                toppings+="M&M ";
            }

            if(ck_oreo.isSelected()){
                toppings+="Oreos ";
            }

            if(ck_pb.isSelected()){
                toppings+="PB Cup ";
            }

            if(ck_chip.isSelected()){
                toppings+="Chips ";
            }

            if(ck_sprinkles.isSelected()){
                toppings+="Sprinkles ";
            }

            double cost=calculateCost();

            IceCreamOrder order = orders.get(row);

            order.setContainer(container);
            order.setFlavor(flavor);
            order.setScoops(scoops);
            order.setToppings(toppings);
            order.setCost(cost);

            tbl_orders.clearSelection();

            updateTable();
            updateTotals();
            resetFields();
        }
    }

    public void deleteOrder(){

        if(tbl_orders.getSelectedRow()!=-1){
            orders.remove(tbl_orders.getSelectedRow());
        }

        updateTable();
        updateTotals();
        btn_delete.setEnabled(false);
    }

    public void selectedRow(){

        int row = tbl_orders.getSelectedRow();

        if(row != -1){

            btn_delete.setEnabled(true);
            btn_addSave.setText("Save");

            IceCreamOrder o = orders.get(row);

            cmb_flavor.setSelectedItem(o.getFlavor());
            cmb_scoops.setSelectedItem(o.getScoops());

        }else{

            btn_delete.setEnabled(false);
            btn_addSave.setText("Add");

        }

    }

    public void updateTable(){

        String[][] data=new String[orders.size()][5];

        int row=0;

        for(IceCreamOrder o:orders){

            data[row][0]=o.getContainer();
            data[row][1]=o.getFlavor();
            data[row][2]=o.getScoops();
            data[row][3]=o.getToppings();
            data[row][4]=String.format("%.2f",o.getCost());

            row++;
        }

        scr_orders.remove(tbl_orders);

        tbl_orders=new JTable(data,headings.toArray()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        tbl_orders.getSelectionModel().addListSelectionListener(e -> selectedRow());

        scr_orders.setViewportView(tbl_orders);
        scr_orders.revalidate();
    }

    public void updateTotals(){
        double subtotal=0;
        for(IceCreamOrder o:orders){
            subtotal+=o.getCost();
        }
        double tax=subtotal*.0825;
        double total=subtotal+tax;

        txt_subtotal.setText(String.format("%.2f",subtotal));
        txt_tax.setText(String.format("%.2f",tax));
        txt_total.setText(String.format("%.2f",total));
    }

    public void resetFields(){

        rad_bowl.setSelected(true);
        cmb_flavor.setSelectedItem("Vanilla");
        cmb_scoops.setSelectedIndex(0);
        ck_choc.setSelected(false);
        ck_caramel.setSelected(false);
        ck_mms.setSelected(false);
        ck_oreo.setSelected(false);
        ck_pb.setSelected(false);
        ck_chip.setSelected(false);
        ck_sprinkles.setSelected(false);
    }
}