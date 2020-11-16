import MNIST.MNIST_SET_server;
import MNIST.MNIST_image;

import java.io.*;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            MNIST_SET_server identifier = new MNIST_SET_server (
                    "src/Numbers data/train-images.idx3-ubyte",
                    "src/Numbers data/train-labels.idx1-ubyte");

            MNIST_image[] images = MNIST_SET_server.getImagesFromIDX(
                    "src/Numbers data/t10k-images.idx3-ubyte",
                    "src/Numbers data/t10k-labels.idx1-ubyte"
            );

            System.out.println(images[7]);

            ErrorsCounter errors = new ErrorsCounter();
            Thread[] threads = new Thread[10];

            //Запускаем 10 потоков, каждый определяет свою 1000 картинок
            for(int i=0; i<threads.length; i++) {
                threads[i] = new MNIST_ImagesIdentifyThread (
                        images, identifier,i*1000, i*1000+1000, errors
                );
                threads[i].start();
            }

            //Ожидаем завершения потоков
            for(Thread thread: threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nТочность алгоритма: " + (100 - errors.getErrorsCounter()/100) + "%");

        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }
}
