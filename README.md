# service
Stitching graphql Service to local-nerdGraph

STEPS TO RUN Demo-service
Demo-service-info:
* JAVA 21
* Maven project
* Springboot-graphql service
* DATASource: Inmempory : HashMAP
* serverURl: http://localhost:8080/graphiql
<img width="1269" alt="Screenshot 2025-02-10 at 9 50 26 PM" src="https://github.com/user-attachments/assets/3dfe3ef2-5129-4cc8-be75-d37433da265e" />

* PostMan: http://localhost:8080/graphql
<img width="1205" alt="Screenshot 2025-02-10 at 9 50 45 PM" src="https://github.com/user-attachments/assets/03315459-5642-4996-abc8-55ad6ff9566a" />



Steps to run nerd-graph:

* make sure local-service which you want to stich is up and running : clone this app do run mvn clean intall and start the server
* make sure docker-desktop is installed from self-service
* https://source.datanerd.us/after/nerd-graph/wiki/Running-NerdGraph-in-%22Local-NerdGraph-Mode%22#generate-a-proxiesjson-file : add this proxy to forward the request to local-service
* nerd-graph.env file to be created

1. Set SSH key if you're logging-in for the first time : https://www.geeksforgeeks.org/how-to-fix-support-for-password-authentication-was-removed/
2. git clone : git clone git@source.datanerd.us:after/nerd-graph.git
under localNerdGraph
3. ./install-cert-osx (since we are running in local make sure newrelic.com certs are downloaded to keyChain
4. login to vault : newrelic-vault us login -method=oidc
5. ./configure : add your local service config

<img width="941" alt="Screenshot 2025-02-10 at 8 34 46 PM" src="https://github.com/user-attachments/assets/93e5e29b-f23a-43a2-bd9e-033ea07ef711" />
6. run .start to start local-nerd-graph
7. stitched schemas(query-mutations) are visible under nerd-graph : 

query: stitched under actor kindly refer the queryResolver of the demo app schema:
<img width="1544" alt="Screenshot 2025-02-10 at 9 42 58 PM" src="https://github.com/user-attachments/assets/d6ee4404-430f-41ed-9cd0-879c7aa4e07a" />

Mutations:
<img width="1518" alt="Screenshot 2025-02-10 at 8 44 52 PM" src="https://github.com/user-attachments/assets/65b7fbbf-0b0d-42a1-a7d6-38c6b0866297" />
here: https://staging-one.newrelic.com/nerdgraph-graphiql?use_local_service=public-nerd-graph!3100,public-one-nerd-graph!3100,public-rpm-api!3200 : pointing to locally running nerd-graph 
you can very the same in proxies.json and nerd-graph.env:










