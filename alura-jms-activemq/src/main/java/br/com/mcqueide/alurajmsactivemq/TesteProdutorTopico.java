package br.com.mcqueide.alurajmsactivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TesteProdutorTopico {

    public static void main(String[] args) throws Exception{

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("loja");

        MessageProducer producer = session.createProducer(fila);

        Message message = session.createTextMessage("<produto><id>123</id></produto>");
        producer.send(message);

        new Scanner(System.in).nextLine(); //parar o programa para testar a conexao

        session.close();
        connection.close();
        context.close();
    }
}
