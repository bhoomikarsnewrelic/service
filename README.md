# service
Stitching graphql Service to local-nerdGraph


Steps to run nerd-graph:

make sure docker-desktop is installed from self-service
https://source.datanerd.us/after/nerd-graph/wiki/Running-NerdGraph-in-%22Local-NerdGraph-Mode%22#generate-a-proxiesjson-file : add this proxy to forward the request to local-service

1. Set SSH key if you're logging-in for the first time : https://www.geeksforgeeks.org/how-to-fix-support-for-password-authentication-was-removed/
2. git clone : git clone git@source.datanerd.us:after/nerd-graph.git
under localNerdGraph
3. ./install-cert-osx (since we are running in local make sure newrelic.com certs are downloaded to keyChain
4. login to vault : newrelic-vault us login -method=oidc
5. ./configure : add your local service config

<img width="941" alt="Screenshot 2025-02-10 at 8 34 46 PM" src="https://github.com/user-attachments/assets/93e5e29b-f23a-43a2-bd9e-033ea07ef711" />
6. run .start to start local-nerd-graph

running service:




