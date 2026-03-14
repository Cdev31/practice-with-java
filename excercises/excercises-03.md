# Ejercicio 61 — Inspector de archivos con `FileChannel`

## Qué se practicará

- `FileChannel`
- `ByteBuffer`
- NIO de bajo nivel
- lectura por bloques
- métricas de archivos
- reutilización de utilidades de archivos
- separación entre acceso binario y reporte

---

## Enunciado

Construye `FileChannelInspectorCLI`, una herramienta que lea archivos usando `FileChannel` y genere métricas de contenido binario.

Debe poder mostrar:

- tamaño total
- primeros bytes en hexadecimal
- últimos bytes en hexadecimal
- cantidad de bloques leídos
- tiempo de lectura

---

## Requerimientos del programa

1. Debe usar `FileChannel`.
2. Debe usar `ByteBuffer` para leer por bloques.
3. Debe permitir configurar tamaño del buffer.
4. Debe validar que el archivo exista.
5. Debe mostrar los primeros y últimos bytes con formato legible.
6. Debe encapsular resultados en un `BinaryFileInspectionReport`.
7. Debe separar:

   - lector binario
   - formateador hexadecimal
   - UI

8. Debe reutilizar manejo de rutas y errores construido antes.

---

# Ejercicio 62 — Editor binario mínimo de archivos

## Qué se practicará

- `FileChannel`
- escritura posicional
- `ByteBuffer`
- offsets
- POO de herramientas binarias
- validación de entradas numéricas

---

## Enunciado

Desarrolla `BinaryPatchCLI`, una utilidad que permita inspeccionar y modificar bytes específicos de un archivo en posiciones determinadas.

La herramienta debe permitir:

- leer bytes desde cierto offset
- reemplazar bytes
- guardar cambios
- crear respaldo del archivo antes de modificar

---

## Requerimientos del programa

1. Debe usar `FileChannel` en modo lectura/escritura.
2. Debe permitir ingresar un offset.
3. Debe validar que el offset sea válido dentro del archivo.
4. Debe permitir reemplazar uno o varios bytes.
5. Debe generar backup antes de escribir.
6. Debe mostrar diferencias básicas antes/después.
7. Debe encapsular la operación en un `BinaryPatchReport`.
8. Debe reutilizar lógica de copia de archivos cuando tenga sentido.

---

# Ejercicio 63 — Analizador de codificaciones de texto

## Qué se practicará

- `Charset`
- conversión bytes ↔ texto
- validación de encoding
- `ByteBuffer` / `CharBuffer`
- detección de diferencias por codificación
- reutilización de lectura de archivos

---

## Enunciado

Crea `CharsetInspectorCLI`, una herramienta para leer un archivo de texto usando distintas codificaciones y comparar resultados.

Debe permitir:

- elegir una codificación
- leer archivo como texto
- comparar representación usando diferentes charsets
- exportar salida decodificada

---

## Requerimientos del programa

1. Debe usar `Charset`.
2. Debe permitir al menos:

   - UTF-8
   - ISO-8859-1
   - UTF-16

3. Debe validar charset inválido.
4. Debe mostrar:

   - cantidad de caracteres
   - contenido parcial
   - errores de decodificación si ocurren

5. Debe usar `ByteBuffer` o `CharBuffer` en alguna parte del procesamiento.
6. Debe separar:

   - carga binaria
   - decodificación
   - reporte

7. Debe reutilizar infraestructura de archivos previa.

---

# Ejercicio 64 — Renderizador de texto por buffers

## Qué se practicará

- `CharBuffer`
- manipulación de texto en bajo nivel
- transformaciones por bloques
- modelado de pipelines de texto
- acumulación del trabajo con strings y archivos

---

## Enunciado

Construye `CharBufferTextProcessorCLI`, una herramienta que procese texto a través de buffers de caracteres y aplique transformaciones configurables.

Ejemplos de transformaciones:

- convertir a mayúsculas
- invertir líneas
- reemplazar secuencias
- numerar líneas

---

## Requerimientos del programa

1. Debe usar `CharBuffer`.
2. Debe permitir procesar:

   - entrada por consola
   - archivo de texto

