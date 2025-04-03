import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionReport {
    public static void main(String[] args) {

        // Validar argumentos
        if (args.length == 0) {
            System.out.println("Por favor, proporcione la ruta del archivo CSV como argumento.");
            return;
        }
        String filePath = args[0];

        // Llenar la lista de transacciones
        List<Transaction> transactions = readTransactions(filePath);

        // Generar el reporte
        generateReport(transactions);
    }

    private static List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath))) {
            br.readLine();
            transactions = br.lines().map(line -> {
                String [] parts = line.split(",");
                return new Transaction(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Double.parseDouble(parts[2])
                );
            }).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo: " + e.getMessage());
        }
        return transactions;
    }

    private static void generateReport(List<Transaction> transactions) {
        double balance = transactions.stream()
                .mapToDouble(t -> t.type.equals(Constant.CREDIT) ? t.amount : -t.amount)
                .sum();

        Transaction maxTransaction = transactions.stream()
                .max(Comparator.comparingDouble(t -> t.amount))
                .orElse(null);

        long creditCount = transactions.stream().filter(t -> t.type.equalsIgnoreCase(Constant.CREDIT)).count();
        long debitCount = transactions.stream().filter(t -> t.type.equalsIgnoreCase(Constant.DEBIT)).count();

        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.printf("Balance Final: %.2f%n", balance);
        if (maxTransaction != null) {
            System.out.printf("Transacción de Mayor Monto: ID %d - %.2f%n", maxTransaction.id, maxTransaction.amount);
        }
        System.out.printf("Conteo de Transacciones: Crédito: %d Débito: %d%n", creditCount, debitCount);

    }

}