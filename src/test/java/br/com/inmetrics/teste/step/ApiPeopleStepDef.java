package br.com.inmetrics.teste.step;

import br.com.inmetrics.teste.actions.APIActions;
import br.com.inmetrics.teste.model.ApiModel;
import io.cucumber.java8.En;
import io.restassured.response.Response;

public class ApiPeopleStepDef implements En {

	APIActions action;

	public ApiPeopleStepDef() {

		action = new APIActions();

		Given("que eu acesso a api people", () -> {

			Response a = (ApiModel.response = action.executeGet("uriPeople"));
			System.out.println(a.asString());

		});

		Then("o http status code da api people for {int}", (Integer statusCode) -> {

			action.validateStatusCode(statusCode, ApiModel.response);

		});

		Then("o parâmetro nome da personagem deverá ser {string}", (String name) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "name", name);

		});

		Then("a altura deverá ser {string}", (String altura) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "height", altura);

		});

		Then("o peso deverá ser {string}", (String peso) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "mass", peso);
		});

		Then("a cor de cabelo deverá ser {string}", (String cabelo) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "hair_color", cabelo);

		});

		Then("a cor de pele deverá ser {string}", (String pele) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "skin_color", pele);

		});

		Then("a cor do olho deverá ser {string}", (String olho) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "eye_color", olho);

		});

		Then("a data de nascimento deverá ser {string}", (String birth) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "birth_year", birth);

		});

		Then("o gênero deverá ser {string}", (String gender) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "gender", gender);

		});

		Then("o planeta natal deverá ser apresentado no serviço {string}", (String homeworld) -> {

			action.assertJsonObjectDataFromResponse(ApiModel.response, "homeworld", homeworld);

		});

		Then("o filme deverá conter {string}", (String film) -> {

			action.assertArrayDataFromResponse( "films",ApiModel.response, film);

		});

	}

}
