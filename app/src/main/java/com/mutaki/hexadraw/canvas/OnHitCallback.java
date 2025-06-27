package com.mutaki.hexadraw.canvas;

import com.mutaki.hexadraw.model.events.ElementHitEvent;

public interface OnHitCallback {
    void hitSuccessful(ElementHitEvent elementHitEvent);
}
