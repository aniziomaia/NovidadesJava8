package com.br.code.yes.lambda.outros;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TestesEmpresas2 {

	 
	
	public static List<List<Integer>> getEmailThreads(List<String> emails) {
	    // Write your code here
		    //Map<Integer, String> map = new HashMap<Integer, String>();
		    List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		    
			for (String email : emails) {
				String vector[] = email.split(",");
				for (int i = 0; i < vector.length; i++) {
					String v = vector[i];
					if(v.contains("@")) {
						String mailFirstPart = v.substring(0, v.indexOf("@"));
						 Map<Integer, String> map = new HashMap<Integer, String>();
						if(!map.containsValue(mailFirstPart)) {
							map.put(1, "1");
							List<Integer> L = map.values().stream().map(c -> Integer.valueOf(c.toString())).collect(Collectors.toList());
							
							resultado.add( L);
						}
					}
				}
			}
	        return resultado;
	    }
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int emailsCount = Integer.parseInt(bufferedReader.readLine().trim());
	        //guarda a lista de email por linha
	        List<String> emails = IntStream.range(0, emailsCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine();
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .collect(Collectors.toList());

	        List<List<Integer>> result = getEmailThreads(emails);

	        result.stream().map(r -> r.stream().map(Object::toString).collect(joining(" ")))
	            .map(r -> r + "\n")
	            .collect(toList())
	            .forEach(e -> {
	                //bufferedWriter.write(e);
					System.out.println(e);
	            });

	        bufferedReader.close();
	        //bufferedWriter.close();
	    }
	}
