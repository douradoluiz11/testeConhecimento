#Author: henrike.dourado@gmail.com

@editFunc @teste
Feature: Editar funcionario
  Eu como administrador do sistema desejo fazer a edição de um funcionario cadastrado

  @sucesso
  Scenario: Edito funcionario com sucesso
    Given Acesso o site de cadastro new empregado
    When Clico no botão de novo funcionario
    And preencho dados do novo funcionario
    And clico no botao enviar
    Then valido cadastro com sucesso
    And pesquiso por nome do funcionario
    And valido meu funcionario
    And clico no botão editar
    And Edito nome funcionario 
    And envio alteracao
    And valido edicao de cadastro com sucesso
    