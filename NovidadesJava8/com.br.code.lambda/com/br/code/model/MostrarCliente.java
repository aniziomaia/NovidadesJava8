package com.br.code.model;

import java.util.function.*;

public class MostrarCliente implements Consumer<Cliente>{
   public void accept(Cliente c) {
       System.out.println("Nome: " + c.getNome() + " :: " + "Senha: " + c.getSenha());  
   }
}
