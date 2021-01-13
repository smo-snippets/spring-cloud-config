# Setup
git clone https://github.com/smo-snippets/spring-cloud-config.git

git submodule update --init --recursive

# Architecture
- Globale Git Config über Spring Cloud Config
- Currency-Exchange-Service runs on a H2 in memory database
- 
- Feign -> Invoke other  via feignclient
- Ribbon -> Load Balancing


TODO
Tests WebMvc