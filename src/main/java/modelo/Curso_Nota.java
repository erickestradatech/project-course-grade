package modelo;

public class Curso_Nota {

    private String codc;
    private String nomc;
    private int ep;
    private int ef;

    public double prome() {

        return (ep + ef) / 2;
    }

    public String obser() {

        return prome() >= 12 ? "Aprobado" : "Desaprobado";
    }

    public String getCodc() {
        return codc;
    }

    public void setCodc(String codc) {
        this.codc = codc;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getEf() {
        return ef;
    }

    public void setEf(int ef) {
        this.ef = ef;
    }

}
