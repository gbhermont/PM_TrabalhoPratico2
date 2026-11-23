package pm_prova2_m;

public class AluguelBasico extends Aluguel {

    private static final int LIMITE_KM_POR_DIA = 100;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    public int getLimiteKmTotal() {
        return LIMITE_KM_POR_DIA * getQuantidadeDias();
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[ALUGUEL BASICO]");
        exibirDadosBase();
        System.out.println("Limite: " + LIMITE_KM_POR_DIA + " km/dia (" + getLimiteKmTotal() + " km no total)");
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Nao"));
    }
}
