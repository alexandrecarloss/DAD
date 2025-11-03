package ui;

import entity.Cidade;
import entity.Estado;
import service.PopulacaoService;

import java.util.List;
import java.util.Scanner;

public class PopulacaoUI {
    private PopulacaoService populacaoService;
    private Scanner scanner;

    public PopulacaoUI() {
        this.populacaoService = new PopulacaoService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=== SISTEMA DE CONSULTA POPULACIONAL DO BRASIL ===");

        while (true) {
            try {
                Estado estado = selecionarEstado();
                if (estado == null) break;

                Cidade cidade = selecionarCidade(estado);

                if (cidade != null) {
                    populacaoService.exibirDadosPopulacionais(cidade);
                } else {
                    populacaoService.exibirDadosPopulacionais(estado);
                }

                System.out.print("\nDeseja fazer outra consulta? (S/N): ");
                String continuar = scanner.nextLine();
                if (!continuar.equalsIgnoreCase("S")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        populacaoService.fechar();
        System.out.println("Sistema encerrado. Obrigado!");
    }

    private Estado selecionarEstado() {
        List<Estado> estados = populacaoService.listarEstados();

        if (estados.isEmpty()) {
            System.out.println("Nenhum estado cadastrado no sistema.");
            return null;
        }

        System.out.println("\n=== SELECIONE UM ESTADO ===");
        for (int i = 0; i < estados.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, estados.get(i));
        }
        System.out.println("0. Sair");

        System.out.print("Escolha o número do estado: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 0) return null;
        if (opcao < 1 || opcao > estados.size()) {
            System.out.println("Opção inválida!");
            return selecionarEstado();
        }

        return estados.get(opcao - 1);
    }

    private Cidade selecionarCidade(Estado estado) {
        List<Cidade> cidades = populacaoService.listarCidadesPorEstado(estado.getId());

        System.out.println("\n=== SELECIONE UMA CIDADE DO " + estado.getUf() + " ===");
        System.out.println("1. Consultar todo o estado");

        for (int i = 0; i < cidades.size(); i++) {
            System.out.printf("%d. %s%n", i + 2, cidades.get(i));
        }

        System.out.print("Escolha a opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            return null; // Retorna null para indicar consulta do estado todo
        }
        if (opcao < 2 || opcao > cidades.size() + 1) {
            System.out.println("Opção inválida!");
            return selecionarCidade(estado);
        }

        return cidades.get(opcao - 2);
    }

    public static void main(String[] args) {
        new PopulacaoUI().iniciar();
    }
}