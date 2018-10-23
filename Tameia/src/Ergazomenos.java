public class Ergazomenos extends  Asfalismenos {
    private double apodoxes;
    private int children;

    public Ergazomenos(String eponimo, String AFM, double pososto, double apodoxes, int children) {
        super(eponimo, AFM, pososto);
        this.apodoxes = apodoxes;
        this.children = children;
    }
    public double calcIncome() {
        return (apodoxes*(1-pososto)+children*100);
    }
}
