oc -n rhc-wks apply -f /wks/aux/pipe/pipeline.yaml
oc -n rhc-wks delete PipelineRun --all
oc -n rhc-wks delete Pod --all
oc -n rhc-wks create -f /wks/aux/pipe/pipelinerun.yaml 