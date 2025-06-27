package com.mutaki.hexadraw.canvas.state;

import com.mutaki.hexadraw.canvas.OnHitListener;

import java.awt.Point;

public interface CanvasState extends OnHitListener {

    void click(Point point);

}
