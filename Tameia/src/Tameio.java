import java.util.ArrayList;

public class Tameio {

	private String titlos;
	private String edra;
	//dhlwnw kai ftiaxnw ena arraylist opoy to tameio kserei tous asfalismenous tou
	//etsi mporw se ayto to arraylist  na valw ergazomenous kathws kai syntaxsiouxous
	private ArrayList<Asfalismenos> asfalismenoi= new ArrayList<>();
	
	public Tameio(String text1, String text2) {
		titlos = text1;
		edra = text2;
	}
	
	public String getTitlos() {
		return titlos;
	}

	//einai mia methodos h opoia tha pernei enan asflismeno kai tha ton kataxwreis thn lista
	public void addAsfalismenos(Asfalismenos asfalismenos)
	{
		asfalismenoi.add(asfalismenos);
	}
//methodos pou tah typwnei ola ta stoixeia tvn asfalismenwn
	public  void printInfo()
	{
		for (Asfalismenos asfalismenos:asfalismenoi) {
			//polymorfikh methodos vriskei to antikeimeno an einai ergazomenos h syntaksiouxos kai typwnei katallhla
			System.out.println("Onoma: "+asfalismenos.getEponimo()+" apodoxes: "+asfalismenos.calcIncome());

		}
	}
}
