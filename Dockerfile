name: Build JAR with Docker

on:
  push:
    branches: [ "master" ]
  pull_request:
    branches: [ "master" ]
  workflow_dispatch:

jobs:
  build:
    runs-on: self-hosted  # your Ubuntu server

    steps:
      # Checkout your repo
      - uses: actions/checkout@v4

      # Build the Docker image
      - name: Docker build
        run: docker build -t fhvdevops .

      # Create a container from the image, copy the JAR to host
      - name: Extract JAR from Docker image
        run: |
          CONTAINER_ID=$(docker create fhvdevops)
          docker cp $CONTAINER_ID:/build/libs/$(ls build/libs/ | head -n1) ./app.jar
          docker rm $CONTAINER_ID

      # List the JAR on the host
      - name: Verify JAR
        run: ls -l app.jar
