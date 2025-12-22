#!/bin/bash
echo "Starting Spring Boot application"

cd /home/ec2-user/app

nohup java -jar *.jar > app.log 2>&1 &
