#!/bin/sh 
BRANCH_NAME=""
while getopts "b" opt ; do
    case $opt in
        b)
            BRANCH_NAME="$OPTARG"
            echo "using branch name : $OPTARG"
            ;;
    esac
done
sed -e "s~BRANCH_NAME_VAR~$BRANCH_NAME~g" "deployment.yaml" > "deploy.yaml"