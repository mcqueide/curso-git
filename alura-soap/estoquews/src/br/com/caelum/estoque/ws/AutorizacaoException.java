package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name="autorizacaoFault", messageName="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String string) {
		super(string);
	}
	
	public String getFaltInfo(){
		return "Token inválido";
	}

}
