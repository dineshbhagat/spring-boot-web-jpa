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
