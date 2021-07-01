#!/bin/bash

## /usr/bin/zsh /home/shubham/git/microservice-architecture-spring-boot/dockerize.sh package build push

BASE=$PWD
echo $BASE

args=("$@")


function process() {
  local var i=$1
  echo ${i}
  cd ${BASE}/${arr[i + 1]}
  echo $PWD
  if [[ "${args[@]}" =~ "package" ]]; then
    ./gradlew clean build
  fi

  if [[ "${args[@]}" =~ "build" ]]; then
    docker build -t shubham01/${arr[i]} .
  fi
  cd $BASE

  if [[ "${args[@]}" =~ "push" ]]; then
    docker push shubham01/${arr[i]}
  fi
}

arr=(
  user:0.0.1 services/user
  service-registry:0.0.1 service-registry
  hystrix-dashboard:0.0.1 hystrix-dashboard
  cloud-config-server:0.0.1 cloud-config-server
  cloud-gateway:0.0.1 cloud-gateway
  department:0.0.1 services/department
)
let l=${#arr[@]}
echo ${l}

let a=1
while [[ a -lt l ]]; do
  process ${a} &
  a=a+2
done

wait
