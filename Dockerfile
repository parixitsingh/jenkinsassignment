FROM openjdk:8
EXPOSE 8080
ADD target/nagpband3-1.jar nagpband3-1.jar
ENTRYPOINT ["java", "-jar", "nagpband3-1.jar"]