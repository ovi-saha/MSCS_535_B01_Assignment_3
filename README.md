# MSCS_535_B01_Assignment_3
This Repo is Assignment 3 for Secure Software Development (MSCS-535-B01)

# Secure Software Development – Java Implementation

## Overview

This project contains two Java programs that demonstrate basic security concepts used in secure software development. The first program demonstrates how to protect the Application Layer (Layer 7) of the OSI model from common security attacks such as SQL injection and malicious input. The second program demonstrates the implementation of One-Time Pad (OTP) encryption to secure a message through encryption and decryption.

These examples illustrate how security techniques can be implemented directly in software to prevent attacks and protect sensitive information.

---

# Question 1: Application Layer Security (Layer 7 Protection)

## Description

The Application Layer (Layer 7) of the OSI model is responsible for interacting directly with user applications and services. Because it processes user input and communicates with backend systems such as databases, it is often a target for attacks, including:

* SQL Injection
* Malicious user input
* Unauthorized data access

The Java program demonstrates two important techniques to protect the application layer:

1. **Input Validation** – Ensures only valid characters are accepted from users.
2. **Prepared Statements** – Prevents SQL injection by separating SQL commands from user input.

## Security Mechanisms Implemented

* Input validation using regular expressions
* Parameterized SQL queries using `PreparedStatement`
* Exception handling for database errors

## Code Explanation

The program performs the following steps:

1. Accepts user input.
2. Validates the input to ensure it contains only letters and spaces.
3. Connects to a MySQL database using JDBC.
4. Uses a prepared SQL statement to safely query the database.
5. Displays the result if a matching user is found.

These practices help prevent attackers from injecting malicious SQL code into the database query.


## How to Compile and Run
- Create a database
- Change the database user and password according to your system 
Then,

Compile:

```
javac Question1.java
```

Run (with MySQL connector):

```
java -cp ".:mysql-connector-j-8.0.32.jar" Question1
```

---

# Question 2: One-Time Pad Encryption

## Description

The One-Time Pad (OTP) is a cryptographic technique used to securely encrypt messages. It is considered theoretically unbreakable when implemented correctly.

OTP works by combining each character of the message with a randomly generated key of the same length.

## Encryption Formula

Encryption uses the following formula:

```
Cipher = (Message + Key) mod 26
```

## Decryption Formula

Decryption reverses the process:

```
Message = (Cipher - Key + 26) mod 26
```

## Program Functionality

The Java program performs the following operations:

1. Accepts the plaintext message:

   ```
   MY NAME IS UNKNOWN
   ```
2. Generates a random key with the same length as the message.
3. Encrypts the message using the generated key.
4. Decrypts the encrypted message using the same key.
5. Displays the key, cipher text, and decrypted text.

## Example Output

```
Key:       ID IEJY FL ZTGISRD
Cipher:    UB VEVC ND TGQVGNQ
Decrypted: MY NAME IS UNKNOWN
```

Each time the program runs, the key and cipher text will change because the key is randomly generated.

## Security Properties of One-Time Pad

OTP is secure only if the following conditions are satisfied:

* The key is truly random.
* The key is the same length as the message.
* The key is used only once.
* The key is kept completely secret.

If these conditions are met, OTP encryption is mathematically unbreakable.

## How to Compile and Run

Compile:

```
javac Question2.java
```

Run:

```
java Question2
```

---

# Conclusion

This project demonstrates two important security concepts in software development:

1. **Application Layer Protection**

   * Prevents attacks such as SQL injection and malicious input.
   * Uses secure database interaction techniques.

2. **Data Encryption**

   * Uses One-Time Pad encryption to protect sensitive information.
   * Ensures secure communication through encryption and decryption.

Together, these techniques help improve software security and reduce application vulnerabilities.

---

