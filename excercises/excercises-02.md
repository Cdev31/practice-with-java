# Ejercicio 31 — Monitor de cambios en directorios

## Qué se practicará

- `WatchService`
- `Path`
- `Files`
- eventos del sistema de archivos
- POO orientada a eventos
- reutilización del analizador de directorios
- separación entre observación y reporte

---

## Enunciado

Construye `DirectoryWatchCLI`, una herramienta que observe un directorio en tiempo real y registre cambios en los archivos.

El sistema debe detectar eventos como:

- creación de archivos
- modificación de archivos
- eliminación de archivos

Además, debe poder mantener un historial en memoria de eventos detectados y permitir consultar estadísticas del monitoreo.

---

## Requerimientos del programa

1. Debe usar `WatchService`.
2. Debe permitir al usuario indicar el directorio a observar.
3. Debe validar que la ruta exista y sea un directorio.
4. Debe registrar cada evento en un objeto `FileSystemEvent`.
5. Debe permitir:

   - iniciar monitoreo
   - detener monitoreo
   - listar eventos capturados
   - contar eventos por tipo

6. Debe registrar fecha y hora de cada evento.
7. Debe separar:

   - observador de archivos
   - almacenamiento de eventos
   - UI

8. Debe reutilizar componentes de renderizado tabular si ya los tienes.

---

# Ejercicio 32 — Copiador de archivos por bloques

## Qué se practicará

- `InputStream` / `OutputStream`
- NIO básico
- buffers
- métricas de copia
- diseño de servicios
- manejo de errores de archivos grandes

---

## Enunciado

Crea `FileCopyToolCLI`, una utilidad para copiar archivos usando lectura y escritura por bloques.

El programa debe mostrar:

- tamaño del archivo origen
- progreso aproximado
- bytes copiados
- tiempo total de copia
- tasa promedio de transferencia

---

## Requerimientos del programa

1. Debe leer archivo origen y destino desde consola o argumentos.
2. Debe validar:

   - archivo origen existente
   - destino válido
   - que origen y destino no sean el mismo archivo

3. Debe copiar por bloques usando buffer configurable.
4. Debe encapsular resultados en un objeto `FileCopyReport`.
5. Debe medir duración de la operación.
6. Debe permitir elegir tamaño de buffer.
7. Debe manejar errores de permisos o lectura/escritura.
8. Debe separar la lógica de copia de la presentación del reporte.

---

# Ejercicio 33 — Sincronizador simple de directorios

## Qué se practicará

- `Files.walk`
- comparación de archivos
- reutilización de hashing y metadatos
- diseño incremental
- reportes de sincronización

---

## Enunciado

Desarrolla `DirectorySyncCLI`, una herramienta que compare dos directorios y determine qué archivos deben copiarse para sincronizarlos.

Debe detectar:

- archivos que existen solo en origen
- archivos que existen solo en destino
- archivos con mismo nombre pero distinto contenido
- archivos idénticos

---

## Requerimientos del programa

1. Debe analizar dos directorios.
2. Debe recorrer ambos árboles de archivos.
3. Debe comparar archivos por:

   - ruta relativa
   - tamaño
   - opcionalmente hash

4. Debe generar un `DirectorySyncReport`.
5. Debe permitir modo:

   - solo análisis
   - sincronización real

6. Debe mostrar resumen de:

   - archivos copiados
   - omitidos
   - conflictivos

7. Debe reutilizar lógica de comparación de archivos ya creada.
8. Debe validar correctamente rutas inválidas.

---

# Ejercicio 34 — Cliente HTTP de consulta remota

## Qué se practicará

- `HttpClient`
- `HttpRequest`
- `HttpResponse`
- diseño de clientes HTTP
- manejo de timeouts
- parsing de respuestas de texto
- separación entre transporte y lógica

---

## Enunciado

Construye `HttpInspectorCLI`, una herramienta que realice solicitudes HTTP a una URL indicada por el usuario y muestre información relevante de la respuesta.

Debe permitir:

- hacer peticiones GET
- ver código de estado
- ver headers
- ver tamaño del body
- guardar el body en archivo opcionalmente

---

## Requerimientos del programa

1. Debe usar `java.net.http.HttpClient`.
2. Debe permitir ingresar una URL válida.
3. Debe mostrar:

   - método usado
   - status code
   - headers
   - duración de la petición
   - tamaño del body

