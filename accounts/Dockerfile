#start with the base image containing java runtime
FROM openjdk:17-jdk-slim

#info about who maintain this image


#add the app jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]