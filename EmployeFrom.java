package com.forms;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bds.DBService;
import com.pojo.Employe;

public class EmployeFrom extends JFrame implements ActionListener {

	

		//private static final String Integer = null;
		JLabel l1,l2,l3;
		JTextField t1,t2,t3;
		JButton  b1,b2,b3,b4,b5,b6,b7;
		
		public EmployeFrom() {
			l1=new JLabel("Employe Id");
			
			
			l2=new JLabel("Employe Name");
			
			
			
			l3=new JLabel("Employe age");
			
			t1=new JTextField(15);
			t2=new JTextField(15);
			t3=new JTextField(15);

			b1=new JButton("Add");
			b2=new JButton("Update");
			b3=new JButton("Delete");
			b4=new JButton("Search");
			b5=new JButton("List of Employe");
			b6=new JButton("Reset");
			b7=new JButton("Close");

			add(l1);
			add(t1);
			add(l2);
			add(t2);
			add(l3);
			add(t3);
			
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
			add(b7);
			
			
			setSize(400,300);
			setTitle("Employe From");
			setLayout(new FlowLayout());
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			b7.addActionListener(this);
		}
		
	 public void actionPerformed(ActionEvent e) {
        Employe pd = new Employe();
        try {
            pd.setId(Integer.parseInt(t1.getText()));
        } catch (Exception e2) {
            pd.setName(t2.getText());
        }
        pd.setName(t2.getText());
        try {
            pd.setAge(Integer.parseInt(t3.getText()));
        } catch (Exception e2) {}

        DBService db = new DBService();

        if (e.getSource() == b1) {
            if (db.addEmploye(pd)) {
                t2.setText("Record Inserted");
            } else {
                t2.setText("Record not Inserted");
            }
        }

        if (e.getSource() == b2) {
            if (db.updateEmploye(pd)) {
                t2.setText("Record Updated");
            } else {
                t2.setText("Record not Updated");
            }
        }

        if (e.getSource() == b3) {
            if (db.deleteEmploye(pd)) {
                t2.setText("Record Deleted");
            } else {
                t2.setText("Record not Deleted");
            }
        }

        if (e.getSource() == b4) {
            Employe p = db.getEmploye(pd);
            if (p != null) {
                t1.setText(String.valueOf(p.getId()));
                t2.setText(p.getName());
                t3.setText(String.valueOf(p.getAge()));
            } else {
                t2.setText("Record not found");
            }
        }

        if (e.getSource() == b5) {
        	ListOfEmploye lsp = new ListOfEmploye();
            lsp.setVisible(true);
        }

        if (e.getSource() == b6) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }

        if (e.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        EmployeFrom pf = new EmployeFrom();
        pf.setLocation(400, 500);
        pf.setVisible(true);
    }
}

