#!/bin/bash

declare -a dirs=("venv" ".idea" "target" "build" ".vs" "renv" "out" ".gradle" "cmake-build-debug" "CMakeFiles" "__pycache__" ".ipynb_checkpoints" ".settings" ".Rproj.user" ".mvn" ".gitlet" "gradle" ".vscode" ".temp")

for name in "${dirs[@]}"; do
  echo 'Cleaning' $name
  find . -type d -name $name -exec rm -rf {} \;
done

declare -a files=(".DS_Store" ".gitignore" "*.class")

for name in "${files[@]}"; do
  echo 'Cleaning' $name
  find . -type f -name $name -exec rm -rf {} \;
done

# echo 'Deleting all extension less files....'
# find . -type f  ! -name "*.?*" -delete
# echo 'Done.'
