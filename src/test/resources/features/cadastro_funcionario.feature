#Author: henrike.dourado@gmail.com

@cadastroFunc @teste
Feature: Cadastrar novo funcionario
  Eu como administrador do sistema desejo fazer a inclusão de um novo funcionario

  @sucesso
  Scenario: Cadastro de funcionario com sucesso
    Given Acesso o site de cadastro new empregado
    When Clico no botão de novo funcionario
    And preencho dados do novo funcionario
    And clico no botao enviar
    Then valido cadastro com sucesso