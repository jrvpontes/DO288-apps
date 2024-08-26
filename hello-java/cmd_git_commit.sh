BASEDIR=$(dirname "$0")
now=$(date +"%T")
echo "Base dir : $BASEDIR" 
echo "Current time Master : $now" >> "$BASEDIR/app-src/src/main/java/master.txt"
git -C $BASEDIR add .
git -C $BASEDIR commit -m "Ajuste: $now"
git -C $BASEDIR push
