package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int totalNotas;
    private int quantidadeAvaliacoes;
    private int quantidadeInspecoes;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public double getMediaAvaliacoes() {
        return quantidadeAvaliacoes == 0 ? 0 : (double) totalNotas / quantidadeAvaliacoes;
    }

    public int getQuantidadeInspecoes() {
        return quantidadeInspecoes;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota invalida. Use um valor de 1 a 5.");
            return;
        }
        totalNotas += nota;
        quantidadeAvaliacoes++;
        System.out.println("Van " + getPlaca() + " avaliada com nota " + nota
                + ". Media atual: " + getMediaAvaliacoes());
    }

    @Override
    public void realizarInspecao() {
        quantidadeInspecoes++;
        System.out.println("Inspecao realizada na van " + getPlaca()
                + ". Total de inspecoes: " + quantidadeInspecoes);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[VAN] Placa: " + getPlaca() + " / Modelo: " + getModelo()
                + " / Ano: " + getAnoFabricacao() + " / Diaria: R$ " + getValorDiaria()
                + " / Km: " + getQuilometragem() + " / Status: " + getStatus()
                + " / Max. passageiros: " + maxPassageiros
                + " / Avaliacao media: " + getMediaAvaliacoes()
                + " / Inspecoes: " + quantidadeInspecoes);
    }
}
