package br.com.alura;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutosHandler;

public class ProcessaVenda {

	public static void main(String[] args) throws Exception {
		utilizandoXPath();
	}
	
	public static void lerPeloStax() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("src/venda.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(fileInputStream);
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<>();
		
		while(eventos.hasNext()){
			XMLEvent evento = eventos.nextEvent();
			
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")){
				produto = new Produto();
			}else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")){
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			}else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")){
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setPreco(Double.parseDouble(nome));
			}else if(evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")){
				produtos.add(produto);
			}
		}
		
		System.out.println(produtos);
	}
	
	public static void lerPeloSax() throws Exception{
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		ProdutosHandler produtosHandler = new ProdutosHandler();
		xmlReader.setContentHandler(produtosHandler);
		
		FileInputStream fileInputStream = new FileInputStream("src/venda.xml");
		InputSource inputSource = new InputSource(fileInputStream);
		
		xmlReader.parse(inputSource);
		System.out.println(produtosHandler.getProdutos());
	}
	
	public static void lerPeloDOM() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		
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
	
	public static void utilizandoXPath() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		
		NodeList formasPagamento = document.getElementsByTagName("formaDePagamento");
		System.out.println(formasPagamento.item(0).getTextContent());
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);

		//String exp = "venda/produtos/produto[nome='Livro']";
		//String exp = "venda/produtos/produto[contains(nome,'java')]";
		//String exp = "venda/produtos/produto[2]";
		String exp = "venda/produtos/produto";
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		for(int i=0;i<produtos.getLength();i++){
			Element produtoElement = (Element) produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			
		    Produto produto = new Produto(nome,preco);
		    
		    System.out.println(produto);
		}
	}
}
