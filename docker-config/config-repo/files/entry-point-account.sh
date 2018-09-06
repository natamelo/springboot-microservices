#!/bin/sh

while ! nc -z config-server 8088 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z discovery-service 8761 ; do
    echo "Waiting for the Discovery Service"
    sleep 3
done

java -jar /opt/lib/account-service-0.0.1.jar