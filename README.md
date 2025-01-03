# Foro Alura

**Foro Alura** es una aplicación que permite gestionar tópicos en un foro mediante una API REST construida con **Spring Boot**. El objetivo de esta API es permitir la creación, lectura, actualización y eliminación (CRUD) de los tópicos de forma sencilla, siguiendo las mejores prácticas del modelo REST.

## Funcionalidades

### **CRUD de Tópicos**

- **Crear** un nuevo tópico.
  
- **Leer** todos los tópicos o uno específico.
  
- **Actualizar** un tópico existente.
  
- **Eliminar** un tópico.

### **Rutas de la API**

Las rutas de la API están implementadas siguiendo las mejores prácticas del modelo REST. Las rutas disponibles son:

- `POST /login`: Loguea al usuario previamente registrado en la base de datos.

- `POST /topicos`: Crea un nuevo tópico.
  
- `GET /topicos`: Muestra todos los tópicos.
  
- `GET /topicos/{id}`: Muestra un tópico específico según su ID.
  
- `PUT /topicos`: Actualiza un tópico existente según su ID.
  
- `DELETE /topicos/{id}`: Elimina un tópico según su ID.

### **Autenticación y Autorización**

Se implementa un servicio de autenticación/autorización que restringe el acceso a los tópicos y permite realizar las operaciones solo a los usuarios autorizados.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación utilizado para desarrollar la API.
  
- **Spring Boot**: Framework utilizado para crear la API REST.
  
- **Spring Security**: Implementación de seguridad para manejar la autenticación y autorización.
  
- **JPA / Hibernate**: Utilizado para la persistencia de datos en una base de datos.
  
- **MySQL**: Base de datos relacional utilizada para almacenar los tópicos.

## Requisitos

- **Java 11 o superior**
- **Maven**
- **MySQL** (o cualquier otra base de datos compatible)

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/foro-alura.git
  
2. Navega al directorio del proyecto:
   
     ```bash
    cd foro-alura

3. Configura tu base de datos MySQL y ajusta las credenciales en el archivo application.properties:

    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/foro_alura
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña

4. Compila y ejecuta el proyecto con Maven:
   
   ```bash
    mvn clean install
    mvn spring-boot:run

5. Accede a la API en http://localhost:8080.

## Uso

Para interactuar con la API, puedes usar herramientas como Postman o curl. 

IMPORTANTE: Debes crear un usuario en tu base de datos local, con la clave encriptada en el formato BCrypt, y luego acceder al endpoint '/login' con tu usuario y tu clave. Esto te devolverá un token que deberás enviar en cada petición que realices a la API. El token dura 2 horas.
Aquí hay algunos ejemplos de uso:

Crear un nuevo tópico:

    POST /topicos
    Content-Type: application/json
    Body:
    {
        "titulo": "Nuevo Tópico",
        "mensaje": "Este es el mensaje del nuevo tópico",
        "nombreCurso": "Curso de Spring"
    }
    
Mostrar todos los tópicos:

    GET /topicos
    
Mostrar un tópico específico:

    GET /topicos/{id}

Actualizar un tópico:

    PUT /topicos
    Content-Type: application/json
    Body:
    {    
        "id": 1,
        "titulo": "Tópico Actualizado",
        "mensaje": "Este es el mensaje actualizado",
        "nombreCurso": "Curso de Spring Avanzado"
    }
    
Eliminar un tópico:

    ```bash
    DELETE /topicos/{id}

## Autor
Nombre: Paula Singh

Correo Electrónico: paulasofiasingh@gmail.com
