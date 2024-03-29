# Translator API

Projeto de um backend para realização de traduções.

<br/>

## 🛠 Tecnologias

- Spring Boot
- Java

<br/>

## Instalação
<br/>

> Começaramos clonando o projeto e acessando a pasta do projeto:
```
git clone https://github.com/gabriellgjs/translator && cd translator
```

<br/>

>Criando o ambiente do projeto:
```
docker-compose -f .docker/docker-compose.yml up -d --build
```
<br/>

>Ou se preferir use o Make:
```
make start
```

<br/>

---
## Rotas
| Url                               | Método | Uso             |
| :---------------------------------|:-------|:----------------|
| /translate                            | POST   | Traduz um texto |

## Dados para consumir a rota de tradução

##### *POST* Request: `/translate`

- Retorna  a tradução
- Os dados obrigatórios são:
    *  `lang_from`: o idioma de original <a href="#enuns">(Enum de String)</a>
    *  `lang_to`: o idioma para qual vai ser traduzido <a href="#enuns">(Enum de String)</a>
    *  `text`: o texto a ser traduzido (String) 
  
  <br/>

- Exemplo de request:

    ```
        {
            "lang_from": "PORTUGUESE",
            "lang_to": "ENGLISH",
            "text": "Testando essa aplicação"
        }
    ```

  <br/>

- Exemplo de response:
  ```
    {
    "result": "Testing this application"
    }
  ```

<br/>

---

<h2 id="enuns"> Idiomas Suportados </h2> 


| Idioma      | Enum             |
|:------------|:-----------------|
| Russo       | RUSSIAN          |
| Inglês      | ENGLISH          |
| Árabe       | ARABIC           |
| Azerbaijano | AZERBAIJANI      |
| Catalã      | CATALAN          |
| Mandarim    | CHINESE          |
| Tcheca      | CZECH            |
| Dinamarquês | DANISH           |
| Holandês    | DUTCH            |
| Esperanto   | ESPERANTO        |
| Finlandês   | FINNISH          |
| Francês     | FRENCH           |
| Alemão      | GERMAN           |
| Grego       | GREEK            |
| Hebraico    | HEBREW           |
| Hindi       | HINDI            |
| Húngaro     | HUNGARIAN        |
| Indonésio   | INDONESIAN       |
| Irlandês    | IRISH            |
| Italiano    | ITALIAN          |
| Japonês     | JAPANESE         |
| Coreano     | KOREAN           |
| Persa       | PERSIAN          |
| Polonês     | POLISH           |
| Português   | PORTUGUESE       |
| Eslovaco    | SLOVAK           |
| Espanhol    | SPANISH          |
| Sueco       | SWEDISH          |
| Turco       | TURKISH          |
| Ucraniano   | UKRAINIAN        |

<br/>

