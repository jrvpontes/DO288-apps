#bin/bash
#oc -n save-dev delete build --all
#oc -n save-dev start-build save-m-builder
BASEDIR=$(dirname "$0")
now=$(date +"%T")
echo "Base dir : $BASEDIR" 
echo "Current time Master : $now" >> "$BASEDIR/app-src/src/main/java/master.txt"
git -C $BASEDIR add .
git -C $BASEDIR commit -m "Ajuste: $now"
git -C $BASEDIR push
