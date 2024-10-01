package modelo;

public class Casa extends Financiamento {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
        return pagamentoBase + 80; // R$ 80 de seguro obrigatório
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public double aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double jurosMensal = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (getTaxaJurosAnual() / 12);

        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("O desconto é maior do que o valor dos juros.");
        }

        return calcularPagamentoMensal() - desconto;
    }

    @Override
    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Área construída: %.2f m², Tamanho do terreno: %.2f m²\n", tamanhoAreaConstruida, tamanhoTerreno);
    }

    public Object getTamanhoAreaConstruida() {
        return null;
    }

    public Object getTamanhoTerreno() {
        return null;
    }
}
