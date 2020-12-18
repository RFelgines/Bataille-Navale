# Bataille-Navale
Projet Bataille navale

Dans la version actuelle du programme,le serveur et le client sont capables de lire et d’envoyer des messages afin que le client puisse avoir les informations nécessaires.
Le client n’a pas la notion de jeu à part le plateau, c’est donc le serveur qui gère les différentes phases de jeu
Pour le placement des bateaux on vérifie deux choses : 
-	Que le bateau ne dépasse pas les limites de la carte
-	Que le bateau ne se superpose avec aucun autre.

Après chaque tir on vérifie si la partie est terminée ou pas. Pour cela on vérifie après chaque tir si il existe encore des bateaux avec une vie non nulle.

