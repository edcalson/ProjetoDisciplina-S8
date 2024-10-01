package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valorImovel = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();
                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("O valor do imóvel deve ser positivo.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Insira um número válido.");
                scanner.next(); // Limpa o buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazoFinanciamento = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o prazo de financiamento (em anos): ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0) {
                    throw new IllegalArgumentException("O prazo de financiamento deve ser positivo.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Insira um número inteiro válido.");
                scanner.next(); // Limpa o buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return prazoFinanciamento;
    }

    public double pedirTaxaJurosAnual() {
        double taxaJurosAnual = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite a taxa de juros anual (em %): ");
                taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual <= 0) {
                    throw new IllegalArgumentException("A taxa de juros deve ser positiva.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Insira um número válido.");
                scanner.next(); // Limpa o buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return taxaJurosAnual;
    }
}
