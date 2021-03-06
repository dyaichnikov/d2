#!/usr/bin/env bash

script_dir=$(cd "$(dirname "$0")" && pwd)

get_app_version() {
  pom="$script_dir/../pom.xml"
  xpath -e 'string(//project/version)' "$pom" 2> /dev/null
}
