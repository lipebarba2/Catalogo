# Etapa 1: Build da aplicação
FROM maven:3.9.4-amazoncorretto-17 AS build
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY pom.xml .
COPY src ./src

# Faz o build do projeto (gera o .jar na pasta target)
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM amazoncorretto:17
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
