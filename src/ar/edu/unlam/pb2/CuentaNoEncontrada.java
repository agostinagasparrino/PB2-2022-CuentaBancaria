package ar.edu.unlam.pb2;

public class CuentaNoEncontrada extends Exception {

	public CuentaNoEncontrada(String string) {
		super("No se pudo encontrar la cuenta");
	}

}
