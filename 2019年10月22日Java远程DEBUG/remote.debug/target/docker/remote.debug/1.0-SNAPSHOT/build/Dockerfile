FROM openjdk:8-jre
MAINTAINER wulonghuai <1053216036@qq.com>

# 添加端口映射，通过8999映射出来
EXPOSE 5005

# 指定环境变量spring.profiles.active
# 这边使用java，因为openjdk中已经有了这些东西
ENTRYPOINT ["java", "-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "/usr/share/myservice/myservice.jar"]

# nohup $JAVA_HOME/bin/java -Xmx512m -jar ./home.controller.backcontroller-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --spring.config.location=classpath:/dev/application.properties > catalina.out 2>&1 &

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# springboot使用一个jar包的方式，不需要拷贝库文件

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar
