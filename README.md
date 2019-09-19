## spring-boot-web-jpa
---------------------------------------------------------------------------------------------------------------

Using Java-8, Spring-boot, mysql, Docker, [2-level-hibernate-cache](https://github.com/dineshbhagat/Spring-boot-JPA-Two-Level-Cache)

---------------------------------------------------------------------------------------------------------------


ORM to OOPs mapping need understanding of the following terms:  
Bidirectional, unidirectional, ownedBy,mappedBy, inversedBy, oneToOne, oneToMany, manyToMany, joinColumn,inverseJoinColumns, joinTable,

- Relationships may be bidirectional or unidirectional.
- A bidirectional relationship has both an owning side and an inverse side
- A unidirectional relationship only has an owning side.

In bidirectional *one-to-many/many-to-one* relationship, the target side has a reference back to the source entity as well. 

The owning side of a `@OneToOne` assocation is the entity with the table containing the foreign key.

The annotation `@OneToMany` is used on the side which has the collection reference(always the inverse side of a bidirectional assocation)  
The annotation `@ManyToOne` is used on the side which has the single-valued back reference(always the owning side of a bidirectional assocation)  
We must use `'mappedBy'` element of the `@OneToMany` annotations to specify that the corresponding table will be the parent table.  
In other words the other side (which has `@ManyToOne`) will be the foreign-key table (child table).  
The value of `'mappedBy'` element should be the name of the `reference variable` used in the other class's back reference.  
The side which has `'mappedBy'` specified, will be the target entity of the relationship and corresponding table will be the parent of the relationship(has to be specified on the inversed side of a (bidirectional) association)   
The side which doesn't have `'mappedBy'` element will be the source (owner) and the corresponding table will be the child of the relationship, i.e. it will have the foreign key column.  
On the owner side, we can also use `@JoinColumn`, whose one of the purposes is to specify a foreign key column name instead of relying on the default name.  
`inversedBy` has to be specified on the owning side of a (bidirectional) association.  


##### @ManyToMany

1. One article can have multiple tags: e.g. java, hibernate, jpa etc.    
   one tag can be a part of multiple Articles   
   For Many-To-Many associations you can chose which entity is the owning and which the inverse side.  
   There is a very simple semantic rule to decide which side is more suitable to be the owning side from a developers perspective.  
   You only have to ask yourself, which entity is responsible for the connection management and pick that as the owning side.  
   Take an example of two entities Article and Tag.  
   Whenever you want to connect an Article to a Tag and vice-versa, it is mostly the Article that is responsible for this relation.  
   Whenever you add a new article, you want to connect it with existing or new tags.  
   Your create Article form will probably support this notion and allow to specify the tags directly.  
   This is why you should pick the Article as owning side, as it makes the code more understandable:  
   Annotate variables in both entity class with @ManyToMany

   ```java
   @Entity
   @Table(name = "article")
   @Data
   public class Article {
      ...
      @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Lazy loading of records
      private Set<Tag> tags;
      ...
   }
   ```


   ```java
   @Entity
   @Table(name = "tag")
   @Data
   public class Tag {
      ...
      @ManyToMany(mappedBy = "tags") // tags is instance variable in Article entity 
      private Set<Article> articles;
      ...
   }
   ```

2. Now to achive this we need to map relationship among Tags and Articles,  
   So we need an extra table where we will store the relationship  
   Let say table: `article_tag`, it has primary key of both article and tag table  

   ```sql
   CREATE TABLE `article_tag` (
      `article_id` int(11) NOT NULL,
      `tag_id` int(11) NOT NULL,
      UNIQUE KEY `uq_article_tag` (`article_id`,`tag_id`),
      KEY `article_id_idx` (`article_id`),
      KEY `tag_id_idx` (`tag_id`),
      CONSTRAINT `` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
      CONSTRAINT `tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   ```

3. Lets use this table as joining table for two entities Tags and Article
   So Let's annotate it with @JoinTable,  
   but which field? `Article.tags` or `Tag.articles`  
   To answer that we need to understand [owning side and reverse side](https://stackoverflow.com/q/2749689/2987755)
   Since owning side is Article, Lets define `@JoinTable` on Article entity.
   
      ```java
      @Entity
      @Table(name = "article")
      @Data
      public class Article {
         ...
         @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Lazy loading of records
         @JoinTable(
            name = "article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
         )
         private Set<Tag> tags;
         ...
      }
   ```
4. But This will introduce circular dependency for Jackson when it serialize/deserialize because Article depends on tag and tag intern depends on article so we will get stackoverflow error.  
To break this we need to ignore property from one of the entity by annotating it with `@JsonIgnore`.  
Ths same issue will persist if application tries to print entities which intern will call ToString methods and again circular dependency so to break this we need to annotate it with `@ToString.Exclude`

      ```java
      @Entity
      @Table(name = "article")
      @Data
      public class Article {
         ...
         @JsonIgnore
         @ToString.Exclude
         @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Lazy loading of records
         @JoinTable(
            name = "article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
         )
         private Set<Tag> tags;
         ...
      }
   ```


Ref: 
- https://www.baeldung.com/hibernate-many-to-many  
- https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional.html  
- https://stackoverflow.com/q/12493865/2987755  

---------------------------------------------------------------------------------------------------------------
![article-eer-diagram](https://user-images.githubusercontent.com/3823705/47979440-34a48880-e0e9-11e8-8c6c-7c7f552d7ad3.png)


---------------------------------------------------------------------------------------------------------------

#### Dockerize your application:   

If your application has multiple dependencies then there are two way to dockerize whole application infra viz.  
1. Create individual images for each components and link them together once containers are up
2. using docker-compose

Let see approach 1.

Prerequisite:
Install following docker related software and packages
- [Docker](https://www.docker.com/products/docker-engine)
- [Docker-toolbox](https://docs.docker.com/toolbox/) 



1. get mysql server image  
`docker pull mysql:8`

   check image list  
   `docker images -a`


2. Run mysql image ==> it means create mysql container (lets name it as spring-mysql)

   `docker run --name spring-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -e MYSQL_USER=root -e MYSQL_PASSWORD=root -d mysql/mysql-server:8.0`


   By default, when you create a container, it does not publish any of its ports to the outside world.  
   To make a port available to services outside of Docker, or to Docker containers which are not connected to the container’s network, use the --publish or -p flag.   
   This creates a firewall rule which maps a container port to a port on the Docker host. Here are some examples

   `-p <docker-host-port>:<Docker-port>`
   
   `-p 8080:80/tcp -p 8080:80/udp` //Map TCP port 80 in the container to TCP port 8080 on the Docker host, and map UDP port 80 in the container to UDP port 8080 on the Docker host.  

3. You should get your container in list  
`docker ps`

4. connect to mysql create DB and insert data by connecting to container via shell  
   `docker exec -it spring-mysql bash`
   `mysql -uroot -proot`

   //execute mysql commands for DB,table creation and insert data  
   [table.sql](src/main/resources/table.sql)

5. Build your application image from Dockerfile  

   Update [application.properties](src/main/resources/application.properties) file with file at [here](docker/application.properties)  
   Difference between two file is database url
 
   `spring.datasource.url=jdbc:mysql://spring-mysql:3306/test`
   here: spring-mysql is mysql container name


   Build application  
    `./gradlew clean build`

   To create image we need to write [`Dockerfile`](Dockerfile)   


   Create image file with name :spring-boot-web-jpa  
     `docker build . -t spring-boot-web-jpa`

   check images, should show above image  
     `docker images`

6. if there are existing images or container, stop them or delete them  
   `docker container rm -f spring-boot-web-jpa-mysql spring-mysql && docker container list && docker image rm -f spring-boot-web-jpa && docker images`

7. link mysql with spring-boot application and create container(name : spring-boot-web-jpa-mysql)  
   `docker run -p 8080:8080 --name spring-boot-web-jpa-mysql --link spring-mysql:mysql spring-boot-web-jpa`  
you can run in detach mode  
   `docker run -p 8080:8080 --name spring-boot-web-jpa-mysql --link spring-mysql:mysql -d spring-boot-web-jpa`


8. To Stop container  
   `docker container stop <container-name or container id>`  



Ref:   
1. https://springbootdev.com/2017/11/30/docker-spring-boot-and-spring-data-jpa-mysql-rest-api-example-with-docker-without-docker-compose/  
2. https://springbootdev.com/2018/01/09/spring-boot-rest-api-with-docker-with-docker-compose/



----------------------------------------------------------------------------------------------------------------
If you want to identify number of connections for hikari
1. Open application in visualVM, attach to application process and check 
2. Log in application logs/System.out.println
```java
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName poolName = new ObjectName("com.zaxxer.hikari:type=Pool (HikariPool-1)");
            HikariPoolMXBean poolProxy = JMX.newMXBeanProxy(mBeanServer, poolName, HikariPoolMXBean.class);

            System.out.println("idleConnection before sleep:"+ poolProxy.getIdleConnections());
            System.out.println("getActiveConnections before sleep:"+ poolProxy.getActiveConnections());
            System.out.println("getIdleConnections before sleep:"+ poolProxy.getIdleConnections());
            System.out.println("getThreadsAwaitingConnection before sleep:"+ poolProxy.getThreadsAwaitingConnection());
            System.out.println("getTotalConnections before sleep:"+ poolProxy.getTotalConnections());
            Thread.sleep(10000);
            System.out.println("idleConnection after sleep:"+ poolProxy.getIdleConnections());
            System.out.println("getActiveConnections after sleep:"+ poolProxy.getActiveConnections());
            System.out.println("getIdleConnections after sleep:"+ poolProxy.getIdleConnections());
            System.out.println("getThreadsAwaitingConnection after sleep:"+ poolProxy.getThreadsAwaitingConnection());
            System.out.println("getTotalConnections after sleep:"+ poolProxy.getTotalConnections());
```

[Ref](https://github.com/brettwooldridge/HikariCP/wiki/MBean-(JMX)-Monitoring-and-Management)

---------------------------------------------------------------------------------------------------------------
