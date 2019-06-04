package com.br.code.model.util;

import java.util.Arrays;
import java.util.List;

import com.br.code.model.Cliente;

public class Util {

	public static List<String> getStringLista(){
		List<String> lista = Arrays.asList("Blumenau","Maringa","Manaus",
				                   "Parintins","São Paulo","Fortaleza",
				                   "Jericoacoara","Curitiba");
		return lista;
	}
	
	public static List<Cliente> getClienteLista(){
		Cliente c = new Cliente("Jose", true, "123", 10);
		Cliente c1 = new Cliente("Maia", true, "456", 5);
		Cliente c2 = new Cliente("Anizio", true, "789", 2);
		Cliente c3 = new Cliente("Anizio", true, "789", 10);
		Cliente c4 = new Cliente("Anizio", true, "789", 15);
		List<Cliente> lista = Arrays.asList(c, c1, c2, c3, c4);
		return lista;
	}
	
	
}
