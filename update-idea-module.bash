#!/usr/bin/env bash

npm run gen-idea-libs

# This script takes the generated project files and updates the project at $CONFIG_DIR so that this application is usable as a module

CONFIG_DIR="../logrally-intellij/.idea"

cat logrally-web.iml | sed -s "s#\\\$MODULE_DIR\\\$#$PWD#g" > "${CONFIG_DIR}/modules/logrally-web.iml"
cat logrally-web.iml | sed -s "s#\\\$MODULE_DIR\\\$#$PWD#g" > module.iml

for f in .idea/runConfigurations/*; do
    echo "Copying $f"
    cat "$f" | sed -e 's/\$PROJECT_DIR\$/\$PROJECT_DIR\$\/..\/logrally-web/' > "${CONFIG_DIR}/runConfigurations/$(basename $f)"
done

for f in .idea/libraries/*; do
    echo "Copying $f"
    cat "$f" | sed -e 's/node_modules/..\/logrally-web\/node_modules/' > "${CONFIG_DIR}/libraries/$(basename $f)"
done
