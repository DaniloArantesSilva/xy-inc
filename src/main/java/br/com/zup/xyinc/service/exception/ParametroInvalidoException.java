package br.com.zup.xyinc.service.exception;

/**
 * Classe que representa a exceção de quando os parâmetros estão incorretos
 * @author danilo
 *
 */
public class ParametroInvalidoException extends RuntimeException {	
	private static final long serialVersionUID = 1L;
	
	public ParametroInvalidoException(String msg) {
		super(msg);
	}
	
	public ParametroInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
