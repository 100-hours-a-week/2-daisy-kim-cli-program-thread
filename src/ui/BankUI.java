package ui;
import services.BankService;
import java.util.Scanner;

public class BankUI {
    private Scanner scanner;
    private BankService bankService;
    private boolean isFirstRun = true;

    public BankUI() {
        this.scanner = new Scanner(System.in);
        this.bankService = new BankService();
    }

    public void start() {
        if (isFirstRun) {
            System.out.println("---------------------------------");
            System.out.println("\n✨ 풀스택 은행에 오신 것을 환영합니다! ✨");
            System.out.println("\t\t무엇을 도와드릴까요?\n");
            System.out.println("---------------------------------");
            isFirstRun = false;
        }

        while (true) {
            System.out.println("\n1️⃣ 로그인\n2️⃣ 입금\n3️⃣ 출금\n4️⃣ 잔액 조회\n5️⃣ 프리미엄 혜택 보기\n6️⃣ 송금\n7️⃣ 종료");
            System.out.print("👆🏻 선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("👤 아이디 입력: ");
                    String userId = scanner.nextLine();
                    System.out.print("🔒 비밀번호 입력: ");
                    String password = scanner.nextLine();
                    bankService.login(userId, password);
                    break;
                case "2":
                    if (!bankService.isLoggedIn()) {
                        System.out.println("🔑 로그인 후 이용 가능합니다.");
                        break;
                    }
                    System.out.print("💰 입금할 금액: ");
                    int depositAmount = scanner.nextInt();
                    scanner.nextLine();
                    bankService.deposit(depositAmount);
                    break;
                case "3":
                    if (!bankService.isLoggedIn()) {
                        System.out.println("🔑 로그인 후 이용 가능합니다.");
                        break;
                    }
                    System.out.print("💸 출금할 금액: ");
                    int withdrawAmount = scanner.nextInt();
                    scanner.nextLine();
                    bankService.withdraw(withdrawAmount);
                    break;
                case "4":
                    bankService.checkBalance();
                    break;
                case "5":
                    bankService.viewPremiumBenefits();
                    break;
                case "6":
                    if (!bankService.isLoggedIn()) {
                        System.out.println("🔑 로그인 후 송금을 이용할 수 있습니다.");
                        break;
                    }
                    System.out.print("💶 송금할 금액: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("👤 송금 받을 사람 아이디: ");
                    String friendId = scanner.nextLine();
                    bankService.sendToFriends(friendId, amount);
                    break;
                case "7":
                    System.out.println("---------------------------------");
                    System.out.println("\n\t   방문해주셔서 감사합니다!");
                    System.out.println("\t\t좋은 하루 되세요 :)\n");
                    System.out.println("---------------------------------");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ 올바른 선택이 아닙니다. 다시 시도하세요.");
            }
        }
    }
}