3. Debe modelar cada transformación como componente separado.
4. Debe permitir encadenar múltiples transformaciones.
5. Debe generar un reporte final con:

   - texto original
   - texto transformado
   - cantidad de cambios aplicados

6. Debe reutilizar ideas del pipeline de archivos del ejercicio 44.

---

# Ejercicio 65 — Servidor TCP con `ServerSocketChannel`

## Qué se practicará

- `ServerSocketChannel`
- NIO channels
- comunicación TCP con canales
- arquitectura de servidor
- transición desde IO clásico a NIO

---

## Enunciado

Desarrolla `NioTcpServerCLI`, un servidor TCP basado en canales que acepte conexiones y procese mensajes simples de texto.

Debe ser funcionalmente parecido al servidor TCP previo, pero implementado con NIO channels.

---

## Requerimientos del programa

1. Debe usar `ServerSocketChannel`.
2. Debe aceptar múltiples conexiones.
3. Debe leer y escribir datos usando buffers.
4. Debe registrar:

   - cliente conectado
   - hora
   - mensajes procesados

5. Debe permitir cerrar el servidor limpiamente.
6. Debe encapsular sesiones de cliente en objetos propios.
7. Debe mostrar diferencias arquitectónicas respecto a la versión con `ServerSocket`.
8. Debe reutilizar modelos de mensajes o sesiones si es viable.

---

# Ejercicio 66 — Cliente TCP con `SocketChannel`

## Qué se practicará

- `SocketChannel`
- buffers
- conexión TCP NIO
- reutilización de protocolo de texto
- cliente de bajo nivel

---

## Enunciado

Construye `NioTcpClientCLI`, un cliente TCP basado en `SocketChannel` para conectarse al servidor del ejercicio anterior.

---

## Requerimientos del programa

1. Debe usar `SocketChannel`.
2. Debe conectarse a host y puerto configurables.
3. Debe enviar mensajes usando buffers.
4. Debe leer respuesta del servidor.
5. Debe manejar:

   - conexión fallida
   - desconexión
   - mensajes vacíos

6. Debe registrar historial local con timestamps.
7. Debe reutilizar el protocolo textual definido antes.
8. Debe separar:

   - conexión
   - serialización del mensaje
   - UI

---

# Ejercicio 67 — Multiplexor de sockets con `Selector`

## Qué se practicará

- `Selector`
- non-blocking IO
- múltiples canales
- arquitectura dirigida por eventos
- diseño de loop principal

---

## Enunciado

Crea `NioMultiplexServerCLI`, un servidor que use `Selector` para manejar múltiples conexiones no bloqueantes dentro de un loop central.

---

## Requerimientos del programa

1. Debe usar `Selector`.
2. Debe registrar al menos:

   - accept
   - read
   - write

3. Debe manejar múltiples clientes sin crear un thread por cliente.
4. Debe tener una estructura clara de loop de eventos.
5. Debe registrar eventos de red en objetos de dominio.
6. Debe mostrar clientes activos y total de mensajes.
7. Debe reutilizar protocolo de mensajes ya usado.
8. Debe separar:

   - reactor/event loop
   - manejo de sesión
   - parser/serializer
   - UI/monitor

---

# Ejercicio 68 — Notificador UDP con `DatagramChannel`

## Qué se practicará

- `DatagramChannel`
- UDP en NIO
- buffers
- diferencias entre socket clásico y channel
- utilidades de red más profundas

---

## Enunciado

Desarrolla `NioUdpNotifierCLI`, una versión basada en channels de tu utilidad UDP previa.

---

## Requerimientos del programa

1. Debe usar `DatagramChannel`.
2. Debe permitir modo cliente y servidor.
3. Debe enviar y recibir mensajes de texto.
4. Debe registrar:

   - remitente
   - mensaje
   - timestamp

5. Debe usar `ByteBuffer`.
6. Debe validar host, puerto y tamaño de payload.
7. Debe comparar su comportamiento con la versión clásica si decides agregar ayuda o reporte técnico.

---

# Ejercicio 69 — Analizador de tráfico textual en sockets

## Qué se practicará

