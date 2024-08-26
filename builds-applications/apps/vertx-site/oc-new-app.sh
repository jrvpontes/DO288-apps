#!/bin/env bash

oc new-app --name vertx-site \
  --env JAVA_APP_JAR=vertx-site-1.0.0-SNAPSHOT-fat.jar \
  -i redhat-openjdk18-openshift:1.8 \
  --context-dir builds-applications/apps/vertx-site \
  https://github.com/jrvpontes/DO288-apps
