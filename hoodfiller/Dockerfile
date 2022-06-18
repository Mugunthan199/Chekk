FROM openjdk:8
EXPOSE 9001
RUN mkdir /app
COPY . /app/
WORKDIR /app
RUN ./mvnw clean install
RUN chmod 777 * -R
CMD java -jar /app/hoodfiller/target/hoodfiller-0.0.1-SNAPSHOT.jar