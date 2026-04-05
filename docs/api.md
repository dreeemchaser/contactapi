# API Reference

The Contact API provides RESTful endpoints for managing contacts. Base URL: `http://localhost:8080/contacts`

## Endpoints

### GET /contacts
Retrieve a paginated list of contacts.

**Parameters:**
- `page` (optional): Page number (default 0)
- `size` (optional): Page size (default 10)

**Response:**
```json
{
  "content": [
    {
      "id": "uuid",
      "name": "John Doe",
      "email": "john@example.com",
      "title": "Manager",
      "phone": "123-456-7890",
      "address": "123 Main St",
      "status": "active",
      "photoURL": "http://localhost:8080/contacts/image/uuid.jpg"
    }
  ],
  "pageable": {...},
  "totalElements": 1
}
```

### GET /contacts/{id}
Retrieve a single contact by ID.

**Response:** Contact object or 404 if not found.

### POST /contacts
Create a new contact.

**Request Body:**
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "title": "Developer",
  "phone": "098-765-4321",
  "address": "456 Elm St",
  "status": "active"
}
```

**Response:** Created contact object.

### PUT /contacts/{id}
Update an existing contact.

**Request Body:** Contact object with updated fields.

**Response:** Updated contact object.

### DELETE /contacts/{id}
Delete a contact by ID.

**Response:** 204 No Content.

### POST /contacts/{id}/photo
Upload a photo for a contact.

**Content-Type:** multipart/form-data

**Parameters:**
- `file`: Image file

**Response:** Photo URL.

### GET /contacts/image/{filename}
Retrieve a contact's photo.

**Response:** Image file.

## Error Responses

- 400 Bad Request: Invalid input
- 404 Not Found: Contact not found
- 500 Internal Server Error: Server error

## Authentication

Not implemented yet. Add JWT or OAuth2 for production.