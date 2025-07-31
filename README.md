# 📄 FileApi (Basic Auth, Java 21, MapStruct, DTO)

A simple but functional REST API for document management with file upload/download capabilities and user access control via Basic Authentication. Built with **Java 21**, **Spring Boot**, **MapStruct**, and layered DTO architecture.

---

## 🧩 Business Model

This system allows registered users to upload various types of files (PDF, DOCX, XLSX), which are stored along with metadata. Users can later list their files or download them. Ideal for document sharing, resume storage, academic records, or collaborative environments.

---

## 📁 Features

- 📤 Upload documents
- 📥 Download documents
- 📃 List documents per user
- 🔐 Basic Authentication per user
- 📦 DTOs for request/response
- 🔄 Mapping via MapStruct

---

## 🔐 Authentication

All endpoints are protected using **Basic Auth**. Each user has their own credentials and can only access their own files.

---

## 🗂️ Entities

### `User`

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}
```

### `Document`

```java
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String type;
    private String url;

    @ManyToOne
    private User owner;
}
```

---

## 📦 DTOs

### 📤 Request DTO

```java
public class DocumentRequestDTO {
    private String name;
    private String description;
    private String type;
    private MultipartFile file;
}
```

### 📥 Response DTO

```java
public class DocumentResponseDTO {
    private Long documentId;
    private String name;
    private String description;
    private String type;
    private String downloadUrl;
}
```

---

## 🔁 Mapper (MapStruct)

```java
@Mapper(componentModel = "spring")
public interface DocumentMapper {
    Document toEntity(DocumentRequestDTO dto);
    DocumentResponseDTO toDto(Document entity);
}
```

---

## 🧪 Sample JSON

### ✅ Request (Upload)

```json
{
  "name": "Invoice July",
  "description": "Monthly invoice",
  "type": "pdf",
  "file": "<binary>"
}
```

### ✅ Response

```json
{
  "documentId": 1,
  "name": "Invoice July",
  "description": "Monthly invoice",
  "type": "pdf",
  "downloadUrl": "http://localhost:8080/api/documents/1/download"
}
```

---

## 🔧 Endpoints

| Method | Endpoint                    | Description            |
|--------|-----------------------------|------------------------|
| POST   | `/api/documents`            | Upload a document      |
| GET    | `/api/documents`            | List user's documents  |
| GET    | `/api/documents/{id}`       | Get document metadata  |
| GET    | `/api/documents/{id}/download` | Download document    |

---

## 🧪 Example cURL (Basic Auth)

```bash
curl -u user1:password123 http://localhost:8080/api/documents
```
