# springboot-microservices


Neste projeto, é apresentada uma arquitetura baseada em micro-serviços. Todas as aplicações estão desenvolvidas sob o framework Spring. São seis os projetos:
1. **config-server: Servidor de Configuração** 
- Fornece os dados de configuração para os serviços;
- Normalmente, as configurações são recuperadas de um repositório, mas neste projeto, elas estão definidas em arquivos no próprio servidor.
2. **discovery-service: Serviço de Descoberta e Registro de Micro-serviços**
- Possibilita o registro dos micro-serviços de modo que se tenha um ponto central seu monitoramento;
- Fornece informações sobre os micro-serviços registrados para outros micro-serviços.
3. **gateway-service: Serviço de Gateway**
- Consiste em um proxy, recebendo as requisições de delegando para o micro-serviço responsável.
4. **uaa-server: Servidor de Autenticação e Autorização**
- Funciona como provedor de serviço Single Sign On e como um servidor de autorização OAuth2.
5. **account-service: Serviço de Conta**
- Responsável pelo gerenciamento de conta dos usuários.
6. **ui-app: Aplicação UI**
- Fornece um serviço de cadastro de contas.

## Alguns Serviços Oferecidos
### Geração de Token (Servidor de Autenticação)
> curl -X POST \
  'http://localhost:8089/uaa/oauth/token?username=login&password=senha&grant_type=password&client_id=client' \
  -H 'Authorization: Basic Y2xpZW50OmNsaWVudHBhc3N3b3Jk' \

### Serviço de Cadastro de Conta

> curl -X POST \
  http://localhost:8081/accounts/create \
  -H 'Content-Type: application/json'
  -d '{
"name":"Natã",
"login":"natamelo",
"email":"torada.venancio.melo@gmail.com",
"password":"natamelo"
}'

### Serviço de Recuperar Conta pelo Id
> curl -X GET \
  'http://localhost:8081/accounts/1?access_token=c2fb2a4e-b1ac-4883-8fb2-d0f87a1793b0' \
  -H 'Content-Type: application/json' \

### Serviço de Recuperar Conta pelo Login
> curl -X GET \
  'http://localhost:8081/accounts?login=login&access_token=d25921ba-7be4-4562-9955-176006775781' \
  -H 'Content-Type: application/json' 

### Serviço de Atualizar Dados de Conta
> curl -X PUT \
  'http://localhost:8081/accounts/1?access_token=c2fb2a4e-b1ac-4883-8fb2-d0f87a1793b0' \
  -H 'Content-Type: application/json' \
  -d '{
"name":"Natã123",
"email":"torad213.venancio.melo@gmail.com"
}'

### Remover Conta Pelo Id
> curl -X DELETE \
  'http://localhost:8081/accounts/2?access_token=6d0e5878-eb0b-4c88-adc7-59e8fc236b22' 
