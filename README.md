# ☁️ Learning Microservices with Spring Boot, Docker & Kubernetes

## 👤 About Me

Hi! I’m Ridho Suhaebi Arrowi, a software engineer diving into microservices and cloud-native architecture. This repo is my personal playground for mastering modern distributed systems.

## 📘 Overview

This repository documents my personal journey in learning how to build, containerize, orchestrate, and deploy Microservices using modern tools like **Spring Boot**, **Docker**, and **Kubernetes**.

The project is structured around several key topics I’ve studied hands-on, including microservices architecture principles, cloud-native design patterns, containerization, service discovery, and resilience strategies.

---

## 🧠 What I Learned

### Section 1 - Introduction to Microservices Architecture  
### Section 2 - Building microservices using Spring Boot  
### Section 3 - How do we right size our microservices & identify boundaries  
### Section 4 - Handle deployment, portability & scalability of microservices using Docker  
### Section 5 - Deep Dive on Cloud Native Apps & 15-Factor methodology  
### Section 6 - Configurations Management in Microservices  
### Section 7 - Using MySQL DBs inside microservices  
### Section 8 - Service Discovery & Service Registration in microservices  
### Section 9 - Gateway, Routing & Cross cutting concerns in Microservices  
### Section 10 - Making Microservices Resilient  
### Section 11 - Observability and monitoring of microservices  
### Section 12 - Microservices Security  
### Section 13 - Event Driven microservices using RabbitMQ, Spring Cloud Functions & Stream  
### Section 14 - Event Driven microservices using Kafka, Spring Cloud Functions & Stream  
### Section 15 - Container Orchestration using Kubernetes  
### Section 16 - Deep dive on Helm  
### Section 17 - Server-side service discovery and load balancing using Kubernetes  
### Section 18 - Deploying microservices into cloud K8s cluster  
### Section 19 - Introduction to K8s Ingress, Service Mesh (Istio) & mTLS  
### Section 20 - Finish  

---

## 🔗 Important Links

