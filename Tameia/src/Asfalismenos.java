public abstract class Asfalismenos {

    private String eponimo;
    private String AFM;
    protected double pososto;

    public Asfalismenos(String eponimo, String AFM, double pososto) {
        this.eponimo = eponimo;
        this.AFM = AFM;
        this.pososto = pososto;
    }

    public String getEponimo() {
        return eponimo;
    }

    public abstract double calcIncome();
}
