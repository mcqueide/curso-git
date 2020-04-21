package br.com.mcqueide.alurajmsactivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import java.util.Scanner;

public class ProdutorMensagemLog {

    public static void main(String[] args) throws Exception{

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection("user", "senha");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("LOG");

        MessageProducer producer = session.createProducer(fila);

        Message messageDebug = session.createTextMessage("DEBUG | .....");
        producer.send(messageDebug, DeliveryMode.NON_PERSISTENT, 1, 5000);
        Message messageInfo = session.createTextMessage("INFO | .....");
        producer.send(messageInfo, DeliveryMode.NON_PERSISTENT, 3, 5000);
        Message messageWarn = session.createTextMessage("WARN | .....");
        producer.send(messageWarn, DeliveryMode.NON_PERSISTENT, 7, 5000);
        Message messageErro = session.createTextMessage("ERROR | .....");
        producer.send(messageErro, DeliveryMode.NON_PERSISTENT, 9, 5000);

        new Scanner(System.in).nextLine(); //parar o programa para testar a conexao

        session.close();
        connection.close();
        context.close();
    }
}
