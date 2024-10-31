package controller;

import java.io.IOException;

public interface IFrutasController {
	
	public void readFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
}
