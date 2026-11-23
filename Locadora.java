package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class Locadora {

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public List<Veiculo> getVeiculosDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                disponiveis.add(v);
            }
        }
        return disponiveis;
    }

    public List<Avaliavel> getAvaliaveis() {
        List<Avaliavel> lista = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Avaliavel) {
                lista.add((Avaliavel) v);
            }
        }
        for (Aluguel a : alugueis) {
            if (a instanceof Avaliavel) {
                lista.add((Avaliavel) a);
            }
        }
        return lista;
    }

    public List<Veiculo> getInspecionaveis() {
        List<Veiculo> lista = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel) {
                lista.add(v);
            }
        }
        return lista;
    }

    public boolean associarVeiculo(Aluguel aluguel, Veiculo veiculo) {
        if (aluguel.getStatus() != StatusAluguel.ATIVO) {
            return false;
        }
        if (veiculo.getStatus() != StatusVeiculo.DISPONIVEL) {
            return false;
        }
        aluguel.adicionarVeiculo(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        return true;
    }

    public int removerVeiculosEmManutencao() {
        List<Veiculo> removidos = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                removidos.add(v);
            }
        }
        for (Veiculo v : removidos) {
            for (Aluguel a : alugueis) {
                a.removerVeiculo(v);
            }
            veiculos.remove(v);
        }
        return removidos.size();
    }
}

