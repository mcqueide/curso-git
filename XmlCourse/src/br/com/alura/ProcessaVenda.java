package br.com.alura;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ProcessaVenda {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("venda.xml");
		
		NodeList formasPagamento = document.getElementsByTagName("formaDePagamento");
		System.out.println(formasPagamento.item(0).getTextContent());
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);
		
		NodeList produtos = document.getElementsByTagName("produto");
		for(int i=0;i<produtos.getLength();i++){
			Element produtoElement = (Element) produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			
		    Produto produto = new Produto(nome,preco);
		    
		    System.out.println(produto);
		}
	}
}
