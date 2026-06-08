# 🛰️ SentinelEye API
> Global Solution 2026/1 — FIAP — Java Advanced — 2TDS Fevereiro

---

## 🔗 Links do Projeto

| Recurso | Link |
|---|---|
| 🌐 **Deploy (API)** | https://sentineleye-gs.onrender.com |
| 📋 **Swagger UI** | https://sentineleye-gs.onrender.com/swagger-ui/index.html |
| 🎥 **Vídeo de Apresentação** | https://youtu.be/SEU_VIDEO_ID |
| 🎬 **Vídeo Pitch** | https://youtu.be/SEU_PITCH_ID |
| 📁 **Repositório GitHub** | https://github.com/SEU_USUARIO/sentineleye-gs |

---

## 👥 Integrantes

| RM | Nome | Turma |
|---|---|---|
| RM564673 | Nome do Integrante 1 | 2TDS-FEV |
| RM000000 | Nome do Integrante 2 | 2TDS-FEV |
| RM000000 | Nome do Integrante 3 | 2TDS-FEV |

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 3.2.5 |
| Spring Data JPA | 3.2.5 |
| Spring Security + JWT | 3.2.5 + jjwt 0.12.6 |
| Spring Cache | 3.2.5 |
| H2 Database | runtime (dev) |
| PostgreSQL | produção |
| springdoc-openapi (Swagger) | 2.5.0 |
| Lombok | 1.18.30 |
| MapStruct | 1.6.3 |
| Maven | 3.9+ |

---

## 🚀 Instruções de Execução

### Pré-requisitos
- Java 21+
- Maven 3.8+

### Executar localmente

```bash
# 1. Clonar o repositório
git clone https://github.com/SEU_USUARIO/sentineleye-gs.git
cd sentineleye-gs

# 2. Executar
mvn spring-boot:run
```

### Acessos locais

| Recurso | URL |
|---|---|
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| H2 Console | http://localhost:8080/h2-console |
| API Docs | http://localhost:8080/v3/api-docs |

### H2 Console
```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)
```

### Login na API
```
POST /autenticacao/login
usuario: RM1
senha: senha
duracao: 480
```

---

## 📋 Documentação da API

### Autenticação
| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/autenticacao/login` | Gera token JWT |

### Alertas
| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/alertas/todos` | Lista todos os alertas |
| `GET` | `/alertas/{id}` | Busca por ID |
| `GET` | `/alertas/nivel` | Filtra por nível |
| `GET` | `/alertas/substring` | Busca por região/satélite |
| `GET` | `/alertas/paginados` | Lista paginada |
| `POST` | `/alertas/inserir` | Cria alerta → 201 |
| `PUT` | `/alertas/{id}` | Atualiza alerta → 200 |
| `DELETE` | `/alertas/{id}` | Remove alerta → 204 |

### Casos
| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/casos/todos` | Lista todos com linhaTempo |
| `GET` | `/casos/{id}` | Busca por ID |
| `GET` | `/casos/status` | Filtra por status |
| `POST` | `/casos/inserir` | Cria caso → 201 |
| `PUT` | `/casos/{id}` | Atualiza caso → 200 |
| `DELETE` | `/casos/{id}` | Remove caso → 204 |

### Satélites
| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/satelites/todos` | Lista os 4 satélites |
| `GET` | `/satelites/{id}` | Busca por ID |
| `GET` | `/satelites/status` | Filtra por status |
| `GET` | `/satelites/agencia` | Filtra por agência |

### Usuários
| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/usuarios/todos` | Lista todos |
| `GET` | `/usuarios/{id}` | Busca por ID |
| `GET` | `/usuarios/status` | Filtra por status |
| `GET` | `/usuarios/substring` | Busca por nome ou RM |
| `POST` | `/usuarios/novo` | Cria usuário → 201 |
| `DELETE` | `/usuarios/remover/{id}` | Remove → 204 |

---

## ✅ Informações Relevantes para Avaliação

### Requisitos atendidos

**Desenvolvimento da API (20%)**
- API REST com Spring Boot 3.2.5 + Java 21
- Organização em 13 camadas
- Verbos HTTP: GET, POST, PUT, DELETE
- HTTP Status: 200, 201, 204, 400, 404
- Injeção de dependência com `@Autowired`
- Lombok e Spring Boot DevTools

**Persistência de Dados e CRUD (20%)**
- Spring Data JPA com `JpaRepository` em 4 repositórios
- CRUD completo em Alertas e Casos
- DTOs: `AlertaDTO`, `CasoDTO`, `UsuarioDTO`
- Record: `UsuarioResponse`
- Projection: `AlertaProjection`
- Spring Validation com `@NotEmpty`, `@Min`, `@Max`, `@Size`
- Tratamento de exceções com `@RestControllerAdvice`

**Modelagem Avançada (5%)**
- 6 tabelas com relacionamentos 1:N
- Herança: `Pessoa` ← `Usuario`
- Enums: `StatusUsuarioEnum`, `TipoAmeacaEnum`, `TipoEventoEnum`
- Spring Security + JWT stateless
- Autenticação via `POST /autenticacao/login`

**Documentação e Deploy (10%)**
- Swagger/OpenAPI com Bearer JWT
- CORS configurado com `allowedOriginPatterns("*")`
- Deploy público no Render
- README com todos os links

### Extras implementados
- Cache com `@Cacheable` e `@CacheEvict`
- Paginação com `Page<AlertaDTO>`
- Scheduler com `@Scheduled(fixedRate=30000)`
- Mapper manual e automático lado a lado
- Query JPQL e SQL nativa
- Seed: 4 satélites, 6 alertas, 6 casos, 15 eventos