4. Debe permitir guardar la respuesta a archivo.
5. Debe manejar:

   - URL inválida
   - timeout
   - host inaccesible

6. Debe encapsular la respuesta en un objeto `HttpInspectionResult`.
7. Debe separar cliente HTTP, validación y UI.

---

# Ejercicio 35 — Descargador concurrente de recursos HTTP

## Qué se practicará

- `HttpClient`
- concurrencia base
- `ExecutorService`
- `Callable`
- `Future`
- reportes agregados
- reutilización del cliente HTTP

---

## Enunciado

Crea `MultiDownloadCLI`, una aplicación que descargue múltiples recursos HTTP en paralelo a partir de una lista de URLs.

El sistema debe:

- descargar varios recursos al mismo tiempo
- guardar cada respuesta en un archivo
- registrar éxito o fallo por cada descarga
- mostrar un reporte final consolidado

---

## Requerimientos del programa

1. Debe usar un `ExecutorService`.
2. Debe modelar cada descarga como una tarea independiente.
3. Debe permitir configurar número máximo de workers.
4. Debe guardar cada archivo descargado en una carpeta destino.
5. Debe registrar por cada URL:

   - estado final
   - tiempo de descarga
   - tamaño descargado
   - error si falló

6. Debe devolver un `BatchDownloadReport`.
7. Debe reutilizar el cliente y validaciones del ejercicio anterior.
8. Debe cerrar correctamente recursos y executor.

---

# Ejercicio 36 — Cliente TCP de mensajería simple

## Qué se practicará

- `Socket`
- streams sobre red
- protocolos simples de texto
- POO para comunicación
- separación entre transporte y comandos
- manejo de desconexiones

---

## Enunciado

Desarrolla `TcpChatClientCLI`, un cliente TCP de consola que se conecte a un servidor y permita enviar y recibir mensajes de texto simples.

El cliente debe:

- conectarse a host y puerto
- enviar mensajes escritos por el usuario
- recibir respuestas del servidor
- registrar un pequeño historial local

---

## Requerimientos del programa

1. Debe usar `Socket`.
2. Debe leer host y puerto desde consola o argumentos.
3. Debe manejar conexión, envío y recepción en clases separadas.
4. Debe permitir salir con un comando especial.
5. Debe registrar mensajes enviados y recibidos con timestamp.
6. Debe manejar:

   - host inválido
   - puerto inválido
   - desconexión del servidor

7. Debe encapsular cada mensaje en un objeto `ChatMessage`.
8. Debe mantener el historial en memoria.

---

# Ejercicio 37 — Servidor TCP de eco multicliente

## Qué se practicará

- `ServerSocket`
- concurrencia con threads o executor
- manejo de múltiples clientes
- diseño cliente/servidor
- reutilización del cliente TCP

---

## Enunciado

Construye `TcpEchoServerCLI`, un servidor TCP que acepte múltiples clientes y responda a cada mensaje recibido devolviendo el mismo contenido con metadatos adicionales.

El servidor debe:

- aceptar múltiples conexiones
- responder por cliente
- registrar conexiones activas
- guardar historial básico de interacción

---

## Requerimientos del programa

1. Debe usar `ServerSocket`.
2. Debe manejar cada cliente en un worker separado.
3. Debe mostrar:

   - clientes conectados
   - total de mensajes recibidos
   - conexiones cerradas

4. Debe registrar por cliente:

   - dirección remota
   - hora de conexión
   - cantidad de mensajes

5. Debe permitir apagar el servidor desde consola.
6. Debe reutilizar el cliente del ejercicio anterior para probarlo.
7. Debe separar:

   - servidor
   - manejador de cliente
   - repositorio de sesiones
   - UI/monitor

---

# Ejercicio 38 — Cliente y servidor UDP de notificaciones

## Qué se practicará

- `DatagramSocket`
- `DatagramPacket`
- comunicación UDP
- comparación con TCP
- diseño simple de protocolo
- reutilización de modelos de mensajes

---

## Enunciado

Crea `UdpNotifierCLI`, compuesto por dos programas o dos modos de ejecución:

- modo servidor UDP
- modo cliente UDP

El cliente enviará mensajes de notificación y el servidor los recibirá y registrará sin mantener conexión persistente.

---

## Requerimientos del programa

