package br.com.caelum.estoque.cliente;

import java.util.List;

public class TesteServicoWeb {

	public static void main(String[] args) {

		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSImplPort();
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo(TipoItem.LIVRO.value());
		filtros.getFiltro().add(filtro );
		cliente.todosOsItens(filtros);
		
		ListaItens todosOsItens = cliente.todosOsItens(filtros);
		List<Item> item = todosOsItens.getItem();
		
		item.forEach(i -> 
			System.out.println("Código: " + i.getCodigo() +
					"\nNome: " + i.getNome() +
					"\nQuantidade: " + i.getQuantidade() +
					"\nTipo: " + i.getTipo())
		);
	}

}
