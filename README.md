# Chekk
Santa Inc microservices for hood filler

serviceRegistery - It is the registry server where all the microservices register themselves in it.In this case hoodfiller service register to serviceRegistery
hoodfiller - This is the microservice which provides the efficient items to prepare the hood 
apigateway -  this is used to route to the respective service .it is used for load balancing when multiple instances for the service are running


Step to run 
1.run the serviceRegistry application(com/santainc/serviceregistery/ServiceRegisteryApplication.java) in the Intellij idea or using maven command 
go to the root of project
1.1.**mvn clean install**
1.2 once the above step is complete go to target folder and run the command **java -jar serviceRegistery-0.0.1-SNAPSHOT.jar**
1.3 this will run in localhost:8761 check this url in the browser for registry dashboard for checking the registered services

2.run the hoodfiller application(com/santainc/hoodfiller/HoodfillerApplication.java) using intellij idea/maven
2.1.**mvn clean install**
2.2 once the above step is complete go to target folder and run the command **java -jar hoodfiller-0.0.1-SNAPSHOT.jar**
2.3 once the service is up and running use the below curl to test the service will run in localhost:9001
curl::
curl --location --request POST 'http://localhost:9001/hoodfiller/' \
--header 'Content-Type: application/json' \
--data-raw '{ 
  "hood_capacity": 41, 
  "present_weights": [2,5,10,50,100]
}'

3.run the apigateway application(com/hoodfiler/apigateway/ApigatewayApplication.java) using intellij idea/maven
2.1.**mvn clean install**
2.2 once the above step is complete go to target folder and run the command **java -jar apigateway-0.0.1-SNAPSHOT.jar**
2.3 once the service is up and running use the below curl to test the service will run in localhost:9191.now all the request will be routed through the api gateway
curl::
curl --location --request POST 'http://localhost:9191/hoodfiller/' \
--header 'Content-Type: application/json' \
--data-raw '{ 
  "hood_capacity": 41, 
  "present_weights": [2,5,10,50,100]
}'

