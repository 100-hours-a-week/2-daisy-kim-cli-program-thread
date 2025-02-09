
### 💶 콘솔 은행 시스템
---
### 🚀 프로젝트 개요
Java 기반의 콘솔 환경(CLI)에서 실행되는 은행 시스템입니다. 사용자는 로그인 후 입금, 출금, 송금, 잔액 조회 등의 기본적인 은행 기능을 이용할 수 있습니다. 또한 보유 잔액이 1,000,000원 이상이 되면 프리미엄 계좌로 전환되어, 추가 혜택을 확인할 수 있습니다.
<br>

### 📌 기능 목록
- **로그인 / 로그아웃**
- **입금 / 출금**
- **잔액 조회**
- **송금 기능** 
- **프리미엄 계좌 업그레이드** (보유 잔액 1,000,000원 이상 시 적용)
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

### 📌 **다이어그램** <br>
<img src="https://github.com/user-attachments/assets/d34e691e-487c-4cce-a72f-430cb3e16223" width="400"/>


### 📌 **시연 영상** <br>

https://github.com/user-attachments/assets/27c254d3-592b-4226-84d1-b309148387a6

