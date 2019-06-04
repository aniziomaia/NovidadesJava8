package com.br.code.no.lambda;

import java.util.Arrays;
import java.util.List;

import com.br.code.model.Cliente;
import com.br.code.model.MostrarCliente;

/**
 * Exemplo de clientes.forEach usando consumer
 * 
 * @author aniziomaia
 *
 */
public class PrincipalConsumer {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("michelli", true, "123", 0);
		Cliente c2 = new Cliente("bruno", true, "456", 0);
		c1.autenticar("852");

		List<Cliente> clientes = Arrays.asList(c1, c2);
		MostrarCliente mc = new MostrarCliente();
		clientes.forEach(mc);

	}
}
