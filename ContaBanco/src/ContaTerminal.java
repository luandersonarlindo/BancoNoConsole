import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroUsuario = 0;
            String agencia = "";
            String nomeCliente = "";
            double saldo = 0.0;

            while (true) {
                try {
                    System.out.print("Digite o Número de Usuário: ");
                    numeroUsuario = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um número válido para o usuário.");
                }
            }

            while (true) {
                System.out.print("Digite o Número da agência: ");
                agencia = scanner.nextLine();
                if (!agencia.isEmpty()) {
                    break;
                } else {
                    System.out.println("Erro: O número da agência não pode estar vazio.");
                }
            }

            while (true) {
                System.out.print("Digite o seu nome de cliente (letras, hífen ou apóstrofo permitidos): ");
                nomeCliente = scanner.nextLine();

                if (nomeCliente.matches("[a-zA-ZÀ-ÿ '\\-]+")) {
                    break;
                } else {
                    System.out.println("Erro: O nome do cliente deve conter apenas letras, hífen ou apóstrofo.");
                }
            }

            while (true) {
                try {
                    System.out.print("Digite o seu Saldo (use vírgula para decimais): ");
                    String entradaSaldo = scanner.nextLine().replace(",", ".");
                    saldo = Double.parseDouble(entradaSaldo);

                    if (saldo < 0) {
                        System.out.println("Erro: O saldo não pode ser negativo.");
                        continue;
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um valor numérico válido para o saldo.");
                }
            }

            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco! Sua agência é %s, Conta %d, e seu saldo R$ %.2f já está disponível para saque.%n",
                    nomeCliente, agencia, numeroUsuario, saldo);
        }
    }
}
