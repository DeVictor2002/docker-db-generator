# Docker DB Generator CLI

Uma ferramenta de linha de comando para gerar rapidamente pastas com `docker-compose.yml` e `.env` prontos para usar com bancos de dados como PostgreSQL.

## 🔧 Instalação

### 👉 Usando `.jar` (Java necessário)

#### Pré-requisitos

- Java 17 ou superior instalado

#### Passo a passo

### 💻 Linux/macOS

1. **Baixe o JAR:**

```bash
mkdir -p ~/docker-db-generator
wget https://github.com/DeVictor2002/docker-db-generator/releases/download/v1.0.1/docker-db-generator.jar -P ~/docker-db-generator/
```
2. **Crie um alias global no terminal:**
  ##### Se estiver usando bash:
```bash
echo "alias docker-db='java -jar ~/docker-db-generator/docker-db-generator.jar'" >> ~/.bashrc
source ~/.bashrc
```
  ##### Se estiver usando zsh:
```zsh
echo "alias docker-db='java -jar ~/docker-db-generator/docker-db-generator.jar'" >> ~/.zshrc
source ~/.zshrc
```
3. **Verifique se funcionou**
```bash
docker-db --help
```

### 🪟 Windows (PowerShell)
1. **Baixe o `.jar`**
  Baixe manualmente o arquivo .jar aqui e salve em uma pasta de sua escolha, por exemplo:
    ```
    C:\Ferramentas\docker-db-generator\
    ```
2. **Crie um alias no PowerShell:**
   Abra o PowerShell e adicione o seguinte comando:
   ```powershell
   Set-Alias docker-db "java -jar C:\Ferramentas\docker-db-generator\docker-db-generator.jar"
   ```
   > Dica: Para tornar esse alias permanente, adicione o comando acima no seu perfil do PowerShell ($PROFILE).
3. **Teste o comando**
   ```powershell
   docker-db --help
   ```
---
## 💡 Suporte atual
- ✅ PostgreSQL
- ✅ MySQL
- ✅ MongoDB
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
