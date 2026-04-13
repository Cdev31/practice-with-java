# Notas de cosas en java

#### Mandar a la jvm una propiedad antes de ejecutar:

```bash
java -Xmx2G -Denv=prod -Dport=8080 Main
```

### Ejecutar desde la consola para compilar en java y luego ejecutar

```bash
javac -d <directory_out> <archive>.java
```

```bash
javac -cp <directory> <archive>.java
```

# Referencia de Librerías en Java

## 1. Scanner

### Paquete

`java.util.Scanner`

### Propósito

`Scanner` se utiliza para **leer datos de entrada** desde diferentes fuentes como:

- Teclado (`System.in`)
- Archivos
- Cadenas de texto
- Streams de entrada

Es muy común en **aplicaciones de consola** para pedir datos al usuario.

### Métodos importantes

| Método         | Descripción                                                         |
| -------------- | ------------------------------------------------------------------- |
| `nextLine()`   | Lee una línea completa hasta que el usuario presiona Enter          |
| `next()`       | Lee la siguiente palabra (hasta encontrar espacio o salto de línea) |
| `nextInt()`    | Lee un número entero                                                |
| `nextDouble()` | Lee un número decimal                                               |
| `hasNext()`    | Verifica si hay más datos disponibles para leer                     |
| `close()`      | Cierra el Scanner y libera recursos                                 |

---

## 2. ZoneId

### Paquete

`java.time.ZoneId`

### Propósito

`ZoneId` representa un **identificador de zona horaria**.

Se usa para especificar **en qué zona horaria se encuentra una fecha y hora**, por ejemplo:

- `America/El_Salvador`
- `UTC`
- `Europe/Madrid`
- `Asia/Tokyo`

### Métodos importantes

| Método                         | Descripción                                           |
| ------------------------------ | ----------------------------------------------------- |
| `ZoneId.of(String zone)`       | Crea una zona horaria usando un identificador de zona |
| `ZoneId.systemDefault()`       | Devuelve la zona horaria predeterminada del sistema   |
| `ZoneId.getAvailableZoneIds()` | Devuelve todas las zonas horarias disponibles en Java |

---

## 3. ZonedDateTime

### Paquete

`java.time.ZonedDateTime`

### Propósito

`ZonedDateTime` representa una **fecha y hora con zona horaria**.

Incluye:

- Año
- Mes
- Día
- Hora
- Minutos
- Segundos
- Zona horaria

Ejemplo de representación:

```

2026-03-17T01:10:15-06:00[America/El_Salvador]

```

### Métodos importantes

| Método                           | Descripción                                               |
| -------------------------------- | --------------------------------------------------------- |
| `ZonedDateTime.now()`            | Obtiene la fecha y hora actual usando la zona del sistema |
| `ZonedDateTime.now(ZoneId zone)` | Obtiene la fecha y hora actual en una zona específica     |
| `getYear()`                      | Devuelve el año                                           |
| `getMonth()`                     | Devuelve el mes                                           |
| `getDayOfMonth()`                | Devuelve el día del mes                                   |
| `getHour()`                      | Devuelve la hora                                          |
| `getMinute()`                    | Devuelve los minutos                                      |
| `plusDays(long days)`            | Suma días a la fecha actual                               |
| `minusHours(long hours)`         | Resta horas a la fecha actual                             |

---

## 4. DateTimeFormatter

### Paquete

`java.time.format.DateTimeFormatter`

### Propósito

`DateTimeFormatter` se utiliza para **formatear fechas y horas en cadenas de texto legibles**.

Permite convertir una fecha y hora en un **formato personalizado**.

Ejemplo de fecha sin formatear:

```

2026-03-17T01:15:20

```

Formateada:

```

17/03/2026

```

### Métodos importantes

| Método                                        | Descripción                                        |
| --------------------------------------------- | -------------------------------------------------- |
| `DateTimeFormatter.ofPattern(String pattern)` | Crea un formateador usando un patrón personalizado |
| `format(TemporalAccessor dateTime)`           | Convierte una fecha/hora en una cadena de texto    |
| `parse(CharSequence text)`                    | Convierte una cadena de texto en una fecha/hora    |

### Patrones de formato comunes

| Patrón | Significado                 |
| ------ | --------------------------- |
| `dd`   | Día                         |
| `MM`   | Mes                         |
| `yyyy` | Año                         |
| `HH`   | Hora en formato de 24 horas |
| `mm`   | Minutos                     |
| `ss`   | Segundos                    |

# Clases de Fecha y Tiempo en Java (Adicionales)

## 1. Instant

### Paquete

