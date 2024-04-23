# Mini-Projet-id3
## Services de Communication
Ce référentiel contient l'implémentation de différents services de communication utilisant Java RMI, gRPC et les sockets.

## Services a implementer
Java RMI :Gestion d'une liste de tâches
### Ajouter une nouvelle tâche à la liste
Méthode : addTask(task: Task)
Description : Cette méthode permet d'ajouter une nouvelle tâche à la liste existante.
### Supprimer une tâche existante de la liste
Méthode : removeTask(taskId: int)
Description : Cette méthode permet de supprimer une tâche existante de la liste en fonction de son identifiant.
### Récupérer la liste complète des tâches
Méthode : getTaskList()
Description : Cette méthode renvoie la liste complète des tâches actuellement enregistrées.
gRPC : Service de messagerie
### Envoi de messages texte à un destinataire spécifié

Méthode : sendMessage(message: SendMessageRequest)
Description : Cette méthode permet d'envoyer un message texte à un destinataire spécifié.
### Récupération des messages reçus pour un utilisateur donné
Méthode : getMessages(message: GetMessageRequest )
Description : Cette méthode renvoie les messages reçus pour un utilisateur donné.
Sockets : Service de chat
### Envoi de messages texte à un salon de discussion commun
Description : Ce service permet aux utilisateurs d'envoyer des messages texte à un salon de discussion commun.
Récupération des messages envoyés par d'autres utilisateurs
Description : Ce service permet aux utilisateurs de récupérer les messages envoyés par d'autres utilisateurs dans le même salon de discussion.
### utilisation de java swing pour une meilleur experience pour l utilisateur
## Deploiemnt et Test
### Java RMI
Cloner ce référentiel depuis GitHub : git clone [https://github.com/jlassim/Mini-Projet-id3/tree/main/mini-projet/mini-projet-sys-repartie/TaskManagement/src/Task]

Accéder au répertoire Java RMI : cd java-rmi

Compiler le code : javac *.java

Démarrer le registre RMI : start rmiregistry

Exécuter le serveur : java TaskServer

Exécuter le client : java TaskClient
### gRPC
Cloner ce référentiel depuis GitHub : git clone [https://github.com/jlassim/Mini-Projet-id3/tree/main/mini-projet/mini-projet-sys-repartie/GRPC-Messagerie/src/main/java]

Accéder au répertoire gRPC : cd grpc

Installer les dépendances : npm install

Démarrer le serveur : java MessagingService.java

Exécuter le client : java MessagingClient.java

### Sockets
Cloner ce référentiel depuis GitHub : git clone https://github.com/mohamedaminerebhi/Projet-sys-repartie-IDS3/tree/main/ChatRoom/src

Accéder au répertoire Sockets : cd sockets

Compiler le code : javac *.java

Démarrer le serveur : java Server

Exécuter le client : java Client

## Contributeurs
### jlassi maram (IDS3)
