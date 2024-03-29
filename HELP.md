# TP Thymeleaf : bibliothèque

* Créer une page HTML dynamique qui affiche la liste des Livres (titre)
* Créer une page HTML qui affiche les détails d'un Livre (titre, date de parution, résumé, ...) (l'id du Livre est
  fourni en 'query param’
* Dans la liste des livres, rendre le titre clickable pour afficher la page détails du Livre. Et un lien pour revenir à
  la liste de livres.
* Créer un formulaire HTML pour ajouter un Livre

# TP Mediathèque

Créer un projet SpringBoot avec JPA et Spring Web

1. On a besoin de 3 tables : **adherents**, **documents**, **emprunts**

2. On a besoin d’une classe Service qui va manipuler la base de données

3. On a besoin d’une classe qui va contenir les règles métier liées au fonctionnement de la médiathèque (et qu’on pourra
   tester avec des Tests Unitaires si nécessaire)
   Ajout
   **Créer une API :**

* GET /adherents
* POST /adherents
* GET /documents
* POST /documents
* GET /emprunts
* POST /emprunts

**Règles métier :**

* Un adhérent ne peut pas emprunter plus de 3 documents
* Un adhérent ne peut pas emprunter si son adhesion est périmée
* Un document ne peut être emprunté en même temps par plusieurs adhérents

**Aide pour les associations JPA:**

* 1 Emprunt doit contenir 1 Adherent et 1 Document (ManyToOne)

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