`java.time.Instant`

### Propósito

`Instant` representa **un punto exacto en el tiempo en formato UTC** (Tiempo Universal Coordinado).

Se usa comúnmente para:

- marcas de tiempo (timestamps)
- logs
- almacenamiento de fechas en bases de datos
- medir tiempo entre eventos

A diferencia de otras clases, **no tiene zona horaria**, siempre trabaja en **UTC**.

Ejemplo de representación:

```

2026-03-17T07:30:15Z

```

### Métodos importantes

| Método                                | Descripción                                                   |
| ------------------------------------- | ------------------------------------------------------------- |
| `Instant.now()`                       | Obtiene el instante actual en UTC                             |
| `Instant.ofEpochSecond(long seconds)` | Crea un instante a partir de segundos desde 1970              |
| `getEpochSecond()`                    | Obtiene los segundos desde el 1 de enero de 1970 (Unix epoch) |
| `plusSeconds(long seconds)`           | Suma segundos al instante                                     |
| `minusSeconds(long seconds)`          | Resta segundos al instante                                    |

---

## 2. LocalDateTime

### Paquete

`java.time.LocalDateTime`

### Propósito

`LocalDateTime` representa **fecha y hora sin zona horaria**.

Incluye:

- año
- mes
- día
- hora
- minutos
- segundos

Se usa cuando **no importa la zona horaria**, por ejemplo:

- horarios de eventos
- agendas
- datos locales de una aplicación

Ejemplo:

```

2026-03-17T01:30:10

```

### Métodos importantes

| Método                   | Descripción                                |
| ------------------------ | ------------------------------------------ |
| `LocalDateTime.now()`    | Obtiene la fecha y hora actual del sistema |
| `getYear()`              | Devuelve el año                            |
| `getMonth()`             | Devuelve el mes                            |
| `getDayOfMonth()`        | Devuelve el día del mes                    |
| `getHour()`              | Devuelve la hora                           |
| `plusDays(long days)`    | Suma días                                  |
| `minusHours(long hours)` | Resta horas                                |

---

## 3. Duration

### Paquete

`java.time.Duration`

### Propósito

`Duration` representa **una cantidad de tiempo entre dos instantes**.

Se usa para calcular:

- cuánto tiempo pasó entre dos fechas
- duración de procesos
- tiempos de ejecución

Ejemplo:

```

PT2H30M

```

Significa:

```

2 horas y 30 minutos

```

### Métodos importantes

| Método                         | Descripción                           |
| ------------------------------ | ------------------------------------- |
| `Duration.between(start, end)` | Calcula la duración entre dos tiempos |
| `toSeconds()`                  | Convierte la duración a segundos      |
| `toMinutes()`                  | Convierte la duración a minutos       |
| `toHours()`                    | Convierte la duración a horas         |
| `plus(Duration duration)`      | Suma otra duración                    |
| `minus(Duration duration)`     | Resta otra duración                   |

---

## 4. DateTimeException

### Paquete

`java.time.DateTimeException`

### Propósito

`DateTimeException` es una **excepción que ocurre cuando hay un error con fechas o tiempos**.

Se lanza cuando:

- una zona horaria no existe
- una fecha es inválida
- un valor está fuera de rango

Ejemplo de error:

```

ZoneId.of("America/PlanetaX")

```

Esto generaría una excepción porque la zona no existe.

### Uso típico

Se usa dentro de `try-catch` para manejar errores relacionados con fechas.

---

## 5. DateTimeParseException

### Paquete

`java.time.format.DateTimeParseException`

### Propósito

`DateTimeParseException` ocurre cuando **Java no puede convertir una cadena de texto en una fecha o tiempo**.

Sucede generalmente cuando el formato del texto **no coincide con el patrón esperado**.

Ejemplo:

Intentar convertir:

```

17-03-2026

```

con un patrón incorrecto como:

```

yyyy/MM/dd

```

provocará esta excepción.

### Uso típico

Se usa para manejar errores al **parsear fechas desde texto**.

# Métodos Útiles de List en Java

## 📋 Operaciones Básicas

### Agregar elementos

```java
list.add(elemento);                    // Agrega al final
list.add(indice, elemento);             // Agrega en posición específica
list.addAll(otraLista);                 // Agrega todos los elementos
```

### Eliminar elementos

```java
list.remove(indice);                    // Elimina por índice
list.remove(elemento);                   // Elimina por objeto
list.removeAll(coleccion);               // Elimina todos los de la colección
list.clear();                            // Elimina todos
```

### Obtener elementos

