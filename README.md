"# MediSupply

## Descripción
Sistema completo de gestión de tareas con autenticación, autorización y control de permisos basado en roles.

## Características Implementadas

### 🔐 Sistema de Autenticación y Autorización
- **Autenticación**: Login basado en email/password usando Spring Security
- **Roles**: USER y ADMIN
- **Permisos**: READ, CREATE, UPDATE, DELETE (a nivel de tareas)
- **Registro de usuarios**: Página pública para crear cuentas

### 👥 Gestión de Usuarios
- **Usuarios ADMIN pueden**:
  - Ver y gestionar todos los usuarios
  - Crear usuarios con roles específicos
  - Editar información: nombre, apellido, email, permisos
  - Activar/desactivar usuarios
  - Eliminar usuarios (con protección para el último admin)
  - Ver todas las tareas de todos los usuarios

- **Usuarios USER pueden**:
  - Solo ver y gestionar sus propias tareas
  - Los permisos controlan qué acciones pueden realizar

### 📋 Gestión de Tareas
- **Control por permisos**: Los botones se ocultan según los permisos del usuario
- **Confirmación de eliminación**: Implementado con SweetAlert2
- **Relación usuario-tarea**: Cada tarea pertenece al usuario que la creó

## Usuarios por Defecto

Al ejecutar la aplicación se crean automáticamente:

### Administrador
- **Email**: `admin@taskmanagement.com`
- **Contraseña**: `admin123`
- **Permisos**: Todos (READ, CREATE, UPDATE, DELETE)

### Usuario de Prueba
- **Email**: `user@taskmanagement.com`
- **Contraseña**: `user123`
- **Permisos**: READ, CREATE (por defecto para usuarios)

## Configuración de Base de Datos

### Variables de Entorno
```bash
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=task_management
export DB_USER=postgres
export DB_PASSWORD=tu_password
```

### Crear Base de Datos
```sql
CREATE DATABASE task_management;
```

## Ejecución

### Usando Maven Wrapper
```bash
./mvnw spring-boot:run
```

### Usando Maven
```bash
mvn spring-boot:run
```

## Acceso a la Aplicación

- **URL**: http://localhost:8080
- **Login**: Usar las credenciales por defecto mencionadas arriba

## Estructura de Permisos

### Páginas y Accesos

| Página/Acción | Usuario | Admin | Permisos Requeridos |
|---------------|---------|-------|-------------------|
| Login/Registro | ✅ | ✅ | Público |
| Dashboard | ✅ | ✅ | Autenticado |
| Ver tareas | ✅ | ✅ | PERMISSION_READ |
| Crear tareas | ✅ | ✅ | PERMISSION_CREATE |
| Editar tareas | ✅ | ✅ | PERMISSION_UPDATE |
| Eliminar tareas | ✅ | ✅ | PERMISSION_DELETE |
| Gestión usuarios | ❌ | ✅ | ROLE_ADMIN |

### Visibilidad de Tareas
- **USER**: Solo ve sus propias tareas
- **ADMIN**: Ve todas las tareas de todos los usuarios

## Tecnologías Utilizadas

- **Backend**: Spring Boot, Spring Security, JPA/Hibernate
- **Frontend**: Thymeleaf, Bootstrap 5, Font Awesome, SweetAlert2
- **Base de Datos**: PostgreSQL
- **Validación**: Spring Validation, JavaScript

## Funcionalidades Destacadas

### 🎨 Interfaz de Usuario
- Diseño moderno con Bootstrap 5
- Confirmaciones elegantes con SweetAlert2
- Iconos con Font Awesome
- Responsive design

### 🔒 Seguridad
- Contraseñas encriptadas con BCrypt
- Control de acceso basado en roles y permisos
- Validación de formularios (frontend y backend)
- Protección CSRF deshabilitada para simplicidad

### 📊 Dashboard
- Estadísticas de tareas por usuario
- Información personalizada según rol
- Accesos rápidos basados en permisos

## Próximas Mejoras Sugeridas

- [ ] Recuperación de contraseña
- [ ] Perfil de usuario editable
- [ ] Notificaciones en tiempo real
- [ ] API REST para móviles
- [ ] Roles personalizados
- [ ] Audit logs
- [ ] Configuración de temas" 

