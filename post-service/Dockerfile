FROM java:8-jre
MAINTAINER Yusuf Aslan <yyusufaslan@gmail.com>

ADD ./target/post-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/post-service.jar"]

EXPOSE 5000