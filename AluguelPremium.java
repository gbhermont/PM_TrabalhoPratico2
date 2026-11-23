package pm_prova2_m;

public class AluguelPremium extends Aluguel {

    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[ALUGUEL PREMIUM]");
        exibirDadosBase();
        System.out.println("Quilometragem: ilimitada");
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Nao"));
    }
}

