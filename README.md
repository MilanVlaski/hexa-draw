# hexa-draw
Desktop graphical editor re-implemented following Ports and Adapters (hexagonal) architecture. 

Working on this app aims to answer the following questions:
# Questions to answer
- What is MVC? Each Model should have a corresponding View into it. The Model and View should be finer grained. How does that look in practice?
- How do Models and Views communicate by the Subscriber pattern? Should finer grained Event value objects be created? Do they carry references to Models and so on?
- Usage of a cocktail of design patterns when drawing: State, Command, Subscriber etc. A model for drawing?
- How does this fit into Ports and Adapters architecture, and what high level components will the app contain? (It's not just MODEL and VIEW and CONTROLLER. That's a lie.).
- How to implement Deskto GUI organization reasonably?
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
