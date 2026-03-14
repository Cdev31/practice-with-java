# Ejercicio 91 — Inspector de clases con Reflection

## Qué se practicará

- `Class`
- `Field`
- `Method`
- `Constructor`
- reflection
- introspección de clases
- reutilización de modelos construidos antes

---

## Enunciado

Construye `ReflectionInspectorCLI`, una herramienta que reciba el nombre de una clase y muestre su estructura usando reflection.

Debe poder inspeccionar clases propias del proyecto y también clases estándar de Java.

---

## Requerimientos del programa

1. Debe usar reflection para inspeccionar clases.
2. Debe mostrar:

   - nombre completo
   - package
   - modificadores
   - constructores
   - campos
   - métodos
   - interfaces implementadas
   - superclase

3. Debe permitir inspeccionar al menos clases de módulos previos como `Task`, `Note`, `Product` o `ExecutionLog`.
4. Debe manejar clase inexistente con mensaje claro.
5. Debe encapsular el resultado en `ClassInspectionReport`.
6. Debe separar:

   - carga de clase
   - extracción de metadatos
   - renderizado del reporte

---

# Ejercicio 92 — Invocador dinámico de métodos

## Qué se practicará

- reflection
- invocación dinámica
- resolución de métodos
- parsing de argumentos
- separación entre metadata e invocación

---

## Enunciado

Desarrolla `DynamicMethodInvokerCLI`, una herramienta que permita elegir una clase, crear una instancia e invocar métodos simples de manera dinámica.

---

## Requerimientos del programa

1. Debe usar reflection para:

   - crear instancia
   - ubicar método
   - invocarlo

2. Debe soportar métodos públicos simples con parámetros básicos como:

   - `String`
   - `int`
   - `boolean`

3. Debe validar:

   - método inexistente
   - cantidad incorrecta de argumentos
   - tipos incompatibles

4. Debe mostrar:

   - método invocado
   - argumentos convertidos
   - resultado devuelto

5. Debe integrarse con al menos una clase propia del proyecto.
6. Debe encapsular la operación en `InvocationReport`.

---

# Ejercicio 93 — Constructor automático de objetos por metadatos

## Qué se practicará

- reflection
- constructores dinámicos
- parsing de propiedades
- mapeo simple de datos a objetos
- abstracción reusable

---

## Enunciado

Crea `ObjectFactoryCLI`, una herramienta que lea pares clave/valor y construya objetos de ciertas clases del proyecto usando reflection.

Por ejemplo, poder crear dinámicamente un `Contact`, `Product` o `Task` a partir de datos textuales.

---

## Requerimientos del programa

1. Debe permitir seleccionar una clase soportada.
2. Debe inspeccionar sus constructores o setters disponibles.
3. Debe convertir strings a tipos básicos necesarios.
4. Debe validar campos faltantes o inválidos.
5. Debe construir el objeto y mostrarlo en consola.
6. Debe diseñarse como una fábrica reusable.
7. Debe generar un `ObjectCreationReport`.

---

# Ejercicio 94 — Motor de mapeo simple estilo mini-ORM en memoria

## Qué se practicará

- reflection
- anotaciones simples o metadatos manuales
- repositorios
- generics
- diseño reusable

---

## Enunciado

Construye `MiniMapperCLI`, un pequeño motor que convierta objetos en representaciones tabulares simples y viceversa.

No es una base de datos real; la idea es construir la infraestructura mínima para mapear entidades a filas en memoria o CSV usando metadatos.

---

## Requerimientos del programa

1. Debe permitir registrar clases mapeables.
2. Debe extraer campos de una entidad mediante reflection.
3. Debe convertir una entidad a `Map<String, String>` o representación tabular equivalente.
4. Debe reconstruir una entidad desde esa representación.
5. Debe integrarse con al menos dos entidades previas.
6. Debe manejar campos no soportados con mensajes claros.
7. Debe separar:

   - metadata
   - mapper
   - repositorio
   - UI

---

# Ejercicio 95 — Framework simple de validación con anotaciones personalizadas

## Qué se practicará