- [Spring Boot](https://spring.io/projects/spring-boot)  
- [Create SpringBoot project](https://start.spring.io)  
- [DTO pattern](https://martinfowler.com/eaaCatalog/dataTransferObject.html)  
- [Model Mapper](http://modelmapper.org/)  
- [Map Struct](https://mapstruct.org/)  
- [Spring Doc](https://springdoc.org/)  
- [Open API](https://www.openapis.org/)  
- [Lucidchart Blog](https://www.lucidchart.com/blog/ddd-event-storming)  
- [Docker](https://www.docker.com)  
- [Docker Hub](https://hub.docker.com)  
- [Buildpacks](https://buildpacks.io)  
- [Google Jib](https://github.com/GoogleContainerTools/jib)  
- [Docker Compose](https://docs.docker.com/compose/)  
- [12-Factor methodology](https://12factor.net)  
- [Beyond the Twelve-Factor App book](https://www.oreilly.com/library/view/beyond-the-twelve-factor/9781492042631/)  
- [Spring Cloud](https://spring.io/projects/spring-cloud)  
- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)  
- [Spring Cloud Bus](https://spring.io/projects/spring-cloud-bus)  
- [RabbitMQ](https://www.rabbitmq.com)  
- [Hookdeck](https://hookdeck.com)  
- [Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix)  
- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)  
- [Netflix OSS Blog](https://netflixtechblog.com/netflix-oss-and-spring-boot-coming-full-circle-4855947713a0)  
- [Resilience4j](https://resilience4j.readme.io)  
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)  
- [Stripe RateLimiter Blog](https://stripe.com/blog/rate-limiters)  
- [Apache Benchmark](https://httpd.apache.org)  
- [Grafana](https://grafana.com)  
- [Grafana Loki Setup](https://grafana.com/docs/loki/latest/get-started/quick-start/)  
- [Micrometer](https://micrometer.io)  
- [Prometheus](https://prometheus.io/)  
- [Grafana Dashboards](https://grafana.com/grafana/dashboards/)  
- [OpenTelemetry](https://opentelemetry.io/)  
- [OpenTelemetry Java Auto Instrumentation](https://opentelemetry.io/docs/instrumentation/java/automatic/)  
- [Keycloak](https://www.keycloak.org/)  
- [Apache Kafka](https://kafka.apache.org)  
- [Kafka Compose File](https://github.com/bitnami/containers/blob/main/bitnami/kafka/docker-compose.yml)  
- [Docker Desktop Kubernetes](https://docs.docker.com/desktop/kubernetes/)  
- [Kubernetes Dashboard](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/)  
- [Helm](https://helm.sh)  
- [Chocolatey](https://chocolatey.org/)  
- [Bitnami Helm Charts](https://github.com/bitnami/charts)  
- [Spring Cloud Kubernetes](https://spring.io/projects/spring-cloud-kubernetes)  
- [Spring Cloud Kubernetes Blog](https://spring.io/blog/2021/10/26/new-features-for-spring-cloud-kubernetes-in-spring-cloud-2021-0-0-m3)  
- [Google Cloud](https://cloud.google.com)  
- [GCP SDK Installation](https://cloud.google.com/sdk/docs/install)  
- [K8s Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)  
- [Ingress Controllers](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/)  
- [Istio](https://istio.io)  

---

## 🛠 Maven Commands

| Command | Description |
|--------|-------------|
| `mvn clean install -Dmaven.test.skip=true` | Generate JAR inside target folder |
| `mvn spring-boot:run` | Start Spring Boot Maven project |
| `mvn spring-boot:build-image` | Generate Docker image using Buildpacks |
| `mvn compile jib:dockerBuild` | Generate Docker image using Google Jib |

---

## 🐳 Docker Commands

> Image: `ridhorezi1212/accounts:s4`

| Command | Description |
|--------|-------------|
| `docker build . -t ridhorezi1212/accounts:s4` | Build Docker image using Dockerfile |
| `docker run -p 8080:8080 ridhorezi1212/accounts:s4` | Run Docker container |
| `docker images` | List all Docker images |
| `docker image inspect <image-id>` | Show image details |
| `docker image rm <image-id>` | Remove image |
| `docker image push docker.io/ridhorezi1212/accounts:s4` | Push image to DockerHub |
| `docker image pull docker.io/ridhorezi1212/accounts:s4` | Pull image from DockerHub |
| `docker ps`, `docker ps -a` | Show running/all containers |
| `docker container start <id>` | Start container |
| `docker container stop <id>` | Stop container |
| `docker container restart <id>` | Restart container |
| `docker container kill <id>` | Kill container |
| `docker container inspect <id>` | Inspect container |
| `docker container logs <id>` | Fetch container logs |
| `docker container logs -f <id>` | Follow logs |
| `docker container pause/unpause <id>` | Pause/unpause container |
| `docker container rm <id>` | Remove container |
| `docker container prune` | Remove all stopped containers |
| `docker compose up` | Start services from docker-compose.yml |
| `docker compose down` | Stop and remove services |
| `docker run -p 3306:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=accountsdb -d mysql` | Run MySQL container |
| `docker run -p 6379:6379 --name redis -d redis` | Run Redis container |
| `docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.3 start-dev` | Run Keycloak container |

---

## 🧪 Apache Benchmark

| Command | Description |
|--------|-------------|
| `ab -n 10 -c 2 -v 3 http://localhost:8072/bank/cards/api/contact-info` | Load testing (10 requests, 2 concurrent) |

---

## ☸️ Kubernetes Commands

| Command | Description |
|--------|-------------|
| `kubectl apply -f filename.yaml` | Apply config |
| `kubectl get all` | Get all resources |
| `kubectl get pods` | List pods |
| `kubectl describe pod <id>` | Pod details |
| `kubectl delete pod <id>` | Delete pod |
| `kubectl get services` | List services |
| `kubectl describe service <id>` | Service details |
| `kubectl get nodes` | List nodes |
| `kubectl get replicasets` | List replica sets |
| `kubectl get deployments` | List deployments |
| `kubectl get configmaps` | List configmaps |
| `kubectl get events --sort-by=.metadata.creationTimestamp` | List events sorted |
| `kubectl scale deployment <deployment-name> --replicas=1` | Scale deployment |
| `kubectl set image deployment <name> <container>=<image> --record` | Set new image |
| `kubectl rollout history deployment <name>` | View rollout history |
| `kubectl rollout undo deployment <name> --to-revision=1` | Rollback deployment |
| `kubectl get pvc` | List PVCs |
| `kubectl delete pvc <name>` | Delete PVC |

---

## ⛵ Helm Commands

| Command | Description |
|--------|-------------|
| `helm create [NAME]` | Create chart |
| `helm dependencies build` | Recompile dependencies |
| `helm install [NAME] [CHART]` | Install chart |
| `helm upgrade [NAME] [CHART]` | Upgrade release |
| `helm history [NAME]` | Release history |
| `helm rollback [NAME] [REVISION]` | Rollback release |
| `helm uninstall [NAME]` | Uninstall release |
| `helm template [NAME] [CHART]` | Render templates locally |
| `helm list` | List Helm releases |

---

## 📄 License

This is a learning project — use at your own risk. Licensed under the [MIT License](LICENSE).

---
