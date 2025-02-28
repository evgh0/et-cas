FROM openjdk:23 as builder

WORKDIR /app

COPY src /app/src
COPY . /app

# Compile Java files
RUN javac -d out src/dev/evgh/et_cas/api/Main.java

FROM openjdk:23 as runtime

WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/out /app/out
CMD ["java", "-cp", "out/", "dev.evgh.et_cas.api.Main"]
