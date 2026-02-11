# Home Maintenance Tracker

Full-stack application for tracking home maintenance tasks and reminders.

## Tech Stack

**Backend:**
- Java with Spring Boot
- MySQL database

**Frontend:** (Coming soon)
- React with TypeScript
- Next.js

## Project Structure

- `/backend` - Spring Boot application
- `/frontend` - React/Next.js application

## Database Schema

The application uses a relational MySQL database with the following tables:

### Users
- **Purpose:** Stores user accounts and authentication information
- **Key Fields:** username, email, passwordHash, notificationPreference
- **Relationships:** One-to-one with Homes (each user has one home)

### Homes
- **Purpose:** Tracks property-specific details (property type, square footage, year built, state)
- **Key Fields:** propertyType, yearBuilt, squareFootage, state
- **Relationships:** 
  - One-to-one with Users
  - One-to-many with MaintenanceItems

### MaintenanceCategories
- **Purpose:** Defines types of maintenance (HVAC, Plumbing, Lawn Care, Exterior, etc.)
- **Key Fields:** category (name)
- **Relationships:** One-to-many with MaintenanceItems

### MaintenanceItems
- **Purpose:** Represents specific maintenance items in a home (e.g., furnace, water heater, air filter)
- **Key Fields:** description, model, serialNumber, yearInstalled, maintenanceFrequencyDays
- **Relationships:** 
  - Many-to-one with Homes (many items belong to one home)
  - Many-to-one with MaintenanceCategories (many items share one category)
  - One-to-many with MaintenanceRecords
  - One-to-many with Reminders

### MaintenanceRecords
- **Purpose:** Logs completed maintenance activities with details and costs
- **Key Fields:** completedAt, completedBy, cost, notes
- **Relationships:** Many-to-one with MaintenanceItems (one item can have many records)

### Reminders
- **Purpose:** Manages automatic reminders for upcoming maintenance and tracks notification history
- **Key Fields:** dueDate, status (pending/sent/completed), sentAt
- **Relationships:** Many-to-one with MaintenanceItems (one item can have many reminders)

## Entity Relationship Diagram
![Database ERD](docs/erd-diagram.png)

## API Endpoints (34 endpoints)

### Users (5 endpoints)
- GET `/api/users` | Get all users
- GET `/api/users/{userId}` | Get user by ID
- POST `/api/users` | Create new user
- PUT `/api/users/{userId}` | Update existing user
- DELETE `api/users/{userId}` | Delete user

### Homes (5 endpoints)
- GET `/api/homes` | Get all homes
- GET `/api/homes/{homeId}` | Get home by ID
- POST `/api/homes` | Create new home
- PUT `/api/homes/{homeId}` | Update existing home
- DELETE `/api/homes/{homeId}` | Delete home

### Maintenance Categories (4 endpoints)
- GET `api/categories` | Get all categories
- GET `api/categories/{categoryId}` | Get category by ID
- POST `api/categories` | Create new category
- DELETE `api/categories/{categoryId}` | Delete category

### Maintenance Items (7 endpoints)
- GET `/api/maintenance-items` | Get all maintenance items
- GET `/api/maintenance-items/{maintenanceItemId}` | Get maintenance item by ID
- POST `/api/maintenance-items` | Create new maintenance item
- PUT `/api/maintenance-items/{maintenanceItemId}` | Update existing maintenance item
- DELETE `/api/maintenance-items/{maintenanceItemId}` | Delete maintenance item
- GET `/api/maintenance-items/home/{homeId}` | Get maintenance items by home ID
- GET `/api/maintenance-items/category/{categoryId}` | Get maintenance items by category ID

### Maintenance Records (6 endpoints)
- GET `/api/maintenance-records` | Get all records
- GET `/api/maintenance-records/{maintenanceRecordId}` | Get record by ID
- POST `/api/maintenance-records` | Create new record
- PUT `/api/maintenance-records/{maintenanceRecordId}` | Update existing record
- DELETE `/api/maintenace-records/{maintenanceRecordId}` | Delete record
- GET `/api/maintenance-item/{maintenanceItemId}` | Get record by maintenance item ID

### Reminders (7 endpoints)
- GET `/api/reminders` | Get all reminders
- GET `/api/reminders/{reminderId}` | Get reminder by ID
- POST `/api/reminders` | Create new reminder
- PUT `/api/reminders/{reminderId}` | Update existing reminder
- DELETE `/api/reminders/{reminderId}` | Delete reminder
- GET `/api/reminders/maintenence-items/{maintenanceItemId}` | Get reminders by maintenanceItemId
- GET `/api/reminders/status/{status}` | Get reminders by status


## Getting Started

See individual README files in each directory for setup instructions.