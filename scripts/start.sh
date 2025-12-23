#!/bin/bash
echo "Starting Spring Boot application"

cd /home/ubuntu/backend


nohup java -jar *SNAPSHOT.jar > app.log 2>&1 &
