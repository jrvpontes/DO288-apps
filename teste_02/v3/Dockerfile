FROM image-registry.openshift-image-registry.svc:5000/rhc-wks/jpontes-java:latest


# oc delete is --all

# oc import-image ubi8-openjdk-17-runtime --from=image-registry.openshift-image-registry.svc:5000/openshift/ubi8-openjdk-17-runtime --confirm --all
# oc tag ubi8-openjdk-17-runtime:1.12 jpontes-java:latest

# oc create imagestream ex288-t2
# oc delete build --all && oc start-build buildconfig/ex288-t2

#https://github.com/jrvpontes/DO288-apps.git - /teste_02/v3/Dockerfile


# ----------------------------------------------------------------------
# Cenario:
# OCP-Web >> Developer >> Add >> git
# Resultado esperado:
#   após criar a aplicação, o build consegue criar a imagestream ex288-t2

# Resultado obtido:
#   sucesso apenas no ambiente de lab. No RHPDS dá problema
#   /wks/nuvem/jsatan/red-hat/certificacoes/288_labs/4.14/wks.txt