- anotaciones personalizadas
- reflection
- validación declarativa
- integración con el motor de validaciones previo
- diseño tipo framework

---

## Enunciado

Desarrolla `AnnotationValidationCLI`, una extensión del motor de validaciones que permita anotar campos de clases con reglas declarativas como:

- requerido
- longitud mínima
- patrón regex
- rango numérico

---

## Requerimientos del programa

1. Debe crear al menos 3 anotaciones personalizadas, por ejemplo:

   - `@Required`
   - `@MinLength`
   - `@Regex`

2. Debe inspeccionar entidades mediante reflection.
3. Debe validar campos anotados y devolver `ValidationResult`.
4. Debe integrarse con entidades ya construidas como `User`, `Contact` o `Product`.
5. Debe permitir listar errores por campo.
6. Debe reutilizar parte del motor de validaciones del ejercicio 57.
7. Debe diseñarse para extenderse con nuevas reglas.

---

# Ejercicio 96 — Ejecutor de acciones basado en anotaciones

## Qué se practicará

- anotaciones personalizadas
- reflection
- descubrimiento de métodos
- ejecución dinámica
- arquitectura de comandos

---

## Enunciado

Crea `AnnotatedActionRunnerCLI`, una herramienta que detecte métodos anotados como comandos ejecutables dentro de ciertas clases y los permita invocar desde un menú dinámico.

---

## Requerimientos del programa

1. Debe existir una anotación tipo `@CliAction`.
2. Debe escanear clases registradas y encontrar métodos anotados.
3. Debe construir un menú automático con esas acciones.
4. Debe permitir ejecutar las acciones detectadas.
5. Debe soportar metadatos mínimos como:

   - nombre visible
   - descripción

6. Debe integrarse con algún módulo previo.
7. Debe separar descubrimiento, registro y ejecución de acciones.

---

# Ejercicio 97 — Explorador de `MethodHandle`

## Qué se practicará

- `MethodHandle`
- `MethodHandles`
- invocación eficiente
- comparación con reflection
- metaprogramación avanzada

---

## Enunciado

Construye `MethodHandleLabCLI`, una utilidad para obtener e invocar métodos y constructores usando `MethodHandle` en lugar de reflection clásica.

---

## Requerimientos del programa

1. Debe usar `MethodHandles.Lookup`.
2. Debe obtener `MethodHandle` para:

   - método de instancia
   - método estático
   - constructor

3. Debe invocar handles sobre clases del proyecto o clases estándar.
4. Debe comparar conceptualmente el flujo con reflection.
5. Debe medir tiempo básico de varias invocaciones si deseas agregar valor.
6. Debe encapsular resultados en `MethodHandleReport`.
7. Debe manejar errores de acceso o firma incompatible.

---

# Ejercicio 98 — Acceso concurrente con `VarHandle`

## Qué se practicará

- `VarHandle`
- acceso controlado a campos
- operaciones atómicas básicas
- low-level concurrency
- comparación con synchronized/locks

---

## Enunciado

Desarrolla `VarHandleCounterCLI`, una herramienta que use `VarHandle` para manipular de forma concurrente uno o más campos compartidos.

---

## Requerimientos del programa

1. Debe usar `VarHandle`.
2. Debe modelar un contador o estructura simple con campos mutables.
3. Debe soportar operaciones como:

   - lectura
   - escritura
   - incremento atómico

4. Debe lanzar múltiples workers concurrentes.
5. Debe comparar resultado con una implementación ingenua no sincronizada o con lock.
6. Debe mostrar reporte de consistencia y rendimiento básico.
7. Debe separar modelo, acceso y simulación.

---

# Ejercicio 99 — Cargador aislado de clases con `ClassLoader`

## Qué se practicará

- `ClassLoader`
- carga dinámica de clases
- namespaces de clases
- arquitectura modular básica
- introspección avanzada

---

## Enunciado

Crea `CustomClassLoaderCLI`, una herramienta que cargue clases desde una ruta determinada usando un cargador personalizado.

La idea es simular un sistema extensible o de plugins muy básico.

---

## Requerimientos del programa

