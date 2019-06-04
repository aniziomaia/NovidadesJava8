package com.br.code.yes.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.br.code.interfaces.Numeros;
import com.br.code.interfaces.ValorNumerico;
import com.br.code.interfaces.ValorNumerico2;
import com.br.code.model.Cliente;
import com.br.code.model.util.Util;

/**
 * @author aniziomaia
 *
 */
public class PrincipalLambda {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("michelli", true, "123", 0);
		Cliente c2 = new Cliente("bruno", true, "456", 0);
		c1.autenticar("852");

		List<Cliente> clientes = Arrays.asList(c1, c2);

		//MODO 1 LAMBDA
		Consumer<Cliente> consumidor = (Cliente c)->{System.out.println(c.getNome());};
		clientes.forEach(consumidor);
		
		//MODO 2 LAMBDA
		clientes.forEach((Cliente c)->{System.out.println(c.getNome());});
		
		//MODO 3 LAMBDA
		clientes.forEach(c -> System.out.println(c.getNome()));

		//MODO 4 METHOD REFERENCE
		clientes.forEach(Cliente::getNome); 
		
		//MODO 5 COM LAMBDA
		Runnable r = () -> System.out.println("Olá mundo!"); 
		new Thread(r).start();
	    
		//MODO 6 SEM LAMBDA
		Runnable r2 = new Runnable() {
			public void run() {
				System.out.println("Olá mundo!"); 
			}
		};
		r2.run();
		
		//MODO 7 COM LAMBDA
		Numeros n = () -> 4.236;
		System.out.println(n.getValor());
		
		n = () -> Math.random() * 100;
		System.out.println(n.getValor());
		
		//MODO 8 COM LAMBDA
		ValorNumerico isPar  = (int v) -> (v % 2) == 0;
		ValorNumerico isPar2 = v -> (v % 2) == 0;
		System.out.println(isPar.teste(4));
		System.out.println(isPar2.teste(5));
		
		//MODO 9 COM LAMBDA
		ValorNumerico2 isDiv = (x , y) -> (x % y) == 0;
		ValorNumerico2 isDiv2 = (int x , int y) -> (x % y) == 0;
		System.out.println(isDiv.teste(10 , 2));
		System.out.println(isDiv2.teste(5, 3));
		
		//MODO 10 COM BLOCO LAMBDA
		ValorNumerico2 expressao = (int x , int y) -> {
			int w = x + y;
			return w > 1000;
		};
		System.out.println(expressao.teste(10 , 2));
		
		//MODO 11 LISTA LAMBDA
		Util.getStringLista().forEach(x -> System.out.println(x));
		Util.getStringLista().forEach(System.out::println);
		
		//MODO 12 PREDECATE LAMBDA
		filtro(Util.getStringLista(), (s) -> s.startsWith("M"));
		filtro(Util.getStringLista(), (s) -> true);
		filtro(Util.getStringLista(), (s) -> false);
		filtro(Util.getStringLista(), (s) -> s.length() > 10);
		
		//MODO 13 ITERACAO STREAM LAMBDA
		filtroStream(Util.getStringLista(), (s) -> s.startsWith("M"));
		
		Stream<Cliente> stream = Util.getClienteLista().stream().filter(c -> c.getPontos() > 5);
		//stream.forEach(c -> System.out.println(c.getPontos()));
		
		List<Cliente> novaLista = stream.collect(Collectors.toList());
		novaLista.forEach(c -> System.out.println(c.getPontos()));
		
		List<Cliente> lst = Util.getClienteLista().stream().filter(c -> c.getPontos() > 2).collect(Collectors.toList());
		lst.forEach(c -> System.out.println(c.getPontos()));
		
		IntStream intstream = Util.getClienteLista().stream().mapToInt(c -> c.getPontos());
		intstream.forEach(System.out::println);
		
	}
	
	public static void filtro(List<String> lista, Predicate<String>condicao){
		for (String s : lista) {
			if(condicao.test(s))
				System.out.println(s);
		}
	}
	
	public static void filtroStream(List<String> lista, Predicate<String>condicao){
		lista.stream().filter((s) -> condicao.test(s)).forEach((s) -> System.out.println(s));
		lista.stream().filter(condicao :: test).forEach(System.out::println);
	}
	
}
