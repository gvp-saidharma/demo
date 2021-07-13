#
# Build stage
#
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /home/ec2-user/demo
COPY ./ ./
RUN mvn -v
RUN mvn clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/ec2-user/demo/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]