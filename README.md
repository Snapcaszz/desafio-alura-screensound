# ScreenSound Application

A ScreenSound é uma aplicação de linha de comando desenvolvida em Java utilizando o Spring Boot. Seu principal objetivo é consultar a API do Vagalume para obter informações sobre artistas e músicas, e armazenar esses dados em um banco de dados. Além disso, a aplicação permite buscar informações adicionais sobre artistas na web utilizando a API do OpenAI.

## Funcionalidades

- Registrar Artista
- Registrar Música
- Listar Músicas
- Listar Músicas por Artista
- Listar Artistas
- Buscar Artista na Web

## Requisitos

- Java 11+
- Spring Boot
- Dependências Maven (especificadas no `pom.xml`)
- Banco de dados configurado (ex.: MySQL, PostgreSQL)
- Credenciais da API do Vagalume
- Credenciais da API do OpenAI

## Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/Snapcaszz/desafio-alura-screensound.git
   cd desafio-alura-screensound
   ```
2. Configure as variáveis de ambiente:

- VAGALUME_CREDENTIALS: Credenciais da API do Vagalume.
- OPEN_AI_KEY: Credenciais da API do OpenAI.

3. Configure o Banco de dados no arquivo 'aplication.properties'
4. Execute a aplicação: 

```bash
  ./mvnw spring-boot:run
```
## Uso

Após iniciar a aplicação, você verá o seguinte menu no terminal:

```shell
*** Screen Sound ***

1 - Register Artist
2 - Register Music
3 - List Musics
4 - List Musics by Artist
5 - List Artists
6 - Search Artist on Web

0 - Exit

Select an option: 
```

Digite o número correspondente à ação que deseja realizar e siga as instruções fornecidas pela aplicação.

## Contribuição

Sinta-se à vontade para contribuir com o projeto. Você pode abrir issues e pull requests no GitHub. Certifique-se de seguir as boas práticas de desenvolvimento e incluir testes para suas alterações.

## Disclaimer
Este projeto tem fins educativos e, portanto, muitos erros de input não foram tratados propositalmente. Use com cautela e sinta-se à vontade para melhorar o tratamento de erros conforme necessário.