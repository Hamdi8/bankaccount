# BankAccount KATA
Ce projet a été développé en spring boot avec l'architecture hexagonale.
ce projet expose un API REST de cas d'utilisation d'une application bancaire.
## les endpoints : 
#### POST "account/{balance}/{username}"
création d'un compte pour l'utilisateur {username} et avec un solde {balance}.

#### ¨POST "account/{id}/deposit/{amount}"
Operation de dépot d'une somme {amount} dans le compte qui a l'id {id}.

#### POST "account/{id}/withdraw/{amount}"
retirer une somme {amount} dans le compte qui a l'id {id}.

#### GET "account/{username}
récupérer un compte avec son unique username.

