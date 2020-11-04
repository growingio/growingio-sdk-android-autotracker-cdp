#!/bin/bash

./gradlew clean \
&& ./gradlew :growingio-tracker-cdp:publishReleaseAgentPublicationToMavenLocal \
&& ./gradlew :growingio-autotracker-cdp:publishReleaseAgentPublicationToMavenLocal \
&& ./gradlew clean
