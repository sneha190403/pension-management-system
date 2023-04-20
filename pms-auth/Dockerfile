FROM openjdk:8-slim
ENV TZ="Asia/Kolkata"
EXPOSE 443
WORKDIR /pms
VOLUME /pms
ADD target/pms_auth_app.jar pms_auth_app.jar
ENTRYPOINT ["java", "-jar", "pms_auth_app.jar"]