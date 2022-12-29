# Observer-Design-Pattern

## Definition
The Observer design pattern is a behavioral design pattern that defines a one-to-many dependency between objects. It allows one object (the subject) to notify a group of other objects (the observers) when its state changes.

The Observer pattern is useful when you need to have multiple objects that depend on the state of another object and you want to be able to update those objects whenever the state of the first object changes. It decouples the objects that depend on the state of the subject from the subject itself, so that the subject can change independently of the dependent objects.

## Implenetaion of the pattern in the project
In this example, the GroupAdmin represents the subject and the ConcreteMember class represents the observer. The GroupAdmin maintains a list of observers(as Member object) and notifies them whenever its state changes. ConcreteMember implements the update method to perform an action based on the updated state of the GroupAdmin.
