package ru.itmo.vector;

public class Main {

    public static void main(String[] args) {
        Vector[] randomVectors = Vector.randVectors(5);

        for (Vector randomVector : randomVectors) {
            System.out.println(randomVector.toString());
        }

        System.out.print('\n');

        Vector vector = new Vector(3.5, 4.5, 6.4);
        System.out.print("Вектор: "+vector.toString()+'\n'+"Длина: "+vector.length());

        System.out.print('\n');

        Vector vector_2 = new Vector(3.2, 6.42, 56.2);
        System.out.println("Скалярное произведение с {3.2, 6.42, 56.2}: "+vector.scalarProd(vector_2));
        System.out.println("Векторное произведение с {3.2, 6.42, 56.2}: "+vector.vectorProd(vector_2).toString());
        System.out.println("Векторная сумма с {3.2, 6.42, 56.2}: "+vector.vectorSum(vector_2).toString());
        System.out.println("Векторная разница с {3.2, 6.42, 56.2}: "+vector.vectorSub(vector_2).toString());
        System.out.println("Угол с {3.2, 6.42, 56.2}: "+vector.angle(vector_2));
    }
}