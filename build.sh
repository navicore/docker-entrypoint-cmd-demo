#!/usr/bin/env bash

sbt assembly && docker build -t navicore/hiya . && docker push navicore/hiya

