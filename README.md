# 🏨 Hotel Reservation System

A simplified hotel reservation system implemented in Java, managing users, rooms, and bookings. Built for learning core object-oriented programming and logic design.

---

## 📦 Features

- Add users and rooms
- Book rooms for a given date range
- Validate user balance and room availability
- Snapshot user and room data at booking time
- Print all users and bookings from latest to oldest
- Fully in-memory using ArrayLists (no database)

---

## 🛠️ Technologies

- Java (8+)
- No external libraries required
- Uses `ArrayList`, `Date`, and `SimpleDateFormat`

---

## 🧪 Test Scenario

The project includes a test case in `Main.java`:

- **Rooms Created**:
    - Room 1: STANDARD, 1000/night
    - Room 2: JUNIOR, 2000/night
    - Room 3: SUITE, 3000/night

- **Users Created**:
    - User 1: ID 1, balance 5000
    - User 2: ID 2, balance 10000

- **Bookings Attempted**:
    - ❌ User 1 → Room 2 for 7 nights (insufficient balance)
    - ❌ User 1 → Room 2 with invalid date range
    - ✅ User 1 → Room 1 for 1 night
    - ❌ User 2 → Room 1 (conflict)
    - ✅ User 2 → Room 3 for 1 night
    - Room 1 is later updated to SUITE with 10000/night (does not affect past bookings)

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/hotel-reservation-system.git
   cd hotel-reservation-system
