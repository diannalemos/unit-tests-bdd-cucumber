package br.am.packages.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContadorTests {

    int sum = 0;

    @Given("que o valor do contador é (\\d+)$")
    public void que_o_valor_do_contador_é(int int1) {
        sum = int1;
    }
    @When("eu incrementar em (\\d+)$")
    public void eu_incrementar_em(int int1) {
        sum = sum + int1;
    }
    @Then("o valor do contador será (\\d+)$")
    public void o_valor_do_contador_será(int int1) {
        Assert.assertEquals (sum, int1);
    }
}


