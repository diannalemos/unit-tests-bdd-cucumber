package br.am.packages.servicos;

import br.am.packages.entidades.NotaAluguel;
import br.am.packages.entidades.Filme;
import br.am.packages.utils.DateUtils;


public class AluguelService {
    public NotaAluguel alugar (Filme filme, String tipoAluguel){
        if (filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");
        NotaAluguel nota = new NotaAluguel();
        if ("extendido".equals(tipoAluguel)){
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
            nota.setPontuacao(2);
        } else {
            nota.setPreco(filme.getAluguel());
            nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }

}
