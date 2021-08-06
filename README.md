# Football World
> An application for viewing sports leagues, clubs registered with them and players playing in these clubs.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Views](#views)
* [Project Status](#project-status)
* [Contact](#contact)


## General Information
- Project created in Java according to REST API.
- Models created: League, Club, Player.
- Leagues were connected with Clubs by OneToMany relationship, as was Clubs relationship with Players.
- Enpoints have been created for all entities for saving, reading, editing and deleting (CRUD).
- Additional methods have been added that return the average salary of players from a given club and the average salary of all players.
- A graphical interface for the Leagues was created using Thymeleaf. The interface allows you to view all leagues, add, update and delete leagues.
- Documentation available using Swagger 2.


## Technologies Used
- Java
- Spring Boot
- MySQL
- Lombok
- Mapstruct
- Swagger 2
- Thymeleaf
- Docker

## Setup
Use the command  ```docker compose up```

## Views
![image](https://user-images.githubusercontent.com/62305866/128501989-535ceac3-7537-4ff7-b7f4-ba439b7cdeab.png)
![image](https://user-images.githubusercontent.com/62305866/128502056-0609ab98-548e-4496-915a-7907f82c04b6.png)
![image](https://user-images.githubusercontent.com/62305866/128502127-3ae6eee4-bbb5-48a3-af85-c7f72b6cb24b.png)

## Project Status
Project is: _in progress_

## Contact
Created by [@wojciechkostecki](https://www.linkedin.com/in/wojciech-kostecki-7816411a4/)
