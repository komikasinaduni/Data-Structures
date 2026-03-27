package Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CartPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private JTextField txtTip;
    private JTextField txtSubtotal, txtTax, txtTipAmt, txtTotal;

    private ArrayList<OrderItem> cart;
    private final double TAX_RATE = 0.0825;

    public CartPanel(ArrayList<OrderItem> cart){
        this.cart = cart;
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"Item","Qty","Price","Extended"},0){
            public boolean isCellEditable(int row,int col){ return false; }
        };
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(5,2));

        bottom.add(new JLabel("Tip %"));
        txtTip = new JTextField("0");
        bottom.add(txtTip);

        bottom.add(new JLabel("Subtotal"));
        txtSubtotal = new JTextField();
        txtSubtotal.setEditable(false);
        bottom.add(txtSubtotal);

        bottom.add(new JLabel("Tax"));
        txtTax = new JTextField();
        txtTax.setEditable(false);
        bottom.add(txtTax);

        bottom.add(new JLabel("Tip"));
        txtTipAmt = new JTextField();
        txtTipAmt.setEditable(false);
        bottom.add(txtTipAmt);

        bottom.add(new JLabel("Total"));
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        bottom.add(txtTotal);

        add(bottom, BorderLayout.SOUTH);

        txtTip.addActionListener(e -> calculate());
        txtTip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent e){ calculate(); }
        });
    }

    public void refreshTable(){

        model.setRowCount(0);

        for(OrderItem item : cart){
            model.addRow(new Object[]{
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getQuantity()*item.getPrice()
            });
        }

        calculate();
    }

    private void calculate(){

        double subtotal = 0;
        for(OrderItem item : cart){
            subtotal += item.getQuantity()*item.getPrice();
        }

        double tax = subtotal*TAX_RATE;

        int tipPerc = 0;
        try{ tipPerc = Integer.parseInt(txtTip.getText()); if(tipPerc<0) tipPerc=0; }
        catch(Exception e){ tipPerc=0; txtTip.setText("0"); }

        double tipAmt = subtotal*tipPerc/100.0;
        double total = subtotal+tax+tipAmt;

        txtSubtotal.setText(String.format("%.2f", subtotal));
        txtTax.setText(String.format("%.2f", tax));
        txtTipAmt.setText(String.format("%.2f", tipAmt));
        txtTotal.setText(String.format("%.2f", total));
    }
}