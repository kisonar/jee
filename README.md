# JEE 9 examples with Maven 3.x
```
Tools:
Apache Maven 3.6.2 
Java version: 11.0.4, vendor: AdoptOpenJDK,
Java EE 9 (Jakarta project) libraries

This project is in maintenance mode.
Used for laerning & testing  Maven & Java EE solutions. 
I do not guarantee that runtime works fine.

How to run Maven:
mvn clean install versions:display-dependency-updates versions:display-plugin-updates
``` 

## GlassFish stuff

###  JDBC

#### jdbc-connection-pool
```
Pool Name: MySQL_Connection_Pool
Resource Type: 
Datasource Classname: com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource
Initial and Minimum Pool Size :8 --steadypoolsize
Maximum Pool Size:32 --maxpoolsize
Pool Resize Quantity: 2 --poolresize
Idle Timeout:300 --idletimeout 
Max Wait Time: 60000 --maxwait
User: user
Password: user
URL: jdbc:mysql://127.0.0.1:3306/test
url: jdbc:mysql://127.0.0.1:3306/test
ServerName: 127.0.0.1

for MySQL
asadmin create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource 	   --restype javax.sql.DataSource --property portNumber=3306:password=mossad:user=mossad:serverName=127.0.0.1:databaseName=test MySQL_Connection_Pool_test

for orlace
asadmin create-jdbc-connection-pool --datasourceclassname oracle.jdbc.pool.OracleDataSource --restype javax.sql.DataSource --property portNumber=1521:password=mossad:user=mossad:serverName=127.0.0.1:databaseName=XE Oracle_XE_JDBC_Connection_Pool_Mossad

url=jdbc:oracle:thin:@127.0.01:1521:XE
```

#### jdbc-resource
```
JNDI Name: jdbc/MySQL_Mossad
Pool Name: MySQL_Connection_Pool

asadmin create-jdbc-resource --connectionpoolid Oracle_XE_JDBC_Connection_Pool_Mossad jdbc/Oracle_XE_JDBC_Resource_Mossad
```

### JMS

#### Connection factories 
```
Pool Name: MossadConnectionFactory
JNDI Name: MossadConnectionFactory
Resource Type: javax.jms.ConnectionFactory
asadmin create-jms-resource --restype javax.jms.ConnectionFactory MossadConnectionFactory

Pool Name: MossadQueueConnectionFactory
NDI Name: MossadQueueConnectionFactory
Resource Type: javax.jms.QueueConnectionFactory

Pool Name: MossadTopicConnectionFactory
JNDI Name: MossadTopicConnectionFactory
Resource Type: javax.jms.TopicConnectionFactory
```

#### Destination Resources
```
Queue - P2P

JNDI Name: MossadQueue
Physical Destination Name: MossadQueueDestName
Resource Type: javax.jms.Queue
asadmin create-jms-resource --restype javax.jms.Queue MossadQueue

Topic - broadcast
JNDI Name: MossadTopic
Physical Destination Name: MossadTopicDestName
Resource Type: javax.jms.Topic
asadmin create-jms-resource --restype javax.jms.Topic MossadTopic
````

### GalssFish
```
Path to asadmin
/pathToGlashFish/glassfish-4.0/bin

http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.30
http://mvnrepository.com/artifact/com.oracle/ojdbc14 ==> Oracle JDBC Driver � 10.2.0.4.0 

Get the jar and put it to glassfish
should be placed under the lib folder, not under lib/ext folder. 

For Local EJB runner set in run config
-Djava.ext.dirs=/usr/local/glassfish-3.1/glassfish/lib 

http://host:8080/mossad-web-servlet/ServletMossadAdmin
```

### Windows ports
```
netstat -aon | more
```

### OSGI
```
http://felix.apache.org/downloads.cgi
path2glassFish\domain1\autodeploy\bundles
```