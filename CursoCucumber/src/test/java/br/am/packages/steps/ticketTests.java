package br.am.packages.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ticketTests {
    @Given("que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF345(String tipo, String arg1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("que o valor da passagem é R\\$ (\\d+),(\\d+)$")
    public void queOValorDaPassagemÉR$(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("criar os steps")
    public void criarOsSteps() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("o teste vai funcionar")
    public void oTesteVaiFuncionar() {
        // Write code here that turns the phrase above into concrete actions
    }

}