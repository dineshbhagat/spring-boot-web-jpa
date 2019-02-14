# spring-boot-web-jpa
---------------------------------------------------------------------------------------------------------------
Using Java-8

Ref: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional.html

In bidirectional *one-to-many/many-to-one* relationship, the target side has a reference back to the source entity as well.  
The annotation `@OneToMany` is used on the side which has the collection reference.  
The annotation `@ManyToOne` is used on the side which has the single-valued back reference.  
We must use `'mappedBy'` element of the `@OneToMany` annotations to specify that the corresponding table will be the parent table.  
In other words the other side (which has `@ManyToOne`) will be the foreign-key table (child table).  
The value of `'mappedBy'` element should be the name of the reference variable used in the other class's back reference.  
The side which has `'mappedBy'` specified, will be the target entity of the relationship and corresponding table will be the parent of the relationship.  
The side which doesn't have `'mappedBy'` element will be the source (owner) and the corresponding table will be the child of the relationship, i.e. it will have the foreign key column.  
On the owner side, we can also use `@JoinColumn`, whose one of the purposes is to specify a foreign key column name instead of relying on the default name.  

---------------------------------------------------------------------------------------------------------------
![article-eer-diagram](https://user-images.githubusercontent.com/3823705/47979440-34a48880-e0e9-11e8-8c6c-7c7f552d7ad3.png)


---------------------------------------------------------------------------------------------------------------

**** Dockerize your application:   

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



Ref 1. https://springbootdev.com/2017/11/30/docker-spring-boot-and-spring-data-jpa-mysql-rest-api-example-with-docker-without-docker-compose/
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
