mvn clean install -f app-src/
mkdir -p ../releases/download/OCP-4.1-1/
cp -v app-src/target/hello-thorntail.jar ../releases/download/OCP-4.1-1/hello-java.jar 
