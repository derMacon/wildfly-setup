# wildfly-setup
Projekt zum Testen der Konfiguration eines Active mq resource adapters mit dem application server wildfly. Nachrichten werden über eine Spring Api an einen Active mq broker, welcher in einem Docker container läuft, und über das docker-compose file gestartet werden kann. 

### Versionen / Artikel
* active mq 5.9.0 [download](https://repo1.maven.org/maven2/org/apache/activemq/activemq-rar/5.9.0/)
* wildfly 23.0.2.Final [downlaod](https://www.wildfly.org/downloads/)
* [tutorial](http://www.mastertheboss.com/jboss-frameworks/ironjacamar/configuring-a-resource-adapter-for-activemq-on-jbosswildfly)

### Probleme
Wenn ich den application server über die [standalone.bat](./bin/standlalone.bat) starte, bekomme ich zwar wie im Artikel beschrieben die Meldung:

```
15:07:45,610 INFO  [org.jboss.as.connector.deployment] (MSC service thread 1-3) WFLYJCA0007: Registered connection factory java:/ConnectionFactory
15:07:45,610 INFO  [org.jboss.as.connector.deployment] (MSC service thread 1-3) WFLYJCA0006: Registered admin object at java:/queue/test-queue
```

Allerdings wird dies mit folgender Warning befolgt:

```
15:07:45,626 WARN  [org.jboss.as.connector.deployers.RaXmlDeployer] (MSC service thread 1-3) IJ020017: Invalid archive: activemq-rar.rar
15:07:45,626 WARN  [org.jboss.as.connector.deployers.RaXmlDeployer] (MSC service thread 1-3) Severity: WARNING
Section: 20.7
Description: Invalid config-property-type for AdminObject.
Code: Class: org.apache.activemq.pool.XaPooledConnectionFactory Property: tmFromJndi Type: boolean
```

In einem anderen Artikel habe ich gelesen, dass bereits beim Hochfahren des Servers automatisch die angegebene Queue erstellt wird, solange diese nicht vorhanden ist. Im [docker-compose](docker-compose.yml) file habe ich neben den standard Port 61616 auch den Port 8161 freigegeben um den Zugriff auf die ui vom Broker zu ermöglichen (credentials user: admin; pass: admin). Hierbei ist zu sehen, dass keinerlei Queue oder Topic etc. angelegt wurde. Wenn ich nun das mdb Projekt starte führt dies ebenfalls zu Fehlern, weil er keine Connection aufbauen kann. 
