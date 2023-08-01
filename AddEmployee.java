import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

import  com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    JButton add,back;
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;
    JComboBox  cdeducation;

    JLabel lblempId;
    JDateChooser dcdob;
    Random ran =new Random();
    int number=ran.nextInt(999999);
    AddEmployee(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel((" Add Employee Detail"));
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);

        JLabel lebelname=new JLabel("Name");
        lebelname.setBounds(50,150,150,30);
        lebelname.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelname);

        tfname=new JTextField("");
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);

        tffname=new JTextField("");
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lebelbod=new JLabel("Date of birth");
        lebelbod.setBounds(50,200,150,30);
        lebelbod.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelbod);

        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel lebelsalary=new JLabel("Salary ");
        lebelsalary.setBounds(400,200,150,30);
        lebelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelsalary);

        tfsalary=new JTextField("");
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel lebeladdress=new JLabel("Address ");
        lebeladdress.setBounds(50,250,150,30);
        lebeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeladdress);

        tfaddress=new JTextField("");
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lebelphone=new JLabel("Phone ");
        lebelphone.setBounds(400,250,150,30);
        lebelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelphone);

        tfphone=new JTextField("");
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lebelemail=new JLabel("Email ");
        lebelemail.setBounds(50,300,150,30);
        lebelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelemail);

        tfemail=new JTextField("");
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lebeleducation=new JLabel("Highest Education ");
        lebeleducation.setBounds(400,300,150,30);
        lebeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeleducation);

        String course[]={"BA","B.COM","BAC","BBA","MBA","PHD","BCS","B.TECH"};
        cdeducation=new JComboBox(course);
        cdeducation.setBackground(Color.white);
        cdeducation.setBounds(600,300,150,30);
        add(cdeducation);

        JLabel lebeldesignation=new JLabel("Designation ");
        lebeldesignation.setBounds(50,350,150,30);
        lebeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeldesignation);

        tfdesignation=new JTextField("");
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel lebelaadhar=new JLabel("Aadhar Number ");
        lebelaadhar.setBounds(400,350,150,30);
        lebelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelaadhar);

        tfaadhar=new JTextField("");
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel lebelempId=new JLabel("Employee id ");
        lebelempId.setBounds(50,400,150,30);
        lebelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelempId);

        lblempId=new JLabel(" "+ number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);

        add = new JButton("Add details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==add){

      String name=tfname.getText();
      String fname= tffname.getText();
      String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
      String salary=tfsalary.getText();
      String address = tfaddress.getText();
      String phone=tfphone.getText();
      String email=tfemail.getText();
      String education =(String) cdeducation.getSelectedItem();
      String designation =tfdesignation.getText();
      String aadhar = tfaadhar.getText();
      String emlId=lblempId.getText();

      try{
          Conn conn=new Conn();
          Connection c1 = conn.getC();
          String query=" insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+emlId+"')";
          conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Details added Successfully");
          setVisible(false);
          new Home();

      }catch (Exception e){
          e.printStackTrace();
      }


  }
  else {
      setVisible(false);
      new Home();
  }
    }
    public static void main(String[] args) {

        new AddEmployee();
    }


}
