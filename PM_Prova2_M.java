/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pm_prova2_m;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author glbra
 */

public class PM_Prova2_M {

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        criarDadosIniciais(locadora);

        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opcao: ");
            switch (opcao) {
                case 1:
                    associarVeiculoAluguel(locadora);
                    break;
                case 2:
                    exibirVeiculos(locadora.getVeiculos());
                    break;
                case 3:
                    exibirAlugueis(locadora);
                    break;
                case 4:
                    exibirVeiculos(locadora.getVeiculosDisponiveis());
                    break;
                case 5:
                    avaliar(locadora);
                    break;
                case 6:
                    inspecionar(locadora);
                    break;
                case 7:
                    int qtd = locadora.removerVeiculosEmManutencao();
                    System.out.println(qtd + " veiculo(s) em manutencao removido(s).");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    private static void criarDadosIniciais(Locadora locadora) {
        locadora.cadastrarVeiculo(new Carro("ABCD123", "Onix", 2022, 150.0, 25000, StatusVeiculo.DISPONIVEL, 4));
        locadora.cadastrarVeiculo(new Moto("ASDF345", "Fan 180", 2023, 80.0, 8000, StatusVeiculo.DISPONIVEL, 160));
        locadora.cadastrarVeiculo(new Van("ZXCV124", "Escolar", 2021, 300.0, 60000, StatusVeiculo.MANUTENCAO, 15));

        locadora.cadastrarAluguel(new AluguelBasico("Eduardo Costa", 3, 0, StatusAluguel.ATIVO));
        locadora.cadastrarAluguel(new AluguelExecutivo("Daniel de Sunga", 5, 0, StatusAluguel.ATIVO));
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("LOCADORA DE VEICULOS");
        System.out.println("1 - Associar veiculos a um aluguel");
        System.out.println("2 - Exibir todos os veiculos");
        System.out.println("3 - Exibir todos os alugueis");
        System.out.println("4 - Exibir veiculos disponiveis");
        System.out.println("5 - Avaliar");
        System.out.println("6 - Realizar inspecao");
        System.out.println("7 - Remover veiculos em manutencao");
        System.out.println("0 - Sair");
    }

    private static void associarVeiculoAluguel(Locadora locadora) {
        List<Aluguel> alugueis = locadora.getAlugueis();
        List<Veiculo> disponiveis = locadora.getVeiculosDisponiveis();

        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponivel.");
            return;
        }

        System.out.println("Alugueis");
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel a = alugueis.get(i);
            System.out.println((i + 1) + " - " + a.getNomeCliente() + " (" + a.getStatus() + ")");
        }
        int ia = lerInt("Escolha o aluguel: ") - 1;
        if (ia < 0 || ia >= alugueis.size()) {
            System.out.println("Aluguel invalido.");
            return;
        }

        System.out.println("Veiculos disponiveis");
        for (int i = 0; i < disponiveis.size(); i++) {
            Veiculo v = disponiveis.get(i);
            System.out.println((i + 1) + " - " + v.getPlaca() + " | " + v.getModelo());
        }
        int iv = lerInt("Escolha o veiculo: ") - 1;
        if (iv < 0 || iv >= disponiveis.size()) {
            System.out.println("Veiculo invalido.");
            return;
        }

        if (locadora.associarVeiculo(alugueis.get(ia), disponiveis.get(iv))) {
            System.out.println("Veiculo associado com sucesso.");
        } else {
            System.out.println("Nao foi possivel associar (aluguel precisa estar ATIVO).");
        }
    }

    private static void exibirVeiculos(List<Veiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum veiculo para exibir.");
            return;
        }
        for (Veiculo v : lista) {
            v.exibirDetalhes();
        }
    }

    private static void exibirAlugueis(Locadora locadora) {
        if (locadora.getAlugueis().isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : locadora.getAlugueis()) {
            a.exibirDetalhes();
        }
    }

    private static void avaliar(Locadora locadora) {
        List<Avaliavel> lista = locadora.getAvaliaveis();
        if (lista.isEmpty()) {
            System.out.println("Nenhum item avaliavel.");
            return;
        }
        System.out.println("Itens avaliaveis");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print((i + 1) + " - ");
            Avaliavel item = lista.get(i);
            if (item instanceof Veiculo) {
                ((Veiculo) item).exibirDetalhes();
            } else if (item instanceof Aluguel) {
                System.out.println("Aluguel executivo de " + ((Aluguel) item).getNomeCliente());
            }
        }
        int idx = lerInt("Escolha o item: ") - 1;
        if (idx < 0 || idx >= lista.size()) {
            System.out.println("Item invalido.");
            return;
        }
        int nota = lerInt("Nota (1 a 5): ");
        lista.get(idx).avaliar(nota);
    }

    private static void inspecionar(Locadora locadora) {
        List<Veiculo> lista = locadora.getInspecionaveis();
        if (lista.isEmpty()) {
            System.out.println("Nenhum veiculo inspecionavel.");
            return;
        }
        System.out.println("Veiculos inspecionaveis");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print((i + 1) + " - ");
            lista.get(i).exibirDetalhes();
        }
        int idx = lerInt("Escolha o veiculo: ") - 1;
        if (idx < 0 || idx >= lista.size()) {
            System.out.println("Veiculo invalido.");
            return;
        }
        ((Inspecionavel) lista.get(idx)).realizarInspecao();
    }

    private static int lerInt(String mensagem) {
        System.out.print(mensagem);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

