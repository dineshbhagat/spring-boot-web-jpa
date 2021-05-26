### for mac osx

#### Fresh mariadb installation and do not have mysql installed on machine

```bash
brew install mariadb
```

 Set password for root user

```
sudo /usr/local/bin/mariadb-secure-installation
```
Do not select `Switch to unix_socket authentication`


restart mariadb.

```bash
mysql -u root -p -h localhost
# enter password
MariaDB [(none)]> use mysql
MariaDB [mysql]> select User, plugin from user;
```

| User        | plugin                |
 -------------|---------------------- |
| mariadb.sys | mysql_native_password |
| root        | mysql_native_password |
| userMachineName     | mysql_native_password |
|             |                       |
|             |                       |

5 rows in set (0.001 sec)

##### If you do not want to give password for root user then
- login to mysql shell with priviledge `sudo mysql -u root`
- create your database `CREATE DATABASE yourdb;`
- grant and flush priviledge `GRANT ALL ON yourdb.* TO yournewuser@localhost IDENTIFIED BY 'yourpassword';` , `FLUSH privileges;`

#### Fresh mariadb installation with existing mysql on machine

[Ref](https://stackoverflow.com/a/54368020/2987755) 

- remove existing mysql installation
- unlink all binaries
- install mariadb
- follow steps mention above for `Set password for root user`

##### Add new user

```
mysql -u root -p -h localhost
# enter password if already set
```

```
MariaDB [(none)]> use mysql;
MariaDB [(none)]> show user;
MariaDB [mysql]> show tables;
MariaDB [mysql]> create user nonroot;
MariaDB [mysql]> \q
```
