package com.mossad.mossaddesktopapp;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BusinessLogicEJBMDBTester {

    //@Resource(mappedName = Constants.JMS_MAPPING_QUEUE_CONNECTION_FACTORY)
    // private static ConnectionFactory connectionFactory;
    //@Resource(mappedName = Constants.JMS_MAPPING_NAME_QUEUE)
    private static Queue queue;
    private static Connection connection;
    private static Topic topic;


    private static Session session;
    private static MessageProducer messageProducer;
    private static TextMessage message;

    //Sends JMS to EJB MDB
    public static void main(String[] args) throws NamingException, JMSException {

        Properties props = new Properties();

        //WAS related
        props.setProperty("java.naming.factory.initial", "com.ibm.websphere.naming.WsnInitialContextFactory");
        props.setProperty("java.naming.provider.url", "iiop://127.0.0.1:9810");
        /*
            + on classpath all jars from APP_SERVER/runtime
        
        */

        //GlassFish related
        //props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        // props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        //props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");  
        //props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        // props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        System.out.println("JMS Tester");
        try {

            InitialContext ctx = new InitialContext(props);

            //ConnectionFactory connectionFactory =
            //    (ConnectionFactory) ctx.lookup(Constants.JMS_MAPPING_CONNECTION_FACTORY);

            ConnectionFactory connectionFactory =
                (ConnectionFactory) ctx.lookup("jms/LmRequestTopicFactory");

            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //queue = (Queue)ctx.lookup(Constants.JMS_MAPPING_NAME_QUEUE);    
            topic = (Topic) ctx.lookup("jms/LmRequestTopic");

            //messageProducer = session.createProducer(queue);

            messageProducer = session.createProducer(topic);
            message = session.createTextMessage();

            for (int i = 0; i < 3; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                messageProducer.send(message);
            }
            System.out.println("JMS poszedl");

            //JMS Tester
        } catch (Exception ex) {

            System.out.println("Error message : " + ex.getMessage());
            System.out.println("Error : " + ex);

        } finally {
            System.out.println("Closing connections : ");
            if (connection != null) {
                connection.close();
            }
            System.out.println("Closed connections : ");

        }


    }
}