1. Debe usar `DatagramSocket` y `DatagramPacket`.
2. Debe permitir configurar host y puerto.
3. Debe registrar en el servidor:

   - remitente
   - hora de recepción
   - contenido

4. Debe permitir al cliente enviar múltiples mensajes.
5. Debe manejar límite de tamaño razonable para datagramas.
6. Debe mostrar diferencias prácticas frente a TCP en el reporte o ayuda.
7. Debe reutilizar modelos de mensajes cuando tenga sentido.

---

# Ejercicio 39 — Explorador DNS y direcciones IP

## Qué se practicará

- `InetAddress`
- validación de hostnames
- reportes de red
- normalización de entrada
- composición de utilidades de red

---

## Enunciado

Construye `DnsInspectorCLI`, una herramienta que permita consultar información de red básica sobre un hostname o dirección IP.

Debe poder mostrar:

- nombre canónico
- IP(s) resueltas
- tipo aproximado de entrada
- si el host parece alcanzable

---

## Requerimientos del programa

1. Debe usar `InetAddress`.
2. Debe aceptar hostnames o IPs.
3. Debe mostrar:

   - host ingresado
   - host canónico
   - lista de direcciones resueltas
   - prueba básica de alcance si es posible

4. Debe manejar entradas inválidas.
5. Debe encapsular el resultado en un objeto `DnsLookupReport`.
6. Debe permitir repetir consultas desde el menú.

---

# Ejercicio 40 — Pool de procesamiento de trabajos

## Qué se practicará

- `ExecutorService`
- `Runnable`
- `Callable`
- cola de trabajos
- reportes de ejecución
- diseño de scheduler simple

---

## Enunciado

Desarrolla `JobProcessorCLI`, una aplicación para recibir trabajos en cola y ejecutarlos mediante un pool de threads configurable.

Cada trabajo tendrá:

- id
- nombre
- duración simulada
- prioridad simple
- estado

---

## Requerimientos del programa

1. Debe modelar un `Job`.
2. Debe usar `ExecutorService`.
3. Debe permitir:

   - agregar trabajo
   - ejecutar lote
   - ver trabajos pendientes
   - ver trabajos finalizados

4. Debe registrar:

   - hora de inicio
   - hora de fin
   - duración real
   - worker que ejecutó el trabajo

5. Debe manejar errores simulados en ciertos trabajos.
6. Debe devolver un reporte agregado del lote.
7. Debe separar scheduler, repositorio y UI.

---

# Ejercicio 41 — Simulador productor-consumidor

## Qué se practicará

- `BlockingQueue`
- `ArrayBlockingQueue` o `LinkedBlockingQueue`
- coordinación entre hilos
- concurrencia clásica
- observación de throughput
- diseño por componentes

---

## Enunciado

Construye `ProducerConsumerCLI`, una simulación donde uno o más productores generan elementos y uno o más consumidores los procesan.

Debe poder configurarse:

- cantidad de productores
- cantidad de consumidores
- tamaño de la cola
- tiempo de producción y consumo

---

## Requerimientos del programa

1. Debe usar `BlockingQueue`.
2. Debe modelar el elemento intercambiado, por ejemplo `WorkItem`.
3. Debe registrar:

   - total producido
   - total consumido
   - elementos pendientes

4. Debe permitir detener la simulación de forma controlada.
5. Debe mostrar métricas de ejecución.
6. Debe separar productores, consumidores y monitor.
7. Debe reutilizar ideas de pool de trabajos del ejercicio anterior.

---

# Ejercicio 42 — Gestor de tareas programadas

## Qué se practicará

- `ScheduledExecutorService`
- temporizadores
- diseño de tareas recurrentes
- timestamps
- control de ejecución periódica

---

## Enunciado

Crea `SchedulerCLI`, una herramienta que permita programar tareas simples de consola para ejecutarse:

- una vez después de cierto tiempo
- repetidamente cada N segundos

Cada tarea puede ser una acción simple como imprimir mensaje, revisar archivo o generar log.

---

## Requerimientos del programa

1. Debe usar `ScheduledExecutorService`.
2. Debe modelar una `ScheduledTask`.
3. Debe permitir:

   - crear tarea one-shot
   - crear tarea repetitiva
   - listar tareas registradas
   - cancelar tarea

4. Debe registrar:

   - próxima ejecución
   - última ejecución
   - estado

