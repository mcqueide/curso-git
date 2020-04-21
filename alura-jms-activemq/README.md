# alura-jms-activemq

Esse é um projeto com base no curso da alura JMS e ActiveMQ para praticar o conteúdo do curso.

## configurações

- Baixar o arquivo do [ActiveMQ](https://s3.amazonaws.com/caelum-online-public/jms/apache-activemq-5.12.0-bin.zip)
- No windows é necessário executar o `InstallService.bat` antes que está na bin/win32 ou bin/win64
- Iniciar o ActiveMQ com o script com o comando `bin\activemq active` (windows) ou `sh bin/activemq console` (linux)
- Abrir a página `http://localhost:8161/admin`, login: admin e senha: admin
- Lembrar de adicionar o **activemq-all-5.12.0.jar** no classpath.

## aula 6

Para configurar autenticação e autorização no activemq, edite o arquivo `conf/activemq.xml` adicionando o conteúdo
abaixo dentro do **<broker>...</broker>**. Lembrar de adicionar as credenciais na criação das conexões 
`Connection connection = cf.createConnection("user", "senha");`

```xml
<plugins>
    <simpleAuthenticationPlugin anonymousAccessAllowed="false">
        <users>
            <authenticationUser username="admin" password="admin" groups="users,admins"/>
            <authenticationUser username="user" password="senha" groups="users"/>
            <authenticationUser username="guest" password="senha" groups="guests"/>
        </users>
    </simpleAuthenticationPlugin>

    <authorizationPlugin>
        <map>
            <authorizationMap>
                <authorizationEntries>
                    <authorizationEntry queue="fila.financeiro" read="users" write="users" admin="users,admins" />
                    <authorizationEntry topic="comercial" read="users" write="users" admin="users,admins" />
                    <authorizationEntry topic="topico.loja" read="users" write="users" admin="users,admins" />
                    <authorizationEntry topic="ActiveMQ.Advisory.>" read="users,admins" write="users,admins" admin="users,admins"/>
                </authorizationEntries>
                <tempDestinationAuthorizationEntry>
                    <tempDestinationAuthorizationEntry read="admin" write="admin" admin="admin"/>
                </tempDestinationAuthorizationEntry>
            </authorizationMap>
        </map>
    </authorizationPlugin>
</plugins>
```

## aula 8, habilitar prioridades no activemq

Para habilitar prioridade no activemq, edite o arquivo `conf/activemq.xml` adicionando o conteúdo
abaixo dentro do  **<destinationPolicy><policyMap><policyEntries>...</policyEntries></policyMap></destinationPolicy>**.

```xml
<policyEntry queue=">" prioritizedMessages="true"/>
```