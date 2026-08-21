import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

class Produto {
    private List<Double> valores;
    private String valorFormatado; 

    public Produto(){
        this.valores = new ArrayList<>();
    }

    public void adicionarValor(double valor){
        valores.add(valor);
    }
    
    public double calcularMedia(){
        double soma = 0;
        for (double valor: valores){
            soma += valor;
        }
        double media = soma / valores.size();
        DecimalFormat df = new DecimalFormat("0.00");
    
        this.valorFormatado = df.format(media); 
        return media;
    }

    
    public String getValorFormatado() {
        return valorFormatado;
    }

    public boolean isBarato(){
    
        return calcularMedia() >= 50; 
    }
}

class LeitorDeValores{
    private Scanner scanner;
    public LeitorDeValores(){
        this.scanner = new Scanner(System.in);
    }
    public void preencherValores(Produto produto, int totalValores){
        for (int i = 1; i <= totalValores; i++){
            System.out.print("Digite o valor do produto " + i + ": ");
            double valor = scanner.nextDouble();
            produto.adicionarValor(valor);
        }
    }
    public void fechar(){
        scanner.close();
    }
}

public class NovaMedia {
    public static void main (String[] args){
        Produto produto = new Produto();
        LeitorDeValores leitor = new LeitorDeValores();
        
        leitor.preencherValores(produto, 3);
        leitor.fechar();
        produto.calcularMedia(); 
        System.out.print("Média de valor dos produtos: " + produto.getValorFormatado());
        
        if (produto.isBarato()){
             System.out.println("  Tá Carinho");
        } else {
           System.out.println(" -> Tá suave");
        }
    }   
}
