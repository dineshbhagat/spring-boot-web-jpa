#### for mac osx

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

#### Fresh mariadb installation with existing mysql on machine

[Ref](https://stackoverflow.com/a/54368020/2987755) 

- remove existing mysql installation
- unlink all binaries
- install mariadb
- follow steps mention above for `Set password for root user`
