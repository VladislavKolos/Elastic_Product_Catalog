# Elastic Product Catalog

## Overview

Elastic Product Catalog is a project for indexing products from a PostgreSQL database into Elasticsearch, enabling highly efficient search capabilities through a REST API. This application is designed for easy deployment with Docker and offers a RESTful API for interacting with product data.

## Acceptance Criteria

- The project can be cloned from a remote Git repository.
- It can be started using provided instructions.
- Users can obtain search results through the API.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Usage](#api-usage)
  - [Loading Products into Elasticsearch](#loading-products-into-elasticsearch)
  - [Searching Products](#searching-products)
- [Stopping the Application](#stopping-the-application)

## Features

- Manage products and their SKUs.
- Perform search operations using Elasticsearch.
- Dockerized for seamless deployment.

## Technologies

- **Backend:** Spring Boot, JPA, PostgreSQL
- **Search Engine:** Elasticsearch
- **Containerization:** Docker, Docker Compose
- **Build Tool:** Maven
- **Miscellaneous:** Lombok, Flyway for database migrations

## Prerequisites

- **Docker:** Ensure Docker is installed on your machine.
- **Docker Compose:** Ensure Docker Compose is installed.

## Installation

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd Elastic_Product_Catalog
   ```
   Alternatively, use:
   ```bash
   git clone https://github.com/username/Elastic_Product_Catalog.git
   cd Elastic_Product_Catalog
2. **Ensure Docker and Docker Compose are running.**

## Running the Application

1. **Start the application with Docker Compose:**
   ```bash
   docker-compose up --build
2. The application will be available at http://localhost:8080.

## API Usage

### Loading Products into Elasticsearch

To load products into Elasticsearch, use the following API endpoint in Postman:
POST http://localhost:8080/api/index/create
1. **Open Postman.**
2. **Create a new request.**
3. **Set the method to POST.**
4. **Enter the URL: http://localhost:8080/api/index/create.**
5. **Click Send.**
6. **If successful, the response will contain a list of indexed products.**

### Searching Products

To search for products, use this API endpoint:
GET http://localhost:8080/api/products/search?keyword=<search-term>

1. **Open Postman.**
2. **Create a new request.**
3. **Set the method to GET.**
4. **Enter the URL: http://localhost:8080/api/products/search?keyword=<your-search-term>.**
5. **Click Send.**
6. **The response will return a list of products matching the search term.**

## Stopping the Application

To stop the application and remove running containers, execute:
```bash
docker-compose down
