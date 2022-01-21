package br.am.packages.steps;

import br.am.packages.entidades.NotaAluguel;
import br.am.packages.entidades.Filme;
import br.am.packages.utils.DateUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import br.am.packages.servicos.AluguelService;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class locadoraTests {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;


    @Given("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);

    }
    @Given("que o preço de aluguel seja R$ {int}")
    public void queOPreçoDeAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }
    @When("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }
    @Then("o preço do aluguel será R$ {int}")
    public void oPreçoDoAluguelSeráR$(Integer int1) {
        // Assert.assertEquals(int1, nota.getPreco());
    }
    @Then("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }
    @Then("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {

        assertEquals(int1, filme.getEstoque());
    }
    @Then("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }
    @Given("que o tipo do aluguel seja extendido")
    public void queOTipoDoAluguelSejaExtendido() {
        tipoAluguel = "extendido";
    }
    @Then("a entrega será em {int} dias")
    public void aEntregaSeráEmDias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(3);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }
    @Then("a pontuação recebida será de {int} pontos")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
        if (int1 == nota.getPontuacao()) {
            System.out.println("passou");
        }
    }

    //terceiro cenario
    Date entrega = new Date();

    @Given("que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
    public void que_a_entrega_é_dia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes -1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }
    @When("a entrega atrasar em (\\d+) dias$")
    public void a_entrega_atrasar_em_dias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }
    @Then("a entrega será efetuada em (\\d{2})/(\\d{2})/(\\d{4})$")
    public void a_entrega_será_efetuada_em(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes -1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(entrega, dataFormatada);
    }
}
