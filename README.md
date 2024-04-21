# mti2024
Corrections de cours MTI2024 & sujet du projet d'évaluation

 

# Projet
La société SpaceYX décide de se lancer dans le tourisme spatial.
Le principe et simple : Les passagers se rendent à une base pour le petit voyage, la navette décolle avec un maximum de 5 touristes à son bord, fais un petit tour dans l'espace avant de retourner se poser à la base.

Le but est de développer le backend d'une application pour gérer les différents voyages et leurs réservations.

Il existe plusieurs rôles dans l'aplication, chacuns ayant accès à leurs fonctionnalités.

## Techniciens
Les techniciens, qui sont capables de mettre à disposition du système des navettes et de révisions techniques.
  - Chaque navette possède :
    - Un nom
    - Une capacité de voyageur entre 3 et 5
    - Un status (OK, OBSOLETE)
  - Chaque révision est prévue à
    - Une date précise
    - Pour une navette précise

Les techniciens peuvent :
- Afficher, créer, supprimer des navettes. Modifier le status d'une navette.
- Créer, supprimer des révisions pour une navette
- Le passage d'une navette en OBSOLETE doit avoir le même effet que l'annulation d'un vol (décrit dans le paragraphe ci-dessous)

## Planificateurs
Les planificateurs, qui peuvent créer, lire, modifier et supprimer les vols.
  - Un vol correspond à une date, heure une navette et un status.
  - Le status est
      - PASSED si la date du vol est passée
      - OK si la navette a correctement été révisée
      - WAITING_FOR_GEARCHECK si la navette n'a pas effectué de révision depuis son dernier vol (on estime qu'une navette nouvellement créée doit être révisée quand même).
  - Pas plus d'un vol spatial par mois (toute navette confondue) ! C'est interdit par la FAA (federal aviation administration)
  - La modification ou la suppression d'un vol doit s'accompagner d'un mail (bouchonné à l'aide d'un System.out.println) aux usagers de ce vol expliquant pourquoi le vol a été annulé. Il n'est pas nécessaire de conserver un historique dans vols annulés.

## Voyageurs
Les voyageurs : Qui s'inscrivent sur les différents vols grâce à un identifiant qui est également leur mail.
  - Ils peuvent afficher la liste des vols futurs avec le nombre de places restantes
  - Ils peuvent s'inscrire que sur un/des vol(s) futur(s) (pas d'inscription sur un vol déjà passé)
  - Ils ne peuvent pas s'inscrire plusieurs fois sur un même vol
  - Ils ne peuvent pas s'inscrire sur un vol sur lequel il n'y a pas de place
  - Ils ne peuvent s'inscrire que eux-même
  - Ils ne peuvent pas annuler...tant pis pour eux !
 
------

## Utilisateurs

Voici la liste des utilisateurs devant avoir accès à l'application.

| Username                    | Password        | Role            |
|-----------------------------|-----------------|-----------------|
| mrbricolage@spacyx.com      | 33raptor        | Technicien      |
| voyagevoyage@spaceyx.com    | ihaveaplan      | Planificateur   |
| romain@mail.com             | çavaaller       | Voyageur        |

------ 

## Technologies
L'application doit être faite avec les notions vues en cours. Cela comprend :
- Une application Java 21 + Spring-boot avec une version > 3.0
- Spring-web
- Spring-data-jpa
- Spring-security
- L'utilisation de maven pour importer les librairies nécessaires
- Toute persistance doit se faire avec une base de données mémoire H2
- Une architecture monolithique en 4 couches distinctes

## Rendu
Voici la liste des éléments à rendre afin d'être corrigé :
- L'adresse d'un repo git contenant le code source de votre projet
- Les repos seront clonés à date et heure du rendu. Tout commit effectué après ne sera pas pris en compte.
- Pensez à ajouter votre professeur en lecture sur le repo...ça serait dommage pour vous qu'il ne puisse pas clôner votre projet à heure dite...
- La liste des personnes ayant participé à ce projet doit se trouver à l'endroit approprié dans le pom.xml
- Un *.jar *auto-exéutable* (type fat-jar) dans un dossier "jar" à la racine de votre projet. Le jar doit pouvoir s'exécuter sans autre configuration externe.
- Un jeu de données pré-existant dès le démarrage de l'application, permettant de tester un maximum de fonctionnalités de l'application
- L'adresse de votre swagger-ui (ou à défaut, une documentation d'API explicite pour tester votre projet)
- Indiquez également dans le fichier readme.md à la racine de votre projet les choses à savoir qui pourraient intéresser le correcteur

## Point d'attention
Le sujet n'a rien de techniquement complexe. Il est volontairement fonctionnellement simple pour vous permettre de mettre l'accent sur les bonnes pratiques et la maintenabilité. Une grosse partie des points sera attribué à cet effet.

Cela comprend :
- L'utilisation d'un nommage de classe/variable/méthode propre
- Des méthodes claires, petites et auto-portantes
- L'application des principes SOLID
- Peu de duplication (DRY)
- Pas de code mort (YAGNI)
- Des bonnes pratiques dans la conception de vos APIs HTTP

Il n'est pas nécessaire d'effectuer de documentation (type javadoc), et les tests automatisés sont facultatifs (car non abordés pendant ce cours), mais cela vous sera demandé dans le monde de l'entreprise.
Il n'est pas demandé de dossier et il ne sera demandé de soutenance. Le code doit être suffisamment propre et explicite pour ne pas avoir besoin d'explications.
