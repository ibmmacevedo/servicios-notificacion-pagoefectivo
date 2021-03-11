FROM maven:3.5-jdk-8-alpine as BUILD
ENV HOME=/home/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
# 1. add pom.xml only here
ADD pom.xml $HOME
# 2. start downloading dependencies
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "dependency:go-offline"]
# 3. add all source code and start compiling
ADD . $HOME
RUN ["mvn", "package", "-DskipTests"]

FROM adoptopenjdk/openjdk8-openj9
VOLUME /tmp
EXPOSE 8080
COPY --from=BUILD /home/usr/app/target/servicios-notificacion-pagoefectivo.jar servicios-notificacion-pagoefectivo.jar
ENTRYPOINT ["java","-jar","/servicios-notificacion-pagoefectivo.jar"]

