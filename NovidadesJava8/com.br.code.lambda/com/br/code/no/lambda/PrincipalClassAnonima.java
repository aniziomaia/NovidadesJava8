package com.br.code.no.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.br.code.model.Cliente;

/**
 * Exemplo de clientes.forEach usando classe anonima
 * 
 * @author aniziomaia
 *
 */
public class PrincipalClassAnonima {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("michelli", true, "123", 0);
		Cliente c2 = new Cliente("bruno", true, "456", 0);
		c1.autenticar("852");

		List<Cliente> clientes = Arrays.asList(c1, c2);

		Consumer<Cliente> consumidor = new Consumer<Cliente>() { // CLASSE
																	// ANÔNIMA
			public void accept(Cliente c) {
				System.out.println("Nome: " + c.getNome() + " :: " + "Senha: " + c.getSenha());
			}
		};
		clientes.forEach(consumidor);

	}
}
