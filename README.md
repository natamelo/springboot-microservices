# springboot-microservices


Neste projeto, é apresentada uma arquitetura baseada em micro-serviços. Todas as aplicações estão desenvolvidas sob o framework Spring. São seis os projetos:
1. config-server: Servidor de Configuração 
- Fornece os dados de configuração para os serviços;
- Normalmente, as configurações são recuperadas de um repositório, mas neste projeto, elas estão definidas em arquivos no próprio servidor.
2. discovery-service: Serviço de Descoberta e Registro de Micro-serviços
- Possibilita o registro dos micro-serviços de modo que se tenha um ponto central seu monitoramento;
- Fornece informações sobre os micro-serviços registrados para outros micro-serviços.
3. gateway-service: Serviço de Gateway
- Consiste em um proxy, recebendo as requisições de delegando para o micro-serviço responsável.
4. uaa-server: Servidor de Autenticação e Autorização
- Funciona como provedor de serviço Single Sign On e como um servidor de autorização OAuth2.
5. account-service: Serviço de Conta
- Responsável pelo gerenciamento de conta dos usuários.
6. ui-app: Aplicação UI
- Fornece um serviço de cadastro de contas.

