package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setTitle("Signup - Page 3");
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setFont(new Font("Raleway", Font.BOLD, 16));

        r1.setBackground(Color.white);
        r2.setBackground(Color.white);
        r3.setBackground(Color.white);
        r4.setBackground(Color.white);

        r1.setBounds(100, 180, 250, 20);
        r2.setBounds(350, 180, 250, 20);
        r3.setBounds(100, 220, 250, 20);
        r4.setBounds(350, 220, 250, 20);

        add(r1);
        add(r2);
        add(r3);
        add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4665");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetails = new JLabel("Your 16-digit Card Number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 330, 300, 20);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pindetails = new JLabel("Your 4-digit PIN Number");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email & SMS Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");
        c7 = new JCheckBox("I hereby declare that the above details are correct");

        JCheckBox[] checkboxes = {c1, c2, c3, c4, c5, c6, c7};
        int yPos = 500;
        for (JCheckBox c : checkboxes) {
            c.setFont(new Font("Raleway", Font.BOLD, 16));
            c.setBackground(Color.WHITE);
            c.setBounds(100, yPos, 400, 30);
            add(c);
            yPos += 50;
        }

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 850, 100, 30);
        submit.addActionListener(this);
        add(submit);

//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 850, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is required");
                return;
            }

            Random random = new Random();
            String cardNumber = "" + (Math.abs((random.nextLong() % 90000000L) + 5040936000000000L));
            String pinNumber = "" + (Math.abs((random.nextInt(9000)) + 1000));

            StringBuilder facility = new StringBuilder();
            if (c1.isSelected()) facility.append("ATM Card, ");
            if (c2.isSelected()) facility.append("Internet Banking, ");
            if (c3.isSelected()) facility.append("Mobile Banking, ");
            if (c4.isSelected()) facility.append("Email & SMS Alerts, ");
            if (c5.isSelected()) facility.append("Cheque Book, ");
            if (c6.isSelected()) facility.append("E-Statement, ");

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept the declaration");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "','" + cardNumber + "', '" + pinNumber + "', '" + facility.toString() + "')";
                String q2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Account Created Successfully!\nCard No: " + cardNumber + "\nPIN: " + pinNumber);
                new Deposit(pinNumber).setVisible(true);
                    setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new SignupThree("1234");
    }
}
