#! /bin/bash -e

echo "Starting Spring application ...."
#JAVA_OPTS in java is not working
#export JAVA_OPTS="-Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Xms1024m -Xmx2048m -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -XshowSettings:vm -version -Dspring.config.location=/opt/mydemo/application.properties"

cat /opt/mydemo/application.properties

java -jar /opt/mydemo/demo-*.jar
