
### 🏦 CLI Bank System
---
### 🚀 프로젝트 개요
Java 기반의 콘솔 환경(CLI)에서 동작하는 은행 시스템입니다.
사용자는 로그인 후, 입금 / 출금 / 송금 등 기본적인 은행 기능을 이용할 수 있습니다. 또한 일정 금액 이상 입금하면 프리미엄 계좌로 전환되어 특별한 혜택을 확인할 수 있는 기능을 구현하였습니다.

<br>

### 📌 기능 목록
- **로그인 / 로그아웃**
- **입금 / 출금**
- **잔액 조회**
- **송금 기능** 
- **프리미엄 계좌 업그레이드** (보유 잔액 1,000,000원 이상일 때 자동 업그레이드)
- **프리미엄 혜택 조회**

<br>

### 📂 프로젝트 구조
```
📦 BankSystem
 ┣ 📂 src
 ┃ ┣ 📂 models
 ┃ ┃ ┣ 📜 Account.java
 ┃ ┃ ┣ 📜 AccountHolder.java
 ┃ ┃ ┣ 📜 PremiumAccount.java
 ┃ ┃ ┣ 📜 PremiumBenefits.java
 ┃ ┃ ┗ 📜 User.java
 ┃ ┣ 📂 services
 ┃ ┃ ┗ 📜 BankService.java
 ┃ ┣ 📂 ui
 ┃ ┃ ┗ 📜 BankUI.java
 ┃ ┗ 📜 Main.java
 ┗ 📜 README.md
```

<br>

### 📌 클래스 설명
| 클래스 | 설명 |
|--------|-------------------------------------------------|
| `Account` | 기본 계좌 클래스 (부모 클래스) |
| `AccountHolder` | 일반 계좌 (송금 기능 지원) |
| `PremiumAccount` | 프리미엄 계좌 (특별 혜택 제공) |
| `PremiumBenefits` | 프리미엄 계좌의 혜택 관리 |
| `User` | 사용자 정보 관리 (로그인 기능 포함) |
| `BankService` | 은행 서비스 (입금, 출금, 송금, 프리미엄 전환 등) |
| `BankUI` | CLI 기반 사용자 인터페이스 |
| `Main` | 프로그램 실행을 담당 |

<br>

### 📌 **시연 영상** <br>

https://github.com/user-attachments/assets/27c254d3-592b-4226-84d1-b309148387a6

