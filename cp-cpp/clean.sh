#!/bin/bash

#!/bin/bash

declare -a dirs=(".vscode" ".temp")

for name in "${dirs[@]}"; do
  echo 'Cleaning' $name
  find . -type d -name $name -exec rm -rf {} \;
done

# declare -a files=(".DS_Store" ".gitignore" "*.class")

# for name in "${files[@]}"; do
#   echo 'Cleaning' $name
#   find ./completed -type f -name $name -exec rm -rf {} \;
# done

echo 'Deleting all extension less files....'
find . -type f  ! -name "*.?*" -delete
echo 'Done.'

