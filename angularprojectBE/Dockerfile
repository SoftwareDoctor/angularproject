# Usa l'immagine di base di OpenJDK
FROM openjdk:17.0.1-jdk-slim

# Imposta la directory di lavoro
WORKDIR /webappBE

# Installa Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copia il file pom.xml e scarica le dipendenze (se non ci sono modifiche frequenti)
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copia il codice sorgente e costruisce l'applicazione
COPY src ./src
RUN mvn clean install -DskipTests

# Copia il file JAR generato nella directory di lavoro
COPY target/*.jar webappBE.jar

# Espone la porta su cui l'applicazione è in esecuzione
EXPOSE 8080

# Comando per eseguire il JAR
CMD ["java", "-jar", "webappBE.jar"]