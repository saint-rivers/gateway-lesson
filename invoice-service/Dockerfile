FROM eclipse-temurin:17-jdk-jammy as builder
# RUN addgroup jdkusergroup; adduser  --ingroup jdkusergroup --disabled-password jdkuser
# USER jdkuser
WORKDIR /opt/app

COPY .gradle .gradle
COPY gradle gradle
COPY gradlew build.gradle settings.gradle ./
COPY src src
# COPY . .
RUN ./gradlew bootjar -x test

FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/build/libs/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]