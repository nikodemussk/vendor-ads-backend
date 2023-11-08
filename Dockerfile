FROM azul/zulu-openjdk:17-latest

COPY jarFile/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
