# Kata 6 IS2

Este proyecto consiste en una simple aplicación que muestra una lista de personas y una breve información sobre ellas. La información de las personas
es almacenada en una base de datos MongoDb, hosteada en una máquina virtual utilizando el servicio de virtualización docker. La comunicación entre 
la aplicación y la base de datos se realiza utilizando el [driver java para mongodb](https://mongodb.github.io/mongo-java-driver/).
Para la instalación del paquete se utilizó el gestor de librerías de java [gradle](https://gradle.org/).

## Instalación y ejecución

En primer lugar, se debe de instalar [docker](https://docs.docker.com/install/) y la imagen de mongo de docker.

```bash
docker pull mongo
```

A continuación creamos el container mongo con el mapeo de puertos correspondiente

```bash
docker create --name mongodb -p 27017:27017 mongo
```

Una vez creado el container, lo inicializamos
```
docker start mongodb
```

Con el container inicializado, podemos proceder a la instalación de [gradle](https://gradle.org/) para la ejecución de la aplicación.
Después de instalar gradle, podemos ejecutar el comando gradle run en el directorio de descarga del proyecto.
