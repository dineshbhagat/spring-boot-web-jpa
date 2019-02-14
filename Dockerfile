FROM alpine:3.9
#FROM ubuntu:18.04
LABEL maintainer="dinesh"

# following will be like
# RUN apt-get update && apt-get install -y  openjdk-8-jre openjdk-8-jdk openjfx git maven && ca-certificates-java && apt-get clean &&
# rm -rf /var/lib/apt/lists/* && rm -rf /var/cache/oracle-jdk8-installer;
#RUN apt-get update && apt-get install -y \
#    openjdk-8-jre \
#    openjdk-8-jdk \
##    openjfx \
##    git \
##    maven && \
## Fix certificate issues, found as of
## https://bugs.launchpad.net/ubuntu/+source/ca-certificates-java/+bug/983302
#    ca-certificates-java && \
#    apt-get clean && \
#    rm -rf /var/lib/apt/lists/* && \
#    rm -rf /var/cache/oracle-jdk8-installer;

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8


#ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
#RUN export JAVA_HOME

# add a simple script that can auto-detect the appropriate JAVA_HOME value
# based on whether the JDK or only the JRE is installed
RUN { \
		echo '#!/bin/sh'; \
		echo 'set -e'; \
		echo; \
		echo 'dirname "$(dirname "$(readlink -f "$(which javac || which java)")")"'; \
	} > /usr/local/bin/docker-java-home \
	&& chmod +x /usr/local/bin/docker-java-home
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/jre/bin:/usr/lib/jvm/java-1.8-openjdk/bin

ENV JAVA_VERSION 8u191
ENV JAVA_ALPINE_VERSION 8.191.12-r0

RUN set -x \
	&& apk add --no-cache \
		openjdk8="$JAVA_ALPINE_VERSION" \
	&& [ "$JAVA_HOME" = "$(docker-java-home)" ]



RUN mkdir /opt/mydemo

RUN ls /opt/

ADD build/libs/* /opt/mydemo/
ADD build/resources/main/* /opt/mydemo/
ADD docker/* /opt/mydemo/

RUN chmod 755 /opt/mydemo/

EXPOSE 8080
EXPOSE 5432

RUN ls /opt/mydemo/
WORKDIR /opt/mydemo/

ENTRYPOINT sh /opt/mydemo/run.sh