5. Debe manejar entradas inválidas de tiempo.
6. Debe separar definición de tarea, scheduler y UI.
7. Debe reutilizar componentes de logging o reportes si ya existen.

---

# Ejercicio 43 — Cliente HTTP asíncrono con `CompletableFuture`

## Qué se practicará

- `CompletableFuture`
- `HttpClient.sendAsync`
- composición de tareas asíncronas
- manejo de errores async
- reportes agregados

---

## Enunciado

Desarrolla `AsyncHttpProbeCLI`, una herramienta que consulte varias URLs de forma asíncrona y consolide resultados.

Debe permitir:

- verificar múltiples endpoints
- mostrar tiempos de respuesta
- contar éxitos y fallos
- opcionalmente guardar resultados

---

## Requerimientos del programa

1. Debe usar `CompletableFuture`.
2. Debe usar cliente HTTP asíncrono.
3. Debe aceptar varias URLs.
4. Debe registrar por URL:

   - código de estado
   - duración
   - excepción si ocurrió

5. Debe producir un `AsyncProbeReport`.
6. Debe esperar correctamente la finalización de todas las tareas.
7. Debe reutilizar componentes del cliente HTTP anterior.
8. Debe mostrar claramente qué tareas se completaron y cuáles fallaron.

---

# Ejercicio 44 — Pipeline de procesamiento de archivos

## Qué se practicará

- `CompletableFuture`
- composición por etapas
- archivos
- parsing
- diseño orientado a pipeline
- reutilización de analizadores previos

---

## Enunciado

Construye `FilePipelineCLI`, una aplicación que procese uno o más archivos en etapas secuenciales.

Por ejemplo:

1. leer archivo
2. validar contenido
3. transformar texto
4. generar estadísticas
5. guardar resultado en otro archivo

Cada etapa debe estar modelada claramente.

---

## Requerimientos del programa

1. Debe modelar etapas de pipeline.
2. Debe permitir configurar al menos tres transformaciones de texto.
3. Debe soportar procesamiento de múltiples archivos.
4. Debe usar `CompletableFuture` o un pipeline equivalente bien separado.
5. Debe generar un reporte por archivo.
6. Debe continuar con otros archivos aunque uno falle.
7. Debe reutilizar módulos de análisis textual ya construidos.

---

# Ejercicio 45 — Sistema de acceso concurrente con locks

## Qué se practicará

- `ReentrantLock`
- exclusión mutua
- diseño thread-safe
- concurrencia aplicada a dominio
- comparación con `synchronized`

---

## Enunciado

Crea `ConcurrentVaultCLI`, una simulación de bóveda o almacén donde múltiples hilos intentan modificar un recurso compartido.

Por ejemplo, puede representar:

- cantidad de stock
- saldo de una cuenta
- número de recursos disponibles

---

## Requerimientos del programa

1. Debe modelar un recurso compartido.
2. Debe proteger operaciones críticas con `ReentrantLock`.
3. Debe permitir operaciones concurrentes de:

   - incremento
   - decremento
   - consulta

4. Debe registrar intentos exitosos y fallidos.
5. Debe evitar inconsistencias del estado.
6. Debe tener una pequeña simulación con varios workers.
7. Debe mostrar el valor final y el historial resumido.
8. Debe separar dominio, sincronización y simulación.

---

# Ejercicio 46 — Sistema de lectura/escritura concurrente

## Qué se practicará

- `ReadWriteLock`
- múltiples lectores / un escritor
- diseño de repositorio thread-safe
- comparación de estrategias de concurrencia

---

## Enunciado

Desarrolla `ConcurrentConfigStoreCLI`, un almacén de configuración en memoria donde múltiples hilos pueden leer configuraciones mientras algunos pocos las actualizan.

---

## Requerimientos del programa

1. Debe usar `ReadWriteLock`.
2. Debe modelar un repositorio clave/valor.
3. Debe permitir:

   - leer valor
   - escribir valor
   - listar configuraciones

4. Debe lanzar una simulación con varios lectores y escritores.
5. Debe medir o mostrar cuántas operaciones de lectura y escritura se realizaron.
6. Debe evitar corrupción de datos.
7. Debe reutilizar la idea de configuración y properties ya trabajada, aunque aquí sea en memoria.

---

# Ejercicio 47 — Procesador de archivos comprimidos ZIP

## Qué se practicará