1. Debe implementar un `ClassLoader` personalizado o derivado.
2. Debe cargar una clase desde un directorio o ruta configurada.
3. Debe mostrar:

   - nombre de la clase
   - cargador utilizado
   - métodos disponibles

4. Debe permitir instanciar la clase si es compatible.
5. Debe manejar clase no encontrada o bytecode inválido.
6. Debe generar un `ClassLoadingReport`.
7. Debe documentar la diferencia entre class loader del sistema y el custom.

---

# Ejercicio 100 — Sistema de plugins mínimo

## Qué se practicará

- `ClassLoader`
- interfaces
- desacoplamiento
- arquitectura extensible
- integración de plugins

---

## Enunciado

Construye `PluginHostCLI`, una aplicación que cargue módulos externos simples como plugins.

Cada plugin debe implementar una interfaz común, por ejemplo para hacer una transformación de texto, un análisis o una utilidad de reporte.

---

## Requerimientos del programa

1. Debe definir una interfaz de plugin.
2. Debe descubrir o cargar plugins desde una carpeta.
3. Debe usar el class loader del ejercicio anterior.
4. Debe permitir:

   - listar plugins
   - ejecutar plugin
   - mostrar resultado

5. Debe manejar plugins inválidos o incompatibles.
6. Debe permitir integrar plugins con datos del sistema ya construido.
7. Debe separar host, registry y loader.

---

# Ejercicio 101 — Laboratorio de referencias débiles con `WeakReference`

## Qué se practicará

- `WeakReference`
- GC
- referencias no fuertes
- caches simples
- observación de recolección

---

## Enunciado

Desarrolla `WeakCacheCLI`, una caché experimental donde los valores se almacenen con `WeakReference` para observar cómo pueden desaparecer cuando el recolector de basura los libera.

---

## Requerimientos del programa

1. Debe usar `WeakReference`.
2. Debe permitir:

   - guardar objetos
   - consultar objetos
   - listar entradas activas o liberadas

3. Debe mostrar el comportamiento antes y después de intentar forzar GC.
4. Debe integrarse conceptualmente con el ejercicio de caché en memoria.
5. Debe explicar con resultados qué pasó con las referencias.
6. Debe encapsular métricas en `WeakCacheReport`.

---

# Ejercicio 102 — Caché experimental con `SoftReference`

## Qué se practicará

- `SoftReference`
- memoria y caching
- diferencias con weak references
- observación de presión de memoria

---

## Enunciado

Crea `SoftCacheCLI`, una caché experimental enfocada a reutilizar objetos mientras haya memoria suficiente.

---

## Requerimientos del programa

1. Debe usar `SoftReference`.
2. Debe permitir:

   - almacenar objetos pesados simulados
   - consultar si siguen disponibles
   - mostrar cuántos sobreviven tras presión de memoria

3. Debe comparar conceptualmente con el ejercicio de `WeakReference`.
4. Debe integrar un pequeño reporte de memoria usando utilidades JVM ya creadas.
5. Debe registrar resultados antes/después de operaciones intensivas.
6. Debe encapsular resultados en `SoftCacheReport`.

---

# Ejercicio 103 — Rastreador de liberación con `PhantomReference`

## Qué se practicará

- `PhantomReference`
- `ReferenceQueue`
- lifecycle avanzado de objetos
- observación de limpieza
- memoria avanzada

---

## Enunciado

Construye `PhantomTrackerCLI`, una herramienta experimental que rastree objetos mediante `PhantomReference` y registre cuándo se encolan en una `ReferenceQueue`.

---

## Requerimientos del programa

1. Debe usar `PhantomReference`.
2. Debe usar `ReferenceQueue`.
3. Debe crear objetos monitoreados y registrar referencias fantasma asociadas.
4. Debe mostrar cuándo una referencia entra en la cola.
5. Debe explicar, mediante reporte, por qué una `PhantomReference` no devuelve el objeto real.
6. Debe integrarse con utilidades de monitoreo de memoria.
7. Debe separar creación de objetos, observación de cola y renderizado.

---

# Ejercicio 104 — Administrador de logs formal con `java.util.logging`

## Qué se practicará

