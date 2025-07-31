# 📁 DocuGestor

> Sistema de gestión documental para entidades públicas del Perú. Permite registrar, consultar y descargar documentos administrativos (como informes, oficios y reportes), con filtros por unidad, tipo y fecha.

---

## 🎯 Objetivo

Centralizar el almacenamiento y consulta de documentos internos escaneados de una entidad pública, para mejorar la organización, trazabilidad y accesibilidad de la información.

---

## 🧱 Arquitectura del Proyecto

```
Java 21 + Spring Boot 3
│
├── Controller         # Endpoints REST
├── Service            # Lógica de negocio
├── Repository         # Acceso a datos (JPA)
├── Entity             # Modelo Documento
├── DTO                # Transferencia segura de datos
├── Mapper             # MapStruct para conversión Entity <-> DTO
├── Exception Handler  # Manejo global de errores
└── Security Config    # Seguridad básica con Spring Security
```

---

## 📦 Tecnologías Usadas

* **Java 21**
* **Spring Boot 3**
* **Spring Web**
* **Spring Data JPA**
* **PostgreSQL**
* **Spring Security**
* **Spring Validation**
* **MapStruct**
* **Lombok**
* **Swagger (springdoc-openapi)**

---

## 🗃️ Base de datos: PostgreSQL

### Tabla `documento`

```sql
CREATE TABLE documento (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255),
  tipo VARCHAR(50),
  unidad VARCHAR(100),
  fecha DATE,
  observaciones TEXT,
  ruta_archivo VARCHAR(255)
);
```

---

## 🔐 Seguridad

* Autenticación básica (Basic Auth).
* Los endpoints de carga y eliminación de documentos requieren credenciales.

---

## 📂 Endpoints REST

### 1. Subir documento

`POST /api/documentos`

* multipart/form-data: `archivo`, `nombre`, `tipo`, `unidad`, `fecha`, `observaciones`

### 2. Listar documentos

`GET /api/documentos`

* Filtros opcionales: `tipo`, `unidad`, `fechaDesde`, `fechaHasta`

### 3. Descargar documento

`GET /api/documentos/{id}/descargar`

### 4. Eliminar documento

`DELETE /api/documentos/{id}`

---

## 📁 Estructura de Archivos Subidos

```
/uploads/
  └── documentos/
        └── 2025/
              └── informe-juntos-lima.pdf
```

---

## 🧪 Buenas prácticas aplicadas

* Uso de capas separadas (Controller-Service-Repository).
* Validaciones con `@Valid`.
* DTOs para ocultar entidad interna.
* Mapeo automático con **MapStruct**.
* Documentación REST con Swagger.
* Seguridad con Spring Security.
* Registros organizados por año.

---

## 🚀 Posibles mejoras futuras

* Firma digital de documentos.
* Integración con MinIO o Amazon S3.
* Auditoría de acciones por usuario.
* Generación de reportes en PDF.

---

## 🧠 Inspirado en

* Estándares de gobierno digital (Estonia, Chile, España).
* Necesidades reales de instituciones como MIDIS, UGEL, Minsa.

---

## 📌 Autor

**Alexis** – Práctica profesional orientada a soluciones reales del Estado Peruano.

