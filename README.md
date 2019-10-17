 Capas de la aplicación

Una vez acabada la prueba describa en un readme brevemente:

1. Las capas de la aplicación (por ejemplo capa de persistencia, vistas, red, negocio, etc) y qué clases pertenecen a cual.

 Directory :
 data -> Persistencia de información y modelos.
         Parser para consumir informacion del API
 uimovie  -> Vista principal
 uidetail -> Detalle de cada elemento


2. La responsabilidad de cada clase creada.

   Clase :
   ReneConfig -> Endpoint and api key for themoviedb
   App -> Initialization DB and SDK Fresco
   extension -> Clase que apoya para el parser de la información
   ReneDB -> Instancia de BD


Responda y escriba dentro del Readme con las siguientes preguntas:

1a. ¿En qué consiste el principio de responsabilidad única?

R.- Cada clase debe tener responsabilidad sobre una sola parte de la funcionalidad del programa.

1b. ¿Cuál es su propósito?

R.- El proposito es modular el codigo y con ello poder funcionar de forma independiente cuando se requiera.

2. Qué características tiene, según su opinión, un “buen” código o código limpio?

R.- Escrito de forma correcta , facil de comprender , estandarización de nombres de metodos , variables y clases.

# TestRappi
