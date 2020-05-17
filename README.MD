oc new-build --binary=true --name="hellotest" --image-stream=openshift/java:8



bc.yaml:

kind: BuildConfig
apiVersion: build.openshift.io/v1
metadata:
  name: chainedcicddemo
  namespace: dev
  selfLink: /apis/build.openshift.io/v1/namespaces/dev/buildconfigs/chainedcicddemo
  uid: 27216625-42bd-4458-93f2-eab6eb4f6fc8
  resourceVersion: '528776'
  creationTimestamp: '2020-05-16T14:18:10Z'
  labels:
    build: chainedcicddemo
  annotations:
    openshift.io/generated-by: OpenShiftNewBuild
spec:
  nodeSelector: {}
  output: {}
  resources: {}
  successfulBuildsHistoryLimit: 5
  failedBuildsHistoryLimit: 5
  strategy:
    type: JenkinsPipeline
    jenkinsPipelineStrategy:
      jenkinsfilePath: Jenkinsfile
  postCommit: {}
  source:
    type: Git
    git:
      uri: 'https://github.com/jaysonzhao/chainedcicddemo.git'
      ref: master
  triggers:
    - type: GitHub
      github:
        secret: Gbe1zU1UFVGiNfLJhM9H
    - type: Generic
      generic:
        secret: fpfEjsMLxeOM9tCq0Yv5
    - type: ConfigChange
  runPolicy: Serial


oc start-build chainedcicddemo