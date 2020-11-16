package ru.smak.math;

/**
 * класс множества Мандельборта
 */
public class Mandelbrot implements Fractal{

    /**
     * количесто возвидений в степень
     */
    private int maxIters = 200;
    /**
     * квадрат максимально удалённой точки от начала системы кординат
     */
    private double r2 = 4;

    /**
     * передача max(5,value)
     * @param value - количество возвидений в степень.
     */
    public void setMaxIters(int value){
        maxIters = Math.max(5, value);
    }

    /**
     * изменение квадрата радиуса
     * @param value - значение радиуса
     */
    public void setR(int value){
        var r = Math.max(0.1, value);
        r2 = r*r;
    }

    /**
     * проверка на принадлежность множеству Мандельборта
     * @param c - комплексное число
     * @return true - если принадлежит множеству Мондельборта, иначе false
     */
    @Override
    public boolean isInSet(Complex c) {
        var z = new Complex();
        for (int i = 0; i<maxIters; i++){
            //z = z.times(z).plus(c);
            z.result(c);

            if (z.abs2() > r2) return false;
        }
        return true;
    }
}
