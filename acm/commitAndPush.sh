#!/bin/bash

message=$@

git add --all
git commit -m "${message}"
git push
