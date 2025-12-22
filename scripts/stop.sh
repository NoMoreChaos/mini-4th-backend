#!/bin/bash
echo "Stopping existing Spring Boot application"

PID=$(pgrep -f "java -jar")

if [ -n "$PID" ]; then
  echo "Killing process $PID"
  kill -9 $PID
else
  echo "No application running"
fi