- integración de TCP/NIO
- buffers
- parsing incremental
- diseño de monitores de tráfico
- reutilización de renderizado de tablas y logs

---

## Enunciado

Construye `SocketTrafficInspectorCLI`, una herramienta que se enganche a tu propia arquitectura cliente/servidor y registre mensajes entrantes y salientes.

Debe mostrar:

- cantidad de mensajes
- tamaño total transferido
- promedio por mensaje
- cliente más activo
- últimas N transmisiones

---

## Requerimientos del programa

1. Debe integrarse con alguno de los servidores/clientes ya desarrollados.
2. Debe registrar eventos de entrada y salida.
3. Debe almacenar eventos en una estructura propia.
4. Debe mostrar reportes consolidados.
5. Debe ser thread-safe si se usa con múltiples conexiones.
6. Debe reutilizar tabla de consola o sistema de eventos si ya existen.

---

# Ejercicio 70 — Índice concurrente en memoria con `ConcurrentHashMap`

## Qué se practicará

- `ConcurrentHashMap`
- acceso concurrente
- índices por clave
- diseño thread-safe
- integración con módulos previos

---

## Enunciado

Crea `ConcurrentIndexCLI`, un índice en memoria para almacenar y consultar entidades por clave en entornos concurrentes.

Debe poder aplicarse a entidades ya conocidas, como:

- usuarios
- productos
- tareas
- contactos

---

## Requerimientos del programa

1. Debe usar `ConcurrentHashMap`.
2. Debe soportar:

   - inserción
   - consulta
   - actualización
   - eliminación

3. Debe permitir una simulación concurrente con varios threads.
4. Debe garantizar coherencia en accesos concurrentes.
5. Debe aplicar generics.
6. Debe integrar al menos dos tipos de entidad existentes.
7. Debe generar reporte de operaciones concurrentes.

---

# Ejercicio 71 — Registro de auditoría con `CopyOnWriteArrayList`

## Qué se practicará

- `CopyOnWriteArrayList`
- auditoría concurrente
- lecturas frecuentes / escrituras poco frecuentes
- integración con event bus y logging

---

## Enunciado

Desarrolla `AuditTrailCLI`, un sistema de auditoría que registre eventos del sistema y permita múltiples lecturas concurrentes del historial con bajo riesgo de inconsistencias.

---

## Requerimientos del programa

1. Debe usar `CopyOnWriteArrayList`.
2. Debe modelar un `AuditEvent`.
3. Debe integrarse con eventos de módulos previos:

   - tareas
   - contactos
   - archivos
   - red

4. Debe permitir:

   - registrar evento
   - listar historial
   - filtrar por tipo
   - exportar eventos

5. Debe justificar su elección de estructura en el diseño.
6. Debe mostrar seguridad frente a lecturas concurrentes.

---

# Ejercicio 72 — Catálogo ordenado concurrente con `ConcurrentSkipListMap`

## Qué se practicará

- `ConcurrentSkipListMap`
- mapas ordenados concurrentes
- consultas por rango
- diseño orientado a índices ordenados

---

## Enunciado

Construye `OrderedConcurrentCatalogCLI`, un catálogo concurrente donde los elementos puedan consultarse en orden natural o por rango de claves.

Por ejemplo, podría usarse con:

- productos por precio
- logs por timestamp
- tareas por fecha límite

---

## Requerimientos del programa

1. Debe usar `ConcurrentSkipListMap`.
2. Debe soportar:

   - inserción concurrente
   - consulta ordenada
   - consultas por rango

3. Debe integrarse con alguna entidad previa.
4. Debe permitir simulación concurrente.
5. Debe generar reportes de rango.
6. Debe comparar funcionalmente con un `HashMap` cuando tenga sentido.

---

# Ejercicio 73 — Coordinador de arranque con `CountDownLatch`

## Qué se practicará

- `CountDownLatch`
- sincronización entre workers
- coordinación de fases
- diseño de bootstrapping concurrente

---

## Enunciado

Crea `StartupCoordinatorCLI`, una simulación donde varios subsistemas deben inicializarse y el sistema principal no puede continuar hasta que todos estén listos.

