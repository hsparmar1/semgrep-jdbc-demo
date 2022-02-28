#!/bin/bash
echo "Running Spring JDBC Template Check..."
while getopts v: flag
do
    case "${flag}" in
        v) printEnv=${OPTARG};;
    esac
done

if [[ "$printEnv" == "verbose" ]];
then
	semgrep --verbose --config=/Users/Harjeet.S.Parmar/Development/semgrep/local-registry/java/spring-jdbc-template-check.yaml
else
	semgrep --config=/Users/Harjeet.S.Parmar/Development/semgrep/local-registry/java/spring-jdbc-template-check.yaml
fi
