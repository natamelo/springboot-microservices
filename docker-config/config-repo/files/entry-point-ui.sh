#!/bin/sh

while ! nc -z config-server 8088 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z discovery-service 8761 ; do
    echo "Waiting for the Discovery Service"
    sleep 3
done
while ! nc -z gateway-service 8081 ; do
    echo "Waiting for the Gateway Service"
    sleep 3
done
while ! nc -z account-service 8082 ; do
    echo "Waiting for the Account Service"
    sleep 3
done
while ! nc -z uaa-server 8089 ; do
    echo "Waiting for the UAA Server"
    sleep 3
done

java -jar /opt/lib/ui-app-0.0.1.jar