Ejemplos de subsistemas:

- configuración
- caché
- red
- logs
- repositorios

---

## Requerimientos del programa

1. Debe usar `CountDownLatch`.
2. Debe modelar cada subsistema como un worker de arranque.
3. Debe registrar:

   - inicio
   - fin
   - duración
   - errores

4. Debe bloquear el sistema principal hasta que todos terminen o fallen.
5. Debe generar un `StartupReport`.
6. Debe integrarse con módulos reales o simulados de ejercicios previos.

---

# Ejercicio 74 — Sincronización por barreras con `CyclicBarrier`

## Qué se practicará

- `CyclicBarrier`
- trabajo por fases
- coordinación de etapas repetitivas
- simulaciones concurrentes

---

## Enunciado

Desarrolla `PhaseWorkerCLI`, una simulación donde varios workers ejecutan tareas por rondas y todos deben llegar a una barrera antes de continuar a la siguiente fase.

---

## Requerimientos del programa

1. Debe usar `CyclicBarrier`.
2. Debe permitir configurar:

   - número de workers
   - número de fases
   - duración simulada por fase

3. Debe registrar:

   - llegada a barrera
   - liberación de barrera
   - tiempos por fase

4. Debe mostrar si algún worker retrasa a los demás.
5. Debe generar un reporte final por fase y por worker.
6. Debe separar lógica de simulación y renderizado de resultados.

---

# Ejercicio 75 — Control de acceso con `Semaphore`

## Qué se practicará

- `Semaphore`
- recursos limitados
- concurrencia aplicada
- modelado de capacidad compartida

---

## Enunciado

Construye `LimitedResourceAccessCLI`, una simulación en la que múltiples clientes intentan acceder a un recurso con capacidad limitada, como:

- impresoras
- conexiones
- slots de procesamiento
- puestos de trabajo

---

## Requerimientos del programa

1. Debe usar `Semaphore`.
2. Debe permitir configurar cantidad de permisos.
3. Debe registrar:

   - intentos de acceso
   - acceso concedido
   - espera
   - liberación

4. Debe mostrar cuántas operaciones fueron bloqueadas temporalmente.
5. Debe generar un reporte de uso del recurso.
6. Debe integrar ideas de la cola de impresión o pool de trabajos.

---

# Ejercicio 76 — Almacén optimista con `StampedLock`

## Qué se practicará

- `StampedLock`
- lecturas optimistas
- diseño de contenedores thread-safe
- comparación con `ReadWriteLock`

---

## Enunciado

Desarrolla `OptimisticStoreCLI`, un almacén de datos en memoria optimizado para muchas lecturas y pocas escrituras.

---

## Requerimientos del programa

1. Debe usar `StampedLock`.
2. Debe permitir:

   - leer valor
   - escribir valor
   - listar contenido

3. Debe incluir lectura optimista cuando sea posible.
4. Debe tener simulación concurrente con lectores y escritores.
5. Debe registrar cuántas lecturas optimistas fueron válidas o debieron repetirse.
6. Debe comparar su enfoque con el ejercicio basado en `ReadWriteLock`.

---

# Ejercicio 77 — Motor de sumas paralelas con `ForkJoinPool`

## Qué se practicará

- `ForkJoinPool`
- división y conquista
- tareas recursivas
- benchmarking simple
- procesamiento paralelo

---

## Enunciado

Crea `ParallelSumCLI`, una herramienta que calcule la suma de grandes colecciones numéricas usando estrategia secuencial y usando `ForkJoinPool`.

---

## Requerimientos del programa

1. Debe usar `ForkJoinPool`.
2. Debe dividir el problema en subtareas recursivas.
3. Debe permitir configurar umbral de partición.
4. Debe comparar:

   - tiempo secuencial
   - tiempo paralelo

5. Debe validar entradas vacías o inválidas.
6. Debe generar un reporte comparativo.
7. Debe reutilizar módulos de métricas numéricas si tiene sentido.

---

# Ejercicio 78 — Indexador paralelo de directorios

## Qué se practicará

- `ForkJoinPool`
- archivos
- recorrido paralelo
- agregación de resultados
- integración con análisis de directorios