- `ZipInputStream`
- `ZipOutputStream`
- archivos
- buffers
- reportes de compresión
- reutilización de análisis de directorios

---

## Enunciado

Construye `ZipManagerCLI`, una herramienta capaz de:

- comprimir uno o varios archivos en un ZIP
- listar el contenido de un ZIP
- extraer un ZIP a un directorio destino

---

## Requerimientos del programa

1. Debe usar `java.util.zip`.
2. Debe permitir:

   - crear ZIP
   - listar entradas
   - extraer ZIP

3. Debe registrar:

   - tamaño original
   - tamaño comprimido
   - cantidad de entradas

4. Debe validar archivos inexistentes.
5. Debe proteger contra rutas inválidas al extraer.
6. Debe encapsular resultados en un `ZipOperationReport`.
7. Debe reutilizar utilidades de archivos cuando sea posible.

---

# Ejercicio 48 — Compresor GZIP de logs

## Qué se practicará

- `GZIPInputStream`
- `GZIPOutputStream`
- flujos
- composición de herramientas
- integración con logs y archivos previos

---

## Enunciado

Crea `GzipLogArchiverCLI`, una herramienta especializada en comprimir y descomprimir archivos de logs usando GZIP.

---

## Requerimientos del programa

1. Debe permitir:

   - comprimir log a `.gz`
   - descomprimir `.gz`
   - verificar si el archivo de salida coincide con el original mediante hash opcional

2. Debe mostrar:

   - tamaño original
   - tamaño comprimido
   - ratio de compresión

3. Debe manejar errores de formato o archivos corruptos.
4. Debe reutilizar servicios de hash y manejo de archivos ya construidos.
5. Debe separar compresión, validación y reporte.

---

# Ejercicio 49 — Herramienta de codificación Base64

## Qué se practicará

- `Base64`
- bytes y strings
- archivos binarios
- encoding/decoding
- integración con utilidades anteriores

---

## Enunciado

Desarrolla `Base64ToolkitCLI`, una utilidad para codificar y decodificar contenido en Base64.

Debe soportar:

- texto
- archivos
- comparación entre original y decodificado

---

## Requerimientos del programa

1. Debe usar `java.util.Base64`.
2. Debe permitir:

   - codificar texto
   - decodificar texto
   - codificar archivo
   - decodificar archivo

3. Debe manejar errores si el contenido no es Base64 válido.
4. Debe permitir guardar salida a archivo.
5. Debe reutilizar componentes de archivos y hashing para verificar integridad si aplica.
6. Debe encapsular resultados en un objeto de reporte.

---

# Ejercicio 50 — Explorador de locales y formatos regionales

## Qué se practicará

- `Locale`
- `NumberFormat`
- `DateTimeFormatter`
- internacionalización básica
- diseño de utilidades regionales

---

## Enunciado

Construye `LocaleExplorerCLI`, una herramienta que permita ver cómo cambia la representación de fechas, números, porcentajes y moneda según distintas configuraciones regionales.

---

## Requerimientos del programa

1. Debe permitir elegir un `Locale`.
2. Debe mostrar para ese locale:

   - fecha formateada
   - hora formateada
   - número decimal
   - porcentaje
   - moneda

3. Debe comparar al menos dos locales en una misma salida.
4. Debe usar APIs estándar de formato.
5. Debe validar locale inválido.
6. Debe encapsular el resultado de exploración en una clase propia.

---

# Ejercicio 51 — Sistema multilanguage con `ResourceBundle`

## Qué se practicará

- `ResourceBundle`
- internacionalización
- separación de mensajes
- CLI configurable por idioma
- reutilización del explorador regional

---

## Enunciado

Desarrolla `MultiLangCLI`, una aplicación de consola configurable por idioma.

La aplicación debe cargar sus mensajes desde archivos de recursos y mostrar menús y mensajes en diferentes idiomas según el locale seleccionado.

---

## Requerimientos del programa

1. Debe usar `ResourceBundle`.
2. Debe tener al menos dos idiomas.
3. Debe permitir cambiar idioma desde el menú o configuración.
4. Debe externalizar mensajes de:

   - bienvenida
   - errores comunes
   - opciones del menú

5. Debe manejar ausencia de traducción con fallback razonable.
6. Debe integrar con algún módulo previo pequeño para demostrar uso real.

---

# Ejercicio 52 — Monitor de memoria y threads de la JVM

