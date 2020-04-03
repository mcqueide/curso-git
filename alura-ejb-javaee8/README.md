# Agendamento de email

Esse é um sistema para estudo com base no curso da alura "EJB com Java EE 8: API Rest com WildFly 15".

## Criação do banco de dados

```sql
CREATE USER 'agendamento'@'localhost' IDENTIFIED BY 'agendamento';
GRANT ALL PRIVILEGES ON * . * TO 'agendamento'@'localhost';
CREATE DATABASE agendamentobd;
```

## Configurando o driver e datasource no wildfly

Rodar o jboss-cli
```
$JBOSS_HOME/bin/jboss-cli.sh --connect
```

Para adicionar o JAR como module use:
```
module add --name=com.mysql --resources=C:\jdbc_drivers\mysql-connector-java-8.0.19.jar --dependencies=javax.api,javax.transaction.api
```

Para definir o module como driver:
```
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
```

No comando abaixo, que define o datasource, altere o host, usuário e a senha baseado na sua configuração do banco:
```
data-source add --name=AgendamentoDS --jndi-name=java:jboss/datasources/AgendamentoDS --driver-name=mysql  --connection-url=jdbc:mysql://192.168.99.100:3306/agendamentobd --user-name=root --password=root --min-pool-size=10 --max-pool-size=20
```

## Configurando o java mail no wildfly

Criar uma conta no mailtrap, e executar os comandos abaixo no jboss-cli.sh. Lembrar de alterar o username e password.
```
/subsystem=mail/mail-session=agendamentoMailSession:add(jndi-name=java:jboss/mail/AgendamentoMailSession)
/socket-binding-group=standard-sockets/remote-destination-outbound-socket-binding=my-smtp-binding:add(host=smtp.mailtrap.io, port=2525)
/subsystem=mail/mail-session=agendamentoMailSession/server=smtp:add(outbound-socket-binding-ref= my-smtp-binding, username={username}, password={password}, tls=true)
```

## Configurando fila no wildfly

```
jms-queue add --queue-address=EmailQueue --entries=java:/jms/queue/EmailQueue
```

Comando para listar mensagens na fila
```
/subsystem=messaging-activemq/server=default/jms-queue=EmailQueue:list-messages
```

Comando para listar mensagens que tiveram erro no processamento
```
/subsystem=messaging-activemq/server=default/jms-queue=DLQ:list-messages
```
