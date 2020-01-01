FROM java:8-jre
MAINTAINER Yusuf Aslan <yyusufaslan@gmail.com>

ADD ./target/billing-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/billing-service.jar"]

EXPOSE 5000