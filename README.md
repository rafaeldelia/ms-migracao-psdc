# BMC - Scheduling Migration

#### Microsserviço

A aplicação será um scheduler. 

Mais informações técnicas podem ser encontradas no Swagger da API, acessível através do link seguinte (uma vez que esta aplicação for executada): http://localhost:8094/ms-proposta/swagger-ui.html.

A base deste projeto foi gerada com a ferramenta: https://start.spring.io/

##### Índice

1. [ Rodando Projeto Localmente; ](#1-rodando-projeto-localmente)
2. [ Rodando Projeto no K8S; ](#2-rodando-projeto-no-k8s)
3. [ Rotina de Trabalho; ](#3-rotina-de-trabalho)
4. [ Correndo os Testes no Postman; ](#4-correndo-os-testes-no-postman)
5. [ Funcionalidades; ](#5-funcionalidades)
6. [ Outras Informações; e ](#6-outras-informações)
7. [ Arquitetura. ](#7-arquitetura)

<a id="1"></a>

### 1. Rodando Projeto Localmente

##### 1.1. Tenha Instalado

* [Java JDK 11+]
* [Maven]
* [Docker](https://www.docker.com/products/docker-desktop/);

##### 1.2. Passo-a-Passo

1. Clone o projeto;
2. Através do terminal entre na pasta do projeto;
3. Compile o Maven;
4. Abra sua IDE favorita, importe o projeto e o execute normalmente.

```sh
1. git clone <url_do_projeto>
2. cd <nome_da_pasta>
3. mvn package -U
```

##### 2.1. Siga os Passos

1. O Pablo criou um tutorial de como realizar a montagem do ambiente kubernetes.
   Siga-o [clicando aqui](http://gitlab.tools.com.br/nbcbank/cluster/blob/master/enviorment_usuario/README.md);
2. Criar namespace (apenas uma vez);
3. Empacote o projeto
4. Entre na pasta `target` do projeto
5. Aplique o build ao namespace do kukbernetes; e
6. Para mandar o build para o docker registry. Atenção, esse passo acerreta um deploy automático.

```sh
2. kubectl create ns portal-correspondente
3. mvn clean package
4. cd target
5. kubectl apply -f . -n portal-correspondente
6. setup.sh
```

##### 2.2. Check Básico

1. Verificar tudo do namespace, garantir que seu pod está `Running` e verificar a porta do service relacionado;
2. Buscar nós do kubernetes e identificar o ip do nó alvo; e
3. Faça requisições ao postman usando o ip e a porta encontradas pelos comando anteriores.

```sh
1. kubectl -n portal-correspondente get all
2. kubectl get node -o wide
```

### 3. Rotina de Trabalho

- Sempre criar branch para os novos desenvolvimento;
- Sempre efetuar comitts periódicos e com mensagens relevantes;
- Sempre verificar se está **TUDO** funcionando;
- Periodicamente Atualizar o projeto com o comando `git pull`;
- Mesclar com a branch `master` somente ao final do desenvolvimento; e
- Sempre faça testes e salve a versão mais atualizada para os colegas usarem.

### 4. Correndo os Testes no Postman

Simplesmente importe o arquivo `.json` existente na pasta `./src/postman` na interface cliente do Postman.

### 5. Funcionalidades

- [x] Confirmação de Dados Externos;
- [X] Incluir Propostas;
- [x] Buscar clientes;
- [x] Filtrar clientes;
- [x] Cadastrar clientes;

### 6. Outras Informações

De acordo com a documentação, o cadastro de motivos de negação deve ocorrer somente através
de banco de dados. Por tal motivo, não há necessidade de uma funcionalidade de cadastro.

Os itens inseridos previamente podem ser encontrados no script SQL "Insert" presente na
pasta "external_utils" deste projeto.

O modelo de retorno através da classe ResponseMessage é um padrão adotado para todo o
projeto devido à restrições no front-end padrão do NBC.

### 7. Arquitetura

##### 7.1 Apresentação

Não foram feitos diagramas para todo o motor de crédito. Ele segue a sequência indicada pelo nome:
primeiro deve ser executado o passo 1, depois o passo 2 e assim por diante. A quarta etapa
(referente aos documentos relacionados à proposta), porém, é mais complexa e,
por este motivo, é explicada no diagrama abaixo.

![Fluxo de Integração Da Etapa de Documentos](external_utils/Fluxo de Integração Da Etapa de Documentos.png)

Abaixo segue um exemplo de request para o serviço. Destaca-se que o campo "dadosComplementares"
só será utilizado se a ação for igual a "C" (representando a adição dos dados complementares).
O campo "base64Doc" deve ser preenchido com o documento a ser feito upload - este campo só 
será útil se a ação for igual a "A" (representando a adição do documento). A ação "R" representa
resubmeter a proposta / verificar status em serviço externo e, para esta ação, só é necessário 
enviar a ação e o id da proposta (pois, neste momento, o id do documento já estará armazenado na proposta).

```json
{
  "acao": "A",
  "base64Doc": "string",
  "dadosComplementares": {
    "dataEmissao": "19/05/2021",
    "estadoCivil": "Solteiro",
    "nomeCartao": "Jhemeson Mota",
    "nomeEmpresa": "Empresa Top",
    "numeroDocumento": "12315",
    "orgaoEmissor": "STP",
    "tipoDocumento": "1",
    "ufEmissor": "SP",
    "vencimentoFatura": "28/05"
  },
  "propostaId": 38952
}
```

Esta descrição não deseja explicar as regras de negócio (para isso existe a documentação) e não deseja 
substituir a documentação de integração contida no Swagger. Este é apenas um item a mais para auxiliar na compreensão. Estudar os outros dois documentos é de suma importância.

##### 7.2 Diagrama de Contexto

O microsserviço contido neste projeto se comunica com o Front-End React, com o KeyCloak (para autenticação). Na imagem
abaixo (que representa a arquitetura geral do sistema)
este microsserviço é representado por qualquer Spring Boot Microservice, visto que todos estes terão o mesmo
posicionamento arquitetural.

![Diagrama de Contexto](external_utils/NBC%20-%20Visão%20Geral.png)
