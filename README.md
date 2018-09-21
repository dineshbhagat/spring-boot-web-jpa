# spring-boot-web-jpa


---------------------------------------------------------------------------------------------------------------
Ref: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional.html

In bidirectional one-to-many/many-to-one relationship, the target side has a reference back to the source entity as well.
The annotation @OneToMany is used on the side which has the collection reference.
The annotation @ManyToOne is used on the side which has the single-valued back reference.
We must use 'mappedBy' element of the @OneToMany annotations to specify that the corresponding table will be the parent table. In other words the other side (which has @ManyToOne) will be the foreign-key table (child table).
The value of 'mappedBy' element should be the name of the reference variable used in the other class's back reference.
The side which has 'mappedBy' specified, will be the target entity of the relationship and corresponding table will be the parent of the relationship .
The side which doesn't have 'mappedBy' element will be the source (owner) and the corresponding table will be the child of the relationship, i.e. it will have the foreign key column.
On the owner side, we can also use @JoinColumn, whose one of the purposes is to specify a foreign key column name instead of relying on the default name.

---------------------------------------------------------------------------------------------------------------
