package modelo;

public class Terreno extends Financiamento {
    private String tipoZona; // residencial ou comercial

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
        return pagamentoBase * 1.02; // Acréscimo de 2%
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    @Override
    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Tipo de zona: %s\n", tipoZona);
    }

    public Object getTipoZona() {
        return null;
    }
}
