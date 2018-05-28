package:
	mvn package

build: package
	docker build . --tag myguddy/sam-springboot-redis:latest
	docker push myguddy/sam-springboot-redis:latest
run:
	docker run -d --name sam-springboot-redis --link local-redis:session-redis -p 127.0.0.1:8081:8080 myguddy/sam-springboot-redis:latest