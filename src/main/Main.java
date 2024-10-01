package main;

import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Financiamento;
import util.GerenciadorArquivo;
import util.GerenciadorSerializacao;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Exemplo de inserção de financiamentos
        Financiamento casa1 = new Casa(300000, 20, 8.5, 150.0, 250.0);
        Financiamento apto1 = new Apartamento(400000, 15, 7.5, 2, 5);
        Financiamento terreno1 = new Terreno(200000, 10, 6.0, "Residencial");

        financiamentos.add(casa1);
        financiamentos.add(apto1);
        financiamentos.add(terreno1);

        // Caminho para o arquivo de texto e serializado
        String arquivoTexto = "financiamentos.txt";
        String arquivoSerializado = "financiamentos.ser";

        // 1. Salvando dados em arquivo de texto
        GerenciadorArquivo.salvarDadosTexto(financiamentos, arquivoTexto);

        // 2. Lendo dados do arquivo de texto
        System.out.println("Dados salvos no arquivo de texto:");
        GerenciadorArquivo.lerDadosTexto(arquivoTexto);

        // 3. Salvando ArrayList serializado
        GerenciadorSerializacao.salvarArrayListSerializado(financiamentos, arquivoSerializado);

        // 4. Lendo ArrayList serializado
        ArrayList<Financiamento> financiamentosLidos = GerenciadorSerializacao.lerArrayListSerializado(arquivoSerializado);

        if (financiamentosLidos != null) {
            System.out.println("\nDados lidos do arquivo serializado:");
            for (Financiamento financiamento : financiamentosLidos) {
                financiamento.mostrarResumo();
            }
        }
    }
}
