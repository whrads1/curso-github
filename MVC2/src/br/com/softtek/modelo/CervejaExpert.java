package br.com.softtek.modelo;
import java.util.*;
//Para utilizar o m�todo List � preciso importar a classa java.util.*
public class CervejaExpert {
    public List<String> getMarcas(String cor){
    	List marcas = new ArrayList<String>();
    	if (cor.equals("Clara")) {
    		marcas.add("Antarctica");
    		marcas.add("Brahma");
    	}
    	else {
    		marcas.add("Bohemia");
    		marcas.add("Original");
    	}
    	return marcas;
    }
}
