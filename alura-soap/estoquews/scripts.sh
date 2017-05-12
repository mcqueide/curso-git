# geração de contrato wsdl
wsgen -cp bin br.com.caelum.estoque.ws.EstoqueWS -wsdl

# geração de projeto SOAP com contract first pelo wildfly
sh wsconsume.sh -k -n -o /Users/nico/workspace/estoque-web/src /Users/nico/workspace/estoque-web/src/EstoqueWSServiceCap5.wsdl

# geração das classe do projeto cliente do WebService
wsimport -s src -p br.com.caelum.estoque.cliente http://localhost:8080/estoquews-web/EstoqueWS?wsdl
