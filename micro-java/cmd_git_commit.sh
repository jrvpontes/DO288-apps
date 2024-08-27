BASEDIR=$(dirname "$0")
now=$(date +"%T")
echo "Base dir : $BASEDIR" 
echo "Current time Master : $now" >> "$BASEDIR/app-source/src/main/resources/master.txt"
git add --force ../releases/download/OCP-4.1-1/micro-java.jar
git -C $BASEDIR add .
git -C $BASEDIR commit -m "Ajuste: $now"
git -C $BASEDIR push
