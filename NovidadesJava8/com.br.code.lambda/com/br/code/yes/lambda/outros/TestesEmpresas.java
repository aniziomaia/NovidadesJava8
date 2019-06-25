package com.br.code.yes.lambda.outros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestesEmpresas {

	public static String filtro(List<Integer> lista, Predicate<Integer>condicao){
		for (Integer n : lista) {
			if(condicao.test(n))
				return "Yes";
		}
		return "No";
	}
	
	static String findNumber(List<Integer> arr, int k) {
        //solucao 1
		StringBuilder r = new StringBuilder();
        r.append("No");
		arr.forEach( n ->{
			if(n == k) {
				r.replace(0, 2, "Yes");
			}
			
		});
		
		//solucao 2
        //return filtro(arr, (s) -> s > k);
		return r.toString();

    }

	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Maria\\Documents\\teste.txt"));
	
			//pega a quantidade total de numeros ex: 5
	        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
	
	        List<String> arrTemp = new ArrayList<>();
	
	        IntStream.range(0, arrCount).forEach(i -> {
	            try {
	            	//pega os numeros ate a quantidade total ex: 1-5
	                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
	            } catch (IOException ex) {
	            	ex.printStackTrace();
	                throw new RuntimeException(ex);
	            }
	        });
	
	        List<Integer> arr = arrTemp.stream()
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(Collectors.toList());
	            //pega o numero da comparacao ex: 5
		        int k = Integer.parseInt(bufferedReader.readLine().trim());
		
		        String res = findNumber(arr, k);
		        System.out.println(res);
		
		        //bufferedWriter.write(res);
		        //bufferedWriter.newLine();
		
		        bufferedReader.close();
		        //bufferedWriter.close();
        }catch(Throwable e) {
        	e.printStackTrace();
        }
    }
}
