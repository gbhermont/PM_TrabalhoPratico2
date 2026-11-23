package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {

    private int cilindrada;
    private int quantidadeInspecoes;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int cilindrada) 
        {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getQuantidadeInspecoes() {
        return quantidadeInspecoes;
    }

    @Override
    public void realizarInspecao() {
        quantidadeInspecoes++;
        System.out.println("Inspecao realizada na moto " + getPlaca()
                + ". Total de inspecoes: " + quantidadeInspecoes);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[MOTO] Placa: " + getPlaca() + " / Modelo: " + getModelo()
                + " / Ano: " + getAnoFabricacao() + " / Diaria: R$ " + getValorDiaria()
                + " / Km: " + getQuilometragem() + " / Status: " + getStatus()
                + " / Cilindrada: " + cilindrada + "cc"
                + " / Inspecoes: " + quantidadeInspecoes);
    }
}

