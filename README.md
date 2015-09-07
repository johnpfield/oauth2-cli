# README for OAuth2-CLI Spring Security Example

Last updated: September 7, 2015


This repository contains a sample OAuth2 client application that was implemented in Java, using the following frameworks:

 * Spring Boot
 * Spring Security OAuth2 

If you have been looking for some Java code that provides an example of how to do an HTTP GET request on an 
OAuth2 protected database service that surfaces it's data as MediaType: application/json+hal, and expects 
OAuth2 tokens using the Client Credentials grant, then this is the place.

## Features

The application is a simple Spring Boot application. It implements a dirt-simple command line client that accesses a RESTful Web Service. The expectation is that that RESTful Web service exposes some database data from a back end MySQL database table, with the help of Spring Data JPA. That service endpoint has been protected using Spring
Security OAuth2. This Client application wants to fetch data from the Web service endpoint, and must present a valid OAuth2 token, obtained from a trusted OAuth2 Authorization Server.  

## Prerequisites for target environment

 1. Spring Boot
 2. Java 7 (or greater) sdk
 3. Git
 4. Apache Maven 3
 5. Your favorite IDE (Spring STS preferred)

## Why Did the World Need Yet Another OAuth2 Example?

This repo provides a standalone example of how to do the client side implementation of the OAuth2 Client Credentials grant.  It should be noted that there already exists several other Spring Security OAuth2 examples, and many of these are very good.  The unique contribution of this project is that this sample Spring Boot application illustrates how to implement a functioning command line client program that works with the OAuth2 Client Credentials Grant. The Client Credentials Grant should be used whenever the resources to be accessed are going to be authorized based on the identity of the Client application alone, rather than on behalf of any particular end user.  In this use case scenario, the end user does not own the data at the resource server. The access is granted based upon the credentials of the Client application, and the end user identity is not part of the interaction.   

This CLI client is intended to be used in conjunction with the corresponding data service found in this [other repo](https://github.com/johnpfield/oauth2-jpa.git). Alternatively, the command line client implementation found in this repository could be used as a test utility against any other OAuth2 compliant Authorization Server and Authorization Server pair that expects a Client Credentials grant.

## Quick Start

Get a copy of this repository by doing a Git clone:

 ``git clone https://github.com/johnpfield/oauth2-cli.git``

Assuming the OAuth2-protected service endpointi(s) have already been deployed, do the following:

 ``mvn spring-boot:run``


## Configuration Options

The OAuth2 details such as client ids, client secrets, the URLs and/or port numbers used to obtain and present the OAuth2 tokens, etc. can all be changed by editing 

 ``/src/main/resources/application.properties``.

## To Do List

Still need to add more documentation, code comments, and do some general tidying up.  In particular, the OAuth2 connection details should be configurable using Spring profiles, and the test suite is essentially nonexistent.
