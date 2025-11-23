# Sistema de Coordinación Estratégica del Cuerpo de Cazadores - Castillo Infinito

## Requisitos
- Java 17
- Maven
- MySQL 8.x
- IDE (IntelliJ/NetBeans/VSCode)
- Postman o curl

## Cómo ejecutar
1. Crear DB: `CREATE DATABASE castillo_infinito;`
2. Configurar `src/main/resources/application.properties` con credenciales MySQL.
3. (Opcional) Colocar `schema.sql` y `data.sql` en `src/main/resources`.
4. Compilar y ejecutar:
   - `mvn clean package`
   - `mvn spring-boot:run`

## Endpoints obligatorios
1. GET `/api/pilares/{id}` - Obtener información completa de un Pilar.
2. GET `/api/inteligencia/triangulacion` - Obtener triangulación estimada.
3. POST `/api/pilares/actualizar-posicion` - Registrar/actualizar posición del pilar.
4. POST `/api/mensajes` - Registrar mensaje táctico fragmentado.
5. PUT `/api/mensajes/{id}/reconstruir` - Reconstruir un mensaje.

## Scripts
- `schema.sql` crea tablas.
- `data.sql` inserta pilares iniciales según enunciado.

