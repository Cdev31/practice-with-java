# Ejercicios de Programación en Java

## Ejercicio 1 — Registro de ejecuciones del sistema en Java

### Qué se practicará

- Estructura básica de un programa Java
- POO básica
- Clases y objetos
- `java.time`
- Propiedades del sistema
- Salida por consola
- Separación entre modelo y lógica

### Enunciado

Desarrolla un programa llamado `ExecutionLoggerApp` que, al iniciar, obtenga información básica de la ejecución actual del sistema y la almacene en un objeto de dominio.

El programa debe capturar:

- fecha y hora actual
- nombre del usuario del sistema operativo
- nombre del sistema operativo
- versión de Java en uso

Esa información debe almacenarse en un objeto `ExecutionLog` y luego imprimirse en consola de forma legible.

### Requerimientos del programa

1. Debe existir una clase `ExecutionLog` con los datos de la ejecución.
2. Debe existir una clase de servicio encargada de construir ese log.
3. Debe obtener:

   - `user.name`
   - `os.name`
   - `java.version`
   - fecha y hora actual

4. Debe imprimirse un resumen en consola.
5. No se permite meter toda la lógica en `main`.
6. Debe manejar de forma segura posibles errores al leer propiedades.
7. La salida debe tener formato claro y consistente.

---

## Ejercicio 2 — Monitor de tiempo y zona horaria (CLI)

### Qué se practicará

- `Instant`
- `ZoneId`
- `ZonedDateTime`
- `DateTimeFormatter`
- Menús por consola
- Validación de entrada
- Excepciones
- POO básica
- Reutilización de servicios

### Enunciado

Crea un programa llamado `TimeZoneMonitor` que funcione como monitor de tiempo en consola.

El programa debe detectar información del sistema y luego ofrecer un menú interactivo para:

- ver la hora del sistema
- convertir la hora actual a otra zona
- comparar la hora del sistema con otra zona
- calcular cuántos minutos faltan para un evento futuro definido en otra zona horaria

El sistema debe trabajar correctamente usando el **mismo instante real**, cambiando solo la representación zonal cuando aplique.

### Requerimientos del programa

1. Debe mostrar al arrancar:

   - usuario del sistema
   - zona del sistema
   - hora actual con zona

2. Debe existir un menú en bucle hasta que el usuario elija salir.
3. Debe soportar estas opciones:

   - mostrar hora en otra zona
   - comparar zonas
   - cuenta regresiva hasta evento
   - salir

4. Debe validar:

   - zona horaria inválida
   - fecha/hora inválida
   - opción no numérica

5. Debe usar al menos:

   - `ZoneId`
   - `ZonedDateTime`
   - `Instant`
   - `DateTimeFormatter`

6. Debe separar:

   - clases modelo
   - lógica de tiempo
   - manejo del menú

7. No usar `Date` ni `Calendar`.

---

## Ejercicio 3 — Agenda de ejecuciones del sistema

### Qué se practicará

- POO acumulativa
- `ArrayList`
- composición
- records o clases simples
- formateo de fechas
- separación `model/service/ui`
- reutilización del ejercicio 1

### Enunciado

Amplía la idea del registro de ejecuciones para construir una pequeña agenda de ejecuciones del sistema.

Cada vez que el programa se ejecute, debe permitir registrar varias ejecuciones manuales o automáticas en memoria, almacenar cada una como objeto y luego mostrar:

- listado completo de ejecuciones
- ejecución más reciente
- ejecuciones hechas por un usuario específico
- conteo total por sistema operativo

### Requerimientos del programa

1. Debe reutilizar un modelo `ExecutionLog`.
2. Debe existir una clase `ExecutionLogManager` que mantenga una colección de logs.
3. Debe usar `List<ExecutionLog>`.
4. Debe permitir:

   - agregar log
   - listar logs
   - filtrar por usuario
   - obtener el último log
   - agrupar por sistema operativo

5. Debe usar `java.time` para fechas.
6. Debe imprimir resultados con formato legible.
7. Debe validar entradas vacías o inválidas.

---

## Ejercicio 4 — Analizador de texto y frecuencia de palabras

### Qué se practicará

- Strings
- limpieza de texto
- `Map`
- `HashMap`
- conteos
- encapsulación
- reutilización de objetos de resultado

### Enunciado

