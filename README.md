# Observer-Design-Pattern

## Definition
The Observer design pattern is a behavioral design pattern that defines a one-to-many dependency between objects. It allows one object (the subject) to notify a group of other objects (the observers) when its state changes.

## Uses
The Observer pattern is useful when you need to have multiple objects that depend on the state of another object and you want to be able to update those objects whenever the state of the first object changes. It decouples the objects that depend on the state of the subject from the subject itself, so that the subject can change independently of the dependent objects.

## How it works with shallow copy method
The observer design pattern is a behavioral design pattern that allows an object (called the subject) to notify a set of objects (called observers) when its state changes. The observers are registered with the subject, and they are notified whenever the subject's state changes.

One way to implement the observer design pattern is to use a shallow copy method. In a shallow copy, the subject maintains a list of observers, and it notifies them of state changes by calling a specific method on each observer. The observer can then update its own state based on the information provided by the subject.


## Implenetaion of the pattern in the project
In this example, the GroupAdmin represents the subject and the ConcreteMember class represents the observer. The GroupAdmin maintains a list of observers(as Member object) and notifies them whenever its state changes. ConcreteMember implements the update method to perform an action based on the updated state of the GroupAdmin.

