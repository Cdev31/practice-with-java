# Java Core Topics Roadmap

## Lenguaje y fundamentos

- Tipos primitivos
- Wrappers
- Autoboxing / Unboxing
- Inferencia de tipos (`var`)
- Literales numéricos avanzados
- Conversión de tipos (casting)
- Operadores
- Control de flujo (`if`, `switch`, `while`, `for`)
- Switch expressions
- Pattern matching
- Records
- Sealed classes
- Enums

---

## Programación orientada a objetos

- Clases
- Objetos
- Constructores
- Encapsulación
- Herencia
- Polimorfismo
- Abstracción
- Interfaces
- Clases abstractas
- Interfaces funcionales
- Default methods
- Static methods en interfaces
- Composición
- Delegación
- Inmutabilidad

---

## Tipado avanzado

- Generics
- Generics con múltiples bounds
- Wildcards (`?`, `extends`, `super`)
- Type erasure
- Covariance
- Contravariance
- PECS rule
- Type inference
- Generic methods
- Generic classes

---

## Manejo de excepciones

- Checked exceptions
- Unchecked exceptions
- Jerarquía de excepciones
- `try / catch / finally`
- `try-with-resources`
- Custom exceptions
- Propagación de excepciones

---

## Manejo de strings

- `String`
- `StringBuilder`
- `StringBuffer`
- Manipulación de cadenas
- Formateo (`String.format`)
- Unicode
- Codificación de caracteres
- Charset
- Normalización de strings

---

## Expresiones regulares

- `java.util.regex`
- `Pattern`
- `Matcher`
- Grupos
- Lookahead
- Lookbehind
- Validación con regex
- Reemplazo con regex

---

## Colecciones y estructuras de datos

- Collection framework
- List
- Set
- Map
- Queue
- Deque
- Iterator
- ListIterator
- Spliterator

### Implementaciones

- ArrayList
- LinkedList
- HashSet
- LinkedHashSet
- TreeSet
- HashMap
- LinkedHashMap
- TreeMap
- WeakHashMap
- IdentityHashMap
- EnumSet
- EnumMap
- PriorityQueue
- ArrayDeque

---

## Streams y programación funcional

- Stream API
- Lambdas
- Functional interfaces
- Method references
- map
- filter
- reduce
- collect
- Collectors
- Parallel streams
- Optional

---

## Manejo de fechas y tiempo

- `java.time`
- Instant
- LocalDate
- LocalTime
- LocalDateTime
- ZonedDateTime
- ZoneId
- Duration
- Period
- DateTimeFormatter
- Conversión de zonas horarias

---

## Entrada / salida

- `java.io`
- File
- FileReader / FileWriter
- BufferedReader / BufferedWriter
- InputStream / OutputStream
- Object streams

---

## NIO

- `java.nio`
- Buffers
- ByteBuffer
- CharBuffer
- IntBuffer

---

## NIO avanzado

- Channels
- FileChannel
- SocketChannel
- ServerSocketChannel
- DatagramChannel
- Selectors
- Non-blocking IO

---

## Sistema de archivos

- `java.nio.file`
- Path
- Paths
- Files
- File attributes
- File walking
- File watchers
- WatchService

---

## Manejo del sistema

- System properties
- Environment variables
- Runtime
- Runtime information
- Process
- ProcessBuilder
- Manejo de procesos externos

---

## Concurrencia

- Thread
- Runnable
- Callable
- ExecutorService
- Thread pools
- Future
- CompletableFuture
- ForkJoinPool
- ForkJoinTask

---

## Sincronización

- synchronized
- volatile
- Locks
- ReentrantLock
- ReadWriteLock
- StampedLock
- Semaphore
- CountDownLatch
- CyclicBarrier

---

## Colecciones concurrentes

- ConcurrentHashMap
- CopyOnWriteArrayList
- CopyOnWriteArraySet
- ConcurrentLinkedQueue
- ConcurrentSkipListMap

---

## Colas bloqueantes

- BlockingQueue
- ArrayBlockingQueue
- LinkedBlockingQueue
- PriorityBlockingQueue

---

## Temporizadores

- Timer
- TimerTask
- ScheduledExecutorService

---

## Redes

- `java.net`
- InetAddress
- Socket
- ServerSocket
- DatagramSocket
- DatagramPacket
- TCP networking
- UDP networking

---

## Cliente HTTP

- `java.net.http`
- HttpClient
- HttpRequest
- HttpResponse
- HTTP/2
- Async HTTP requests

---

## Seguridad y criptografía

- `java.security`
- `javax.crypto`
- MessageDigest
- Cipher
- SecureRandom
- KeyPairGenerator
- Signature
- Hashing
- AES
- RSA

---

## Compresión

- `java.util.zip`
- Zip streams
- GZIP streams

---

## Codificación

- Base64
- Charset
- Encoding / decoding

---

## Matemáticas

- `java.lang.Math`
- BigInteger
- BigDecimal
- Random
- ThreadLocalRandom

---

## Configuración

- Properties
- Config files
- ResourceBundle

---

## Internacionalización

- Locale
- NumberFormat
- MessageFormat

---

## Serialización

- Serializable
- Externalizable
- Object serialization

---

## Reflection

- Class
- Method
- Field
- Constructor
- Dynamic instantiation
- Runtime introspection

---

## Method handles

- MethodHandle
- MethodHandles
- VarHandle

---

## Anotaciones

- Annotation types
- Retention
- Target
- Runtime annotations

---

## Gestión de memoria

- Heap
- Stack
- Garbage collection
- Java Memory Model

### Tipos de referencia

- Strong reference
- Weak reference
- Soft reference
- Phantom reference

---

## JVM e introspección

- ClassLoader
- Bytecode
- JIT
- JVM memory model
- JVM monitoring

---

## Gestión de la JVM

- `java.lang.management`
- MemoryMXBean
- ThreadMXBean
- RuntimeMXBean

---

## CLI y consola

- `java.io.Console`
- Input por terminal
- Lectura segura de passwords

---

## Logging

- `java.util.logging`

---

## Compilación y módulos

- Module system
- module-info.java
- Modularización del JDK

---

## Patrones de diseño

### Creacionales

- Singleton
- Factory
- Abstract Factory
- Builder
- Prototype

### Estructurales

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Proxy

### Comportamiento

- Strategy
- Observer
- Command
- Iterator
- State
- Template Method
- Visitor

---

## Principios SOLID

- Single Responsibility Principle (SRP)
- Open / Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)
