# 🍃 Spring & Spring Boot Learning & Practice Lab

A structured repository tracking my journey through the **Spring Framework** and **Spring Boot**, featuring hands-on practice projects and core concept demonstrations.

---

## 🛠️ Hands-on Practice Projects

| Module / Project | Focus & Implementation Highlights |
| :--- | :--- |
| `1.DI and IOC` | Inversion of Control container setup and Dependency Injection basics |
| `2.SpringCoreBeans` | Bean configuration, lifecycle management, and custom scopes |
| `3-Bookstore-api` | RESTful API design with CRUD operations and DTO patterns |
| `4JobTrackerApi` | Micro-service with custom request interceptors and filtering |
| `5.AopMiniProject` | Aspect-Oriented Programming with custom annotations and pointcuts |
| `6.JpaRelationshipsTransactionalProject` | Multi-table entity relationships (`@OneToMany`, `@ManyToOne`) & `@Transactional` boundaries |

---

## 📚 Concept Demos & Topic Breakdown

### ⚙️ Core Spring & Lifecycle
* `Ioc_ContainerAnnotationsDemo` — Annotation-driven container configurations (`@Component`, `@Autowired`, `@Qualifier`).
* `BeanScopeDemo` & `BeanLifeCycleDemo` — Exploring singleton/prototype scopes and `PostConstruct`/`PreDestroy` lifecycles.
* `ApplicationPropertiesDemo` & `ProfileDemo` — Environment profiling (`@Profile`), YAML/Properties parsing.

### 🌐 Web, Routing & Interception
* `CrudSpringBootDemo` — Standard controller-service-repository flow with global exception handling.
* `FilterDemo` — Servlet filters for incoming request validation and logging.
* `InterceptorsDemo` — HandlerInterceptor implementations for pre/post controller logic execution.

### 🗄️ Spring Data JPA & Transactions
* `SpringJpaDemo` — Pagination, custom derived queries, and sorting.
* `JpaRelationshipDemo` & `JpaRelationshipdemo2` — Bidirectional entity mappings and cascade rules.
* `TransactionDemo` & `TransactionDemo2` — ACID properties, propagation behaviors, and transaction isolation levels.

### ⚡ Cross-Cutting Concerns
* `SpringAopDemo` — Basic aspects, pointcuts, and advice execution before/after method calls.

---

## 🧰 Tech Stack

* **Language:** Java
* **Framework:** Spring Framework, Spring Boot, Spring Data JPA, Spring AOP
* **Build Tool:** Apache Maven
* **Tools:** Postman, IntelliJ IDEA

---

## 🚀 How to Run Any Module

1. **Clone the repository:**
   ```bash
   git clone https://github.com/NischayaPodder8/Spring.git
   ```

2. **Navigate into any project folder:**
   ```bash
   cd Spring/4JobTrackerApi
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
