package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int totalNotas;
    private int quantidadeAvaliacoes;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
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
        System.out.println("Carro " + getPlaca() + " avaliado com nota " + nota
                + ". Media atual: " + getMediaAvaliacoes());
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[CARRO] Placa: " + getPlaca() + " / Modelo: " + getModelo()
                + " / Ano: " + getAnoFabricacao() + " / Diaria: R$ " + getValorDiaria()
                + " / Km: " + getQuilometragem() + " / Status: " + getStatus()
                + " / Portas: " + quantidadePortas
                + " / Avaliacao media: " + getMediaAvaliacoes());
    }
}