---

## Enunciado

Construye `ParallelDirectoryIndexerCLI`, una herramienta que recorra directorios grandes en paralelo y construya un índice con metadatos de archivos.

---

## Requerimientos del programa

1. Debe usar `ForkJoinPool`.
2. Debe indexar:

   - ruta
   - tamaño
   - extensión
   - fecha de modificación

3. Debe procesar subdirectorios en paralelo.
4. Debe generar un índice consultable luego.
5. Debe mostrar métricas de rendimiento.
6. Debe reutilizar componentes del analizador de directorios previo.
7. Debe encapsular resultados en una estructura de índice.

---

# Ejercicio 79 — Explorador de colecciones con `Spliterator`

## Qué se practicará

- `Spliterator`
- recorrido custom de colecciones
- división para procesamiento
- diseño de iteradores avanzados

---

## Enunciado

Desarrolla `SpliteratorExplorerCLI`, una utilidad que permita explorar cómo se dividen y recorren colecciones al usar `Spliterator`.

Debe servir con colecciones como:

- listas de productos
- tareas
- contactos
- líneas de archivo

---

## Requerimientos del programa

1. Debe usar `Spliterator`.
2. Debe mostrar:

   - tamaño estimado
   - características del spliterator
   - divisiones realizadas

3. Debe permitir particionar una colección varias veces.
4. Debe integrarse con al menos una colección real generada en ejercicios previos.
5. Debe generar una representación legible del árbol de división si decides agregar valor.
6. Debe separar análisis de presentación.

---

# Ejercicio 80 — Reportes con `parallelStream`

## Qué se practicará

- `parallelStream`
- streams paralelos
- agregaciones concurrentes
- comparación con streams secuenciales
- reportes estadísticos

---

## Enunciado

Construye `ParallelReportCLI`, una herramienta que genere reportes estadísticos sobre grandes conjuntos de datos usando streams secuenciales y paralelos.

---

## Requerimientos del programa

1. Debe usar `parallelStream`.
2. Debe permitir cargar o generar un conjunto grande de datos.
3. Debe ejecutar:

   - filtros
   - agrupaciones
   - conteos
   - ordenamientos

4. Debe comparar tiempos de ejecución secuencial vs paralelo.
5. Debe advertir cuando el paralelismo no parezca conveniente.
6. Debe reutilizar datos de ejercicios de directorios, logs o catálogos si quieres.

---

# Ejercicio 81 — Cadena de procesamiento con `Optional`

## Qué se practicará

- `Optional`
- modelado de ausencia de datos
- composición segura
- eliminación de `null` arbitrarios
- integración con repositorios y búsqueda

---

## Enunciado

Crea `OptionalFlowCLI`, una herramienta que demuestre búsquedas, conversiones y validaciones encadenadas usando `Optional`.

Por ejemplo:

- buscar entidad por id
- obtener propiedad opcional
- transformar resultado
- generar salida segura si no existe

---

## Requerimientos del programa

1. Debe usar `Optional` en servicios y búsquedas.
2. Debe integrar al menos dos módulos ya creados.
3. Debe mostrar:

   - caso encontrado
   - caso ausente
   - fallback

4. Debe evitar devolver `null` en componentes relevantes.
5. Debe demostrar buenas prácticas de uso de `Optional`, no abuso en campos persistentes si decides mantenerlo limpio.
6. Debe generar ejemplos reales desde datos existentes.

---

# Ejercicio 82 — Formateador numérico avanzado

## Qué se practicará

- `DecimalFormat`
- `NumberFormat`
- formatos personalizados
- separación entre valor y presentación
- integración con módulos financieros y métricos

---

## Enunciado

Desarrolla `NumericFormatterCLI`, una herramienta para formatear números en diferentes estilos:

- decimal
- porcentaje
- moneda
- científico
- patrón personalizado

---

## Requerimientos del programa

1. Debe usar `DecimalFormat`.
2. Debe permitir ingresar patrones personalizados.
3. Debe permitir elegir locale cuando aplique.
4. Debe formatear valores de:

   - métricas numéricas
   - caja registradora
   - catálogos

