package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrutasController implements IFrutasController {

	public FrutasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File dir = new File(path);
		File file = new File(path, nome+ ".csv");
		
		if(dir.exists() && dir.isDirectory()) {
			if (file.exists() && file.isFile()) {
				FileInputStream fluxo = new FileInputStream(file);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String line = buffer.readLine();
				
				System.out.format("+---------------------------+--------------------------------+---------------------------+%n");
				System.out.format("| Fruta                     | Nome Cient                          | Grupo     |%n");
				System.out.format("+---------------------------+--------------------------------+---------------------------+%n");
				
				while(line!= null && line.contains("NULL") == false) {

					this.toString(line);
					line = buffer.readLine();
				}
				
				System.out.format("+---------------------------+--------------------------------+-----------------+%n");
				buffer.close();
				leitor.close();
				fluxo.close();
				    
			} else {
				throw new IOException("Arquivo Não encontrado");
			}
		} else {
			throw new IOException("Caminho Não encontrado");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public void toString(String line) {
		String[]fruta = line.split(",");
		String leftAlignFormat = "| %-25s | %-50s | %-18s |%n";
		
		if(fruta[2].contains("Fruit")) {
			System.out.format(leftAlignFormat,fruta[0], fruta[1], fruta[3]);
		}
		
	}

}
