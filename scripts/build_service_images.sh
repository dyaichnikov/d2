#!/usr/bin/env bash

script_dir=$(cd "$(dirname "$0")" && pwd)

for service_name in $(ls "$script_dir/.." | grep ".*-service$")
do
  "$script_dir"/build_service_image.sh "$service_name"
done
