FROM maven:3.9-eclipse-temurin-17-alpine

RUN mkdir -p /var/www/todo-spring

ADD .docker/java/bin/* /docker/

RUN chmod +x /docker/entrypoint.sh

CMD ["mvn", "package"]

ENTRYPOINT ["/docker/entrypoint.sh"]