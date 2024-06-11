# Cliente JAX-RS para Consumir API RESTful usando la implementación RESTeasy

## Descripción

Este proyecto consiste en un cliente JAX-RS desarrollado en Java SDK 21 para consumir una API RESTful. El cliente se encarga de realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad `Curso` a través de la API RESTful desplegada en el servidor.

## Características Principales

- Cliente JAX-RS para consumir servicios RESTful.
- Implementación del CRUD para la entidad `Curso`.
- Uso de RESTeasy como la implementación de JAX-RS.

## Tecnologías Utilizadas

[![Java SDK](https://img.shields.io/badge/Java-21-orange)](https://jdk.java.net/21/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-yellow)](https://maven.apache.org/)
[![RESTeasy](https://img.shields.io/badge/RESTeasy-6.2.9.Final-green)](https://resteasy.github.io/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-2024.1.1-blue)](https://www.jetbrains.com/idea/)

## Requisitos Previos

- Java SDK 21 instalado.
- Maven 3.9.6 instalado.
- API RESTful desplegada y en ejecución en `http://localhost:8080/_73_1_webapp-jaxrs/api`.

## Configuración del Entorno de Desarrollo

1. **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tuusuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Compilar el proyecto:**
    ```bash
    mvn clean install
    ```

3. **Ejecutar la aplicación:**
    - Ejecuta la clase `Main` para consumir la API RESTful.

## Estructura de Carpetas

```markdown
.
├── src
│   └── main
│       └── java
│           └── org
│               └── mbohorquez
│                   └── webapp
│                       └── jaxrs
│                           ├── models
│                           │   └── Curso.java
│                           └── Main.java
├── .gitignore
├── README.md
└── pom.xml
```

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).

