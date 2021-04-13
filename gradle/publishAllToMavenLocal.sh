#!/bin/bash

./gradlew clean \
&& ./gradlew :growingio-tracker-core-cdp:publishMavenAgentPublicationToMavenLocal \
&& ./gradlew :growingio-tracker-cdp:publishMavenAgentPublicationToMavenLocal \
&& ./gradlew :growingio-autotracker-cdp:publishMavenAgentPublicationToMavenLocal \
&& ./gradlew clean
