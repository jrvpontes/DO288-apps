BASEDIR=$(dirname "$0")
now=$(date +"%T")
echo "Base dir : $BASEDIR" 
echo "Current time Master : $now" >> "$BASEDIR/app-src/src/main/java/master.txt"

mvn clean install -f app-src/
mkdir -p ../releases/download/OCP-4.1-1/
cp -v app-src/target/hello-thorntail.jar ../releases/download/OCP-4.1-1/hello-java.jar
podman build -t teste -f Containerfile