oc new-build https://github.com/jaysonzhao/chainedcicddemo.git --strategy=pipeline
oc new-build --binary=true --name="hellotest" --image-stream=openshift/java:8

oc start-build chainedcicddemo

oc new-app hellotest
oc expose svc/hellotest