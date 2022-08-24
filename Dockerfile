FROM openjdk:8
EXPOSE 8080
ADD target/nagp-band-3-1.war nagp-band-3-1.war
ENTRYPOINT ["java", "-war", "nagp-band-3-1.war"]