package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBanco {

	@Test
	public void queSePuedaDividir() {
		Cuenta cuenta = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		try {
			assertNull(cuenta.div(cuenta.div(4.0,0.0), 2.0));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//para que cuando termine con exception complie, si le pasamos un valor que no es exception, va a dar rojo ya que le pide que sea asi
	@Test (expected = CuentaNoEncontrada.class)
	public void queAlBuscarUnaCuentaQueNoExistaDuvuelvaUnaExcepcion() throws CuentaNoEncontrada{
		Cuenta cuentaCorriente = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		Banco banco = new Banco();
		banco.agregarCuenta(cuentaCorriente);
		banco.buscarCuenta(5);
	}
	
	@Test (expected = MontoInsuficienteException.class)
	public void queNoSePuedaTransferirSiDevuelveException () throws MontoInsuficienteException, CuentaNoEncontrada  {
		Cuenta cuentaCorriente = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		Cuenta cajaAhorro = new CajaAhorro(2, 44, "cande", "agos");
		Banco banco = new Banco();
		banco.agregarCuenta(cuentaCorriente);
		banco.agregarCuenta(cajaAhorro);
		
		banco.transferir(2, 1, 200.0);
		
		
	}

}
