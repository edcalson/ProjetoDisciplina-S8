package util;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorArquivo {

    // Método para salvar os dados em um arquivo de texto
    public static void salvarDadosTexto(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                if (financiamento instanceof Casa) {
                    Casa casa = (Casa) financiamento;
                    writer.write(String.format("Casa;%.2f;%.2f;%.2f;%d;%.2f;%.2f%n",
                            casa.getValorImovel(),
                            casa.calcularTotalPagamento(),
                            casa.getTaxaJurosAnual(),
                            casa.getPrazoFinanciamento(),
                            casa.getTamanhoAreaConstruida(),
                            casa.getTamanhoTerreno()));
                } else if (financiamento instanceof Apartamento) {
                    Apartamento apto = (Apartamento) financiamento;
                    writer.write(String.format("Apartamento;%.2f;%.2f;%.2f;%d;%d;%d%n",
                            apto.getValorImovel(),
                            apto.calcularTotalPagamento(),
                            apto.getTaxaJurosAnual(),
                            apto.getPrazoFinanciamento(),
                            apto.getNumeroVagasGaragem(),
                            apto.getNumeroAndar()));
                } else if (financiamento instanceof Terreno) {
                    Terreno terreno = (Terreno) financiamento;
                    writer.write(String.format("Terreno;%.2f;%.2f;%.2f;%d;%s%n",
                            terreno.getValorImovel(),
                            terreno.calcularTotalPagamento(),
                            terreno.getTaxaJurosAnual(),
                            terreno.getPrazoFinanciamento(),
                            terreno.getTipoZona()));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // Método para ler os dados do arquivo de texto
    public static void lerDadosTexto(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

