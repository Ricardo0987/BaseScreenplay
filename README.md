# Base Screenplay

## Para correr prueba ejecutar

```
gradle clean test aggregate
```

## **Resumen**

Se utiliza BDD como framework de automatización sobre el patrón de arquitectura de ScreenPlay donde segregamos las capas de automatización.

### features
Se evidencian los casos prueba en lenguaje Gherkin para fácil entendimiento por parde del negocio siguiendo el modelo “**Given** [rol] **When**[característica] **Then** [los beneficios]” y sus variaciones, con él se define el comportamiento de la transacción que vamos a automatizar. Se trata de un lenguaje fácil de leer, fácil de entender y fácil de escribir. Utilizar Gherkin nos va a permitir crear una documentación viva a la vez que automatizamos los tests.

### Step Definitions
Son clases que mapean cada línea de los escenarios definidos en lengua-je Gherkin a métodos java.

### Tasks]
Son tareas a un nivel de granularidad más alto al de clicks y selects.

### Interactions
Una interacción representa una acción directa del usuario con la interfaz como ingresar datos en campos o dar clics en botones.

### Questions
Es la capa donde se verifican los resultados de las operaciones realizadas en las capas anteriores.

### User interface
Son las clases que mapean los componentes de una interfaz de usuario.

### Integration
Capa creada para integraciones con otros subsistemas.

### Util
Capa trasnversal al proyecto para reutilización de metodos.

### Model
Una capa donde se encontrarán todos los objetos complejos de negocio, como personas o cuentas bancarias para ser usados dentro de cualquier capa del proyecto.

### Exceptions
Una capa donde se crearán las excepciones específicas que permitirán la legibilidad de los reportes cuando las pruebas fallen.