- `java.util.logging`
- handlers
- formatters
- niveles de log
- logging estructurado
- reemplazo de logging manual previo

---

## Enunciado

Desarrolla `JulLogManagerCLI`, una herramienta y configuración base para manejar logging formal dentro de tu ecosistema de mini-proyectos usando `java.util.logging`.

---

## Requerimientos del programa

1. Debe usar `java.util.logging`.
2. Debe configurar:

   - niveles
   - handler a consola
   - handler a archivo

3. Debe permitir cambiar nivel en runtime.
4. Debe integrarse con al menos dos módulos previos para reemplazar logs manuales.
5. Debe mostrar cómo se formatean entradas de log.
6. Debe soportar logs INFO, WARNING y SEVERE como mínimo.
7. Debe separar configuración de logging de módulos consumidores.

---

# Ejercicio 105 — Firma digital de documentos

## Qué se practicará

- `Signature`
- `KeyPairGenerator`
- criptografía asimétrica
- integridad y autenticidad
- archivos y hashing

---

## Enunciado

Crea `DigitalSignatureCLI`, una herramienta que permita firmar un archivo o texto con una clave privada y luego verificar la firma con la clave pública.

---

## Requerimientos del programa

1. Debe usar `KeyPairGenerator` para RSA.
2. Debe usar `Signature`.
3. Debe permitir:

   - generar par de claves
   - firmar texto
   - firmar archivo
   - verificar firma

4. Debe guardar o cargar claves desde archivos si decides extenderlo.
5. Debe mostrar claramente:

   - algoritmo usado
   - tamaño de firma
   - resultado de verificación

6. Debe reutilizar utilidades de archivos y hashes cuando aplique.
7. Debe encapsular resultados en `SignatureReport`.

---

# Ejercicio 106 — Cofre de archivos con cifrado AES

## Qué se practicará

- `Cipher`
- AES
- cifrado simétrico
- archivos binarios
- Base64 opcional para texto
- seguridad aplicada

---

## Enunciado

Construye `AesVaultCLI`, una utilidad para cifrar y descifrar contenido usando AES.

Debe soportar:

- texto
- archivos

---

## Requerimientos del programa

1. Debe usar `Cipher` con AES.
2. Debe permitir:

   - cifrar texto
   - descifrar texto
   - cifrar archivo
   - descifrar archivo

3. Debe validar claves o passwords de entrada según el esquema que elijas.
4. Debe mostrar tamaño del contenido antes y después.
5. Debe integrarse opcionalmente con Base64 para salida textual.
6. Debe manejar errores por clave incorrecta o datos corruptos.
7. Debe encapsular resultados en `EncryptionReport`.

---

# Ejercicio 107 — Intercambio híbrido de claves y archivo seguro

## Qué se practicará

- RSA + AES
- cifrado híbrido
- diseño de flujo criptográfico
- integración de varios módulos de seguridad

---

## Enunciado

Desarrolla `HybridSecureTransferCLI`, una simulación de transferencia segura donde:

- se genera una clave AES para el archivo
- esa clave AES se protege con RSA
- el contenido se cifra con AES
- luego puede recuperarse correctamente

---

## Requerimientos del programa

1. Debe reutilizar componentes de AES y firma/clave RSA previos.
2. Debe mostrar el flujo completo del proceso.
3. Debe permitir:

   - cifrar archivo
   - encapsular clave AES cifrada
   - recuperar archivo original

4. Debe validar cada etapa y reportar errores claros.
5. Debe generar un `HybridTransferReport`.
6. Debe separar:

   - key management
   - file encryption
   - packaging
   - recovery

---

# Ejercicio 108 — Validador de integridad de respaldos

## Qué se practicará

- hashing
- firmas opcionales
- compresión
- archivos
- integración de seguridad y IO

---

## Enunciado

Construye `BackupIntegrityCLI`, una herramienta que valide respaldos generados por tu ecosistema usando hash, y opcionalmente firma, para comprobar integridad y autenticidad.

---

## Requerimientos del programa

1. Debe poder trabajar sobre:

   - archivos normales
   - ZIP
   - GZIP

