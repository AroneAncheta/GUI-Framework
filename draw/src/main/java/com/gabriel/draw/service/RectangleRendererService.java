package com.gabriel.draw.service;


import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;


public class RectangleRendererService implements RendererService {
    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rect = (Rectangle) shape;
        g.setXORMode(rect.getColor());

        int x = Math.min(rect.getLocation().x, rect.getEnd().x);
        int y = Math.min(rect.getLocation().y, rect.getEnd().y);
        int width = Math.abs(rect.getEnd().x - rect.getLocation().x);
        int height = Math.abs(rect.getEnd().y - rect.getLocation().y);

        g.drawRect(x, y, width, height);
    }
}