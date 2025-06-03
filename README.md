# Docker DB Generator CLI

Uma ferramenta de linha de comando para gerar rapidamente pastas com `docker-compose.yml` e `.env` prontos para usar com bancos de dados como PostgreSQL.

## 🔧 Instalação
### 👉 Usando `.jar` (Java necessário)

#### Pré-requisitos
- Java 17+ instalado

#### Passos
1. Baixe o `.jar` na [página de releases](https://github.com/DeVictor2002/docker-db-generator/releases/tag/v1.0.0)
2. Crie um alias global no seu terminal:

##### Linux/macOS (bash/zsh)
```bash
echo "alias docker-db='java -jar /caminho/para/docker-db-generator.jar'" >> ~/.bashrc
# ou para zsh:
echo "alias docker-db='java -jar /caminho/para/docker-db-generator.jar'" >> ~/.zshrc
source ~/.bashrc  # ou source ~/.zshrc
```
##### Windows (PowerShell)
```powershell
Set-Alias docker-db "java -jar C:\caminho\para\docker-db-generator.jar"
```
#### Exemplo de uso
```bash
docker-db postgres meu_banco
```
> Isso criará uma pasta postgres-docker/ com os arquivos .env e docker-compose.yml.
---
## 💡 Suporte atual
- ✅ PostgreSQL
- 🚧 MySQL (em breve)
- 🚧 MongoDB (em breve)
---
## 📝 Exemplo de arquivos gerados
### `.env`
```env
POSTGRES_USER=admin
POSTGRES_PASSWORD=admin123
POSTGRES_DB=meu_banco
POSTGRES_PORT=5432
```
### `docker-compose.yml`
```yaml
services:
  db:
    image: postgres:latest
    container_name: postgres_container
    ports:
      - "${POSTGRES_PORT}:5432"
    environment:
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_DB: ${POSTGRES_DB}
```
---
## 🛠 Como contribuir
Sinta-se livre para abrir issues, enviar PRs com suporte a novos bancos ou melhorias!
