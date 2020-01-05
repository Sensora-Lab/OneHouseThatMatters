FROM node:latest

ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && apt-get install bash

WORKDIR /home/node/app

RUN rm -rf node_modules && \
    rm -rf package-lock.json

CMD npm install && npm run start