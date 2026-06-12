🛡️ Data Masking & Tokenization System


🔐 Secure Sensitive Data Using Data Masking \& Tokenization

Protecting personally identifiable information (PII) through masking techniques and secure token generation.


📖 Overview

This project implements Data Masking and Data Tokenization techniques to protect sensitive information such as:

* 📧 Email Addresses
* 🆔 Aadhaar Numbers
* 📱 Phone Numbers
* 🔑 Passwords \& Personal Data

The system provides:
✅ Data Masking for secure display of sensitive information

✅ Tokenization using UUID-based tokens

✅ SQLite database storage for token mappings

✅ Secure retrieval (Detokenization) of original values

✅ JDBC integration with SQLite database

The project was developed using Java, JDBC, and SQLite as part of a Computer Science Engineering academic project focused on data privacy and security.

🚀 Features :

🔒 Data Masking

Masks sensitive information while maintaining readability.

Examples:
Original Data			Masked Data

shivam@gmail.com		s\*\*\*\*\*\*\*\*\*\*\*m@gmail.com

765787614822			7657\*\*\*\*\*\*22

7261827670			72\*\*\*\*\*\*70

Implemented in:
* DataMasking.java


🎟️ Data Tokenization

Generates unique UUID-based tokens and securely stores mappings inside SQLite.

Example:
Original Data:

shivam password - 72%eh\*dwd9

Generated Token:

8155d7e8-2389-46f5-b87b-597e6fc12ea9

Implemented in:
* DataTokenization.java


🗄️ SQLite Token Vault

Creates and manages a secure token storage database.

Database Schema:

</>SQL

CREATE TABLE tokens (

&#x20;   token TEXT PRIMARY KEY,

&#x20;   original TEXT

);

Implemented in:
* DatabaseSetup.java


🏗️ System Architecture
┌───────────────────┐
│  User Input Data  │
└─────────┬─────────┘
          │
          ▼
┌───────────────────┐
│ Sensitive Data    │
│ Identification    │
└───────┬─────┬─────┘
        │     │
        │     │
        ▼     ▼
┌─────────────┐ ┌─────────────┐
│ Data        │ │ Tokenization│
│ Masking     │ │ Engine      │
└──────┬──────┘ └──────┬──────┘
       │               │
       ▼               ▼
 ┌────────────────────────┐
 │ SQLite Token Vault     │
 └──────────┬─────────────┘
            ▼
 ┌────────────────────────┐
 │ Secure Data Access     │
 └────────────────────────┘

The architecture follows a pipeline of sensitive-data detection, masking/tokenization, and secure storage.


📂 Project Structure

Data-Masking-Tokenization/

│

├── DatabaseSetup.java

├── DataMasking.java

├── DataTokenization.java

│

├── tokens.db

│

├── README.md

│

└── PROJECT REPORT ON DATA MASKING AND TOKENIZATION.doc



⚙️ Technologies Used

Technology		Purpose

Java				  Application Development

JDBC			    Database Connectivity

SQLite			  Token Storage

UUID			    Token Generation

SQL				    Data Persistence



🔧 Installation

Step 1: Clone Repository

git clone https://github.com/yourusername/data-masking-tokenization.git

cd data-masking-tokenization



Step 2: Download SQLite JDBC Driver

Download the JDBC JAR:

Official Repository:

https://github.com/xerial/sqlite-jdbc

Place:

sqlite-jdbc-x.x.x.jar

inside:

project/lib/



Step 3: Compile

</> Bash

javac -cp ".;sqlite-jdbc-3.50.2.0.jar" \*.java



Linux/Mac:

</> Bash

javac -cp ".:sqlite-jdbc-3.50.2.0.jar" \*.java



Step 4: Create Database

</> Bash

java -cp ".;sqlite-jdbc-3.50.2.0.jar" DatabaseSetup



Output:

Database setup completed!





▶️ Usage:

1️⃣ Data Masking



Run:

</> Bash

java DataMasking



Input:



Enter your mail address:

shivamnarayan2021@gmail.com



Enter your Aadhar number:

765787614822



Enter your phone number:

7261827670



Output:



Masked Email:

s\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*m@gmail.com



Masked Aadhar:

7657\*\*\*\*\*\*22



Masked Phone:

72\*\*\*\*\*\*70



2️⃣ Data Tokenization



Run:

</> Bash

java -cp ".;sqlite-jdbc-3.50.2.0.jar" DataTokenization



Menu:



1\. Tokenize Data

2\. Detokenize Data

3\. Exit



Tokenization

Enter data to tokenize:

MySecretPassword



Generated Token:

8155d7e8-2389-46f5-b87b-597e6fc12ea9



Detokenization

Enter token:

8155d7e8-2389-46f5-b87b-597e6fc12ea9

Original Data:

MySecretPassword



🧪 Testing



The project was tested using multiple scenarios:



Test ID		Test Case

T01			Email Masking

T02			Phone Masking

T03			Tokenization

T04			Access Verification

T05			Token Reversal



All test cases passed successfully according to the project verification plan.



🔐 Security Benefits



Data Masking:

✔ Prevents unauthorized viewing of sensitive data



✔ Useful in testing environments



✔ Preserves data format



Tokenization:

✔ Original values never exposed



✔ Secure UUID-based mapping



✔ Reduced risk during database breaches



✔ Supports compliance requirements



The project aligns with security practices such as RBAC, audit logging, and privacy-preserving data protection.



📈 Future Improvements

* Dynamic Data Masking
* AES Encryption for token vault
* Cloud Database Support
* REST API Integration
* Role-Based Access Control (RBAC)
* GDPR \& HIPAA Compliance Modules
* Machine Learning-based Sensitive Data Detection



Future enhancements identified in the project report include dynamic masking, compliance automation, and intelligent data classification.



👨‍💻 Author

\*\*Shivam Narayan



⭐ If you found this project useful, consider giving it a star!



🔒 Secure Data • Protect Privacy • Build Trust