Crea un programa llamado `TextAnalyzerCLI` que reciba un bloque de texto por consola y genere un análisis estructurado del contenido.

El programa debe calcular:

- cantidad de caracteres
- cantidad de palabras
- cantidad de líneas
- frecuencia de palabras
- palabra más repetida
- promedio de longitud por palabra

Toda la salida debe construirse desde un objeto `TextAnalysisResult`.

### Requerimientos del programa

1. Debe existir una clase `TextAnalysisResult`.
2. Debe existir un servicio `TextAnalyzerService`.
3. Debe limpiar signos básicos de puntuación antes de contar palabras.
4. Debe tratar mayúsculas y minúsculas como equivalentes para el conteo.
5. Debe usar `Map<String, Integer>` para la frecuencia.
6. Debe mostrar top 5 palabras más frecuentes.
7. Debe validar que el texto no esté vacío.
8. La lógica de análisis no puede estar en `main`.

---

## Ejercicio 5 — Validador de correos y contactos

### Qué se practicará

- regex
- `Pattern`
- `Matcher`
- POO
- listas
- validación de strings
- reutilización de colecciones

### Enunciado

Construye un programa llamado `ContactValidatorApp` para registrar contactos simples en memoria.

Cada contacto tendrá:

- nombre
- correo electrónico
- número telefónico

El programa debe validar cada dato antes de crear el objeto `Contact` y luego mantener una agenda en memoria.

### Requerimientos del programa

1. Debe existir una clase `Contact`.
2. Debe existir un servicio validador para:

   - correo
   - teléfono
   - nombre

3. Debe usar regex al menos para correo y teléfono.
4. Debe permitir:

   - agregar contacto
   - listar contactos
   - buscar por nombre parcial
   - mostrar contactos inválidos rechazados

5. Debe guardar el resultado de validación en un objeto aparte, por ejemplo `ValidationResult`.
6. Debe manejar entradas vacías.
7. Debe separar claramente validación, almacenamiento y UI.

---

## Ejercicio 6 — Gestor de tareas con fechas límite

### Qué se practicará

- POO
- enums
- `LocalDate`
- listas
- filtros
- estados
- acumulación de lógica de menú

### Enunciado

Desarrolla un programa `TaskManagerCLI` para gestionar tareas personales en consola.

Cada tarea debe tener:

- id
- título
- descripción
- fecha de creación
- fecha límite
- prioridad
- estado

El sistema debe permitir crear y administrar tareas, mostrando también cuáles están vencidas o próximas a vencer.

### Requerimientos del programa

1. Debe existir una clase `Task`.
2. Deben existir enums para:

   - prioridad
   - estado

3. Debe permitir:

   - crear tarea
   - listar todas
   - listar pendientes
   - marcar como completada
   - listar vencidas
   - listar por prioridad

4. Debe validar formato de fecha.
5. Debe usar `LocalDate`.
6. Debe calcular si una tarea está vencida comparando contra la fecha actual.
7. Debe manejar colección en memoria con `List<Task>`.
8. Debe usar IDs únicos enteros o UUID.

---

## Ejercicio 7 — Sistema de notas con búsqueda avanzada

### Qué se practicará

- POO
- strings
- búsqueda parcial
- regex básica
- listas
- ordenamiento
- reutilización de modelos

### Enunciado

Crea un programa llamado `NotesCLI` para administrar notas de texto.

Cada nota debe contener:

- id
- título
- contenido
- fecha de creación
- etiquetas opcionales

El usuario debe poder crear, buscar y filtrar notas, incluyendo búsqueda por palabra clave y por etiqueta.

### Requerimientos del programa

1. Debe existir una clase `Note`.
2. Debe permitir:

   - crear nota
   - listar notas
   - buscar por palabra en título o contenido
   - filtrar por etiqueta
   - eliminar nota

3. Debe almacenar etiquetas como colección.
4. Debe ignorar mayúsculas/minúsculas al buscar.
5. Debe mostrar coincidencias de forma legible.
6. Debe validar que el título no esté vacío.
7. Debe ordenar las notas por fecha de creación al listarlas.

---

## Ejercicio 8 — Generador y evaluador de contraseñas

### Qué se practicará

- `SecureRandom`
- regex
- strings
- diseño orientado a objetos
- reglas configurables
- separación de responsabilidades

### Enunciado

Desarrolla `PasswordToolkitCLI`, una herramienta que permita:

- generar contraseñas seguras
- evaluar la fortaleza de una contraseña dada por el usuario
- validar si cumple políticas de seguridad mínimas

### Requerimientos del programa

1. Debe existir una clase `PasswordPolicy`.
2. Debe existir una clase `PasswordStrengthReport`.
3. Debe permitir:

   - generar contraseña según longitud
   - incluir/excluir símbolos
   - incluir/excluir mayúsculas
   - evaluar contraseña ingresada

4. Debe revisar reglas como:

   - longitud mínima
   - mayúsculas
   - minúsculas
   - dígitos
   - símbolos

5. Debe usar `SecureRandom`.
6. Debe usar regex para ciertas validaciones.
7. Debe devolver resultados en objetos, no solo imprimir texto suelto.

---

## Ejercicio 9 — Conversor de unidades extensible

### Qué se practicará

- enums
- POO más limpia
- principios SOLID básicos
- clases de estrategia simples
- acumulación de menús

### Enunciado

Construye `UnitConverterCLI`, un conversor de unidades que permita convertir entre distintos tipos de magnitudes.

Debe soportar inicialmente:

- longitud
- masa
- temperatura

Y debe quedar diseñado para poder agregar nuevas conversiones sin reescribir toda la aplicación.

### Requerimientos del programa

1. Debe existir una abstracción común para los convertidores.
2. Debe implementar al menos:

   - km ↔ miles
   - kg ↔ pounds
   - celsius ↔ fahrenheit

3. Debe separar:

   - tipo de conversión
   - fórmula
   - UI

4. Debe usar enums para categorías.
5. Debe validar números inválidos.
6. Debe mostrar fórmula aplicada o explicación básica del resultado.
7. Debe estar diseñado para que agregar una nueva unidad no implique romper código existente.

---

## Ejercicio 10 — Simulador de caja registradora

### Qué se practicará

- `BigDecimal`
- listas de objetos
- acumulación de reglas de negocio
- modelado POO
- separación entre dominio y presentación

### Enunciado

Crea un programa llamado `CashRegisterCLI` que permita registrar productos comprados por un cliente y generar un resumen de la venta.

Cada producto debe tener:

- nombre
- precio unitario
- cantidad

El sistema debe calcular:

- subtotal por producto
- subtotal general
- impuesto
- total final

### Requerimientos del programa

1. Debe usar `BigDecimal`, no `double`, para montos monetarios.
2. Debe existir una clase `SaleItem`.
3. Debe existir una clase `SaleSummary`.
4. Debe permitir agregar múltiples productos a una venta.
5. Debe calcular impuesto configurable.
6. Debe permitir eliminar un producto antes de cerrar la venta.
7. Debe mostrar ticket en consola.
8. Debe validar precios y cantidades positivas.

---

## Ejercicio 11 — Analizador de archivos de texto

### Qué se practicará

- `Path`
- `Files`
- lectura de archivos
- strings
- estadísticas
- reutilización de análisis textual

### Enunciado

Crea `FileTextAnalyzerCLI`, un programa que lea un archivo `.txt` y genere un análisis detallado de su contenido.

Debe mostrar:

- tamaño del archivo
- cantidad de líneas
- cantidad de palabras
- cantidad de caracteres
- top 10 palabras frecuentes
- líneas que contienen una palabra buscada

### Requerimientos del programa

1. Debe leer la ruta del archivo desde consola.
2. Debe validar que el archivo exista.
3. Debe reutilizar la lógica de análisis textual cuando sea posible.
4. Debe usar `Files.readString` o `Files.readAllLines`.
5. Debe permitir al usuario buscar una palabra dentro del archivo.
6. Debe manejar errores de lectura correctamente.
7. Debe separar acceso a archivo de análisis del contenido.

---

## Ejercicio 12 — Registro persistente de tareas en archivo CSV

### Qué se practicará

- archivos
- escritura y lectura
- serialización manual
- colecciones
- acumulación del gestor de tareas

### Enunciado

Amplía el gestor de tareas para que las tareas puedan guardarse y cargarse desde un archivo CSV.

El usuario debe poder:

- cargar tareas existentes
- agregar nuevas
- guardar cambios
- exportar el estado actual

### Requerimientos del programa

1. Debe reutilizar el modelo `Task`.
2. Debe existir una clase repositorio para CSV.
3. Debe soportar:

   - cargar desde archivo
   - guardar a archivo

