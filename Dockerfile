#define base docker image
#This line tells Docker to use the official OpenJDK 11 image as the base for your container.
FROM openjdk:11

#set the working directory
WORKDIR /app

#Copy the spring boot application
COPY target/first-project-0.0.1-SNAPSHOT.jar /app

#Expose the application port
EXPOSE 8080

#Run the application
CMD ["java", "-jar", "first-project-0.0.1-SNAPSHOT.jar"]
