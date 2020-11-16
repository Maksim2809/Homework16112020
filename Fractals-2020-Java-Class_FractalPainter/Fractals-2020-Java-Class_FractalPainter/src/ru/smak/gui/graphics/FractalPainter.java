package ru.smak.gui.graphics;

import ru.smak.gui.graphics.coordinates.CartesianScreenPlane;
import ru.smak.gui.graphics.coordinates.Converter;
import ru.smak.math.Complex;
import ru.smak.math.Fractal;

import java.awt.*;

/**
 * класс для рисования фрактала
 */
public class FractalPainter extends Painter {

    /**
     * панель на которой будет рисоваться
     */
    private final CartesianScreenPlane plane;
    /**
     * фрактал
     */
    private final Fractal fractal;

    /**
     * конструктор для рисоания фрактала
     * @param plane - панель
     * @param f - фрактал
     */
    public FractalPainter(CartesianScreenPlane plane,
                          Fractal f){
        this.plane = plane;
        fractal = f;
    }

    /**
     * перекрашивание пиксилей
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        for (int i = 0; i < plane.getWidth(); i++){
            for (int j = 0; j < plane.getHeight(); j++){
                var x = Converter.xScr2Crt(i, plane);
                var y = Converter.yScr2Crt(j, plane);
                var is = fractal.isInSet(new Complex(x, y));
                Color c = (is)?Color.BLACK:Color.WHITE;
                graphics.setColor(c);
                graphics.fillRect(i, j, 1, 1);
            }
        }
    }
}
