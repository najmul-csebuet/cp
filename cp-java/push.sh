#!/bin/bash

git add --all
message=$*
git commit -m "${message}"
git push -u origin main
