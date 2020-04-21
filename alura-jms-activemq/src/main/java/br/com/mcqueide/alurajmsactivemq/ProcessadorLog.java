package br.com.mcqueide.alurajmsactivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import java.util.Scanner;

public class ProcessadorLog {

    public static void main(String[] args) throws Exception{

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection("user", "senha");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("LOG");
        MessageConsumer consumer = session.createConsumer(fila);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;

                try {
                    String mensagem = textMessage.getText();
                    System.out.println(mensagem);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        new Scanner(System.in).nextLine(); //parar o programa para testar a conexao

        session.close();
        connection.close();
        context.close();
    }
}
