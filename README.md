# :deciduous_tree: TREE C.C :deciduous_tree:
la aplicacion consiste en la busqueda rapida y satisfactoria de noticias relacionadas al cambio climatico , a modo de lograr tener una fuente de informacion que recopile cada hecho registrado en el pais. 

 ### :pencil: **Pre-Requisitos** :pencil:

Además de conocimientos de programación, necesitarás un ordenador con las siguientes especificaciones mínimas para poder usar Android Studio:

* 3 GB RAM mínimo, 8 GB RAM recomendado más 1GB adicional para el emulador de Android.
+ 2 GB de espacio en disco para Android Studio, 4GB recomendados (500MB para la IDE y al menos 1.5 GB para Android SDK, imágenes de sistema de emulador y cachés).
+ El Java Development Kit (JDK) 8.
+ version de IDE (ANDROID STUDIO) 3.6 publicada el 24 de febrero de 2020 
+  Una resolución de pantalla mínima de 1280x800, siendo la recomendada 1440x900.

### :computer: instalacion de Android Studio :computer:
1. Accede a la página de Android Developer y ubicarse en el  apartado de  "Android Studio downloads" , y dar click en "download archives".
2. leer las condiciones y seguidamente aceptarlas.
3. seleccionar la version 3.6 y descargarla. 
4. Tras su descarga, pulsa sobre el instalador. Pulsa Next y mantén las dos opciones marcadas seleccionadas. Vuelve a pulsar Next.
5. Elige la carpeta de destino de Android Studio, y pulsa Next. Si quieres crear una carpeta en el menú de inicio, pulsa Install. Si no, marca la opción "Do not create shortcuts", y pulsa Install.
6. Una vez se complete la instalación, vuelve a pulsar Next, y después Finish. Android Studio se iniciará automáticamente.
7. En el primer arranque del programa, te preguntará si quieres importar tus preferencias. Marca la casilla "Do not import settings" y pulsa OK.
8. Comenzará el proceso de configuración de Android Studio. Selecciona la configuración estándar (Standard), elige el tema del programa que más te guste y pulsa finish.
9. Cuando finalice el proceso de descarga e instalación de paquetes, se abrirá la pantalla principal de Android Studio. Para comenzar un nuevo proyecto de Android Studio, pulsa "Start a new Android Studio Project"
10. Elige un nombre para la aplicación, escribe el nombre de tu dominio web (si lo tienes) y pulsa Next. Selecciona la versión de Android sobre la que quieras trabajar, elige la actividad que se añadirá al teléfono, el nombre de dicha actividad y de su disposición.
11. ¡Ya puedes comenzar a trabajar en tu aplicación!

## :wrench: instalacion de firebase :wrench:
* Paso1:Crea un proyecto de Firebase.
A fin de poder agregar Firebase a tu app para Android, debes crear un proyecto de Firebase y conectarlo a la app. Consulta la Información sobre los proyectos de Firebase para obtener detalles acerca del tema.
* paso2:Registra tu app con Firebase.
Cuando tengas un proyecto de Firebase, podrás agregarle tu app para Android.
Revisa la Información sobre los proyectos de Firebase a fin de obtener detalles sobre las recomendaciones y consideraciones para agregar apps a un proyecto de Firebase, incluido cómo manejar diversas variantes de compilación.
1.En el centro de la página de descripción general del proyecto en Firebase console, haz clic en el ícono de Android para iniciar el flujo de trabajo de configuración.
Si ya agregaste una app a tu proyecto de Firebase, haz clic en Agregar app para que se muestren las opciones de plataforma.
2.ngresa el ID de aplicación de tu app en el campo Nombre del paquete de Android.
3.(Opcional) Ingresa otra información de la app si el flujo de trabajo de configuración lo solicita.
El sobrenombre es un identificador interno y conveniente, y solo tú puedes verlo en Firebase console.
4.Haz clic en Registrar app.
* Paso 3: Agrega un archivo de configuración de Firebase
 1. Agrega el archivo de configuración de Firebase para Android a la app, como se indica a continuación:
   - Haz clic en Descargar google-services.json a fin de obtener el archivo de configuración de Firebase para Android (google-services.json).
      * Puedes volver a descargar el archivo de configuración de Firebase para Android cuando quieras.
       * Asegúrate de que no se hayan agregado caracteres adicionales, como (2), al nombre del archivo de configuración.
   - transfiere tu archivo de configuración al directorio del módulo (nivel de app) de tu app.
 2. Agrega el complemento de google-services a tus archivos Gradle a fin de habilitar los productos de Firebase en tu app.
    - Agrega reglas para incluir el complemento de Google Services al archivo Gradle (build.gradle) de nivel de raíz (nivel de proyecto). Además, revisa que tengas el repositorio Maven de Google.
    
    - En el archivo Gradle (generalmente app/build.gradle) de tu módulo (nivel de app), agrega una línea al final del archivo.
* Paso 4: Agrega los SDK de Firebase a tu app.

Puedes agregar cualquiera de los productos de Firebase admitidos a tu app para Android. Te recomendamos comenzar con el SDK principal de Firebase (com.google.firebase:firebase-core), que ofrece funciones de Google Analytics para Firebase.

## :black_nib: Licencia Utilizada :black_nib:
LGPLv3 (GNU Lesser General Public License).

## :iphone: Construido con :iphone:
* :fire: Fire base :fire:
* :recycle: complementos : :recycle: 
- databinding
 - firebase
- lifecycle
- picasso
- navigation 
 - retrofit
- shadowimageview


## :black_nib: Autores :black_nib: 
* Bryan Alexis Orellana Cabrera.
* Gabriel Enrique Gonzales Rodriguez.
* Jesus Antonio Alvarado Gonzalez
* Miguel Ernesto Rivas Serrano.
* Oscar Isai Aldana Cruz.
