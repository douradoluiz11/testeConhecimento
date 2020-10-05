#Author: Luiz Henrique Dourado
@ApiPeople @teste
Feature: Executa Api People

  Scenario Outline: Executa API People Star Wars
    Given que eu acesso a api people
    When o http status code da api people for <status_code>
    Then o parâmetro nome da personagem deverá ser "<nome>"
    And a altura deverá ser "<altura>"
    And o peso deverá ser "<peso>"
    And a cor de cabelo deverá ser "<cor_cabelo>"
    And a cor de pele deverá ser "<cor_pele>"
    And a cor do olho deverá ser "<cor_olho>"
    And a data de nascimento deverá ser "<data_nascimento>"
    And o gênero deverá ser "<genero>"
    And o planeta natal deverá ser apresentado no serviço "<planeta_natal>"
    And o filme deverá conter "<filmes>"

    Examples:
      | status_code | nome           | altura | peso | cor_cabelo | cor_pele | cor_olho | data_nascimento | genero | planeta_natal                   | filmes                        |
      | 200         | Luke Skywalker | 172    | 77   | blond      | fair     | blue     | 19BBY           | male   | http://swapi.dev/api/planets/1/ | http://swapi.dev/api/films/3/ |


