#!/bin/bash

./gradlew clean \
&& ./gradlew :growingio-tracker-core-cdp:publishReleaseAgentPublicationToMavenLocal \
&& ./gradlew :growingio-tracker-cdp:publishReleaseAgentPublicationToMavenLocal \
&& ./gradlew :growingio-autotracker-cdp:publishReleaseAgentPublicationToMavenLocal \
&& ./gradlew clean
