# wildfly-setup
Setting up active mq resource adapter in wildfly application server

* active mq 5.15.13 [download](https://mvnrepository.com/artifact/org.apache.activemq/activemq-rar/5.15.13)
* wildfly 21.0.0.Final [downlaod](https://www.wildfly.org/downloads/)
* Tutorial: [link](https://stackoverflow.com/questions/65854537/wildfly-integration-with-activemq-using-jca-resource-adapter)

# Probleme:
mdb projekt kann nicht gestartet werden, es kommt folgende Meldung: 

```
15:39:36,079 ERROR [org.jboss.msc.service.fail] (MSC service thread 1-7) MSC000001: Failed to start service jboss.deployment.unit."mdb-w21-1.0-SNAPSHOT.war".PARSE: org.jboss.msc.service.StartException in service jboss.deployment.unit."mdb-w21-1.0-SNAPSHOT.war".PARSE: WFLYSRV0153: Failed to process phase PARSE of deployment "mdb-w21-1.0-SNAPSHOT.war"
	at org.jboss.as.server@13.0.3.Final//org.jboss.as.server.deployment.DeploymentUnitPhaseService.start(DeploymentUnitPhaseService.java:189)
	at org.jboss.msc@1.4.12.Final//org.jboss.msc.service.ServiceControllerImpl$StartTask.startService(ServiceControllerImpl.java:1739)
	at org.jboss.msc@1.4.12.Final//org.jboss.msc.service.ServiceControllerImpl$StartTask.execute(ServiceControllerImpl.java:1701)
	at org.jboss.msc@1.4.12.Final//org.jboss.msc.service.ServiceControllerImpl$ControllerTask.run(ServiceControllerImpl.java:1559)
	at org.jboss.threads@2.4.0.Final//org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads@2.4.0.Final//org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1990)
	at org.jboss.threads@2.4.0.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1486)
	at org.jboss.threads@2.4.0.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1377)
	at java.base/java.lang.Thread.run(Thread.java:830)
Caused by: org.jboss.msc.service.ServiceNotFoundException: service jboss.ejb.default-resource-adapter-name-service not found
	at org.jboss.msc@1.4.12.Final//org.jboss.msc.service.ServiceContainerImpl.getRequiredService(ServiceContainerImpl.java:663)
	at org.jboss.as.ejb3@21.0.1.Final//org.jboss.as.ejb3.deployment.processors.MessageDrivenComponentDescriptionFactory.getDefaultResourceAdapterName(MessageDrivenComponentDescriptionFactory.java:257)
	at org.jboss.as.ejb3@21.0.1.Final//org.jboss.as.ejb3.deployment.processors.MessageDrivenComponentDescriptionFactory.processMessageBeans(MessageDrivenComponentDescriptionFactory.java:156)
	at org.jboss.as.ejb3@21.0.1.Final//org.jboss.as.ejb3.deployment.processors.MessageDrivenComponentDescriptionFactory.processAnnotations(MessageDrivenComponentDescriptionFactory.java:83)
	at org.jboss.as.ejb3@21.0.1.Final//org.jboss.as.ejb3.deployment.processors.AnnotatedEJBComponentDescriptionDeploymentUnitProcessor.processAnnotations(AnnotatedEJBComponentDescriptionDeploymentUnitProcessor.java:150)
	at org.jboss.as.ejb3@21.0.1.Final//org.jboss.as.ejb3.deployment.processors.AnnotatedEJBComponentDescriptionDeploymentUnitProcessor.deploy(AnnotatedEJBComponentDescriptionDeploymentUnitProcessor.java:82)
	at org.jboss.as.server@13.0.3.Final//org.jboss.as.server.deployment.DeploymentUnitPhaseService.start(DeploymentUnitPhaseService.java:182)
	... 8 more
```

