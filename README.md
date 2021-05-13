# wildfly-setup
Setting up active mq resource adapter in wildfly application server

* active mq 5.9.0 [download](https://repo1.maven.org/maven2/org/apache/activemq/activemq-rar/5.9.0/)
* wildfly 23.0.2.Final [downlaod](https://www.wildfly.org/downloads/)


Added manager user:
* user: manager
* pass: password

# Probleme:
Obwohl default resource adapter name richtig gesetzt wird, wird trotzdem keine neue Queue im Broker erstellt (Das ist im Artikel anders). (siehe [gui interface](http://127.0.0.1:9990/console/index.html#ejb3-configuration))

