#!/bin/bash
echo "Starting Spring Boot application"

cd /home/ubuntu/app

nohup java -jar *SNAPSHOT.jar > app.log 2>&1 &
