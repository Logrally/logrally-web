#!/usr/bin/env bash

rm -rf "./node-modules/@logrally/kotlin-react-ring-ui"
(cd ../kotlin-react-ring-ui && rm -f *.tgz && gradle clean build npm_pack) && npm install ../kotlin-react-ring-ui/*.tgz