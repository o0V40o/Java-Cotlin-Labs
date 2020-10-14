import java.util.Scanner;


public class SimpleAlgorithms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Задание №1
/*
        int size = 10;
        int[] array = new int[size];

        System.out.print("Исходный массив:");
        for(int i=0; i<size; ++i){
            array[i] = (int) (Math.random() * 10);
            System.out.print(" " + array[i]);
        }

        int min = array[0], max = array[0], avg = array[0];

        for(int i=1; i<size; ++i){
            if(array[i] < min){
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
            avg += array[i];
        }

        System.out.print("\n\nМинимальное: " + min + "\nМаксимальное: " + max + "\nСреднеее: " + avg);
*/
        //Задание №2
/*
        System.out.print("Введите число->");
        int value = scanner.nextInt();

        System.out.print("Введите степень->");
        int power = scanner.nextInt();

        int result = 0;
        for(int i=1; i <= value; ++i){
            result += (int) Math.pow(i, power);
        }

        System.out.print("\nАлгебраическая сумма: " + result);
*/
        //Задание №3
/*
        int size = 10;
        int[] array = new int[size];

        System.out.print("Исходный массив:");
        for(int i=0; i<size; ++i){
            array[i] = (int) (Math.random() * 10);
            System.out.print(" " + array[i]);
        }

        for(int i=1; i<size; ++i){
            for(int j=i-1; j>=0; --j){
                if(array[j+1] < array[j]){
                    //Эквивалент swap
                    array[j] ^= array[j+1];
                    array[j+1] ^= array[j];
                    array[j] ^= array[j+1];
                }
                else{
                    break;
                }
            }
        }

        System.out.print("\nОтсортированный массив:");
        for(int i=0; i<size; ++i){
            System.out.print(" " + array[i]);
        }
*/
        //Задание №4
/*
        System.out.println("Простые числа от 2 до 100:");

        boolean SimpleNumberFLG;
        for(int i=2; i<100; ++i){
            SimpleNumberFLG = true;
            for(int j=2; (j*j)<=i; ++j) {
                if((i%j) == 0) {
                    SimpleNumberFLG = false;
                    break;
                }
            }
            if(SimpleNumberFLG){
                System.out.println(i);
            }
        }
*/
        //Задание №5
/*
        System.out.print("Введите число->");
        int order = scanner.nextInt();

        //Запоминание предыдущих чисел
        int[] prev = new int[2];
        prev[0] = 1;
        prev[1] = 1;

        for(int i=2; i<=order; ++i){
            prev[i%2] = prev[0] + prev [1];
        }

        System.out.print("Число фибоначи порядка " + order + ": " + prev[(order-1)%2]);
*/
        //Задание 6
/*
        int[] array = {2, 9, 2, 7, 1, 4, 5, 6, 2, 4};
        int remove = 2;

        int removeCounter = 0;
        for(int i=0; i<array.length; ++i){
            if(array[i]==remove){
                ++removeCounter;
            }
        }

        System.out.print("\nМассив без " + remove + ":");
        int j=-1;
        int[] arrayWithout = new int[array.length - removeCounter];
        for(int i=0; i<array.length; ++i){
            if(array[i] != remove){
                arrayWithout[++j] = array[i];
                System.out.print(" " + arrayWithout[j]);
            }
        }
*/
        //Задание №7
/*
        int[] array = {2, 9, 2, 7, 1, 4, 5, 6, 2, 4};

        boolean InterrFLG;
        for(int i=0; i<array.length; ++i){
            InterrFLG = true;
            for(int j=0; j<array.length; ++j){
                if(i==j){
                    continue;
                }
                if(array[i] == array[j]){
                    InterrFLG = false;
                    break;
                }
            }
            if(InterrFLG){
                System.out.println("Первое уникальное число массива: " + array[i]);
                break;
            }
        }
*/
        //Задание №8
/*
        int[] array = {4, 3, 0, 3, 4, 2, 4, 2, 5, 2, 5, 4, 1};
        int quantity = 3;

        //Ячейка [0] - для числа, [1] - для кол-ва его вхождений
        int[][] repeatQuantityArray = new int[10][2];
        int k=0;
        boolean interruptFLG;

        for(int i=0; i<array.length; ++i){
            //Отсекаем повторяющиеся числа в массиве подсчёта
            //Запускаем проверку после заполнения первой ячейки
            interruptFLG = false;
            if(k>0){
                for(int j=0; j<k; ++j){
                    if(array[i] == repeatQuantityArray[j][0]) {
                        interruptFLG = true;
                        break;
                    }
                }
                if(interruptFLG){
                    continue;
                }
            }
            for(int j=0; j<array.length; ++j){
                if(i != j){
                    if(array[i] == array[j]){
                        ++repeatQuantityArray[k][1];
                    }
                }
            }
            repeatQuantityArray[k][0] = array[i];
            ++k;
        }

        for(int i=0; i<k; ++i){
            for(int j=i-1; j>=0; --j){
                if(repeatQuantityArray[j+1][1] > repeatQuantityArray[j][1]){
                    //Эквивалент swap
                    repeatQuantityArray[j][0] ^= repeatQuantityArray[j+1][0];
                    repeatQuantityArray[j+1][0] ^= repeatQuantityArray[j][0];
                    repeatQuantityArray[j][0] ^= repeatQuantityArray[j+1][0];

                    repeatQuantityArray[j][1] ^= repeatQuantityArray[j+1][1];
                    repeatQuantityArray[j+1][1] ^= repeatQuantityArray[j][1];
                    repeatQuantityArray[j][1] ^= repeatQuantityArray[j+1][1];
                }
                else{
                    break;
                }
            }
        }

        if(k<quantity){
            quantity = k;
        }

        System.out.println("\nСамые часто встречающиеся элементы:");
        for(int i=0; i<quantity; ++i){
            System.out.print(repeatQuantityArray[i][0]+": "+(repeatQuantityArray[i][1]+1)+" раз(а)\n");
        }
*/
        scanner.close();
    }
}