5. Debe validar patrones inválidos.
6. Debe encapsular cada resultado de formato en un objeto de reporte.

---

# Ejercicio 83 — Motor de mensajes con `MessageFormat`

## Qué se practicará

- `MessageFormat`
- plantillas parametrizadas
- internacionalización
- reutilización del motor de plantillas
- presentación desacoplada

---

## Enunciado

Construye `MessageTemplateCLI`, una utilidad para generar mensajes parametrizados usando `MessageFormat`.

Debe servir para mensajes como:

- confirmaciones
- errores
- reportes
- resúmenes de operaciones

---

## Requerimientos del programa

1. Debe usar `MessageFormat`.
2. Debe permitir:

   - definir plantilla
   - pasar parámetros
   - renderizar resultado

3. Debe integrarse con al menos dos módulos previos para generar mensajes reales.
4. Debe soportar formateo de fechas y números dentro del mensaje.
5. Debe comparar opcionalmente con el motor de placeholders simple ya construido.
6. Debe encapsular plantilla, parámetros y salida en objetos claros.

---

# Ejercicio 84 — Persistencia personalizada con `Externalizable`

## Qué se practicará

- `Externalizable`
- serialización manual
- control del formato persistido
- comparación con `Serializable`
- POO enfocada a persistencia

---

## Enunciado

Crea `ExternalizableNotesCLI`, una versión de persistencia de notas u otra entidad donde el control de escritura y lectura del objeto sea manual.

---

## Requerimientos del programa

1. Debe usar `Externalizable`.
2. Debe implementar manualmente:

   - `writeExternal`
   - `readExternal`

3. Debe persistir al menos una entidad ya existente, por ejemplo `Note` o `Task`.
4. Debe comparar comportamiento básico con la serialización previa.
5. Debe validar lectura de archivos inválidos o corruptos.
6. Debe generar reporte de persistencia y recuperación.
7. Debe documentar qué campos se escriben y por qué.

---

# Ejercicio 85 — Reproductor de eventos desde log persistido

## Qué se practicará

- eventos de dominio
- replay de eventos
- reconstrucción de estado
- integración con auditoría y event bus
- arquitectura más seria

---

## Enunciado

Desarrolla `EventReplayCLI`, una herramienta que cargue eventos previamente guardados y reconstruya el estado de uno o más módulos.

Por ejemplo:

- reconstruir lista de tareas
- reconstruir contactos importados
- reconstruir historial de operaciones

---

## Requerimientos del programa

1. Debe reutilizar el `EventBus` y/o `AuditTrail`.
2. Debe cargar eventos desde archivo.
3. Debe aplicar eventos en orden temporal.
4. Debe reconstruir un estado final consultable.
5. Debe manejar eventos inválidos o desconocidos.
6. Debe generar un reporte del replay:

   - eventos cargados
   - eventos aplicados
   - errores

7. Debe mostrar claramente el before/after si quieres agregar valor.

---

# Ejercicio 86 — Cola de prioridad concurrente de trabajos

## Qué se practicará

- `PriorityBlockingQueue`
- trabajos concurrentes
- priorización
- scheduling simple
- integración con workers y pools previos

---

## Enunciado

Construye `PriorityJobSchedulerCLI`, un scheduler que procese trabajos concurrentemente respetando prioridad.

Cada trabajo debe tener:

- id
- nombre
- prioridad
- duración estimada
- tipo

---

## Requerimientos del programa

1. Debe usar `PriorityBlockingQueue`.
2. Debe integrar un `ExecutorService`.
3. Debe permitir:

   - agregar trabajo
   - ver cola actual
   - ejecutar
   - cancelar pendientes

4. Debe mostrar orden real de procesamiento.
5. Debe registrar si un trabajo de alta prioridad adelantó a otro.
6. Debe generar reporte de ejecución por lote.
7. Debe reutilizar conceptos del procesador de trabajos previo.

---

# Ejercicio 87 — Laboratorio de `ThreadLocalRandom` y `SecureRandom`

## Qué se practicará

- `ThreadLocalRandom`
- `SecureRandom`
- diferencias de propósito
- simulaciones concurrentes
- generación de datos de prueba

