#!/bin/bash
echo "Starting Spring Boot application"

cd /home/ubuntu/app

export DB_URL="jdbc:mariadb://aivle5th.ceq2mnp4ry1v.us-east-2.rds.amazonaws.com:3306/aivle4th"
export DB_ID="admin"
export DB_PW="5ELvGMmIHxEZTXL9hVBz"

nohup java -jar *SNAPSHOT.jar > app.log 2>&1 &
