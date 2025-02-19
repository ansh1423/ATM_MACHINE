package atm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener { 
    JTextField pintext, repintext;
    JButton change, back;
    String pin;

    PinChange(String pin) { 
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pinLabel = new JLabel("New PIN:");
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("System", Font.BOLD, 16));
        pinLabel.setBounds(165, 320, 180, 25);
        image.add(pinLabel);
        
        pintext = new JTextField();
        pintext.setFont(new Font("Raleway", Font.BOLD, 25));
        pintext.setBounds(330, 320, 180, 25);
        image.add(pintext);
        
        JLabel repinLabel = new JLabel("Re-Enter New PIN:");
        repinLabel.setForeground(Color.WHITE);
        repinLabel.setFont(new Font("System", Font.BOLD, 16));
        repinLabel.setBounds(165, 360, 180, 25);
        image.add(repinLabel);
      
        repintext = new JTextField();
        repintext.setFont(new Font("Raleway", Font.BOLD, 25));
        repintext.setBounds(330, 360, 180, 25);
        image.add(repintext);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        image.add(change);
        change.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pintext.getText();
                String rpin = repintext.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PINs do not match.");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter the PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "UPDATE bank SET pin ='" + npin + "' WHERE pin='" + pin + "'";
                String query2 = "UPDATE login SET pin ='" + npin + "' WHERE pin='" + pin + "'";
                String query3 = "UPDATE signupthree SET pin ='" + npin + "' WHERE pin='" + pin + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
