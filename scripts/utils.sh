#!/usr/bin/env bash

# Contains common utils functions to be imported into other scripts

script_dir=$(cd "$(dirname "$0")" && pwd)

# Returns parent module version since all its child modules inherit it
get_app_version() {
  pom="$script_dir/../pom.xml"
  xpath -e 'string(//project/version)' "$pom" 2> /dev/null
}
