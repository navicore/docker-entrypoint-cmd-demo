FROM java:8

ADD target/scala-2.10/docker-entrypoint-cmd-demo.jar /app/
RUN wget http://d3kbcqa49mib13.cloudfront.net/spark-1.6.1-bin-hadoop2.6.tgz && tar xvzf spark* 

WORKDIR /app

ENTRYPOINT ["java","-cp","/spark-1.6.1-bin-hadoop2.6/lib/spark-assembly-1.6.1-hadoop2.6.0.jar:/app/docker-entrypoint-cmd-demo.jar"]

