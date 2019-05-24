package br.com.zup.xyinc.service.exception;

/**
 * Classe que representa a exceção de quando a coordenada é negativa
 * @author danilo
 *
 */
public class CoordenadaInvalidaException extends RuntimeException {	
	private static final long serialVersionUID = 1L;
	
	public CoordenadaInvalidaException(String msg) {
		super(msg);
	}
	
	public CoordenadaInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
