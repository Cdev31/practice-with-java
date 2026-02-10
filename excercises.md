# Ejercicio 1 — Registro de ejecuciones del sistema en Java

## Objetivo

Familiarizarse con la estructura básica de un programa en Java y el uso de la biblioteca estándar, aplicando conceptos de:

- Programación estructurada
- Programación orientada a objetos
- Manejo de excepciones
- Uso de APIs estándar de Java

---

## Contexto

Muchas aplicaciones reales registran información básica cada vez que se ejecutan (logs de arranque, auditoría, diagnóstico, etc.).  
En este ejercicio crearás un programa simple que registre datos de la ejecución actual del sistema.

---

## Enunciado

Desarrolla un programa que realice lo siguiente:

1. Al iniciar el programa:

   - Obtenga la **fecha y hora actual** del sistema.
   - Obtenga el **nombre del usuario del sistema operativo** que ejecuta el programa.

2. Almacene esa información en un objeto llamado `ExecutionLog`.

3. Muestre en consola un mensaje con el siguiente formato aproximado:

```
Programa ejecutado por: <usuario>
Fecha y hora: <fecha_hora>
``
```

# Ejercicio 2 — Monitor de tiempo y zona horaria (CLI)

## Objetivo

Practicar:

- `java.time` (Instant, ZonedDateTime, ZoneId, DateTimeFormatter)
- Zonas horarias y conversión correcta
- Condicionales y bucles
- Lectura de entrada por consola
- Acceso a información del sistema (propiedades / zona)
- Manejo de excepciones y validación básica

---

## Contexto

Vas a construir un pequeño monitor de tiempo en consola que permite:

1. ver la hora local del sistema,
2. verla en otra zona horaria,
3. comparar horarios,
4. calcular cuántos minutos faltan para un evento.

---

## Enunciado

Crea un programa Java (sin Maven/Gradle) llamado `TimeZoneMonitor` que al ejecutarse:

### A) Detecte y muestre información del sistema

1. Muestra:
   - Usuario del sistema (`user.name`)
   - Zona horaria del sistema (ZoneId del sistema)
   - Hora actual del sistema **con zona** (ZonedDateTime)

Formato sugerido:

```
User: <usuario>
System Zone: <zona>
Now (system): <fecha_hora_formateada>
```

---

### B) Menú interactivo (bucle)

Implementa un menú que se repita hasta que el usuario elija salir:

- Mostrar hora actual en otra zona
- Comparar hora del sistema vs otra zona (diferencia en horas/minutos)
- Cuenta regresiva: minutos faltantes hasta una fecha/hora en otra zona
- Salir

- Debe funcionar con un bucle (while o do-while).
- Debe usar `switch` o `if/else` para decidir.

---

## Requerimientos por opción

### Opción 1 — Mostrar hora en otra zona

- Pide al usuario una zona horaria válida (ej: `America/El_Salvador`, `Asia/Manila`, `UTC`).
- Si es válida:
  - Muestra la hora actual en esa zona, usando el **mismo instante real** (no “now()” otra vez en otra zona).
- Si es inválida:
  - Muestra un mensaje claro y vuelve al menú.

**Pista:** el instante debe ser el mismo; solo cambia la representación por zona.

---

### Opción 2 — Comparar hora del sistema vs otra zona

- Pide una zona horaria.
- Muestra:
  - Hora en zona del sistema (ZonedDateTime)
  - Hora en zona objetivo
  - Diferencia en minutos (y si quieres, en horas/minutos)
- Usa clases de duración (`Duration`) o cálculo equivalente.

---

### Opción 3 — Cuenta regresiva hasta un evento (en otra zona)

- Pide:
  1. Zona horaria del evento (ej: `Europe/Madrid`)
  2. Fecha y hora del evento en formato: `yyyy-MM-dd HH:mm:ss`
- Valida:
  - zona válida
  - formato válido de fecha/hora
- Calcula cuántos **minutos faltan** desde “ahora” (instante actual) hasta el evento.
- Condicional:
  - Si ya pasó: imprimir `El evento ya ocurrió hace X minutos`.
  - Si falta: imprimir `Faltan X minutos para el evento`.

---

## Reglas y restricciones

- No usar `Date` ni `Calendar`.
- Usar al menos:
  - `ZoneId`
  - `ZonedDateTime`
  - `Instant` (o demostrar que estás usando el mismo instante)
  - `DateTimeFormatter`
- Manejo de errores obligatorio:
  - Zona inválida
  - Fecha/hora inválida
  - Entrada no numérica en el menú

---

## Extra (opcional, recomendado)

- En cada acción, imprime también el `Instant` usado (para confirmar que es el mismo instante).
- Agrega una opción `help` que muestre ejemplos de zonas válidas.
