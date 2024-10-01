package modelo;

public abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento; // em anos
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Método comum para mostrar informações do financiamento
    public void mostrarResumo() {
        System.out.printf("Valor do imóvel: R$ %.2f, Prazo: %d anos, Juros anual: %.2f%%\n",
                valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // Método abstrato para calcular o pagamento mensal (implementado nas subclasses)
    public abstract double calcularPagamentoMensal();

    // Método abstrato para calcular o total do pagamento (implementado nas subclasses)
    public abstract double calcularTotalPagamento();
}
