package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField panTextField, aadharTextField;
    JRadioButton yesSenior, noSenior, yesExisting, noExisting;
    JButton next;
    JComboBox<String> religion1, category1, income1, education1, occupation1;
    String formno;

    // Constructor
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        String valreligion1[] = {"Hindu", "Muslim", "Sikh", "Christian"};
        religion1 = new JComboBox<>(valreligion1);
        religion1.setBounds(300, 140, 400, 30);
        add(religion1);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(100, 190, 130, 30);
        add(category);
        String vcategory1[] = {"SC", "ST", "General", "OBC"};
        category1 = new JComboBox<>(vcategory1);
        category1.setBounds(300, 190, 400, 30);
        add(category1);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100, 240, 130, 30);
        add(income);
        String valIncome[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10"};
        income1 = new JComboBox<>(valIncome);
        income1.setBounds(300, 240, 400, 30);
        add(income1);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(100, 290, 130, 30);
        add(education);
        String valEducation[] = {"Matrix", "Intermediate", "Graduate", "Post-Graduate", "Others"};
        education1 = new JComboBox<>(valEducation);
        education1.setBounds(300, 290, 400, 30);
        add(education1);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(100, 340, 130, 30);
        add(occupation);
        String valOccupation[] = {"Farming", "Private", "Engineer", "Doctor", "Others"};
        occupation1 = new JComboBox<>(valOccupation);
        occupation1.setBounds(300, 340, 400, 30);
        add(occupation1);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(100, 390, 130, 30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(100, 440, 170, 30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(300, 490, 120, 30);
        yesSenior.setBackground(Color.WHITE);
        add(yesSenior);
        noSenior = new JRadioButton("No");
        noSenior.setBounds(450, 490, 120, 30);
        noSenior.setBackground(Color.WHITE);
        add(noSenior);
        ButtonGroup seniorStatus = new ButtonGroup();
        seniorStatus.add(yesSenior);
        seniorStatus.add(noSenior);

        JLabel existing = new JLabel("Existing User:");
        existing.setFont(new Font("Raleway", Font.BOLD, 18));
        existing.setBounds(100, 540, 150, 30);
        add(existing);

        yesExisting = new JRadioButton("Yes");
        yesExisting.setBounds(300, 540, 120, 30);
        yesExisting.setBackground(Color.WHITE);
        add(yesExisting);
        noExisting = new JRadioButton("No");
        noExisting.setBounds(450, 540, 120, 30);
        noExisting.setBackground(Color.WHITE);
        add(noExisting);
        ButtonGroup existingStatus = new ButtonGroup();
        existingStatus.add(yesExisting);
        existingStatus.add(noExisting);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        // Frame properties
        setSize(800, 800);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();
        String sreligion = (String) religion1.getSelectedItem();
        String scategory = (String) category1.getSelectedItem();
        String sincome = (String) income1.getSelectedItem();
        String seducation = (String) education1.getSelectedItem();
        String soccupation = (String) occupation1.getSelectedItem();
        String seniorcitizen = yesSenior.isSelected() ? "Yes" : "No";
        String isExisting = yesExisting.isSelected() ? "Yes" : "No";

        try {
            if (aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aadhar No. is required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + aadhar + "', '" + pan + "', '" + seniorcitizen + "', '" + isExisting + "')";
                c.s.executeUpdate(query);

//                 Proceed to next signup page
               setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
