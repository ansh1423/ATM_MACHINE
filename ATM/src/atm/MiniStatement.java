package atm;
import atm.Conn;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JTextArea statementArea = new JTextArea();
        statementArea.setBounds(20, 140, 350, 400);
        statementArea.setEditable(false);
        add(statementArea);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                   String maskedCard = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
                    card.setText("Card Number: " + maskedCard);
 
            }

            ResultSet rs2 = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "' ORDER BY date DESC LIMIT 10");
            StringBuilder statementText = new StringBuilder();
            
            while (rs2.next()) {
                statementText.append(rs2.getString("date")).append("\t")
                        .append(rs2.getString("type")).append("\tRs ")
                        .append(rs2.getString("amount")).append("\n");
            }

            statementArea.setText(statementText.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int balance =0;
        
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
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
        text.setText("Your current account balance is Rs " + balance);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(20, 100, 400, 30);
        add(text);
     

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        new MiniStatement(""); // Dynamic PIN Pass Karo
        
    }
}
