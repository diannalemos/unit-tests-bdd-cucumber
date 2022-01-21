Feature: Ticket
  Aprendendo cucumber

Scenario: Deve criar steps genéricos para estes passos
Given que o ticket é AF345
And que o valor da passagem é R$ 230,45
And que o nome do passageiro é "Fulano da Silva"
And que o telefone do passageiro é 9999-9999
When criar os steps
Then o teste vai funcionar

Scenario: Deve reaproveitar os steps "Dado" do cenário anterior
Given que o ticket é AB167
Given que o ticket especial é AB167
Given que o valor da passagem é R$ 1120,23
Given que o nome do passageiro é "Cicrano de Oliveira"
Given que o telefone do passageiro é 9888-8888

  @ignore
Scenario: Deve negar todos os steps "Dado" dos cenários anteriores
Given que o ticket é CD123
Given que o ticket é AG1234
Given que o valor da passagem é R$ 1.1345,56
Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
Given que o telefone do passageiro é 1234-5678
Given que o telefone do passageiro é 999-2223