2. Debe calcular y comparar hashes.
3. Debe opcionalmente verificar una firma si existe.
4. Debe generar un reporte completo:

   - tamaño
   - hash esperado
   - hash actual
   - firma válida o no

5. Debe reutilizar herramientas previas de hash, ZIP, GZIP y firma.
6. Debe manejar archivos faltantes o corruptos.
7. Debe encapsular resultados en `BackupIntegrityReport`.

---

# Ejercicio 109 — Explorador del modelo de memoria de Java

## Qué se practicará

- Java Memory Model
- visibilidad
- `volatile`
- race conditions
- observación práctica de concurrencia

---

## Enunciado

Crea `MemoryModelLabCLI`, una suite de pequeñas simulaciones para observar fenómenos del modelo de memoria de Java, como:

- visibilidad entre hilos
- actualizaciones perdidas
- efectos de `volatile`
- diferencias entre lectura sin sincronización y con sincronización

---

## Requerimientos del programa

1. Debe incluir al menos tres experimentos reproducibles.
2. Debe usar:

   - variable normal
   - `volatile`
   - locks o sincronización en comparación

3. Debe registrar resultados de varias corridas.
4. Debe mostrar cuándo aparecen inconsistencias.
5. Debe generar un reporte comparativo por experimento.
6. Debe separar simulación, captura de resultados y presentación.

---

# Ejercicio 110 — Laboratorio de benchmarking de concurrencia

## Qué se practicará

- medición comparativa
- executors
- locks
- varhandle
- estructuras concurrentes
- análisis cuantitativo

---

## Enunciado

Desarrolla `ConcurrencyBenchmarkCLI`, una herramienta para comparar varias estrategias de concurrencia y acceso compartido usadas en ejercicios anteriores.

Ejemplos:

- lock
- `ReadWriteLock`
- `StampedLock`
- `ConcurrentHashMap`
- `VarHandle`

---

## Requerimientos del programa

1. Debe permitir ejecutar benchmarks simples y repetibles.
2. Debe comparar al menos cuatro estrategias.
3. Debe registrar:

   - tiempo total
   - throughput aproximado
   - consistencia del resultado

4. Debe permitir variar número de workers.
5. Debe reutilizar módulos de concurrencia ya construidos.
6. Debe generar un `BenchmarkReport`.
7. Debe aclarar que es benchmarking simple, no científico estricto.

---

# Ejercicio 111 — Descriptor de módulos con `module-info.java`

## Qué se practicará

- Java Module System
- `module-info.java`
- exports
- requires
- organización modular
- arquitectura del proyecto

---

## Enunciado

Construye `ModuleDescriptorLab`, una reorganización parcial de algunos módulos de tu proyecto para practicar el sistema de módulos de Java.

---

## Requerimientos del programa

1. Debe dividir al menos parte del proyecto en módulos reales.
2. Debe crear archivos `module-info.java`.
3. Debe definir:

   - `requires`
   - `exports`

4. Debe separar al menos:

   - módulo core
   - módulo io
   - módulo net
   - módulo app o cli

5. Debe documentar dependencias entre módulos.
6. Debe compilarse sin frameworks.

---

# Ejercicio 112 — Suite modular de utilidades

## Qué se practicará

- módulos Java
- arquitectura por módulos
- separación de responsabilidades
- integración de paquetes anteriores

---

## Enunciado

Desarrolla `ModularUtilitySuite`, una versión modularizada de parte de tu ecosistema de herramientas, usando el sistema de módulos de Java.

---

## Requerimientos del programa

1. Debe reutilizar el trabajo de módulos del ejercicio anterior.
2. Debe distribuir varios componentes en módulos.
3. Debe mantener una interfaz CLI común.
4. Debe demostrar encapsulación real de paquetes.
5. Debe integrar al menos:

   - archivos
   - red
   - seguridad
   - concurrencia

6. Debe documentar claramente la arquitectura modular.

---

# Ejercicio 113 — Cargador de comandos desacoplado por metadatos

## Qué se practicará

- annotations
- reflection
- plugins
- arquitectura extensible
- registro automático de comandos

---

## Enunciado

