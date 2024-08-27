BASEDIR=$(dirname "$0")
now=$(date +"%T")
echo "Base dir : $BASEDIR" 
echo "Current time Master : $now" >> "$BASEDIR/app-source/src/main/resources/master.txt"

mvn clean install -DskipTests -f app-source
mkdir -p ../releases/download/OCP-4.1-1/
cp -v app-source/target/micro-java-1.0-runner.jar ../releases/download/OCP-4.1-1/micro-java.jar
#podman build -t teste -f Containerfile