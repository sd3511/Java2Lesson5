package Lesson;


public class Methods implements Calculate {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];


    public void firstMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println(System.currentTimeMillis() - a+ " время работы первого метода");

    }

    public void secondMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
        System.out.println();
        System.out.println("второй метод");

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println(System.currentTimeMillis() - a + " Время разбивки на 2 массива");

        MyThreads thread1 = new MyThreads(a1, "первого массива");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyThreads thread2 = new MyThreads(a2, "второго массива");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        a1 = thread1.getArray();
        a2 = thread2.getArray();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - b + " Время склейки");


    }


}