## Qué se practicará

- `java.lang.management`
- `MemoryMXBean`
- `ThreadMXBean`
- métricas de JVM
- reportes de diagnóstico
- integración con concurrencia

---

## Enunciado

Crea `JvmMonitorCLI`, una herramienta que muestre métricas internas de la JVM durante la ejecución de la aplicación.

Debe poder mostrar:

- memoria heap usada
- memoria no heap
- cantidad de threads
- pico de threads
- uptime del proceso

---

## Requerimientos del programa

1. Debe usar `java.lang.management`.
2. Debe permitir:

   - snapshot puntual
   - monitoreo periódico

3. Debe mostrar resultados en consola de forma legible o tabular.
4. Debe encapsular snapshot en una clase `JvmSnapshot`.
5. Debe reutilizar scheduler o temporizador de ejercicios previos.
6. Debe permitir exportar métricas a archivo de texto o CSV.

---

# Ejercicio 53 — Administrador de procesos del sistema

## Qué se practicará

- `ProcessBuilder`
- procesos externos
- captura de stdout y stderr
- timeouts
- diseño de ejecución controlada

---

## Enunciado

Construye `SystemCommandRunnerCLI`, una herramienta para ejecutar comandos del sistema operativo de forma controlada y capturar sus resultados.

---

## Requerimientos del programa

1. Debe usar `ProcessBuilder`.
2. Debe permitir ingresar un comando y sus argumentos.
3. Debe capturar:

   - código de salida
   - stdout
   - stderr
   - duración del proceso

4. Debe permitir timeout configurable.
5. Debe detectar si el proceso excede el tiempo permitido.
6. Debe encapsular el resultado en `CommandExecutionResult`.
7. Debe evitar mezclar toda la lógica en `main`.
8. Debe mostrar claramente que el comando se ejecuta bajo responsabilidad del usuario.

---

# Ejercicio 54 — Monitor concurrente de comandos del sistema

## Qué se practicará

- `ProcessBuilder`
- concurrencia
- `ExecutorService`
- ejecución de múltiples procesos
- reportes consolidados
- reutilización del runner de comandos

---

## Enunciado

Desarrolla `BatchCommandRunnerCLI`, una herramienta que ejecute múltiples comandos del sistema en paralelo y genere un reporte consolidado.

---

## Requerimientos del programa

1. Debe reutilizar el ejecutor de comandos del ejercicio anterior.
2. Debe permitir cargar una lista de comandos.
3. Debe usar `ExecutorService`.
4. Debe registrar por comando:

   - estado
   - duración
   - salida resumida
   - error

5. Debe limitar la concurrencia máxima.
6. Debe generar un `BatchCommandReport`.
7. Debe cerrar correctamente recursos y procesos.

---

# Ejercicio 55 — Bus de eventos interno para la aplicación

## Qué se practicará

- patrón Observer
- eventos de dominio
- desacoplamiento entre módulos
- POO avanzada
- SOLID más evidente
- integración con módulos anteriores

---

## Enunciado

Crea `EventBusCLI`, una infraestructura simple de eventos internos que permita a distintos módulos publicar y escuchar eventos.

Por ejemplo:

- cuando se crea una tarea
- cuando se importa un contacto
- cuando termina una descarga
- cuando falla un comando

---

## Requerimientos del programa

1. Debe existir una abstracción de `Event`.
2. Debe existir un `EventBus`.
3. Debe permitir registrar listeners por tipo de evento.
4. Debe permitir publicar eventos desde distintos módulos.
5. Debe desacoplar productores y consumidores.
6. Debe integrarse con al menos dos ejercicios previos.
7. Debe mostrar un log de eventos publicados.

---

# Ejercicio 56 — Repositorio genérico en memoria

## Qué se practicará

- generics
- interfaces
- tipado avanzado
- inversión de dependencias
- repositorios reutilizables
- POO más abstracta

---

## Enunciado

Desarrolla `GenericRepositoryCLI`, una pequeña infraestructura de repositorio genérico en memoria que pueda reutilizarse para entidades como tareas, notas, productos o contactos.

---

## Requerimientos del programa

1. Debe existir una interfaz genérica de repositorio.
2. Debe soportar operaciones:

   - save
   - findById
   - findAll
   - deleteById

