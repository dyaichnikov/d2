#!/usr/bin/env bash

script_dir=$(cd "$(dirname "$0")" && pwd)
root_project_dir="$script_dir/.."

. "$script_dir/../scripts/utils.sh"

if [[ -z "$1" ]] ; then
  echo "Module's name must be provided as \$1 (see corresponding pom.xml)"
  exit 1
fi

eval "$(minikube docker-env)"

service_name="$1"
tag=$(get_app_version)
image="$service_name:$tag"

echo "Building $image image"
docker build -t "$image" -f "$root_project_dir/$service_name/Dockerfile" "$root_project_dir"
