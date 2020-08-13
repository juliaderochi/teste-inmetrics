Feature: Cadastrar usuario
  Cadastrar um novo usuario no site "inmrobo" para poder acessar o sistema

  @cadastrarUsuario
  Scenario Outline: Cadastrar Usuario
    Given Eu acesso o site inmrobo
    And clico na opção Cadastre-se para acessar a tela de cadastro
    When informo o campo para o "<usuario>"
    And informo o campo para a "<senha>"
    And informo o campo "<confirme>" a senha
    And clico no botão cadastrar
    Then o usuario é criado com sucesso

   Examples:
      | usuario | senha    | confirme  |
      | julia   | teste123 | teste123  |
