FROM java:8-jre
MAINTAINER Yusuf Aslan <yyusufaslan@gmail.com>

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

EXPOSE 5000