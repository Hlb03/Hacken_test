FROM openjdk:21

COPY /target/HackenTest-v1.0.jar /hacken_test/HackenTest-v1.0.jar

ENTRYPOINT ["java", "-jar", "/hacken_test/HackenTest-v1.0.jar"]