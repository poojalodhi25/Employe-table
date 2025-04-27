package com.forms;

import java.awt.BorderLayout;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.bds.DBService;
import com.pojo.Employe;

public class ListOfEmploye extends JDialog {
	DefaultTableModel
	model;
	JTable jt;
	public ListOfEmploye () {
		Vector v= new Vector<>();
		v.add("S.no");
		v.add("Employe-Id");
		v.add("Employe-Name");
		v.add("Employe-age");
		
		model=new DefaultTableModel(new Vector(),v);
		jt=new JTable(model);
		DBService db= new DBService();
		ArrayList<Employe> lst=db.getAllEmploye();
		for(int i=0; i<lst.size(); i++) {
			Employe e=lst.get(i);
			Vector v1= new Vector();
			v1.addElement(i+1);
			v1.addElement(e.getId());
			v1.addElement(e.getName());
			v1.addElement(e.getAge());
			model.addRow(v1);

		}
		setLayout(new BorderLayout());
		setSize(600,300);
		JPanel pn= new JPanel();
		JScrollPane scroll= new JScrollPane(jt,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pn.add(scroll);
		add(pn,BorderLayout.CENTER);
		
	}

}