---

## Enunciado

Crea `RandomLabCLI`, una herramienta que compare distintos generadores aleatorios según contexto de uso.

Debe permitir generar:

- números de prueba para simulaciones
- contraseñas
- tokens
- datasets aleatorios

---

## Requerimientos del programa

1. Debe usar:

   - `ThreadLocalRandom`
   - `SecureRandom`

2. Debe mostrar casos de uso recomendados para cada uno.
3. Debe integrar con:

   - generador de contraseñas
   - simulaciones concurrentes

4. Debe permitir generar lotes grandes de valores.
5. Debe medir tiempos aproximados de generación.
6. Debe generar reporte comparativo.
7. Debe separar estrategia de random de los módulos consumidores.

---

# Ejercicio 88 — Motor de filtros avanzados sobre logs y catálogos

## Qué se practicará

- `Predicate`
- `Optional`
- streams
- composición de filtros
- integración fuerte de módulos previos
- consultas complejas

---

## Enunciado

Desarrolla `AdvancedFilterCLI`, una extensión del motor de búsqueda que permita filtros más expresivos sobre colecciones complejas.

Debe soportar ejemplos como:

- logs ERROR entre dos fechas
- productos sin stock y precio mayor a cierto valor
- tareas vencidas y prioritarias
- auditorías por tipo y rango temporal

---

## Requerimientos del programa

1. Debe reutilizar el motor de búsqueda previo.
2. Debe permitir combinar filtros con:

   - AND
   - OR
   - NOT

3. Debe soportar filtros temporales y numéricos.
4. Debe usar `Optional` donde haya parámetros opcionales de consulta.
5. Debe generar una representación clara de la consulta aplicada.
6. Debe integrarse con al menos tres módulos previos.

---

# Ejercicio 89 — Buscador concurrente en árbol de directorios

## Qué se practicará

- concurrencia en archivos
- `ForkJoinPool` o executor
- búsqueda de texto
- integración con análisis de archivos
- rendimiento y división del trabajo

---

## Enunciado

Construye `ConcurrentFileSearchCLI`, una herramienta que busque texto dentro de muchos archivos de un árbol de directorios en paralelo.

Debe mostrar:

- archivos inspeccionados
- coincidencias encontradas
- líneas coincidentes
- tiempo total
- distribución del trabajo

---

## Requerimientos del programa

1. Debe recorrer directorios recursivamente.
2. Debe procesar archivos en paralelo.
3. Debe permitir buscar:

   - palabra exacta
   - patrón regex

4. Debe soportar filtrado por extensión.
5. Debe generar un `ConcurrentSearchReport`.
6. Debe manejar archivos no legibles sin abortar todo.
7. Debe reutilizar analizadores de texto y archivos anteriores.

---

# Ejercicio 90 — Plataforma intermedia de servicios concurrentes y NIO

## Qué se practicará

- integración grande del bloque 61–90
- modularización seria
- NIO + concurrencia + utilidades de sistema
- arquitectura extensible
- preparación para reflection, annotations, memoria y módulos

---

## Enunciado

Construye `AdvancedSystemPlatformCLI`, una plataforma integrada que reúna y consolide módulos avanzados desarrollados hasta este punto.

Debe incluir, como mínimo, capacidades de:

- inspección binaria de archivos
- edición binaria básica
- exploración de codificaciones
- networking NIO
- monitoreo concurrente
- schedulers y workers
- filtros avanzados
- auditoría
- replay de eventos

---

## Requerimientos del programa

1. Debe tener un menú principal modular.
2. Debe integrar correctamente servicios de:

   - archivos/NIO
   - red/NIO
   - concurrencia
   - eventos/auditoría
   - filtros/reportes

3. Debe compartir infraestructura común:

   - manejo de errores
   - configuración
   - renderizado
   - eventos
   - repositorios

4. Debe aplicar POO de forma consistente.
5. Debe aplicar SOLID mejor que en las suites anteriores.
6. Debe evitar duplicación innecesaria.
7. Debe quedar preparado para que los últimos 30 ejercicios se integren sin romper la arquitectura.

---
