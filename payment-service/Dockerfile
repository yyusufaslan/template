FROM java:8-jre
MAINTAINER Yusuf Aslan <yyusufaslan@gmail.com>

ADD ./target/payment-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/payment-service.jar"]

EXPOSE 5000