#Author: henrike.dourado@gmail.com

@excluiFunc @teste
Feature: Excluir funcionario
  Eu como administrador do sistema desejo fazer a exclusao de um funcionario cadastrado

  @sucesso
  Scenario: Excluo funcionario com sucesso
    Given Acesso o site de cadastro new empregado
    When Clico no botão de novo funcionario
    And preencho dados do novo funcionario
    And clico no botao enviar
    Then valido cadastro com sucesso
    And pesquiso por nome do funcionario
    And valido meu funcionario
    And clico no botão excluir
    And valido exclusao de cadastro com sucesso