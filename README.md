# Marketplace Petblinders - Petshop Online

---

## **Descrição do Projeto**
O **Petblinders** é um marketplace voltado para o segmento de petshops, que permite a comercialização de produtos diversos para animais de estimação. A plataforma busca conectar fornecedores de produtos pet com consumidores finais, oferecendo uma interface intuitiva e eficiente para compras online.

---

## **Principais Funcionalidades Desenvolvidas**

### **1. Gestão de Produtos**
- **Criação de produtos**: Adicione produtos com informações detalhadas como nome, descrição, preço, quantidade disponível e tags associadas.
- **Atualização de produtos**: Permite modificar informações do produto, incluindo nome, descrição e estoque.
- **Remoção de produtos**: Exclusão de produtos descontinuados ou que não devem mais estar disponíveis.
- **Tags**: Organização dos produtos por categorias, com validação de nome único e capitalização automática (primeira letra maiúscula).

---

### **2. Carrinho de Compras**
- **Adicionar itens ao carrinho**: Possibilidade de incluir produtos no carrinho e atualizar a quantidade de itens já existentes.
- **Atualização automática do total**: Recalcula o valor total do carrinho sempre que um produto é adicionado ou removido.
- **Remoção de itens**: Permite excluir itens do carrinho.
- **Validação de estoque**: Garante que o cliente não compre mais do que a quantidade disponível.

---

### **3. Gerenciamento de Usuários**
- **Registro e login**: Módulo de autenticação com credenciais seguras.
- **Perfil do cliente**: Informações básicas, histórico de compras e carrinho associado.
- **Administração**: Área para gerenciar produtos e acompanhar vendas.

---

### **4. Integrações e APIs**
- **Busca avançada**: Pesquisa de produtos por nome ou categorias (tags).
- **Integração com sistemas de pagamento**: Suporte para múltiplos métodos, incluindo cartão de crédito, Pix e boleto bancário.

---

## **Possíveis Melhorias e Funcionalidades Futuras**

### **1. Personalização da Experiência do Usuário**
- **Recomendações personalizadas**: Com base no histórico de compras e nas preferências do cliente.
- **Ofertas e promoções**: Possibilidade de criar descontos exclusivos e campanhas sazonais.

### **2. Suporte ao Vendedor**
- **Área do fornecedor**: Painel para que fornecedores gerenciem seus produtos, acompanhem vendas e analisem relatórios.
- **Cadastro de serviços**: Inclusão de serviços como banho, tosa e adestramento.

### **3. Otimizações no Carrinho de Compras**
- **Compra rápida**: Função para facilitar o processo de compra, evitando múltiplos cliques.
- **Carrinho persistente**: Salva o carrinho do cliente mesmo que ele feche o navegador.

### **4. Expansão da Logística**
- **Cálculo automático de frete**: Integração com APIs de transportadoras e Correios.
- **Rastreamento de pedidos**: Atualizações em tempo real sobre a localização do pedido.

---

## **Tecnologias Utilizadas**
- **Backend**: Spring Boot (Java)
- **Frontend**: React ou Angular (a definir)
- **Banco de Dados**: MySQL ou PostgreSQL
- **Gerenciamento de dependências**: Maven
- **Versionamento**: Git
- **Deploy**: AWS ou Azure

---

## **Como Executar o Projeto**

### **Pré-requisitos**
- Java 17+
- Maven instalado
- Banco de dados configurado (MongoDB Atlas)

### **Passos**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-repositorio/petblinders.git

2. Configure o arquivo *application.properties* com as credenciais do banco de dados.

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run

4. Acesse a aplicação em http://localhost:8080

## Motivo das Escolhas Tecnológicas

### Linguagem Principal: Java
Optamos por **Java** pela sua robustez, confiabilidade e portabilidade. Com forte suporte a orientação a objetos e um ecossistema rico de frameworks, como o **Spring Boot**, facilita a construção de APIs escaláveis e manutenção do sistema no longo prazo.

### Banco de Dados: MongoDB
Escolhemos **MongoDB** por sua flexibilidade no armazenamento de dados não estruturados, ideal para um marketplace onde os produtos podem ter propriedades variadas. Além disso, sua escalabilidade horizontal e desempenho em consultas garantem eficiência no processamento de grandes volumes de dados.