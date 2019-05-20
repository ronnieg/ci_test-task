#!/bin/bash
curl -s -XPOST 'http://localhost:8080/createItem?name=seed' -u admin:admin  --data-binary @config.xml -H "Content-Type:text/xml" > /dev/null 
if [ $? -eq 0 ] ;  
  then echo 'job add in jenkins and create pipeline'
  curl -X POST http://admin:admin@localhost:8080/job/seed/build
else 
   echo 'jon don't add jenkins' 
fi
