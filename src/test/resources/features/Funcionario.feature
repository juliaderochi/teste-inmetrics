@funcionario
Feature: Cadastro de funcionario
  Realizar cadastro, edição e exclusão de um funcionario
  
  Background:
    Given tenha um usuario já cadastrado
    When informo o "juliader"
    And informo a "12345"
    And clico no botao Entre
    And o usuario logou no sistema corretamente

  @cadastrarFuncionario
  Scenario Outline: Cadastrar Funcionario
    Given que o usuario clique em Novo Funcionario
    When informar o nome "<nome>"
    And informar o cargo "<cargo>"
    And informar o CPF
    And informar o salario "<salario>"
    And informar o sexo "<sexo>"
    And informar o Tipo de Contratacao "<tipoContratacao>"
    And informar a Data Adimissão "<dataAdimissao>"
    And clica em enviar
    Then demostra a mensagem "<mensagem>"
    
    Examples: 
      | nome        | cargo 								| salario | sexo     | tipoContratacao | dataAdimissao | mensagem 															|
      | Julia Zinco | Analista de Automacao | 1000000 | Feminino | CLT						 | 01012020      |SUCESSO! Usuário cadastrado com sucesso |
       

  @editarFuncionario
  Scenario Outline: Editar Funcionario
    Given já exista um usuario cadastrado com o nome "<nome>"
    And o usuario digite o nome do funcionario "<nome>" na pesquisa
    When aparece na listagem o funcionario "<nome>"
    Then clica no botao para editar
    And informar o nome "<nomeEdicao>"
    And clica em enviar
    Then demostra a mensagem "<mensagem>"

    Examples: 
      | nome        | nomeEdicao    | mensagem 																     |
      | Julia Zinco | Julia de Rochi| SUCESSO! Informações atualizadas com sucesso |
       

  @deletarFuncionario
  Scenario Outline: Deletar funcionario
    Given já exista um usuario cadastrado com o nome "<nome>"
    And o usuario digite o nome do funcionario "<nome>" na pesquisa
    When aparece na listagem o funcionario "<nome>"
    Then clica no botao para deletar
    Then demostra a mensagem "<mensagem>"

    Examples: 
      | nome         | mensagem                                  |
    	| Julia Zinco  | SUCESSO! Funcionário removido com sucesso |
    
