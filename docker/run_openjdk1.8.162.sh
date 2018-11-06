#!/usr/bin/env bash

docker run --name=jdk1.8.162 --rm \
    -e TZ="Europe/Moscow" \
    payneteasy/jdk-8 \
    bash -c "mvn -version && echo '' && echo '' && cd /home && \
    git clone https://github.com/dvponomarev/signature-diff.git && \
    cd signature-diff && mvn clean install"
