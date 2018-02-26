
####find activemq/bin catagroy and start mq
```
sudo ./activemq start
```
####find error as below:<br>
ERROR: Configuration variable JAVA_HOME or JAVACMD is not defined   
correctly.   
(JAVA_HOME=’ ’ , JAVACMD=’Java’)  

####solve:<br>
find JAVA_HOME path didn't work，just need to add code in activemq file at the very beginning manually.
```
    JAVA_HOME="/home/emin/Downloads/jdk-9.0.4"  
    export JAVA_HOME  
```

####default port : 8161

####find conf file in Tomcat install path，add below config to context.xml:<br>
```
<Resource name="queue/connectionFactory"    
                auth="Container"    
                type="org.apache.activemq.ActiveMQConnectionFactory"  
                description="JMS Connection Factory"  
                factory="org.apache.activemq.jndi.JNDIReferenceFactory"  
                brokerURL="tcp://localhost:61616"  
                brokerName="LocalActiveMQBroker" />  
                  
<Resource name="queue/queue0"    
                auth="Container"    
                type="org.apache.activemq.command.ActiveMQQueue"  
                description="My Queue"  
                factory="org.apache.activemq.jndi.JNDIReferenceFactory"  
                physicalName="TomcatQueue" />
```