4. Debe serializar campos como:

   - id
   - título
   - descripción
   - prioridad
   - estado
   - fechas

5. Debe escapar o manejar comas en contenido si decides permitirlas.
6. Debe manejar archivo inexistente con mensaje claro.
7. No usar librerías externas.

---

## Ejercicio 13 — Analizador de logs por niveles

### Qué se practicará

- enums
- regex
- archivos
- `Map`
- estadísticas
- diseño de parseadores

### Enunciado

Desarrolla `LogAnalyzerCLI`, una herramienta para analizar un archivo de logs de texto.

Cada línea del log tendrá un formato aproximado como:

```text
2026-03-14 10:22:01 [INFO] Application started
```

````

El programa debe procesar el archivo y generar estadísticas por nivel y por rango horario.

### Requerimientos del programa

1. Debe existir un modelo `LogEntry`.
2. Debe existir un parser para transformar líneas en objetos.
3. Debe soportar niveles:

   - INFO
   - WARN
   - ERROR
   - DEBUG

4. Debe mostrar:

   - total de logs
   - cantidad por nivel
   - primer log
   - último log
   - mensajes que contienen una palabra clave

5. Debe usar regex para parsear.
6. Debe omitir o reportar líneas inválidas.
7. Debe usar `LocalDateTime` para la fecha del log.

---

## Ejercicio 14 — Agenda de contactos con importación y exportación

### Qué se practicará

- reutilización del validador
- archivos CSV
- listas
- búsqueda
- deduplicación
- diseño por servicios

### Enunciado

Extiende tu sistema de contactos para convertirlo en una agenda persistente.

La aplicación debe permitir:

- agregar contactos
- buscar contactos
- exportarlos a CSV
- importar contactos desde CSV
- evitar duplicados por correo electrónico

### Requerimientos del programa

1. Debe reutilizar la clase `Contact`.
2. Debe usar validaciones ya construidas.
3. Debe detectar duplicados por email.
4. Debe permitir:

   - importar archivo CSV
   - exportar agenda actual

5. Debe mostrar cuántos contactos se importaron correctamente y cuántos fallaron.
6. Debe manejar líneas inválidas sin detener toda la importación.
7. Debe listar agenda ordenada alfabéticamente.

---

## Ejercicio 15 — Catálogo de productos con filtros y ordenamiento

### Qué se practicará

- `List`
- comparadores
- filtros acumulativos
- modelado POO
- enums
- menú más robusto

### Enunciado

Crea `ProductCatalogCLI`, una herramienta para administrar un catálogo de productos.

Cada producto debe tener:

- id
- nombre
- categoría
- precio
- stock
- fecha de creación

La aplicación debe permitir filtrar y ordenar productos según distintos criterios.

### Requerimientos del programa

1. Debe existir una clase `Product`.
2. Debe existir un enum `ProductCategory`.
3. Debe permitir:

   - crear producto
   - listar productos
   - filtrar por categoría
   - filtrar por rango de precio
   - mostrar productos sin stock
   - ordenar por nombre, precio o fecha

4. Debe usar `BigDecimal` para precio.
5. Debe validar stock no negativo.
6. Debe evitar IDs repetidos.
7. Debe separar reglas de filtrado y ordenamiento de la UI.

---

## Ejercicio 16 — Analizador de argumentos de línea de comandos

### Qué se practicará

- `String[] args`
- parsing manual
- validación
- mapas
- encapsulación
- diseño de parser

### Enunciado

Desarrolla `CommandArgsParserCLI`, una utilidad que interprete argumentos de línea de comandos con formato tipo:

