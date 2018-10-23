import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InputForm extends JFrame {

	private ArrayList<Tameio> tameia;
	private JPanel panel;
	private JList list;
	
	private JButton kataxwrisi;
	private JButton ektypwsi;
	private JTextField eponimoField;
	private JTextField AFMField;
	private JTextField posostoField;
	private JTextField eisodhmaField;
	private JTextField childrenField;
	//ftiaxnw dyo radio button  wste na epilegei o xeirisths ti einai o kathenas
	private JRadioButton ergazomenosRadio = new JRadioButton("misthotos");
	private JRadioButton syntaxRadio = new JRadioButton("syntax");
	
	public InputForm(ArrayList<Tameio> tameia) {
		
		this.tameia = tameia;
		
		panel = new JPanel();
		
		DefaultListModel model = new DefaultListModel();
		for(Tameio t: tameia) {
			model.addElement(t.getTitlos());
		}
		
		list = new JList(model);
		
		kataxwrisi = new JButton("Καταχώρηση");
		ektypwsi = new JButton("Εκτύπωση");

		eponimoField = new JTextField("Επώνυμο");
		AFMField= new JTextField("ΑΦΜ");
		posostoField = new JTextField("Ποσοστό:0.0-0.99");
		eisodhmaField = new JTextField("Εισόδημα");
		childrenField = new JTextField("Παιδιά");
		ergazomenosRadio = new JRadioButton("Μισθωτός");
		syntaxRadio = new JRadioButton("Συνταξιούχος");

		//prosthetw ta antikeimena sto panel
		panel.add(list);
		panel.add(kataxwrisi);
		panel.add(ektypwsi);
		panel.add(eponimoField);
		panel.add(AFMField);
		panel.add(posostoField);
		panel.add(eisodhmaField);
		panel.add(childrenField);
		panel.add(ergazomenosRadio);
		panel.add(syntaxRadio);

		//topothethsh tou panel sthn forma
		this.setContentPane(panel);

		//ftiaxnw enan akroath
		buttonListener listener = new buttonListener();

		//syndeoume ton akroath me thn phgh twn symvantwn
		kataxwrisi.addActionListener(listener);

		//kataxwroume ton akroath kai me to koumpi ektypwsi
		ektypwsi.addActionListener(listener);

		//kathorizei to megethos ths formas
		this.setSize(500, 500);

		//thn kanei thn forma orath
		this.setVisible(true);

		//vazei onoma sthn morfa
		this.setTitle("Input Form");

		//an pathsei x sthn forma klinei to rogramma
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//ftiaxnoume klash akroath
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			//pernoume ayto pou pliktrologhse
			String eponimo = eponimoField.getText();
			String afm= AFMField.getText();
			String posostostring= posostoField.getText();

			double pososto = Double.parseDouble(posostostring);

			//pernw ayto pou epelekse o xrhsths kai to kanw cast se string
			String selectedtameiotext= (String)list.getSelectedValue();

			Tameio selectedTameio = null;
			//sthn synexeia tha treksw thn lista kai tha vrw poio antikeimeno exei idio onoma me to selectedtameiotext
			for (Tameio tameio :tameia) {

				if(tameio.getTitlos().equals(selectedtameiotext)){
					//an einai idio kataxwreitai sthn metavlhth
					selectedTameio= tameio;
				}
			}

			//rwtaw twra poia einai h phgh tou
			//pusiastika telw na mathw ana patithike to pliktro ektypwsh
			if(e.getSource().equals(kataxwrisi)) {

				//elegxw an o to radiobutton einai selected
				if (ergazomenosRadio.isSelected()) {

					String eisodhmaText = eisodhmaField.getText();
					double eisodhma = Double.parseDouble(eisodhmaText);

					String childrenText = childrenField.getText();
					int children = Integer.parseInt(childrenText);

					//kai twra ftiaxnoume enan ergazomeno
					Ergazomenos er1 = new Ergazomenos(eponimo, afm, pososto, eisodhma, children);

					//twra tha kataxwrhsw ton asfalismeno

					selectedTameio.addAsfalismenos(er1);

				} else {

					String syntaksiText = eisodhmaField.getText();
					double syntaksi = Double.parseDouble(syntaksiText);

					//twra ftiaxnoume enan syntaksiouxo
					Syntaksiouxos newsyntaksiouxos = new Syntaksiouxos(eponimo, afm, pososto, syntaksi);

					//kataxwrw sthn lista ton asfalismeno
					selectedTameio.addAsfalismenos(newsyntaksiouxos);
				}
			}
			else
			{
				//an patithei to koumpi ektypwsei tote tah ektypwsei
				selectedTameio.printInfo();
			}

		}
	}

}
