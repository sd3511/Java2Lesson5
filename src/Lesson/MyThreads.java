package Lesson;

public class MyThreads extends Thread implements Calculate {
private float [] array;
    public MyThreads(float [] array, String name) {
        super(name);
    this.array = array;
    }

    public float[] getArray() {
        return array;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        calculate(array);
        System.out.println(System.currentTimeMillis()-a + " Время просчета " + getName());

    }
}
