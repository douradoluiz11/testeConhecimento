## Teste Conhecimento - Descrever como executar o projeto

## Framework para testes de UI 

Este é o framework para testes que possui o intuito de facilitar o desenvolvimento, bem como o de trazer boas práticas para resolver alguns problemas de desenvolvimento, como a mudança de ambientes e conexão SSH com servidores. Este Readme possui alguns exemplos para uso de algumas features presentes neste Framework.

### Mudando de ambientes

O framework disponibiliza um arquivo chamado env.conf para que seja cadastrado variáveis para determinados ambientes (url`s, parametros, etc), que devem seguir uma determinada lógica:

```
environments {
    default {
        url = "https://pt.wikipedia.org/wiki"
        nikola_tesla_photo = {?:nikola_tesla}#/media/Ficheiro:Tesla_Sarony.jpg
    }
    english {
        url = "https://en.wikipedia.org/wiki"
        nikola_tesla_photo = {?:nikola_tesla}#/media/File:N.Tesla.JPG
    }
    all {
        nikola_tesla = {?:url}"/Nikola_Tesla"
        tesla_turbine_photo = {?nikola_tesla}"#/media/Ficheiro:TeslaTurbineOriginal.png"
    }
}
```

Os ambientes devem vir dentro de um objeto `environments` onde o objeto `default` será sempre usado, caso não seja passado nenhum parametro de execução. Demais objetos de ambientes podem ser adicionados, como é o caso do objeto `english` no exemplo acima. Além disso, é possível declarar variáveis para todos os ambientes, utilizando o objeto `all`. Os valores de cada variável podem ser substituidos, para diminuir o 'copy-and-paste', tornando a declaração mais maleável, como pode ser observado no exemplo acima nas variáveis `nikola_tesla`, `testla_turbine_photo` e `nikola_tesla_photo`, os mesmos tem o seu valor baseado em outras variáveis.

##### *Executar*

Para executar os testes com o ambiente cadastrado se faz necessário, no momento da execução pelo maven, adicionar um parametro chamado `env` ao comando, Exemplo:

`mvn clean verify -Denv='english'`

O comando acima irá limpar os artefatos gerados anteriormente, executar os testes de integração e irá utilizar o ambiente cadastrado `english`.

##### *Como utilizar as variáveis dentro do código*

Para isso é necessário invocar a classe `EnvironmentResolver` que possui alguns metodos estáticos que lhe ajudaram a recuperar a informação cadastrada:

- `getEnv()`: recupera todo as variáveis configuradas no arquivo env.conf em um Objeto to `Config` da library `com.typesafe.config` para maiores informações verificar o [Repositório](https://github.com/lightbend/config) da mesma;
- `getSsh()`: mesma funcionalidade do `getEnv()`, porém para o arquivo ssh.conf;
- `getConf(String)`: mesma funcionalidade do getEnv, porém para um arquivo personalizado onde o caminho para o mesmo deverá ser passado por parâmetro;
- `getNamedEnvValue(String)`: recupera o valor da variável, cadastrada em env.conf, desejada que deverá ser passado por parâmetro;
- `getNamedConfValue(String,String)`: mesma funcionalidade de `getNamedEnvValue(String)`, porém para um arquivo personalizado, onde a variável desejada e o caminho para o arquivo deverão ser passados por parâmetro.
- `getNamedSsh(String)`: recupera todo as variáveis configuradas em um objeto cadastrado no arquivo ssh.conf, onde o nome do objeto deverá ser passado por parâmetro.

Além disso, o framework já integra a recuperação de valores com algumas funções básicas, como por exemplo `abrirUrlCadastrada(String)` que pode ser usado de forma transparente, da seguinte forma:

```java
interação.abrirUrlCadastrada("nikola_tesla");

```
##### *br.com.inmetrics.teste.driver*

Package onde se encontram os drivers dos navegadores mais utilizados.

##### *br.com.inmetrics.teste.environment*

Classe de gerenciamento de ambientes, como explicado acima.
