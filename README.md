# Maven Build
./mvnw clean install <br/>
./mvnw package && java -jar target/spring-todo-app.jar ./mvnw clean install

#run maven and start in host os default port 8080
./mvnw spring-boot:run


# Postman : Body sample to save
URL - http://localhost:8080/todos
```

{
  "task_summary": "Summary-1",
  "task_description": "Desc-1"
}
```

http://localhost:8080 - for application

# Postman : read from h2
http://localhost:8080/todos/2


# Authentication Credentials
testuser/testpwd

# CREATE MAVEN DOCKER IMAGE
docker build -t springio/spring-todo-app .

# MAVEN RUN ON PORT
docker run -p 8080:8080 springio/spring-todo-app



### URL to access H2 DB locally
http://localhost:8080/h2-console - for H2 console



# OTHER USEFUL COMMANDS
docker stop $(docker ps -aq)   <br/>
docker rm $(docker ps -aq) 		<br/>
docker rmi -f $(docker images -aq)		<br/>
	
# Kill Port
sudo lsof -i :portNumber		<br/>
kill PID

# Push to new Repo
git init		<br/>
git add README.md		<br/>
git commit -m "first commit"		<br/>
git remote add origin https://github.com/anoop-git/spring-todo-app.git		<br/>
git push -u origin master		<br/>


# Referance
https://spring.io/guides/gs/accessing-data-jpa/


# Referance
TODO LIST 	<br/>
1) Try bypassing /test api from authentication check  	<br/>
2) Implement the noun verb  	<br/>