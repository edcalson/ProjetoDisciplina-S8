package util;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorSerializacao {

    // Método para serializar o ArrayList de financiamentos
    public static void salvarArrayListSerializado(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo serializado: " + e.getMessage());
        }
    }

    // Método para ler o ArrayList serializado
    public static ArrayList<Financiamento> lerArrayListSerializado(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo serializado: " + e.getMessage());
        }
        return null;
    }
}

