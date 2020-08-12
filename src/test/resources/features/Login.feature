@tag
Feature: Realizar login no sistema
  Realizar o login com um usuario já cadastrado

  @tag1
  Scenario Outline: Login no sistema
    Given Eu acesso o site inmrobo
    When informo o "<usuario>"
    And informo a "<senha>"
    And clico no botao Entre
    Then o usuario logou no sistema corretamente

    Examples: 
      | usuario  | senha |
      | name2    |     7 |