```java
list.get(indice);                        // Obtiene elemento por índice
list.indexOf(elemento);                   // Obtiene índice de elemento
list.lastIndexOf(elemento);               // Último índice del elemento
list.subList(inicio, fin);                // Obtiene sublista
```

## 🔍 Búsqueda y Verificación

### Verificar existencia

```java
list.contains(elemento);                  // Si contiene el elemento
list.containsAll(coleccion);               // Si contiene todos
list.isEmpty();                            // Si está vacía
```

### Buscar elementos

```java
// Stream API (Java 8+)
list.stream()
    .filter(item -> item.getPropiedad().equals(valor))
    .collect(Collectors.toList());

// Parallel Stream (para listas grandes)
list.parallelStream()
    .filter(item -> item.getPropiedad() > 100)
    .findAny();

// forEach tradicional
list.forEach(item -> {
    if (item.getNombre().startsWith("A")) {
        System.out.println(item);
    }
});
```

## 🔄 Ordenamiento y Transformación

### Ordenar

```java
Collections.sort(lista);                    // Orden natural
Collections.sort(lista, comparator);         // Con comparador
lista.sort(comparator);                      // Java 8+
lista.sort(Comparator.comparing(Item::getPropiedad));
```

### Transformar

```java
// Mapear a otra lista
List<String> nombres = personas.stream()
    .map(Persona::getNombre)
    .collect(Collectors.toList());

// Filtrar y transformar
List<String> resultados = personas.stream()
    .filter(p -> p.getEdad() > 18)
    .map(Persona::getNombre)
    .collect(Collectors.toList());
```

## 📊 Métodos de Información

```java
list.size();                                 // Tamaño de la lista
list.toArray();                              // Convertir a array
list.toArray(new T[0]);                       // Convertir a array tipado
list.hashCode();                              // Código hash
list.iterator();                              // Obtener iterador
list.listIterator();                          // ListIterator con más opciones
```

## 🔧 Métodos de Modificación

```java
list.set(indice, elemento);                   // Reemplazar elemento
list.replaceAll(operador);                     // Reemplazar todos
list.retainAll(coleccion);                      // Mantener solo los de colección
```

## 💡 Ejemplos Prácticos con Objetos

### Buscar en lista de objetos

```java
List<Persona> personas = new ArrayList<>();

// Encontrar primera persona con cierta edad
Persona encontrada = personas.stream()
    .filter(p -> p.getEdad() == 25)
    .findFirst()
    .orElse(null);

// Buscar múltiples coincidencias
List<Persona> mayores = personas.stream()
    .filter(p -> p.getEdad() >= 18)
    .collect(Collectors.toList());

// Verificar si existe algún elemento que cumpla condición
boolean existeMayor = personas.stream()
    .anyMatch(p -> p.getEdad() > 60);

// Contar elementos que cumplan condición
long totalJovenes = personas.stream()
    .filter(p -> p.getEdad() < 18)
    .count();
```

### Usando Predicates (Java 8+)

```java
// Definir predicados reutilizables
Predicate<Persona> esMayorEdad = p -> p.getEdad() >= 18;
Predicate<Persona> nombreEmpiezaConA = p -> p.getNombre().startsWith("A");

// Combinar predicados
List<Persona> resultado = personas.stream()
    .filter(esMayorEdad.and(nombreEmpiezaConA))
    .collect(Collectors.toList());
```

## 🎯 Métodos Específicos por Tipo de List

### ArrayList (más usado)

```java
ArrayList<String> arrayList = new ArrayList<>();
arrayList.ensureCapacity(100);                // Reservar capacidad
arrayList.trimToSize();                        // Ajustar al tamaño actual
```

### LinkedList

```java
LinkedList<String> linkedList = new LinkedList<>();
linkedList.addFirst(elemento);                  // Agregar al inicio
linkedList.addLast(elemento);                    // Agregar al final
linkedList.getFirst();                           // Obtener primero
linkedList.getLast();                             // Obtener último
linkedList.removeFirst();                         // Eliminar primero
linkedList.removeLast();                           // Eliminar último
```

## 📝 Notas Importantes

- **List** es una interfaz, necesitas implementaciones concretas como `ArrayList`, `LinkedList`
- **ArrayList**: Acceso rápido por índice, lento para insertar/eliminar en medio
- **LinkedList**: Bueno para inserciones/eliminaciones frecuentes, lento para acceso por índice
- **Vector**: Versión antigua sincronizada (thread-safe)
- **CopyOnWriteArrayList**: Thread-safe para lecturas concurrentes

Estos métodos te permitirán manejar la mayoría de operaciones comunes con List en Java de manera efectiva.
