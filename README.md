# hexa-draw
Desktop graphical editor re-implemented following Ports &amp; Adapters architecture.
## To do
- [ ] Make Maven template

### Architecture
- [ ] Identify main architectural bits:
  - App (has user functions)
  - View (controlling the display)
  - Drawing (canvas,
  - Domain (wires, junction boxes, connectors, data...)
- A fun question. What is a Canvas? A view? Part of the app model? Part of the drawing model? A monster?
  - MV: There's a Canvas, and it has it's components in both the View, and in different models (depends on how many models we come up with)
