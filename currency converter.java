import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    // Method to get predefined exchange rates relative to USD
    public static Map<String, Double> getExchangeRates() {
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);    // US Dollar
        exchangeRates.put("EUR", 0.85);   // Euro
        exchangeRates.put("GBP", 0.75);   // British Pound
        exchangeRates.put("JPY", 110.0);  // Japanese Yen
        exchangeRates.put("CAD", 1.25);   // Canadian Dollar
        exchangeRates.put("AUD", 1.35);   // Australian Dollar
        exchangeRates.put("CHF", 0.92);   // Swiss Franc
        exchangeRates.put("CNY", 6.45);   // Chinese Yuan
        exchangeRates.put("INR", 74.0);   // Indian Rupee
        exchangeRates.put("BRL", 5.2);    // Brazilian Real
        // Add more currencies as needed
        return exchangeRates;
    }
    
    // Method to get currency symbols for display purposes
    public static Map<String, String> getCurrencySymbols() {
        Map<String, String> currencySymbols = new HashMap<>();
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("JPY", "¥");
        currencySymbols.put("CAD", "C$");
        currencySymbols.put("AUD", "A$");
        currencySymbols.put("CHF", "CHF");
        currencySymbols.put("CNY", "¥");
        currencySymbols.put("INR", "₹");
        currencySymbols.put("BRL", "R$");
        // Add more symbols as needed
        return currencySymbols;
    }
    
    // Method to display the list of supported currencies
    public static void displaySupportedCurrencies(Map<String, Double> exchangeRates) {
        System.out.println("Supported Currencies:");
        for (String currencyCode : exchangeRates.keySet()) {
            System.out.println("- " + currencyCode);
        }
        System.out.println();
    }
    
    // Method to calculate exchange rate from base currency to target currency
    public static double getExchangeRate(Map<String, Double> exchangeRates, String base, String target) {
        if (base.equals(target)) {
            return 1.0;
        }
        
        Double rateBase = exchangeRates.get(base);
        Double rateTarget = exchangeRates.get(target);
        
        if (rateBase == null || rateTarget == null) {
            return -1.0; // Return -1 to indicate an error
        }
        
        return rateTarget / rateBase;
    }
    
    public static void main(String[] args) {
        Map<String, Double> exchangeRates = getExchangeRates();
        Map<String, String> currencySymbols = getCurrencySymbols();
        
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Display supported currencies
        displaySupportedCurrencies(exchangeRates);
        
        // Step 2: Currency selection
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Unsupported base currency: " + baseCurrency);
            return;
        }
        
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        if (!exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Unsupported target currency: " + targetCurrency);
            return;
        }
        
        // Step 3: Amount input
        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount should be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for amount.");
            return;
        }
        
        // Step 4: Currency conversion
        double exchangeRate = getExchangeRate(exchangeRates, baseCurrency, targetCurrency);
        if (exchangeRate == -1.0) {
            System.out.println("Error calculating exchange rate. Please check the currency codes.");
            return;
        }
        
        double convertedAmount = amount * exchangeRate;
        
        // Step 5: Display result
        String baseSymbol = currencySymbols.getOrDefault(baseCurrency, baseCurrency);
        String targetSymbol = currencySymbols.getOrDefault(targetCurrency, targetCurrency);
        
        System.out.printf("\n%s%.2f %s is equal to %s%.2f %s%n",
                          baseSymbol, amount, baseCurrency, 
                          targetSymbol, convertedAmount, targetCurrency);
        
        scanner.close();
    }
}
