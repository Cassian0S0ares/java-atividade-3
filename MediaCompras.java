import java.util.Scanner;

public class MediaCompras {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int totalProdutos = 3;

        for (int i = 1; i <= totalProdutos; i++){
            System.out.println("Digite o valor do "+ i +" produto");
            double valores = scanner.nextDouble();
            soma += valores;
        }

        double media = soma / totalProdutos;
        System.out.println("Média = "+ media);
        if (media >= 50){
            System.out.println("Ta caro");
        }else{
            System.out.println("Ta barato");
        }
    }
}