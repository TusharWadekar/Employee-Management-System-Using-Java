import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {

    JButton add,back;
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;

    JLabel lblempId;
    String empId;


    UpdateEmployee(String  empId){
        this.empId=empId;

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel((" Update Employee Detail"));
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);

        JLabel lebelname=new JLabel("Name");
        lebelname.setBounds(50,150,150,30);
        lebelname.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelname);

        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);

        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lebelbod=new JLabel("Date of birth");
        lebelbod.setBounds(50,200,150,30);
        lebelbod.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelbod);

        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

        JLabel lebelsalary=new JLabel("Salary ");
        lebelsalary.setBounds(400,200,150,30);
        lebelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelsalary);

        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel lebeladdress=new JLabel("Address ");
        lebeladdress.setBounds(50,250,150,30);
        lebeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeladdress);

        tfaddress=new JTextField(  );
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lebelphone=new JLabel("Phone ");
        lebelphone.setBounds(400,250,150,30);
        lebelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelphone);

        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lebelemail=new JLabel("Email ");
        lebelemail.setBounds(50,300,150,30);
        lebelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lebeleducation=new JLabel("Highest Education ");
        lebeleducation.setBounds(400,300,150,30);
        lebeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeleducation);


        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);

        JLabel lebeldesignation=new JLabel("Designation ");
        lebeldesignation.setBounds(50,350,150,30);
        lebeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(lebeldesignation);

        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel lebelaadhar=new JLabel("Aadhar Number ");
        lebelaadhar.setBounds(400,350,150,30);
        lebelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelaadhar);

            JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);

        JLabel lebelempId=new JLabel("Employee id ");
        lebelempId.setBounds(50,400,150,30);
        lebelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lebelempId);

        lblempId=new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);

        try{
            Conn c=new Conn();
            Connection c1=c.getC();
            String query="select * from employee where empId='"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){

                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update details");
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){


            String fname= tffname.getText();

            String salary=tfsalary.getText();
            String address = tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education =(String) tfeducation.getText();
            String designation =tfdesignation.getText();


            try{
                Conn conn=new Conn();
                Connection c1 = conn.getC();
                String query=" update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empId='"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Update Successfully");
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

        new UpdateEmployee("");
    }


}
