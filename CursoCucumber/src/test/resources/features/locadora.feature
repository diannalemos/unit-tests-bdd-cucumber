Feature: Alugar filme
  Alugar filme em uma locadora com sucesso

Scenario: Alugar filme com sucesso
  Given um filme com estoque de 2 unidades
  And que o preço de aluguel seja R$ 3
  When alugar
  Then o preço do aluguel será R$ 3
  And a data de entrega será no dia seguinte
  And o estoque do filme será 1 unidade

Scenario: Não deve alugar filme sem estoque
  Given um filme com estoque de 0 unidades
  When alugar
  Then não será possível por falta de estoque
  And o estoque do filme será 0 unidade

Scenario: Deve dar condições especiais para categoria extendida
  Given um filme com estoque de 2 unidades
  And que o preço de aluguel seja R$ 4
  And que o tipo do aluguel seja extendido
  When alugar
  Then o preço do aluguel será R$ 8
  And a entrega será em 3 dias
  And a pontuação recebida será de 2 pontos

@ignore
  Scenario: Deve calcular atraso na entrega
    Given que a entrega é dia 05/04/2018
    When a entrega atrasar em 2 dias
    Then a entrega será efetuada em 07/04/2018