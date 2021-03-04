#!/usr/bin/env bash

# Script to start minikube with necessary system requirements
#
# Usage: ./ci/start_minikube.sh

minikube start --vm-driver=virtualbox --cpus 4 --disk-size 40g --memory 6g
