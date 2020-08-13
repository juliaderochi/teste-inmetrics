@login
Feature: Realizar login no sistema
  Realizar o login com um usuario já cadastrado

  @loginComUsuarioJaCadastrado
  Scenario Outline: Login no sistema
    Given Eu acesso o site inmrobo
    And tenha um usuario já cadastrado
    When informo o "<usuario>"
    And informo a "<senha>"
    And clico no botao Entre
    Then o usuario logou no sistema corretamente

    Examples: 
      | usuario  | senha |
      | juliader | 12345 |
