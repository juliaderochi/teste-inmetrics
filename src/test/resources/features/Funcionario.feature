@funcionario
Feature: Cadastro de funcionario
  Realizar cadastro, edição e exclusão de um funcionario
  
  Background:
    Given Eu acesso o site inmrobo
    And tenha um usuario já cadastrado
    When informo o "juliader"
    And informo a "12345"
    And clico no botao Entre
    And o usuario logou no sistema corretamente

  @cadastrarFuncionario
  Scenario Outline: Login no sistema
    Given que o usuario clique em Novo Funcionario
    When informar o nome "<nome>"
    And informar o cargo "<cargo>"
    And informar o CPF "<CPF>"
    And informar o salario "<salario>"
    And informar o sexo "<sexo>"
    And informar o Tipo de Contratacao "<tipoContratacao>"
    And informar a Data Adimissão "<dataAdimissao>"
    And clica em enviar
    When demostra a mensagem de Sucesso 
    
    Examples: 
      | nome        | cargo 								| CPF				  | salario | sexo     | tipoContratacao | dataAdimissao |
      | Julia Zinco | Analista de Automacao | 74931041078 | 1000000 | Feminino | CLT							| 01012020      |
       

  @editarFuncionario
  Scenario Outline: Login no sistema
    Given o usuario digite o nome do funcionario "<nome>" na pesquisa
    And aparece na listagem o funcionario "<nome>"

    Examples: 
      | nome        | cargo 								| CPF				 | salario | sexo     | tipoContratacao | dataAdimissao |
      | Julia Zinco | Analista de Automacao | 04449459032 | 1000000 | Feminino | CLT							| 01012020      |
