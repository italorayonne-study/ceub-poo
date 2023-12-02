# Sistematização - POO

![Logo da Empresa](./.github/download.png)

Implementação de uma API REST para o gerenciamento de pacotes e usuários entregadores.

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- [Docker](https://www.docker.com/)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/italorayonne-study/ceub-poo/tree/master/sistematizacao
   cd sistematizacao
   ```

## Executando o Projeto

Agora, você está pronto para iniciar os serviços usando o Docker Compose. Abra um terminal na pasta do projeto e execute o seguinte comando:

   ```bash
   docker-compose up --build
   ```

Este comando criará e iniciará os contêineres conforme definido no arquivo docker-compose.yml. A aplicação estará disponível em http://localhost

# Testando a API

1. Abra o Postman. Caso não tenha baixe aqui (https://www.postman.com/).

2. Importe a collection 'ceub-sistematizacao.postman_collection' localizada na raiz do projeto

![Tela do Postman](./.github/Screenshot%202023-12-02%20120242.png)