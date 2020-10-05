#Author: henrike.dourado@gmail.com

@login @teste
Feature: Login
  Eu como usuario desejo logar no sistema

  @loginSucesso
  Scenario: Login com sucesso
    Given Que estou na pagina de login
    And insiro o meu user
    And insiro o meu password
    When clico no botao entre
    Then sou redirecionado a pagina de entrada


  