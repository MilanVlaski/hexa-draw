package com.mutaki.hexadraw.canvas.state;

import com.mutaki.hexadraw.canvas.OnHitCallback;

import java.awt.Point;

public interface CanvasState extends OnHitCallback {

    void click(Point point);

}
