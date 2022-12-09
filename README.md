# Información importante

### Para configurar y correr proyecto en tu local
1. Git clone https://github.com/MrSamu25/Java-SpringBoot-Challenge/commits/main
2. Abrirlo en tu IDE preferido
3. Configurar variables de entorno
   1. ${DB_HOST} -> jdbc:postgresql://localhost:5432/postgres -> (db local)
   2. ${DB_USERNAME} -> some_user
   3. ${DB_PASSWORD} -> some_password
4. Correr scripts para crear tablas user, album y shared_album. Los encuentran en el archivo Scripts.sql

###  Ejemplos de los endpoints expuestos

1. GET -> http://localhost:8080/users?username=Bret
2. GET -> http://localhost:8080/users-permissions?albumId=29&read=true&write=true
3. GET -> http://localhost:8080/users/1/photos
4. GET -> http://localhost:8080/albums?id=1
5. GET -> http://localhost:8080/photos?albumId=1
6. GET -> http://localhost:8080/sharedAlbums 
7. POST -> http://localhost:8080/sharedAlbums
   1. {
      "read": false,
      "write": false,
      "userIdSource": 3,
      "userIdDestination": 2,
      "albumId": 29
      }
8. PUT -> http://localhost:8080/sharedAlbums
   1. {
      "id": 8,
      "read": true,
      "write": true,
      "userIdSource": 2,
      "userIdDestination": 1,
      "albumId": 11
      }
9. GET -> http://localhost:8080/comments?name=excepturi sunt cum a et rerum quo voluptatibus quia

## Importar colección de Postman

https://api.postman.com/collections/16067440-ff5bbfce-0aee-4aff-885d-da3aac44052e?
access_key=PMAT-01GKTCA95Q3N37AJWS6ZAMQN36
