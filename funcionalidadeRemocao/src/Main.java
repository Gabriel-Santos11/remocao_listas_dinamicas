import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar no");
            System.out.println("2. Listar nos");
            System.out.println("3. Remover no de origem");
            System.out.println("4. Remover no intermediario");
            System.out.println("5. Remover no do final");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Adiciona
                    int value;
                    do {
                        System.out.print("Digite o valor do no para adicionar: ");
                        value = scanner.nextInt();
                        linkedList.addNode(value);
                        System.out.print("Deseja adicionar outro no? (s/n): ");
                    } while (scanner.next().equalsIgnoreCase("s"));
                    break;

                case 2:
                    // Lista os nos
                    System.out.println("Lista de nos:");
                    linkedList.display();
                    break;

                case 3:
                    // Remove no origem
                    linkedList.removeOrigin();
                    System.out.println("No de origem removido.");
                    break;

                case 4:
                    // Remove no intermediario
                    System.out.print("Digite o valor do no intermediario para remover: ");
                    int nodeValue = scanner.nextInt();
                    linkedList.delete(nodeValue);
                    System.out.println("No removido.");
                    break;

                case 5:
                    // Remove no final
                    linkedList.removeLast();
                    System.out.println("No do final removido.");
                    break;

                case 6:
                    // Sair
                    System.out.println("Flw");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        } while (option != 6);

        scanner.close();
    }
}
