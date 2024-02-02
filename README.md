# CDA-Java-SquareGames

Amis apprenants du Campus Numérique, on a besoin de votre aide pour terminer un projet !

Pour commencer, voici la demande initiale :

"La société Square Games (« Du moment que le plateau est carré ! » ), spécialiste des jeux carrés allant du Tic Tac Toe (morpion) au jeu de go en passant par les échecs et l’Othello, souhaite diversifier son offre en proposer ses jeux dans un format numérique.
Leur demande ? Proposer tous leurs jeux, en ligne ou via des applications , en mode multi-joueurs, dotés d’une intelligence artificielle « adversaire ».
Votre mission, développer, étape par étape, tout ce qui est nécessaire pour répondre au besoin de la société.""

Ce projet concerne la partie application interne exécutée sur un PC, pas de web, juste de la console et du client lourd.

Un de vos GF (gentil formateur) a commencé le travail mais, faute de temps, le projet est un  en stand-by, ça vous dirait de le poursuivre ?

Etape 1 : forkez ce projet
Etape 2 : prenez une des missions suivantes 
Etape 2 : codez !

Ce projet, si vous savez l'expliquer et que vous l'avez fait évoluer pourra vous être utile un jour, au moment de la soutenance par exemple...

## Structure du programme

Le projet est décomposé en 2 grandes parties :

* sdk : toutes les classes génériques qui vous seront utiles pour développer des jeux
* program : l'application de jeu développée spécialement

Plusieurs design patterns et principes sont implémenter dans le projet (SOLID, MVC, Observer, Strategy, Visitor, DAO, DTO...), à vous de les retrouver et de vous en inspirer. 

/!\ bien que ce code se veuille générique, il est possible que quelques erreurs se soient glissées dedans, merci d'être indulgent et de ne pas tout prendre pour vérité absolue ! Faîtes vous votre propre idée

Si jamais vous bloquez, vous avez le droit de donner votre langue au chat ;)

## Missions (si vous les acceptez ;)

### Intégration SQL

Sauvegarder c'est bien !

La première chose est à faire, c'est de mettre en place une base de donnée et de la connecter. Pour apprendre, vous pouvez développer la partie gestion des profils.

Pour ce faire :

* prenez connaissance du pattern DAO/DTO (https://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/)
* lancez le programme
* allez dans le menu profile, vous trouverez des view qui ont besoin d'être connectées à la base

Une fois cette première étape de faite, place au code :

* développez la classe DbAccess située dans program/model/
* développez les méthodes de la classe ProfileDAO située dans program/account/

Pour testez vos développements, lancer le programme, les vues en consoles accessibles dans le menu profile vous aideront bien.

Quelques ressources :

* https://www.jmdoudoux.fr/java/dej/chap-jdbc.htm
* https://learn.microsoft.com/fr-fr/sql/connect/jdbc/step-3-proof-of-concept-connecting-to-sql-using-java?view=sql-server-ver16

Et si l'envie vous en prend, faîtes évoluer le projet pour intégrer des sauvegardes autres (player, jeux...)

### Connexion API

Sauvegardes 

### Développement des jeux

Les jeux en sont à un stade non fonctionnel, ça vous dit d'essayer de coder ce qui manque ?

### Mise en place GUI

Le bash, c'est la vie ! mais c'est pas très moderne...

Développer des vues Java graphiques, si la conception est correcte, elles pourront se mettre à la place des vues Bash...

### Un peu de doc...

Bien nommé ses classes et méthodes c'est bien mais quand on arrive à plus de 100 classes, un peu de doc fait pas de mal.

Pour comprendre le projet, commencer par écrire la javadoc peut être une bonne idée...