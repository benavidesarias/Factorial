/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

/**
 *
 * @author Andres Benavides benavidesarias@misena.edu.co
 */
public class Factorial {

    /**
     * @param valor
     * @param args the command line arguments
     */
    
    private static int superAcumulador = 0;
    
    public static String mulDosPasos(String valor, int numero){
    
        String resultado = "";
        
        if(numero>=10)
        {
            int digito1 = numero%10;
            int digito2 = numero/10;
        
            String resultado1 = multiplicar(valor,digito1);
            String resultado2 = multiplicar(valor,digito2)+"0";
            
            resultado=sumar(resultado1,resultado2);
            
        }
        else
        {
            resultado = multiplicar(valor,numero);
        }
        
                        
        return resultado;
    }
    
    public static String sumar(String cadena1,String cadena2){
        
        String resultado="";
        
        int len1 = cadena1.length();
        int len2 = cadena2.length();
        int maximo=0;
        String complemento = "";
        int ban=0; //cual cadena rellenar
        
        if(len1<len2){
            maximo = len2-len1;
            len1+=maximo;
            ban=1;
        }
        else if(len1>len2)
        {
            maximo = len1-len2;
            len2+=maximo;
            ban=2;
        }
        else{
            maximo = 0;
            ban=0;
        }
        
        for(int i=0;i<maximo;i++)
        {
            complemento="0"+complemento;
            
        }
        
        if(ban==1)
            cadena1=complemento+cadena1;
        else if(ban==2)
            cadena2=complemento+cadena2;
        
        int acumulador=0;
                    
        for(int i=0;i<len1;i++){
            int num1 = Integer.parseInt(""+cadena1.charAt(len1-1-i));
            int num2 = Integer.parseInt(""+cadena2.charAt(len1-1-i));
            int suma = num1+num2+acumulador;
            int primerDig =0;

            if(suma>=10)
            {
                primerDig  = suma % 10; 
                acumulador = suma/10;

            }
            else
            {
                primerDig=suma;
                acumulador = 0;
            }

            resultado = ""+primerDig+resultado;
        }
        
        if(acumulador>0)
            resultado=""+acumulador+resultado;
        
        return resultado;
    }
    
    public static String multiplicar(String valor, int numero){
        
        String resultado = "";
        int len = valor.length();
        int acumulador=0;
        
        for(int pos=0;pos<len;pos++)
        {
            int num = Integer.parseInt(""+valor.charAt(len-pos-1));
            int mul = num*numero+acumulador;
            int primerDig=0;
            
            if(mul>=10)
            {
                primerDig  = mul % 10; 
                acumulador = mul/10;
            }
            else
            {
                primerDig=mul;
                acumulador = 0;
            }
            
            resultado=""+primerDig+resultado;
        }
        
        superAcumulador = acumulador;
        if(acumulador>0)
            resultado=""+acumulador+resultado;
        
        return resultado;
        
    }
    
    public static String factorial(int numero)
    {
        String resultado=""+numero;
        numero--;
        
        for(int i=numero;i>1;i--)
        {
            //resultado=mulDosPasos(resultado,i);
            resultado=multiplicar(resultado,i);
        }
                
        return resultado;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        // Factorial de 1000
        // El valor se puede comprobar en http://www.dcode.fr/factorial
                
        String resultado= factorial(1000);
        
        System.out.println(resultado);
        
    }
    
}