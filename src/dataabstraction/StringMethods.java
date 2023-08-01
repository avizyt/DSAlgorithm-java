package dataabstraction;

public class StringMethods {
    public static void main(String[] args) {
        String genome = "CGCCTGGCGTCTGTAC";
        String codon = genome.substring(6,9);

        System.out.println(codon);
    }
}
