# TEAM12

# Team Members 

@Arison7

# Pipelines Documentation
[[Pipeline]](../.github/workflows/blank.yml)

### Step 1: Set up

- Reset workspace permission 
We ensure that current user has necessary permission in the workspace.

- Cache Gradle packages
We cache Gradle packages to speed up the build process.

- Clear gradle container
We use docker container to run gradlew clean to clear previous build artifacts.

### Step 2: Build 

- Build bootJar 
We use docker container to run gradlew bootJar to build the Spring Boot application.

- build image
We build a Docker image.

### Step 3: Stop and remove old container

- Stop old container
- Remove old container

### Step 4: Run new container

- Run new container from the newly built image

### Step 5: Set up SonarQuebe 

- Run Jacoco to generate code coverage report

- Run SonarQube scanner to analyze the code quality

- Create documentation using MkDocs

- Convert markdown files to PDF using Pandoc

### Step 6: Serve-nginx

- Build Nginx docker image 

- Stop existing Nginx container if run

- Run nginx container to serve the [documentation](http://10.0.40.192/docs.pdf)

- Push to registry

### Step 7: Test: 

- We check if the API is working by sending a request to the endpoint and verifying the response.

### Step 8: Publish

- Publish the Docker image to the Docker registry.

### Step 9: Deploy 

- Setup SSH key 

- Add production server to known hosts

- Deploy on production server 
## Documentation
Find the pdf [here](http://10.0.40.192/docs.pdf)
