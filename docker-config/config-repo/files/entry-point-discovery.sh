#!/bin/sh

while ! nc -z config-server 8088 ; do
    echo "Waiting for the Config Server"
    sleep 3
done

java -jar /opt/lib/discovery-service-0.0.1.jar
