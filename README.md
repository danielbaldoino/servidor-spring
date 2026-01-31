# Servidor Spring - TMS API

Sistema de Gerenciamento de Transporte (Transportation Management System) desenvolvido com Spring Boot.

## 📋 Descrição

API REST para gerenciamento de viagens de transporte, incluindo cadastro de motoristas, veículos e viagens. O sistema permite criar, listar, buscar e excluir registros de forma simples e eficiente.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **MySQL** - Banco de dados
- **Lombok** - Redução de código boilerplate
- **SpringDoc OpenAPI** - Documentação da API (Swagger)
- **Maven** - Gerenciamento de dependências

## 📦 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- Java JDK 17 ou superior
- Maven 3.6+
- MySQL 8.0+
- Git

## 🔧 Instalação e Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/danielbaldoino/servidor-spring.git
cd servidor-spring
```

### 2. Configure o banco de dados MySQL

Crie um banco de dados MySQL chamado `tms`:

```sql
CREATE DATABASE tms;
```

### 3. Configure as credenciais do banco de dados

Edite o arquivo `src/main/resources/application.properties` se necessário:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tms
spring.datasource.username=docker
spring.datasource.password=mysql
```

**Nota:** As credenciais padrão são `docker/mysql`. Ajuste conforme sua configuração local.

### 4. Compile o projeto

```bash
./mvnw clean install
```

## ▶️ Como Executar

Execute a aplicação usando Maven:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Documentação da API (Swagger)

Após iniciar a aplicação, acesse a documentação interativa da API:

**Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

**API Docs (JSON):** [http://localhost:8080/api-docs](http://localhost:8080/api-docs)

## 🛣️ Endpoints da API

### Motoristas (Drivers)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/drivers` | Criar novo motorista |
| GET | `/api/drivers` | Listar todos os motoristas |
| GET | `/api/drivers/{id}` | Buscar motorista por ID |
| DELETE | `/api/drivers/{id}` | Excluir motorista |

### Veículos (Vehicles)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/vehicles` | Criar novo veículo |
| GET | `/api/vehicles` | Listar todos os veículos |
| GET | `/api/vehicles/{id}` | Buscar veículo por ID |
| DELETE | `/api/vehicles/{id}` | Excluir veículo |

### Viagens (Trips)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/trips` | Criar nova viagem |
| GET | `/api/trips` | Listar todas as viagens |
| GET | `/api/trips/{id}` | Buscar viagem por ID |
| DELETE | `/api/trips/{id}` | Excluir viagem |

## 📊 Exemplos de Requisições

### Criar Motorista

```bash
curl -X POST http://localhost:8080/api/drivers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "cpf": "12345678900",
    "phone": "(11) 98765-4321",
    "licenseNumber": "123456789",
    "licenseExpiration": "2025-12-31"
  }'
```

### Criar Veículo

```bash
curl -X POST http://localhost:8080/api/vehicles \
  -H "Content-Type: application/json" \
  -d '{
    "licensePlate": "ABC-1234",
    "model": "Caminhão Baú",
    "brand": "Mercedes",
    "year": 2023,
    "capacityKg": 5000.0,
    "vehicleType": "TRUCK"
  }'
```

### Criar Viagem

```bash
curl -X POST http://localhost:8080/api/trips \
  -H "Content-Type: application/json" \
  -d '{
    "origin": "São Paulo",
    "destination": "Rio de Janeiro",
    "departureDate": "2024-02-01",
    "arrivalDate": "2024-02-02",
    "status": "SCHEDULED",
    "driverId": 1,
    "vehicleId": 1
  }'
```

## 📁 Estrutura do Projeto

```
servidor-spring/
├── src/
│   ├── main/
│   │   ├── java/com/example/servidor_spring/
│   │   │   ├── controller/      # Controladores REST
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # Entidades JPA
│   │   │   ├── enums/            # Enumerações
│   │   │   ├── repository/       # Repositórios JPA
│   │   │   └── ServidorSpringApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/                     # Testes
├── pom.xml
└── README.md
```

## 🗃️ Modelo de Dados

### Driver (Motorista)
- `id`: Long (PK)
- `name`: String
- `cpf`: String (único)
- `phone`: String
- `licenseNumber`: String
- `licenseExpiration`: LocalDate

### Vehicle (Veículo)
- `id`: Long (PK)
- `licensePlate`: String (único)
- `model`: String
- `brand`: String
- `year`: Integer
- `capacityKg`: Double
- `vehicleType`: Enum (TRUCK, VAN, etc.)

### Trip (Viagem)
- `id`: Long (PK)
- `origin`: String
- `destination`: String
- `departureDate`: LocalDate
- `arrivalDate`: LocalDate
- `status`: Enum (SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED)
- `driver`: Driver (FK)
- `vehicle`: Vehicle (FK)

## 🧪 Executar Testes

```bash
./mvnw test
```

## 👤 Autor

Daniel Baldoino

## 📄 Licença

Este projeto é um projeto de demonstração.