3. Debe poder trabajar con distintos tipos de entidad.
4. Debe definir una abstracción para entidades con identificador.
5. Debe integrarse con al menos dos modelos ya creados.
6. Debe mostrar cómo reduce duplicación respecto a ejercicios previos.
7. Debe aplicar generics correctamente.

---

# Ejercicio 57 — Motor de validaciones encadenables

## Qué se practicará

- interfaces funcionales
- composición de validaciones
- generics
- regex
- SOLID
- reutilización de validadores previos

---

## Enunciado

Construye `ValidationEngineCLI`, un motor para encadenar reglas de validación reutilizables sobre distintos tipos de entrada.

Debe servir para validar, por ejemplo:

- correos
- contraseñas
- nombres
- argumentos CLI
- configuraciones

---

## Requerimientos del programa

1. Debe existir una abstracción `Validator<T>`.
2. Debe permitir combinar múltiples reglas.
3. Debe devolver un objeto `ValidationResult` con:

   - válido / inválido
   - lista de errores

4. Debe integrar reglas ya construidas de ejercicios anteriores.
5. Debe soportar validaciones específicas por tipo.
6. Debe estar diseñado para extenderse sin romper código existente.

---

# Ejercicio 58 — Motor de búsqueda y filtrado genérico

## Qué se practicará

- `Predicate`
- streams
- generics
- filtros reutilizables
- composición de criterios
- integración con catálogos y listados previos

---

## Enunciado

Desarrolla `QueryEngineCLI`, una utilidad para filtrar colecciones de objetos usando criterios configurables.

Debe poder aplicarse a entidades ya construidas, como:

- tareas
- productos
- contactos
- logs

---

## Requerimientos del programa

1. Debe existir una abstracción de criterio de búsqueda.
2. Debe permitir combinar filtros con lógica AND / OR.
3. Debe soportar ordenamiento configurable.
4. Debe funcionar con generics.
5. Debe integrarse con al menos dos módulos anteriores.
6. Debe devolver resultados listos para renderizar en tabla.
7. Debe separar totalmente la UI de la lógica del query engine.

---

# Ejercicio 59 — Suite de utilidades de red

## Qué se practicará

- integración de DNS, HTTP, TCP y UDP
- diseño modular
- composición de herramientas
- menús jerárquicos
- reutilización real

---

## Enunciado

Construye `NetworkToolkitCLI`, una suite que agrupe varias utilidades de red desarrolladas anteriormente.

Debe incluir al menos:

- inspección DNS
- prueba HTTP
- cliente TCP
- emisor UDP

---

## Requerimientos del programa

1. Debe tener un menú principal de red.
2. Debe reutilizar servicios de los ejercicios:

   - DNS
   - HTTP
   - TCP
   - UDP

3. Debe compartir componentes comunes:

   - validación de host y puerto
   - renderizado de reportes
   - manejo de errores

4. Debe evitar duplicación de lógica.
5. Debe mostrar arquitectura limpia y modular.
6. Debe aplicar POO consistente y separación por capas.

---

# Ejercicio 60 — Plataforma integrada de utilidades del sistema

## Qué se practicará

- integración grande
- arquitectura de consola
- modularización interna
- POO avanzada
- SOLID
- reutilización transversal
- diseño de suite extensible

---

## Enunciado

Construye `SystemUtilitySuiteCLI`, una plataforma integrada que unifique varios módulos desarrollados entre los ejercicios 1 y 60.

Debe incluir, como mínimo, módulos de:

- tareas
- notas
- contactos
- configuración
- archivos
- red
- compresión
- procesos del sistema
- monitoreo JVM

La aplicación debe sentirse como una suite extensible de herramientas de consola reales.

---

## Requerimientos del programa

1. Debe tener menú principal y submenús por dominio.
2. Debe reutilizar servicios y modelos ya construidos.
3. Debe aplicar estructura mínima por paquetes:

   - `model`
   - `service`
   - `repository`
   - `ui`
   - `util`
   - `net`
   - `io`

4. Debe permitir persistencia en varios módulos.
5. Debe tener un mecanismo centralizado de:

   - manejo de errores
   - configuración
   - renderizado de salida

6. Debe integrar el bus de eventos si ya lo implementaste.
7. Debe demostrar claramente reutilización y crecimiento acumulativo.
8. Debe quedar preparado para que los siguientes 60 ejercicios se integren sin rediseñarlo por completo.

---
