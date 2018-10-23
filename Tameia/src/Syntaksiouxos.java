public class Syntaksiouxos extends  Asfalismenos {
    private double syntaxi;

    public Syntaksiouxos(String eponimo, String AFM, double pososto, double syntaxi) {
        super(eponimo, AFM, pososto);
        this.syntaxi = syntaxi;
    }

    public double calcIncome() {
        return syntaxi*(1-pososto);
    }
}
