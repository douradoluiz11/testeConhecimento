#Author: henrike.dourado@gmail.com

@cadastro @teste
Feature: Cadastrar novo usuario
  Eu como administrador do sistema desejo fazer a inclusão de um novo usuario

  @sucesso
  Scenario: Cadastro de usuario com sucesso
    Given Acesso o site de cadastro
    When Clico no botão de cadasto 
    And preencho dados do cadastro
    And clico no botao cadastrar 
    Then realizo cadastro com sucesso
  