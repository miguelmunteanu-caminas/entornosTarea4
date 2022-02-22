
/**
 * Clase que genera todos los números primos de 1 hasta un número máximo especificado por el usuario.
 * @author Miguel Ángel Munteanu
 * @version 4.5.1
 */


import java.util.Scanner;

public class CribaBien {

    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        int i, j, dim, cuenta;
        boolean[] esPrimo;

        if (max >= 2) {
            // Declaracines
            dim = max + 1; // Tamaño del array
            esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++) {
                esPrimo[i] = true;
            }
            // Eliminar el 0 y el 1, que son no primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2*i; j < dim; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }
            // Cuántos primos hay
            cuenta = 0;

            for (i = 0; i < dim; i++) {
                if (esPrimo[i]) {
                    cuenta = cuenta + 1;
                }
            }

            // @value cuenta

            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];

            for (i = 0; i < dim; i++) {
                j = 0;

                if (esPrimo[i]) {
                    primos[j+1] = i;
                }
        }
            return primos; // max < 2 || @value primos
        } else {
            return new int[0];
            // Vector vacío
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número para la criba de Erastótenes");

        int dato = teclado.nextInt();
        int vector[] = new int[dato];

        System.out.println("\nVector inicial hasta: " + dato);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
                System.out.println(i + 1 + "\t");
            }
        }

        vector = generarPrimos(dato);

        System.out.println("\nVector de primos hasta: "+dato);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
                System.out.println(vector[i] + "\t");
            }
        }
    }
}
