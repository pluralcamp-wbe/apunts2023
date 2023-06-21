#!/bin/bash

ver=$1
group_id=$2

infix=$(echo "$group_id" | tr . /)

local_repo=$HOME/.m2/repository
local_project=$local_repo/$infix/$(basename $PWD)
cp $local_project/$ver/*.war $HOME/webapps/
exit 0
