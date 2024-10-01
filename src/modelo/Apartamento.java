package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12;
        int meses = getPrazoFinanciamento() * 12;
        return (getValorImovel() * Math.pow((1 + taxaMensal), meses)) / (Math.pow((1 + taxaMensal), meses) - 1);
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    @Override
    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Vagas na garagem: %d, Andar: %d\n", vagasGaragem, numeroAndar);
    }

    public Object getNumeroVagasGaragem() {
        return null;
    }

    public Object getNumeroAndar() {
        return null;
    }
}
