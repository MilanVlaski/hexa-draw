# hexa-draw
Desktop graphical editor re-implemented following Ports and Adapters (hexagonal) architecture, and using outside-in TDD. 

# To run
1. `./gradlew build` (omit the `./` if on windows)
2. `./gradlew run`

# Questions to answer
- What is MVC? Each Model should have a corresponding View into it. The Model and View should be finer grained. How does that look in practice?
- How do Models and Views communicate by the Subscriber pattern? Should finer grained Event value objects be created? Do they carry references to Models and so on?
- Usage of a cocktail of design patterns when drawing: State, Command, Subscriber etc. A model for drawing?
- How does this fit into Ports and Adapters architecture, and what high level components will the app contain? (It's not just MODEL and VIEW and CONTROLLER. That's a lie.).
- How to implement Deskto GUI organization reasonably?
## To do
- [x] Make ~Maven~ Gradle template
