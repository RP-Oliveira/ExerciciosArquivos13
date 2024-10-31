package view;

import java.io.IOException;

import controller.FrutasController;
import controller.IFrutasController;

public class Principal {

	public static void main(String[] args) {
		
		// interface 					//implementação
		IFrutasController fruCont = new FrutasController();
		String dirFile = "C:\\TEMP";
		String nome = "generic_food";
		
		try {
			fruCont.readFile(dirFile, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
