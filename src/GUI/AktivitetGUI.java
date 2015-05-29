package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Domain.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class AktivitetGUI extends MainGUI implements ActionListener
{
	private JButton btn_opret = new JButton("OPRET");	
	
	private JTable table;
	private ClosedCellTableModel model = new ClosedCellTableModel();
	private TableRowSorter<TableModel> rowSorter;
	

	private String navn;

	private String pris;

	private String antal;

	private String dato;

	private LabelTextfield navnBox;

	private LabelTextfield prisBox;

	private LabelTextfield deltagerantalBox;

	private LabelTextfield datoBox;
	
	public AktivitetGUI()
	{
		
		//JPanel Labels
		JPanel content1 = new JPanel(new GridLayout(10, 0));
		
		//Navne ud for textfield
		String[] labelTekster = {"navn:", "pris:", "deltagerantal:", "dato:"};
		
		//adder navn og tekstfield til vinduet
		this.navnBox = new LabelTextfield(labelTekster[0]);
		String navn = navnBox.getInputText();
		content1.add(navnBox);
		
		this.prisBox = new LabelTextfield(labelTekster[1]);
		String pris = prisBox.getInputText();
		content1.add(prisBox);
		
		this.deltagerantalBox = new LabelTextfield(labelTekster[2]);
		String deltagerantal = deltagerantalBox.getInputText();
		content1.add(deltagerantalBox);
		
		//speciel desginet dato api kommer
		this.datoBox = new LabelTextfield(labelTekster[3]);
		String dato = datoBox.getInputText();
		content1.add(datoBox);
		
		
		
		Panel_Content.add(content1);
		content1.setBackground(Color.WHITE);
		btn_aktivitet.setBackground(Color.GRAY);
		
		btn_opret.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_opret.addActionListener(this);
		content1.add(btn_opret);
		
		        // Jtable
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 250, 200); // x, y, width, height
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setRowHeight(20);
				table.setFillsViewportHeight(true);
				table.setModel(model);
				Panel_Content.add(scrollPane);
				rowSorter = new TableRowSorter<>((table.getModel()));
				table.setRowSorter(rowSorter);

				rowSorter = new TableRowSorter<>((table.getModel()));
				table.setRowSorter(rowSorter);
			    
				updateJTable();
		
		
	}//constructor slutter

	public void updateJTable() {
		ArrayList<Aktivitet> aktiviteter  = new Control().hentAktiviteter();
		// add the column names
		model.setColumnIdentifiers(new String[] { "id", "navn", "pris", "alder", "dato"});

		// Foreach loop to loop through the ArrayList. One row (person) at a
		// time
		for (Aktivitet aktivitet : aktiviteter) {
			model.addRow(new Object[]
					{
					
					aktivitet.getid(), aktivitet.getNavn(), aktivitet.getPris(), aktivitet.getAntal(), aktivitet.getDato() 
					
					
					
					});	
		}
			
		

		//til patrick
		//for (Medlem medlem : medlemmer){
		//arrayList.add(medlem.getFornavn();
		//}

		//JCombobox aktivitetsMedlemmer(arrayList);
		// add the DefaultTableModel to the JTable
		
	}
	
	
	
	public void clearAll() {
		navnBox.setText(null);
		prisBox.setText(null);
		deltagerantalBox.setText(null);
		datoBox.setText(null);
		
	}


	public boolean validateInput() {
		if 		(  !navnBox.getInputText().equals("")
				&& !prisBox.getInputText().equals("")
				&& !deltagerantalBox.getInputText().equals("")
				&& !datoBox.getInputText().equals(""))
				 {
			return true;
		} else {
			return false;
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_opret)
		{
			
			navn = navnBox.getInputText();
			pris = prisBox.getInputText();
			antal = deltagerantalBox.getInputText();
			dato = datoBox.getInputText();
			
			if(validateInput()){
			
				
				
				Aktivitet aktivitet = new Aktivitet(0, navn, pris, antal, dato);
				new Control().opretAktivitet(aktivitet);
				JOptionPane.showMessageDialog(frame,"Aktivitet oprettet!");

				clearAll();
			}
			
			else{
				JOptionPane.showMessageDialog(frame,"Et eller flere felter er ikke blevet udfyldt. Udfyld alle felter, og pr�v igen.");
			}
			
				
            new AktivitetGUI();
			
			frame.dispose();
									
			}		
			
			
		
		
		if(e.getSource() == btn_aktivitet)
		{
			new AktivitetGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_medlem )
		{
			new MedlemGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_saldo){
			new SaldoGUI();

			frame.dispose();
		}

		if(e.getSource() == btn_medlem )
		{
			new MedlemGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_saldo){
			new SaldoGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_barbog )
		{
			new BarBogGUI();
			frame.dispose();
		}		

	}//actionperformed sluter
	
}//public class medlem_GUI slutter


