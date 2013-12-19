echo "************ UNDEPLOYING *******************"
asadmin undeploy SimpleWebEJB-1.0-SNAPSHOT
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/SimpleWebEJB-1.0-SNAPSHOT
