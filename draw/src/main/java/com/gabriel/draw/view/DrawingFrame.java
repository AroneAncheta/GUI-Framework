package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);

        JToolBar toolBar = new JToolBar();

        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));

        JButton rectButton = new JButton("Rectangle");
        rectButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));

        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));

        toolBar.add(lineButton);
        toolBar.add(rectButton);
        toolBar.add(ellipseButton);

        this.setLayout(new BorderLayout());
        this.add(toolBar, BorderLayout.NORTH);
        this.add(drawingView, BorderLayout.CENTER);
    }
}
