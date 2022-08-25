FROM openjdk:8
EXPOSE 8080
ADD target/nagpband3-1.war nagpband3-1.war
ENTRYPOINT ["java", "-jar", "nagpband3-1.war"]