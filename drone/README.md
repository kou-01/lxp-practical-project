# 

## 開発環境

- Java 17
- Spring 3.2.2


Docker 起動

```
$ docker-compose up -d
$ docker exec -it digitalojt-drone /bin/bash
```

アプリを起動


```
$ ./gradlew wrapper --gradle-version 7.4
$ ./gradlew build
$ ./gradlew bootRun
```

## デプロイ： App Runner with ECS
```
$ ./gradlew bootJar && cp build/libs/dev-0.0.1.jar ./
$ java -jar ./dev-0.0.1.jar
```
