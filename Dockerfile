FROM openjdk:8
EXPOSE 3000
ADD target/nagpband3-1.jar nagpband3-1.jar
ENTRYPOINT ["java", "-jar", "nagpband3-1.jar"]