```text
--file=data.txt --mode=fast --limit=10 --verbose=true
````

La herramienta debe parsear los argumentos, validarlos y mostrarlos estructurados.

### Requerimientos del programa

1. Debe existir una clase `ParsedArguments`.
2. Debe existir una clase `ArgumentParser`.
3. Debe soportar:

   - pares clave=valor
   - banderas booleanas
   - validación de claves requeridas

4. Debe permitir registrar reglas de validación.
5. Debe detectar argumentos duplicados o mal formados.
6. Debe mostrar errores claros.
7. Debe tener al menos una simulación de uso real, por ejemplo lectura de archivo y límite de resultados.

---

## Ejercicio 17 — Motor de plantillas de texto simple

### Qué se practicará

- regex
- strings
- `Map`
- diseño reutilizable
- validación de placeholders

### Enunciado

Construye `TemplateEngineCLI`, una herramienta para procesar plantillas de texto con placeholders del tipo:

```text
Hola {{name}}, tu saldo es {{balance}}
```

El usuario podrá ingresar una plantilla y un conjunto de valores para reemplazar variables.

### Requerimientos del programa

1. Debe detectar placeholders con regex.
2. Debe extraer los nombres de variables requeridas.
3. Debe permitir reemplazar usando un `Map<String, String>`.
4. Debe reportar variables faltantes.
5. Debe permitir reutilizar una misma plantilla varias veces con distintos valores.
6. Debe existir una clase `TemplateRenderResult`.
7. Debe soportar múltiples placeholders repetidos.

---

## Ejercicio 18 — Simulador de cola de impresión

### Qué se practicará

- `Queue`
- `ArrayDeque`
- POO
- estados
- acumulación de diseño de procesos

### Enunciado

Crea `PrintQueueSimulatorCLI`, una aplicación para administrar trabajos de impresión.

Cada trabajo debe tener:

- id
- nombre del documento
- usuario
- número de páginas
- fecha de envío
- estado

La impresora debe procesar los trabajos en orden de llegada.

### Requerimientos del programa

1. Debe existir una clase `PrintJob`.
2. Debe usar `Queue<PrintJob>`.
3. Debe permitir:

   - agregar trabajo
   - ver siguiente trabajo
   - procesar siguiente
   - cancelar trabajo pendiente
   - ver historial procesado

4. Debe validar páginas positivas.
5. Debe usar estados como:

   - QUEUED
   - PRINTING
   - DONE
   - CANCELED

6. Debe separar la cola activa del historial.
7. Debe mostrar tiempos de espera aproximados si quieres agregar valor.

---

## Ejercicio 19 — Buscador de duplicados y normalizador de datos

### Qué se practicará

- `Set`
- `Map`
- normalización de strings
- deduplicación
- composición de reglas

### Enunciado

Desarrolla `DuplicateFinderCLI`, una utilidad para ingresar una colección de datos de texto y detectar duplicados reales y duplicados aparentes.

Por ejemplo, estos podrían considerarse equivalentes según una regla de normalización:

- `"Juan Perez"`
- `" juan perez "`
- `"JUAN PEREZ"`

### Requerimientos del programa

1. Debe existir una estrategia de normalización.
2. Debe permitir:

   - ingresar elementos
   - mostrar duplicados exactos
   - mostrar duplicados tras normalizar

3. Debe reportar cuántas repeticiones tiene cada valor.
4. Debe permitir elegir si la comparación ignora espacios extremos y mayúsculas/minúsculas.
5. Debe usar `Set` y `Map`.
6. Debe guardar resultados en un objeto de reporte.

---

## Ejercicio 20 — Sistema de configuración con archivo Properties

### Qué se practicará

- `Properties`
- archivos
- configuración del sistema
- carga y persistencia
- encapsulación de settings

### Enunciado

Construye `AppConfigManagerCLI`, una herramienta para administrar configuraciones de una aplicación a través de un archivo `.properties`.

Debe permitir:

- cargar configuración
- consultar valores
- modificar propiedades
- guardar cambios
- crear un archivo de configuración inicial si no existe

### Requerimientos del programa

1. Debe usar `java.util.Properties`.
2. Debe existir una clase `AppConfig`.
3. Debe permitir:

   - leer propiedad
   - cambiar propiedad
   - listar todas
   - guardar archivo

4. Debe manejar archivo inexistente creando uno por defecto.
5. Debe validar claves vacías.
6. Debe mostrar claramente de dónde se cargó el archivo.
7. Debe separar acceso a archivo de lógica de negocio.

---

## Ejercicio 21 — Sistema de métricas numéricas

### Qué se practicará

- `Math`
- streams o iteración manual
- estadísticas
- modelado de reportes
- parsing numérico

### Enunciado

Crea `NumericMetricsCLI`, una herramienta que reciba una lista de números y genere un reporte estadístico.

Debe calcular:

- suma
- promedio
- mínimo
- máximo
- rango
- desviación simple
- cantidad de números positivos, negativos y cero

### Requerimientos del programa

1. Debe existir una clase `NumericReport`.
2. Debe permitir ingresar números por consola o por una sola línea separada por comas.
3. Debe validar entradas no numéricas.
4. Debe usar `Math` cuando corresponda.
5. Debe mostrar resultados formateados.
6. Debe permitir repetir el análisis varias veces sin reiniciar el programa.

---

## Ejercicio 22 — Calculadora científica con historial

### Qué se practicará

- `Math`
- enums
- historial de operaciones
- POO
- acumulación del análisis numérico

### Enunciado

Desarrolla `ScientificCalculatorCLI`, una calculadora de consola con historial.

Debe soportar operaciones como:

- suma
- resta
- multiplicación
- división
- potencia
- raíz cuadrada
- seno
- coseno
- logaritmo

Y debe almacenar cada operación realizada.

### Requerimientos del programa

1. Debe existir una clase `CalculationRecord`.
2. Debe existir una abstracción para operaciones.
3. Debe permitir:

   - ejecutar operación
   - ver historial
   - limpiar historial

4. Debe manejar divisiones entre cero.
5. Debe validar dominios inválidos para operaciones matemáticas.
6. Debe guardar fecha y hora de cada cálculo.
7. Debe imprimir expresión y resultado.

---

## Ejercicio 23 — Registro de usuarios con autenticación simple

### Qué se practicará

- POO
- validaciones
- colecciones
- hashing básico
- encapsulación del dominio

### Enunciado

Crea `UserRegistryCLI`, una aplicación para registrar usuarios y permitir inicio de sesión simple.

Cada usuario debe tener:

- username
- correo
- password almacenada de forma no reversible
- fecha de creación
- estado

### Requerimientos del programa

1. Debe reutilizar validación de correos y contraseñas.
2. Debe almacenar la contraseña usando hash, no texto plano.
3. Debe permitir:

   - registrar usuario
   - iniciar sesión
   - listar usuarios
   - desactivar usuario

4. Debe evitar usernames repetidos.
5. Debe evitar correos repetidos.
6. Debe existir una clase `AuthService`.
7. Debe existir una clase `PasswordHasher`.
8. Debe mostrar intentos fallidos con mensajes claros.

---

## Ejercicio 24 — Generador de hashes para texto y archivos

### Qué se practicará

- `MessageDigest`
- archivos
- strings
- hex encoding
- reutilización de servicios de seguridad

### Enunciado

Desarrolla `HashToolkitCLI`, una herramienta para calcular hashes de texto y de archivos.

Debe soportar al menos:

- MD5
- SHA-256

Y debe permitir comparar si dos entradas producen el mismo hash.

### Requerimientos del programa

1. Debe existir una abstracción para algoritmos de hash.
2. Debe permitir:

   - hashear texto
   - hashear archivo
   - comparar hashes

3. Debe leer archivos con manejo correcto de errores.
4. Debe devolver hash en hexadecimal.
5. Debe mostrar tamaño del archivo procesado si aplica.
6. Debe validar algoritmo no soportado.
7. Debe reutilizar lógica común para no duplicar código.

---

## Ejercicio 25 — Comparador de archivos por contenido

### Qué se practicará

- reutilización del hashing
- archivos
- metadatos
- reportes comparativos
- diseño orientado a objetos

### Enunciado

Construye `FileComparatorCLI`, una herramienta que compare dos archivos y determine si son equivalentes.

Debe poder comparar:

- por nombre
- por tamaño
- por contenido real usando hash
- por fecha de modificación

### Requerimientos del programa

1. Debe existir una clase `FileComparisonReport`.
2. Debe permitir elegir el nivel de comparación:

   - solo metadatos
   - hash completo

3. Debe mostrar:

   - tamaño de cada archivo
   - fecha de modificación
   - hashes
   - resultado final

4. Debe validar que ambos archivos existan.
5. Debe reutilizar el servicio de hash del ejercicio anterior.
6. Debe reportar diferencias claramente.

---

## Ejercicio 26 — Sistema de caché en memoria con expiración

### Qué se practicará

- `Map`
- `Instant`
- TTL
- encapsulación
- diseño más orientado a servicios
- principios SOLID básicos

### Enunciado

Desarrolla `InMemoryCacheCLI`, una caché simple en memoria con tiempo de expiración por clave.

El usuario debe poder:

- guardar pares clave/valor
- consultar valor
- eliminar clave
- listar entradas activas
- limpiar entradas expiradas

### Requerimientos del programa

1. Debe existir una clase `CacheEntry`.
2. Debe usar `Map<String, CacheEntry>`.
3. Cada entrada debe guardar:

   - clave
   - valor
   - fecha de creación
   - tiempo de expiración

4. Debe permitir TTL configurable por entrada.
5. Debe detectar automáticamente si un valor ya expiró al consultarlo.
6. Debe mostrar cuántas entradas expiraron al limpiar.
7. Debe separar almacenamiento, reglas de expiración y UI.

---

## Ejercicio 27 — Analizador de directorios y reporte de espacio

### Qué se practicará

- `Files.walk`
- `Path`
- filtros
- acumulación de reportes
- diseño de análisis jerárquico

### Enunciado

Crea `DirectoryAnalyzerCLI`, una herramienta que analice un directorio y genere un reporte estructurado.

Debe calcular:

- número total de archivos
- número total de directorios
- tamaño acumulado
- archivos más grandes
- conteo por extensión

### Requerimientos del programa

1. Debe leer una ruta de directorio.
2. Debe validar que exista y sea directorio.
3. Debe usar `Files.walk`.
4. Debe mostrar top 5 archivos más grandes.
5. Debe agrupar conteo por extensión con `Map`.
6. Debe permitir filtrar por extensión si el usuario lo desea.
7. Debe encapsular resultados en un `DirectoryAnalysisReport`.

---

## Ejercicio 28 — Registro persistente de notas por serialización

### Qué se practicará

- serialización
- objetos persistentes
- reutilización del sistema de notas
- manejo de archivos binarios
- excepciones

### Enunciado

Extiende tu sistema de notas para permitir guardar y cargar el estado completo de la aplicación mediante serialización de objetos.

### Requerimientos del programa

1. Debe reutilizar la clase `Note`.
2. Debe permitir:

   - guardar colección completa de notas
   - cargar colección desde archivo binario

3. Debe usar `Serializable`.
4. Debe manejar clases no serializables correctamente.
5. Debe validar que el archivo exista antes de cargar.
6. Debe informar cuántas notas fueron cargadas.
7. Debe mantener compatibilidad básica con la UI existente.

---

## Ejercicio 29 — Sistema de reportes tabulares en consola

### Qué se practicará

- strings
- padding
- formateo
- colecciones
- reutilización de datos existentes
- separación entre datos y renderizado

### Enunciado

Desarrolla `ConsoleTableRendererCLI`, una utilidad para mostrar listas de objetos como tablas alineadas en consola.

La herramienta debe poder renderizar datos provenientes de módulos ya creados, como:

- tareas
- contactos
- productos
- logs

### Requerimientos del programa

1. Debe existir un componente reutilizable de renderizado tabular.
2. Debe calcular anchos de columna automáticamente.
3. Debe truncar o ajustar valores largos.
4. Debe permitir alinear texto a izquierda o derecha.
5. Debe reutilizar datos de al menos dos ejercicios previos.
6. Debe separar completamente renderizado de obtención de datos.
7. Debe producir salida consistente y legible.

---

## Ejercicio 30 — Mini sistema modular de administración CLI

### Qué se practicará

- integración de todo lo anterior
- diseño por capas simple
- composición
- menús anidados
- reutilización de servicios
- principios SOLID básicos
- arquitectura de consola

### Enunciado

Construye `PersonalAdminSuiteCLI`, una aplicación de consola que unifique varios módulos desarrollados anteriormente dentro de un solo programa.

Debe incluir al menos estos módulos:

- tareas
- notas
- contactos
- productos
- análisis de archivos
- configuración

La idea es que este ejercicio funcione como una primera integración real de mini-sistema.

### Requerimientos del programa

1. Debe tener un menú principal con submenús por módulo.
2. Debe reutilizar clases y servicios de ejercicios anteriores.
3. Debe evitar duplicar lógica ya implementada.
4. Debe tener una estructura mínima tipo:

   - `model`
   - `service`
   - `repository`
   - `ui`
   - `util`

5. Debe aplicar POO de forma consistente.
6. Debe aplicar al menos estas ideas de SOLID:

   - responsabilidad única
   - abierto/cerrado
   - inversión de dependencias básica

7. Debe permitir persistencia en al menos dos módulos.
8. Debe tener manejo centralizado de errores de entrada.
9. Debe ser ejecutable sin frameworks, sin Maven y sin Gradle.

---

```

```
