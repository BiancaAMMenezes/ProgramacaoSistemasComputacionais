/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculotroco;
import java.util.Scanner;

/**
 * @author bianc
 */
public class CalculoNotasTroco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Este sistema informa quantas e quais notas entregar de troco.");
        System.out.println("Insira o troco a ser devolvido:");
        float troco = sc.nextFloat();
        CalcularNotasTroco(troco);
    }
    
    public static void CalcularNotasTroco(float troco){
        float resto = 0;
        double total_notas = 0;
        float saldo = 0;
        int contador = 0;
        
        float notas[] = new float[]{200f, 100f, 50f, 20f, 10f, 5f, 2f, 0.5f, 0.25f, 0.1f, 0.05f, 0.01f};
        
        int quantidade_notas[] = new int[]{1, 5, 10, 2, 10, 7, 100, 200, 50, 50, 50, 50};
        saldo = CacularSaldo(notas,quantidade_notas);
        
        if(troco > saldo){
            System.out.println("Saldo indisponivel em caixa, nao e possivel retornar o valor solicitado.");
            return;
        }
        
        while(contador>=0 && contador < notas.length){
            
            double quantidade_notas_necessaria = troco/notas[contador];
            
            if(quantidade_notas_necessaria < quantidade_notas[contador]){
                resto = troco % notas[contador];
                total_notas = (troco - resto) / notas[contador];
            }
            else{
                resto = troco - notas[contador]*quantidade_notas[contador];
                total_notas = quantidade_notas[contador];
            }
            
            System.out.println("A quantidade de notas de " + notas[contador] + " deve ser: " + total_notas);
            troco = resto;
            contador = contador + 1;
        }
        
    }
    
    public static float CacularSaldo(float[] notas, int[] qnt_notas){
        float total_saldo = 0;
        for(int index = 0; index < notas.length; index++){
            total_saldo = total_saldo + notas[index]*qnt_notas[index];
        }
        return total_saldo;
    }
    
}
