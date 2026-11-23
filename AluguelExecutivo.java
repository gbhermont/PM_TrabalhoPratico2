package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private int totalNotas;
    private int quantidadeAvaliacoes;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    public double getMediaAvaliacoes() {
        return quantidadeAvaliacoes == 0 ? 0 : (double) totalNotas / quantidadeAvaliacoes;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota invalida. Use um valor de 1 a 5.");
            return;
        }
        totalNotas += nota;
        quantidadeAvaliacoes++;
        System.out.println("Aluguel executivo de " + getNomeCliente() + " avaliado com nota " + nota
                + ". Media atual: " + String.format("%.2f", getMediaAvaliacoes()));
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[ALUGUEL EXECUTIVO]");
        exibirDadosBase();
        System.out.println("Quilometragem: ilimitada");
        System.out.println("Motorista particular: Sim");
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Nao"));
        System.out.println("Avaliacao media: " + getMediaAvaliacoes());
    }
}

