# JEE 8 examples with Maven 3.x
Mossad project with Java EE 8 

Needs Java 8
 
## Maven 3.x 

set MAVEN_OPTS=-Xmx2000m -XX:MaxPermSize=2000m

mvn versions:set -DnewVersion=2.0-SNAPSHOTKogut
mvn [-T 4 - liczba watkow obslugujacych build'a, 2C - 2 watki na Core ] 

junit -Dsurefire.skipAfterFailureCount=1 -DskipTests

clean install (covers package) 
surefire-report:report 
cobertura:cobertura 
site 
checkstyle:checkstyle 
pmd:pmd pmd:cpd 
findbugs:findbugs 
javadoc:javadoc 

versions:display-dependency-updates 
versions:display-plugin-updates

enforcer:enforce

dependency:analyze-report => nic nie robi
dependency:analyze-dep-mgt => o ten robi analize
dependency:analyze-duplicate => szuka duplikatow
dependency:resolve-plugins
dependency:tree -> buduje samo drzewo zaleznosci
dependency:tree -DoutputType=graphml -DoutputFile=dependency.graphml [-Dincludes=com.mossad.nac.debt]
-fae
-P profile-1,profile-2

-rf, --resume-from, Resume reactor from specified project
-pl, --projects, Build specified reactor projects instead of all projects
-am, --also-make, If project list is specified, also build projects required by the list
-amd, --also-make-dependents, If project list is specified, also build projects that depend on projects on the list 


Zaleznosci miedzy modulami


com.github.janssk1:maven-dependencygraph-plugin:1.0:graph  -DoutputType=graphml -DoutputFile=dependency.graphml 

1)
mvn clean install -Dmaven.test.skip=true com.googlecode.maven-overview-plugin:maven-overview-plugin:RELEASE:overview => tworzy obraz zawily
mvn clean install -Dmaven.test.skip=true com.googlecode.maven-overview-plugin:maven-overview-plugin:RELEASE:overview -Dinludes=Dincludes=com.nsn.nas.lic -Dscopes=compile

2)
mvn dependency:tree -DoutputType=graphml -DoutputFile=dependency.graphml -Dincludes=com.nsn.nas.lic
yEd Graph Editor 
By default yED will not format the graph, but it has many different formats that you can use. Two simple steps separates you from a nice graph:
a) Select Tools > Fit Note to Label … > OK This should adjust the labels
b) Select Layout > Hierarchical > Orientation > Left to Right > OK 

3) mvn clean install -Dmaven.test.skip=true com.github.janssk1:maven-dependencygraph-plugin:1.2:graph -e

ALL in one:
mvn clean install surefire-report:report cobertura:cobertura site checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs javadoc:javadoc versions:display-dependency-updates versions:display-plugin-updates dependency:analyze-report dependency:analyze-dep-mgt dependency:analyze-duplicate dependency:resolve-plugins dependency:tree -DoutputType=graphml -DoutputFile=dependency.graphml

### Asadmin


1 JDBC
-------------------------------------------------------------------------------------------------------------------------
1.1 jdbc-connection-pool

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

recznie
url=jdbc:oracle:thin:@127.0.01:1521:XE

1.2jdbc-resource

JNDI Name: jdbc/MySQL_Mossad
Pool Name: MySQL_Connection_Pool

asadmin create-jdbc-resource --connectionpoolid Oracle_XE_JDBC_Connection_Pool_Mossad jdbc/Oracle_XE_JDBC_Resource_Mossad

-------------------------------------------------------------------------------------------------------------------------

2 JMS
---------------------------------------------------------
2.1 Connection factories 

uzywaj tylko tej
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
---------------------------------------------------------

2.2 Destination Resources

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

### GalssFish


Path to asadmin
/pathToGlashFish/glassfish-4.0/bin

http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.30
http://mvnrepository.com/artifact/com.oracle/ojdbc14 ==> Oracle JDBC Driver » 10.2.0.4.0 

Get the jar and put it to glassfish
should be placed under the lib folder, not under lib/ext folder. 


For Local EJB runner set in run config
-Djava.ext.dirs=/usr/local/glassfish-3.1/glassfish/lib 


http://host:8080/mossad-web-servlet/ServletMossadAdmin


netstat -aon | more

OSGI
http://felix.apache.org/downloads.cgi

path2glassFish\domain1\autodeploy\bundles