Construye `CommandRegistryCLI`, una infraestructura que descubra comandos disponibles mediante anotaciones o metadatos y los registre automáticamente dentro de la suite.

---

## Requerimientos del programa

1. Debe permitir registrar comandos sin editar manualmente un gran `switch`.
2. Debe descubrir acciones mediante anotaciones o metadata.
3. Debe integrarse con el sistema de plugins o acciones anteriores.
4. Debe construir un menú dinámico.
5. Debe soportar ayuda por comando.
6. Debe separar descubrimiento, registro y dispatch.
7. Debe demostrar reducción de acoplamiento.

---

# Ejercicio 114 — Mini contenedor de dependencias manual

## Qué se practicará

- inversión de dependencias
- reflexión opcional
- wiring manual/automático
- SOLID avanzado
- arquitectura de aplicaciones

---

## Enunciado

Crea `MiniContainerCLI`, un contenedor mínimo que gestione instancias de servicios y sus dependencias dentro de tu ecosistema.

No es un framework; la idea es entender cómo se conectan servicios, repositorios y utilidades.

---

## Requerimientos del programa

1. Debe permitir registrar componentes.
2. Debe resolver dependencias básicas entre servicios.
3. Debe poder construir ciertos servicios automáticamente si decides usar reflection.
4. Debe integrarse con módulos previos de:

   - validación
   - repositorios
   - configuración
   - logging

5. Debe detectar dependencias no registradas.
6. Debe separar definición de bindings y resolución.
7. Debe mostrar un reporte del grafo simple de dependencias.

---

# Ejercicio 115 — Recolector de métricas arquitectónicas

## Qué se practicará

- reflection
- análisis de clases
- diseño de tooling interno
- métricas de código
- integración con módulos y logging

---

## Enunciado

Desarrolla `CodeMetricsCLI`, una herramienta que analice clases de tu propio proyecto y genere métricas simples como:

- número de métodos
- número de campos
- profundidad de herencia
- interfaces implementadas
- clases anotadas
- distribución por paquete

---

## Requerimientos del programa

1. Debe inspeccionar un conjunto de clases registradas.
2. Debe usar reflection.
3. Debe generar métricas por clase y consolidadas.
4. Debe detectar clases que incumplen reglas simples, por ejemplo demasiados métodos o demasiados campos.
5. Debe exportar resultados a texto o CSV.
6. Debe integrarse con logging formal si ya lo implementaste.
7. Debe encapsular resultados en `CodeMetricsReport`.

---

# Ejercicio 116 — Reconstructor de suite desde configuración y plugins

## Qué se practicará

- configuración
- classloading
- registry dinámico
- arquitectura extensible
- integración transversal

---

## Enunciado

Construye `DynamicSuiteBootstrapCLI`, una versión de arranque dinámico de tu suite donde los módulos habilitados se definan por configuración y ciertos componentes puedan venir de plugins.

---

## Requerimientos del programa

1. Debe leer configuración de módulos habilitados.
2. Debe cargar componentes necesarios según esa configuración.
3. Debe integrar:

   - configuración
   - class loader
   - command registry
   - contenedor de dependencias

4. Debe manejar módulo o plugin faltante con mensaje claro.
5. Debe generar un reporte de arranque dinámico.
6. Debe demostrar una arquitectura más desacoplada que las suites previas.

---

# Ejercicio 117 — Plataforma segura de respaldos automáticos

## Qué se practicará

- integración de archivos
- compresión
- hash
- firma
- cifrado
- scheduler
- arquitectura de servicios

---

## Enunciado

Desarrolla `SecureBackupPlatformCLI`, una plataforma que permita programar respaldos automáticos de archivos o directorios con validación de integridad y protección de seguridad.

---

## Requerimientos del programa

1. Debe permitir:

   - seleccionar archivos/directorios
   - comprimir
   - hashear
   - cifrar o firmar
   - guardar backup

2. Debe usar scheduler para respaldos programados.
3. Debe generar manifiesto del backup con metadatos.
4. Debe permitir verificar un backup luego.
5. Debe reutilizar:

   - ZIP/GZIP
   - hashing
   - firma
   - AES
   - configuración

