
package atm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pin;
    Deposit(String pin){
        this.pin=pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      
      JLabel text = new JLabel("Enter the amount you want to deposit");
      text.setFont(new Font("System", Font.BOLD, 16));
      text.setForeground(Color.white);
      text.setBounds(170,300,400,20);
      image.add(text);
      
       amount = new JTextField();
      amount.setFont(new Font("Raleway", Font.BOLD, 18));
      amount.setBounds(170,350,320,25);
      image.add(amount);
      
       deposit = new JButton("Deposit");
      deposit.setFont(new Font("Raleway", Font.BOLD, 18));
       deposit.setBounds(355,485,150,30);
       deposit.addActionListener(this);
      image.add( deposit);
      
      back = new JButton("Exit");
       back .setFont(new Font("Raleway", Font.BOLD, 18));
       back.addActionListener(this);
        back.setBounds(355,520,150,30);
      image.add( back );
      
      
    setSize(900, 900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
           String number = amount.getText();
           Date date = new Date();
           if(number.equals("")){
           JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
           
           } else {
         try {
         Conn conn = new Conn();
        String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + number + "')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Rs " + number + " deposited successfully!");
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }catch(Exception e) {
        System.out.println("Error: " + e);
    }
           }
           
        }else if(ae.getSource() == back){
            setVisible(false);
           new ATM().setVisible(true);
        }
            }
    
    public static void main(String[] args){
      new Deposit("");  
    }
    
}
