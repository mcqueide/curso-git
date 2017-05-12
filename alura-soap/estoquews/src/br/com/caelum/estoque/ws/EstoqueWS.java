package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.BARE)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName="todosOsItens")
	@WebResult(name="itens")
	@ResponseWrapper(localName="getItens")
	public ListaItens getItens(){
		System.out.println("Chamando getItens()");
		List<Item> todosItens = dao.todosItens();
		return new ListaItens(todosItens);
	}
	
	@WebMethod(operationName="todosOsItensComFiltro") 
    @WebResult(name="itens")
    public ListaItens getItensComFiltro(@WebParam(name="filtros") Filtros filtros) {
        System.out.println("Chamando getItens()");
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return new ListaItens(itensResultado);
    }
	
	@WebMethod(operationName="cadastrarItem")
	@WebResult(name="item")
	public Item cadastrarItem(
			@WebParam(name="token",header=true) TokenUsuario token, 
			@WebParam(name="item") Item item) throws AutorizacaoException{
		
		System.out.println("Cadastrando item "+item.getNome() + " com o token " + token.getToken());
		
		boolean ehValido = new TokenDao().ehValido(token);
		
		if(!ehValido){
			throw new AutorizacaoException("Autorização falhou");
		}
		
		this.dao.cadastrar(item);
		
		return item;
	}
}
