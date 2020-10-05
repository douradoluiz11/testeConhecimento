package br.com.inmetrics.teste.exceptions;

/**
 * Author: Luiz Henrique Dourado
 */

@SuppressWarnings("serial")
public class NoSuchEnvironmentException extends Exception {

	public NoSuchEnvironmentException(String env) {
		super("Ambiente requisitado : \"" + env + "\" não encontrado!");
	}
}