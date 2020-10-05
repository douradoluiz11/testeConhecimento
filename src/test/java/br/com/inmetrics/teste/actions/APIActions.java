package br.com.inmetrics.teste.actions;

import static org.fest.assertions.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import br.com.inmetrics.teste.environment.EnvironmentResolver;
import br.com.inmetrics.teste.exceptions.NoSuchEnvironmentException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class APIActions {
	
	/**
	 * Método para execução do verbo Get com base no framework RestAssured
	 *
	 * @param url do tipo String - Endpoint da API.
	 * @return response do tipo Response - Retorna o response da API
	 * @author Luiz Henrique Dourado
	 * @throws NoSuchEnvironmentException 
	 */
	public static Response executeGet(String url) throws NoSuchEnvironmentException {

		Response response = given()
				.contentType("application/json; charset=UTF-8")
				.when()
				.get(EnvironmentResolver.getNamedEnvValue(url))
				.then()
				.extract()
				.response();
		return response;
	}
	
	
	/**
	 *br.com.inmetrics.teste.actionstornado no response da API com base no
	 * framework RestAssured
	 *
	 * @param statusCode do tipo int - O método recebe essa informação afim de
	 *                   validar assertivamente se o parametro que estamos enviando,
	 *                   é retornado no response da API.
	 * @author Luiz Henrique Dourado
	 */
	public static void validateStatusCode(int statusCode, Response response) {

		int statusCodeActual = response.statusCode();
		Assert.assertEquals(statusCode, statusCodeActual);
	}

	/**
	 * Método para conversão do Response retornado em JsonObject para String
	 *
	 * @param response do tipo Response - Recebe o response para tratamento.
	 * @author Luiz Henrique Dourado
	 */
	public static void convertResponseToString(Response response) {

		String responseString = response.asString();
		System.out.println(responseString);
	}

	/**
	 * Método para retornar um JsonObject do response retornado da API.
	 *
	 * @param response do tipo Response - Recebe o response para tratamento.
	 * @param key      do tipo String - esse parametro recebe uma chave continda no
	 *                 response e retorna o valor contido nela.
	 * @return valida do tipo String, retorna o valor contido na chave.
	 * @author Luiz Henrique Dourado
	 */
	public static String returnDataFromResponse(String key, Response response) {

		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		String valida = String.valueOf(jsonObject.get(key));
		return valida;
	}

	/**
	 * Método para validação unitaria de um JsonArray do response retornado da API.
	 *
	 * @param response do tipo Response - Recebe o response para tratamento.
	 * @param key      do tipo String - esse parametro recebe uma chave de um array
	 *                 continda no response.
	 * @param value    do tipo String - esse parametro recebe o valor que deve ser
	 *                 validado dentro do array continda no response, idependente de
	 *                 sua posição..
	 * @author Luiz Henrique Dourado
	 */
	public static void assertArrayDataFromResponse(String key, Response response, String value) {

		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		// JSONArray arrayResult = jsonObject.getJSONArray(key);
		assertThat(jsonObject.get(key).toString()).contains(value);
	}

	/**
	 * Método para conversão de um JsonArray (convertido em String) para uma lista.
	 *
	 * @param jsonArray do tipo Response - Recebe o response para tratamento.
	 * @return conv do tipo List, retorna a lista convertida.
	 * @author Luiz Henrique Dourado
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List convertJsonArrayToList(String jsonArray) {
		List<String> conv = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			conv = objectMapper.readValue(jsonArray, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conv;
	}

	/**
	 * Método para validação unitaria de um JsonObject do response retornado da API.
	 *
	 * @param response do tipo Response - Recebe o response para tratamento.
	 * @param key      do tipo String - esse parametro recebe uma chave de um objeto
	 *                 continda no response.
	 * @param value    do tipo String - esse parametro recebe o valor que deve ser
	 *                 validado dentro do objeto continda no response.
	 * @author Luiz Henrique Dourado
	 */
	public static void assertJsonObjectDataFromResponse(Response response, String key, String value) {

		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		assertThat(jsonObject.get(key).toString()).isEqualTo(value);
	}

	/**
	 * Método para validar se valor existe dentro da lista de string.
	 *
	 * @param list  do tipo List - response do tipo Response - Recebe o response para tratamento.
	 * @param value do tipo String - esse parametro recebe o valor que deve ser validado dentro da lista.
	 * @author Luiz Henrique Dourado
	 */
	public static void assertListDataFromResponse(List<String> list, String value) {

		assertThat(list).contains(value);
	}

}
