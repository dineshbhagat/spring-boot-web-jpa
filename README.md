# Spring Boot Web JPA, 

[![HitCount](https://hits.dwyl.com/dineshbhagat/spring-boot-web-jpa.svg?style=flat-square&show=unique)](http://hits.dwyl.com/dineshbhagat/spring-boot-web-jpa)


A Spring Boot application demonstrating JPA/Hibernate relationships (OneToOne, OneToMany, ManyToMany), REST APIs, and Docker deployment.

## Tech Stack

| Technology  | Version                                   |
|-------------|-------------------------------------------|
| Java        | 25                                        |
| Spring Boot | 4.0.5                                     |
| Gradle      | 9.4.1                                     |
| Hibernate   | 6.x (via Spring Boot)                     |
| PostgreSQL  | Runtime driver included                   |
| H2          | In-memory (default for local dev & tests) |
| Lombok      | 1.18.38                                   |
| JUnit       | 5 (Jupiter)                               |

> All dependency versions are centrally managed in [`gradle/libs.versions.toml`](gradle/libs.versions.toml).

---

## Table of Contents

- [Quick Start](#quick-start)
- [Project Structure](#project-structure)
- [ORM to OOPs Mapping](#orm-to-oops-mapping)
  - [@OneToMany / @ManyToOne (Bidirectional)](#onetomany--manytoone-bidirectional)
  - [@ManyToMany](#manytomany)
- [Docker](#docker)
  - [Build & Run with Docker](#build--run-with-docker)
  - [Run with PostgreSQL via Docker](#run-with-postgresql-via-docker)
  - [Docker Compose (alternative)](#docker-compose-alternative)
- [HikariCP Connection Pool Monitoring](#hikaricp-connection-pool-monitoring)
- [Publishing Local JARs](#publishing-local-jars)
- [Useful Resources](#useful-resources)

---

## Quick Start

### Prerequisites

- **Java 25** — the Gradle [JVM Toolchain](https://docs.gradle.org/current/userguide/toolchains.html) will auto-download it if not installed locally
- **Docker** (optional, for containerised deployments)

### Run locally (H2 in-memory database)

```bash
./gradlew bootRun
```

The application starts on [http://localhost:8080](http://localhost:8080).

| Endpoint | Description |
|---|---|
| `GET /health_check` | Returns `{"a":"Hello World!"}` |
| `GET /actuator/health` | Spring Boot Actuator health status |
| `GET /h2-console` | H2 database web console |
| `POST /article` | Create an article |
| `GET /article/{id}` | Get an article by ID |
| `POST /user` | Create a user |
| `GET /user/{id}` | Get a user by ID |
| `POST /comment` | Create a comment |
| `GET /comment/{id}` | Get a comment by ID |

### Run tests

```bash
./gradlew clean build
```

Tests run against an H2 in-memory database (configured in [`src/test/resources/application.properties`](src/test/resources/application.properties)).

---

## Project Structure

```
src/main/java/com/example/
├── DemoApplication.java              # Entry point
├── configuration/
│   └── ApplicationConfiguration.java # RestClient & ObjectMapper beans
├── controller/
│   ├── ArticleCommentController.java # Article, Comment, User REST endpoints
│   ├── MangaController.java          # Manga async/sync search
│   └── TestController.java           # Query param demo
├── converter/                        # Entity → DTO converters
├── dao/                              # Spring Data JPA repositories
├── dto/                              # Data Transfer Objects
├── entity/
│   ├── Article.java                  # @OneToMany ↔ Comment, @ManyToMany ↔ Tag
│   ├── Comment.java                  # @ManyToOne → Article, @OneToOne → User
│   ├── User.java                     # Referenced by Comment
│   ├── Tag.java                      # @ManyToMany ↔ Article
│   ├── Nodes.java                    # @ManyToOne → Nodetypes
│   └── Nodetypes.java                # @OneToMany ↔ Nodes
├── healthchecks/                     # Custom Actuator health indicator
└── service/                          # Business logic layer
```

---

## ORM to OOPs Mapping

Understanding JPA relationships requires these key concepts:

| Concept | Meaning |
|---|---|
| **Unidirectional** | Only one side knows about the relationship |
| **Bidirectional** | Both sides know about the relationship |
| **Owning side** | The entity whose table contains the foreign key |
| **Inverse side** | The other side; uses `mappedBy` to point back to the owning side |

### @OneToMany / @ManyToOne (Bidirectional)

In this project, `Article` ↔ `Comment` is a bidirectional one-to-many relationship:

```
Article (1) ──────< Comment (N)
   │                    │
   │ @OneToMany          │ @ManyToOne
   │ mappedBy=            │ @JoinColumn
   │ "articleTable"       │ name="article_id"
```

**Article.java** (inverse side — has the collection):
```java
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleTable")
private List<Comment> comments;
```

**Comment.java** (owning side — has the FK):
```java
@ManyToOne(optional = false, fetch = FetchType.LAZY)
@JoinColumn(name = "article_id")
private Article articleTable;
```

**Key rules:**
- `@OneToMany` goes on the side with the collection (always the inverse side)
- `@ManyToOne` goes on the side with the single-value reference (always the owning side)
- `mappedBy` value = the field name in the owning entity (`"articleTable"` in `Comment`)
- The owning side's table gets the FK column (`article_id` in the `comment` table)
- `@JsonIgnore` + `@ToString.Exclude` on the `@OneToMany` side to break circular serialisation/toString

### @ManyToMany

`Article` ↔ `Tag` is a many-to-many relationship (one article can have multiple tags; one tag can span multiple articles):

```
Article (N) ──── article_tag ────(N) Tag
                 ┌─────────────┐
                 │ article_id  │
                 │ tag_id      │
                 └─────────────┘
```

**Article.java** (owning side — defines the join table):
```java
@JsonIgnore
@ToString.Exclude
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinTable(
    name = "article_tag",
    joinColumns = {@JoinColumn(name = "article_id")},
    inverseJoinColumns = {@JoinColumn(name = "tag_id")}
)
private Set<Tag> tags;
```

**Tag.java** (inverse side):
```java
@ManyToMany(mappedBy = "tags")
private Set<Article> articles;
```

> **Why `Set` instead of `List`?** Hibernate handles `@ManyToMany` removal more efficiently with `Set`. With `List`, deleting one association causes Hibernate to delete all rows and re-insert N−1, degrading performance.

**Choosing the owning side:** Pick the entity responsible for managing the connection. Since creating an article typically involves choosing its tags, `Article` is the natural owning side.

---

## Entity Relationship Diagram

![article-eer-diagram](https://user-images.githubusercontent.com/3823705/47979440-34a48880-e0e9-11e8-8c6c-7c7f552d7ad3.png)

---

## Docker

The project uses a **multi-stage Dockerfile** for small, secure production images:

| Stage | Base Image | Purpose |
|---|---|---|
| **Builder** | `eclipse-temurin:25-jdk` | Compiles source with Gradle wrapper |
| **Runtime** | `eclipse-temurin:25-jre-alpine` | Minimal JRE-only image (~150 MB) |

**Key features:**
- 🔒 Runs as non-root user (`appuser`)
- 📦 Layer caching — dependencies are downloaded before source is copied
- 🏥 Built-in `HEALTHCHECK` via `/actuator/health`
- 🧠 JVM respects container memory limits (`-XX:MaxRAMPercentage=75.0`)
- ⚡ ZGC garbage collector for low-latency (`-XX:+UseZGC`)

### Build & Run with Docker

```bash
# Build the image (Gradle build happens inside Docker)
docker build -t spring-boot-web-jpa .

# Run with H2 (default)
docker run -p 8080:8080 spring-boot-web-jpa

# Verify
curl http://localhost:8080/actuator/health
# → {"status":"UP"}
```

### Run with PostgreSQL via Docker

```bash
# 1. Start PostgreSQL
docker run -d \
    --name spring-postgresql \
    -p 5432:5432 \
    -e POSTGRES_DB=test \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    postgres:17-alpine

# 2. (Optional) Load seed data
docker exec -i spring-postgresql psql -U postgres -d test < src/main/resources/table.sql

# 3. Build & run the app, linking to PostgreSQL
docker build -t spring-boot-web-jpa .

docker run -p 8080:8080 \
    --link spring-postgresql:postgresql \
    -v $(pwd)/docker/application.properties:/opt/app/application.properties \
    spring-boot-web-jpa

# 4. Verify
curl http://localhost:8080/health_check
# → {"a":"Hello World!"}
```

### Docker Compose (alternative)

For a simpler multi-container setup, create a `docker-compose.yml`:

```yaml
services:
  db:
    image: postgres:17-alpine
    environment:
      POSTGRES_DB: test
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    volumes:
      - ./docker/application.properties:/opt/app/application.properties
    environment:
      JAVA_OPTS: "-XX:MaxRAMPercentage=75.0 -XX:+UseZGC"

volumes:
  pgdata:
```

```bash
docker compose up -d
```

### Useful Docker commands

```bash
# Stop and remove containers
docker compose down

# Stop individual containers
docker container stop spring-boot-web-jpa spring-postgresql

# Remove containers and images
docker container rm -f spring-boot-web-jpa spring-postgresql
docker image rm -f spring-boot-web-jpa
```

---

## HikariCP Connection Pool Monitoring

To inspect connection pool metrics at runtime, either use **VisualVM** (attach to the app process) or add the following code:

```java
MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
ObjectName poolName = new ObjectName("com.zaxxer.hikari:type=Pool (HikariPool-1)");
HikariPoolMXBean poolProxy = JMX.newMXBeanProxy(mBeanServer, poolName, HikariPoolMXBean.class);

System.out.println("Active connections:  " + poolProxy.getActiveConnections());
System.out.println("Idle connections:    " + poolProxy.getIdleConnections());
System.out.println("Total connections:   " + poolProxy.getTotalConnections());
System.out.println("Threads waiting:     " + poolProxy.getThreadsAwaitingConnection());
```

> Enable JMX monitoring in `application.properties`:
> ```properties
> spring.datasource.hikari.register-mbeans=true
> ```

Reference: [HikariCP JMX Monitoring](https://github.com/brettwooldridge/HikariCP/wiki/MBean-(JMX)-Monitoring-and-Management)

---

## Publishing Local JARs

The build includes `maven-publish` plugin. To publish to your local `.m2` repository:

```bash
./gradlew publishToMavenLocal
```

Artifact location: `~/.m2/repository/com/example/demo/<version>/`

To consume it from another project, add `mavenLocal()` to repositories:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}
```

---

## Useful Resources

- [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/reference/)
- [Hibernate Many-to-Many — Baeldung](https://www.baeldung.com/hibernate-many-to-many)
- [JPA OneToMany Bidirectional — LogicBig](https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional.html)
- [Efficiently adding to persistent collections — Hibernate Blog](https://in.relation.to/2024/11/07/adding-to-collections/)
- [Cause of Death: Spring Data JPA — Talk](https://github.com/Persistence-Hub/Talk_CauseOfDeathSpringDataJPA/tree/main) ([Video](https://www.youtube.com/watch?v=AF9RAgGN5CM))
- [Spring Data JPA Tests Examples](https://github.com/simasch/spring-data-jpa-tests)
- [Docker + Spring Boot + MySQL Tutorial](https://springbootdev.com/2017/11/30/docker-spring-boot-and-spring-data-jpa-mysql-rest-api-example-with-docker-without-docker-compose/)
