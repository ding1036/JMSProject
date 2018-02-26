package com.messagequeue.jms;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Receive")
public class Receive extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public Receive() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            // get the initial context
            InitialContext context = new InitialContext();

            // lookup the queue object
            Queue queue = (Queue) context.lookup("java:comp/env/queue/queue0");

            // lookup the queue connection factory
            QueueConnectionFactory conFactory = (QueueConnectionFactory) context
                    .lookup("java:comp/env/queue/connectionFactory");

            // create a queue connection
            QueueConnection queConn = conFactory.createQueueConnection();

            // create a queue session
            QueueSession queSession = queConn.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            // create a queue receiver
            QueueReceiver queReceiver = queSession.createReceiver(queue);

            // start the connection
            queConn.start();

            // receive a message
            TextMessage message = (TextMessage) queReceiver.receive();

            // print the message
            out.write("Message Received: " + message.getText());

            // close the queue connection
            queConn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
