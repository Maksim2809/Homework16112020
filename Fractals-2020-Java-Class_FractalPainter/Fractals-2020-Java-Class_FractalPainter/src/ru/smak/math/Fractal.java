package ru.smak.math;

import ru.smak.math.Complex;

public interface Fractal {
    /**
     * что-то для создания интерфейса
     * @param c - комплексное число
     * @return что-то что нужно переопределять
     */
    boolean isInSet(Complex c);
}
