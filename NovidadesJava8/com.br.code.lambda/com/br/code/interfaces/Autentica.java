package com.br.code.interfaces;

/**
 * interface funcional deve conter apenas 1 metodo abstrato funcional
 * @author aniziomaia
 *
 */
@FunctionalInterface
public interface Autentica{
	
    public abstract boolean autenticar(String senha);

}
