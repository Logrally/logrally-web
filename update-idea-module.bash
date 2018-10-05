#!/usr/bin/env bash

# This script takes the generated project files and updates the project at $CONFIG_DIR so that this application is usable as a module

CONFIG_DIR="../logrally-intellij/.idea"

for f in .idea/runConfigurations/*; do
    echo "Copying $f"
    cat "$f" | sed -e 's/\$PROJECT_DIR\$/\$PROJECT_DIR\$\/..\/logrally-web/' > "${CONFIG_DIR}/runConfigurations/$(basename $f)"
done

npm run gen-idea-libs
for f in .idea/libraries/*; do
    echo "Copying $f"
    cat "$f" | sed -e 's/node_modules/..\/logrally-web\/node_modules/' > "${CONFIG_DIR}/libraries/$(basename $f)"
done

rm -rf .idea