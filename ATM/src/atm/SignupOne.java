
package atm;

import javax.swing.*;//For Make frame this package is used now
import java.awt.*; //Colour package available
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, fNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JRadioButton male, female, other, others, married , unmarried;
    JDateChooser dateChooser;
   SignupOne() {
       setLayout(null);
       Random ran = new Random();
       random = Math.abs((ran.nextLong() % 9000L)+ 1000L);
       
       JLabel formno = new JLabel("APPLICATION FOR NO. "+random);
       formno.setFont(new Font("Raleway", Font.BOLD, 38));
       formno.setBounds(140, 20, 600, 40);
       add(formno);
       
       JLabel personalDetails = new JLabel("Page 1: Personal Details");
       personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       personalDetails.setBounds(290, 80, 400, 30);
       add(personalDetails);
       
       JLabel name = new JLabel("Name:");
       name.setFont(new Font("Raleway", Font.BOLD, 22));
       name.setBounds(100, 140, 100, 30);
       add(name);
       
       nameTextField = new JTextField();
       nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       nameTextField.setBounds(300, 140, 400, 30); // Set bounds for the text field
       add(nameTextField); // Add the text field to the frame

       
        JLabel fName = new JLabel("Father's Name:");
       fName.setFont(new Font("Raleway", Font.BOLD, 22));
       fName.setBounds(100, 190, 200, 30);
       add(fName);
       fNameTextField = new JTextField();
       fNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       fNameTextField.setBounds(300, 190, 400, 30); // Set bounds for the text field
       add(fNameTextField);
       
        JLabel dob = new JLabel("Date of Birth:");
       dob.setFont(new Font("Raleway", Font.BOLD, 22));
       dob.setBounds(100, 240, 200, 30);
       add(dob);
       
       dateChooser = new JDateChooser();
       dateChooser.setBounds(300,240,400,30);
       dateChooser.setForeground(Color.BLACK);
       add(dateChooser);
       
       JLabel gender = new JLabel("Gender:");
       gender.setFont(new Font("Raleway", Font.BOLD, 22));
       gender.setBounds(100, 290, 100, 30);
       add(gender);
       
       male = new JRadioButton("Male");
       male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.WHITE);
       add(male);
       
       female = new JRadioButton("Female");
       female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
       add(female);
       
       other = new JRadioButton("Other");
       other.setBounds(600, 290, 120, 30);
        other.setBackground(Color.WHITE);
       add(other);
       
       ButtonGroup gendergroup = new ButtonGroup();
       gendergroup.add(male);
       gendergroup.add(female);
       gendergroup.add(other);
       
       JLabel email = new JLabel("Email id:");
       email.setFont(new Font("Raleway", Font.BOLD, 22));
       email.setBounds(100, 340, 100, 30);
       add(email);
       emailTextField = new JTextField();
       emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       emailTextField.setBounds(300, 340, 400, 30); // Set bounds for the text field
       add(emailTextField);
       
        JLabel marital = new JLabel("Marital Status:");
       marital.setFont(new Font("Raleway", Font.BOLD, 22));
       marital.setBounds(100, 390, 200, 30);
       add(marital);
       
        married = new JRadioButton("Married");
       married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
       add(married);
       
       unmarried = new JRadioButton("Unmarried");
       unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
       add(unmarried);
       
       others = new JRadioButton("Other");
       others.setBounds(600, 390, 120, 30);
        others.setBackground(Color.WHITE);
       add(others);
       
       ButtonGroup maritalstatus = new ButtonGroup();
       maritalstatus.add(married);
       maritalstatus.add(unmarried);
       maritalstatus.add(others);
       
        JLabel address = new JLabel("Address:");
       address.setFont(new Font("Raleway", Font.BOLD, 22));
       address.setBounds(100, 440, 200, 30);
       add(address);
       addressTextField = new JTextField();
       addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       addressTextField.setBounds(300, 440, 400, 30); // Set bounds for the text field
       add(addressTextField);
       JLabel city = new JLabel("City:");
       city.setFont(new Font("Raleway", Font.BOLD, 22));
       city.setBounds(100, 490, 200, 30);
       add(city);
       cityTextField = new JTextField();
       cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       cityTextField.setBounds(300, 490, 400, 30); // Set bounds for the text field
       add(cityTextField);
       
        JLabel state = new JLabel("State:");
       state.setFont(new Font("Raleway", Font.BOLD, 22));
       state.setBounds(100, 540, 200, 30);
       add(state);
       stateTextField = new JTextField();
       stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       stateTextField.setBounds(300, 540, 400, 30); // Set bounds for the text field
       add(stateTextField);
       
        JLabel pincode = new JLabel("Pin Code:");
       pincode.setFont(new Font("Raleway", Font.BOLD, 22));
       pincode.setBounds(100, 590, 200, 30);
       add(pincode);
       pincodeTextField = new JTextField();
       pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
       pincodeTextField.setBounds(300, 590, 400, 30); // Set bounds for the text field
       add(pincodeTextField);
        
       JButton next = new JButton("Next");
       next.setBackground(Color.BLACK);
//       next.setForeground(Color.WHITE);
       next.setBounds(620,660, 80, 30);
       next.setFont(new Font("Raleway", Font.BOLD, 14));
       next.addActionListener(this);
       add(next);

       
       getContentPane().setBackground(Color.WHITE);
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
      String formno = ""+ random; //Long value 
      String name = nameTextField.getText();
      String fname = fNameTextField.getText();
      String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
      String email = emailTextField.getText();
      String gender = null;
      if(male.isSelected()){
          gender = "Male";
      }else if(female.isSelected()){
          gender = "Female";
                  }
      
      String marital = null ;
      if(married.isSelected()){
          marital = "married";
                  }
      else if(unmarried.isSelected()){
          marital = "unmarried";
      }
      else if(other.isSelected()){
        marital = "other";
      }
      String address = addressTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String pincode = pincodeTextField.getText();
      
     try{
     if(name.equals("")) {
         JOptionPane.showMessageDialog(null, "Name is required");
     }else{
         Conn c = new Conn();
         String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"','"+dob+"', '"+gender+"', '"+email+"','"+marital+"','"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
         c.s.executeUpdate(query);
         setVisible(false);
         new SignupTwo(formno).setVisible(true);
     }
     }
     catch(Exception e){
         System.out.println(e);
     }
      
   }
    
    public static void main(String args[]) {
         new SignupOne();
    }
    
}
 