FROM java:8-jre

WORKDIR /root
ADD target/*.jar ./

EXPOSE 45000
ENTRYPOINT ["java","-jar","MicroReservierungsService-0.0.6-SNAPSHOT-onejar.jar", "45000"]
