package atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    JLabel text;
    String pinchange;

    BalanceEnquiry(String pinchange) {
        this.pinchange = pinchange;

        setLayout(null);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        // Back button
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);

        int balance = 0;

        // Database Connection
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinchange+"'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = rs.getInt("amount");

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            // Close resources
            rs.close();
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display balance
        text = new JLabel("Your current account balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        label.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinchange).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("1234"); // Example PIN
    }
}
