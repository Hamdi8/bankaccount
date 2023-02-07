# BankAccount KATA
Ce projet a été développé en spring boot avec l'architecture hexagonale.
ce projet expose un API REST de quelques cas d'utilisation d'une application bancaire avec quelques méthodes des tests unitaires avec JUnit.
## les endpoints : 
#### POST "account/{balance}/{username}"
création d'un compte pour l'utilisateur {username} et avec un solde {balance}.

#### POST "account/{id}/deposit/{amount}"
Operation de dépot d'une somme {amount} dans le compte qui a l'id {id} (et ajouter cette opération dans l'historique)

#### POST "account/{id}/withdraw/{amount}"
Opération de retrait d'une somme {amount} dans le compte qui a l'id {id} ((et ajouter cette opération dans l'historique)

#### GET "account/{username}
récupérer un compte avec son unique username.

## Architecture Hexagonale:
L’architecture hexagonale s’appuie sur trois principes et techniques :
  - Séparer explicitement User-Side, Business Logic et Server-Side
  - Les dépendances vont vers la Business Logic
  - On isole les frontières par des Ports et Adapters
  
Le projet est divisé sur deux parties principales:
#### Application Core:
 - Domain:
La principale responsabilité de Domain est de modéliser la logique métier. Il vérifie également que les objets sont toujours dans un état valide.
 
 - Ports:
Les ports sont les interfaces définies par l’hexagone pour s’interfacer avec le monde extérieur.
Il existe 2 types de port, les ports permettant d’appeler des fonctions dans l’hexagone et les ports permettant à l’hexagone d’appeler des éléments extérieurs.
Un autre élément important est que les ports (d’entrée ou de sortie) sont définis dans l’hexagone

- Service:
Le service assure la liaison de toutes les pièces ensemble. Par exemple ,dans les deux opérations (dépot et retrait), le service permet d'utiliser le port 'Load' pour extraire les données de Database , puis modifier les données de l'objet et enfin enregistrer la modification.

#### Adaptaters: 
Dans l'architecture hexagonale, les adaptateurs utilisent les ports définis dans l'application core. Les adaptateurs implementés dans ce projet sont:

 - Web:
Pour les interations entrantes par le User-Side , on crée un REST Controller.
 
 - Persistence:
Pour la couche de persistance, j'ai utilisé MongoDB via Spring Data. De plus, j'ai crée une classe BankAccountRepository qui connecte les outgoing ports avec SpringDataBankAccountRepository
 
 - Infrastructure: 
 Enfin, on doit dire à Spring d'exposer le BankAccountService en tant que bean, afin qu'il puisse être injecté dans le contrôleur.
 La définition des beans dans la couche Adapters aide à maintenir le code d'infrastructure découplé de la logique métier (Business Logic).
 