6. Debe encapsular el proceso completo en reportes claros.
7. Debe aplicar una arquitectura limpia por servicios.

---

# Ejercicio 118 — Consola administrativa extensible final

## Qué se practicará

- integración casi total
- command registry
- plugins
- módulos
- event bus
- logging
- configuración
- DI simple

---

## Enunciado

Construye `AdminConsolePlatformCLI`, una consola administrativa final que reúna gran parte de las utilidades desarrolladas y permita operarlas desde un solo punto, con registro automático de comandos y arquitectura extensible.

---

## Requerimientos del programa

1. Debe integrar:

   - registry dinámico de comandos
   - contenedor de dependencias
   - logging formal
   - configuración
   - módulos habilitables
   - event bus

2. Debe permitir ejecutar utilidades de:

   - archivos
   - red
   - seguridad
   - concurrencia
   - monitoreo JVM

3. Debe soportar ayuda dinámica.
4. Debe evitar un `main` monolítico.
5. Debe reutilizar al máximo la infraestructura anterior.
6. Debe ser extensible sin reescribir el núcleo.

---

# Ejercicio 119 — Sistema de diagnóstico integral de la plataforma

## Qué se practicará

- introspección
- métricas
- logging
- memory refs
- JVM monitoring
- verificación arquitectónica
- tooling interno final

---

## Enunciado

Crea `PlatformDiagnosticsCLI`, una herramienta de diagnóstico para inspeccionar el estado y salud de tu propia plataforma final.

Debe poder revisar:

- módulos cargados
- plugins disponibles
- memoria JVM
- threads activos
- configuraciones cargadas
- integridad de componentes críticos
- estado de caches y colas

---

## Requerimientos del programa

1. Debe integrarse con:

   - monitoreo JVM
   - logging
   - configuración
   - class loading
   - caches
   - auditoría

2. Debe generar un diagnóstico consolidado.
3. Debe detectar problemas básicos, por ejemplo:

   - módulo no cargado
   - configuración faltante
   - plugin inválido
   - cache inconsistente

4. Debe exportar el reporte si se desea.
5. Debe reutilizar infraestructura de reportes y tablas.
6. Debe encapsular resultado en `PlatformDiagnosticReport`.

---

# Ejercicio 120 — Suite total de utilidades Java Core

## Qué se practicará

- integración absoluta del roadmap
- arquitectura completa
- módulos
- seguridad
- concurrencia
- reflection
- NIO
- red
- JVM
- diseño orientado a objetos serio
- SOLID aplicado transversalmente

---

## Enunciado

Construye `JavaCoreWorkbenchCLI`, la suite final que consolide todo el trabajo de los 120 mini-proyectos en una plataforma coherente, extensible y mantenible.

La aplicación debe sentirse como un banco de utilidades de consola serio, construido completamente con Java Core, sin frameworks.

Debe reunir herramientas de:

- archivos y NIO
- texto y regex
- fechas y tiempo
- configuración
- contactos, tareas, notas y catálogos
- red clásica y NIO
- HTTP
- concurrencia y sincronización
- compresión y codificación
- seguridad y criptografía
- reflection y metaprogramación
- plugins y módulos
- monitoreo JVM
- logging
- diagnóstico y reportes

---

## Requerimientos del programa

1. Debe tener arquitectura clara por capas y por módulos.
2. Debe integrar una infraestructura común para:

   - configuración
   - logging
   - eventos
   - validación
   - repositorios
   - renderizado
   - manejo de errores
   - registro de comandos
   - contenedor de dependencias

3. Debe soportar habilitar o deshabilitar módulos por configuración.
4. Debe permitir integrar plugins externos bajo un contrato definido.
5. Debe aplicar POO y SOLID de forma consistente.
6. Debe evitar duplicación significativa.
7. Debe incluir persistencia para varios módulos.
8. Debe incluir al menos una capa formal de auditoría y diagnóstico.
9. Debe ser ejecutable sin frameworks, sin Maven y sin Gradle si así decides mantener la restricción.
10. Debe demostrar que el ecosistema completo puede crecer sin rediseño radical.

---
