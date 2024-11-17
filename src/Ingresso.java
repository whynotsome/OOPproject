import java.util.ArrayList;



public class Ingresso {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;
    public ArrayList<Ingresso> ingressos;
    
    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }
    
    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }
    
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
    public int getIdIngresso() {
        return idIngresso;
    }
    
    public SalaAssento getSalaAssento() {
        return salaAssento;
    }
    
    public Sessao getSessao() {
        return sessao;
    }
    
    public double getValorPago() {
        return valorPago;
    }
    
    public Ingresso(int idIngresso, double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
        this.ingressos = new ArrayList<>();
    }
    
    
    

}
