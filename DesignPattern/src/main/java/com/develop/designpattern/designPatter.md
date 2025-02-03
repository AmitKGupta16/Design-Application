### Creational
    Singleton-Design-Pattern : It is a creational design pattern that ensures a class has only one
    instance and provides a global point of access to that instance.

    ✅ Thread-Safe & Reflection-Proof.
    ✅ Serialization-Proof.


    Real-World Use Cases of Singleton
        ✅ Database Connection Pooling (DriverManager)
        ✅ Logging System (Logger.getInstance())
        ✅ Thread Pool Management
        ✅ Configuration Management (PropertiesLoader)
        ✅ Caching (e.g., Redis, In-Memory Cache)
        ✅ Spring Framework Beans (Spring Beans are Singleton by default)


    Factory-Design-Pattern : It is a creation design pattern that provides an interface for creating objects,
    but lets subclasses decide which clsss to instatiate. Instead of using "new" keyword direclty, the factory
    method encapsulates object creation, promoting loose coupling and scalibity.



    Why Use the Factory Pattern?
       ✅ Encapsulates Object Creation → Hides complex instantiation logic.
       ✅ Promotes Loose Coupling → Clients depend on an interface, not concrete classes.
       ✅ Enhances Code Maintainability → Adding new classes does not affect existing code.
       ✅ Follows Open/Closed Principle (OCP) → New object types can be added without modifying existing code.
    
    Advantages of the Factory Pattern
       ✅ Encapsulates Object Creation → Clients do not use new directly.
       ✅ Provides a Centralized Object Creation Logic → Easy to maintain.
       ✅ Easier to Add New Products → Add new classes without modifying existing code.
       ✅ Improves Testability → Mocks can replace factory-created objects.


    Abstract-Factory-Design-Pattern : It is a creation design pattern that provides an interface for creating
    families of related objects without specifying their concreate class. It is also knows an as factory of factories.


    When to Use?
        When multiple families of related objects need to be created.
        When the system should be independent of how its objects are created.
        When the creation of objects should be abstracted from the client.

    Advantages of Abstract Factory Pattern
       ✅ Encapsulation → Hides object creation logic.
       ✅ Loose Coupling → Client code is independent of object creation.
       ✅ Maintains Compatibility → Ensures related objects work together.
       ✅ Extensibility → Adding new factories doesn’t modify existing code.

    Builder-Design-Pattern : It is a creational design pattern used for constructing complex objects
    step by step. Unlike the factroy or abstract factory patterns, which focus on creating entire 
    objects at once, the builder pattern allows gradual and controlled object construction.

    When to Use?
        When an object has multiple optional attributes.
        When constructing an object requires multiple steps.
        When you want to avoid using complex constructors with many parameters.


### Structural
    Decorator-Design-Pattern : It is a structural design pattern that allows behaviour to be added dynamically
    without modifying original structure of code.

    Instead of using inheritance, the decorator pattern warps an object with additional functionality,
    making it more flexiable and scalble.
    
    Reduce class explosion - If we use basic inheritance.

    Real-World Use Cases
        📌 Java I/O Streams – BufferedReader, InputStreamReader, FileReader.
        📌 GUI Design – Adding buttons, scrollbars, borders dynamically.
        📌 Logging Frameworks – Adding timestamps, file logging, console logging dynamically.
        📌 Security Frameworks – Adding authentication, role-based access control dynamically.


    Adaptor-Design-Pattern: It is structural design pattern that allows incomaptible interfaces to work
    together. It acts as a bridge between two incompatible interfaces, enabling them to communicate
    without modifying their code.


    Real-World Use Cases
        📌 Java I/O Streams (InputStreamReader converts InputStream into Reader).
        📌 Database Drivers (JDBC Adapter allows multiple database implementations).
        📌 Spring Boot (ModelMapper converts DTOs into entities).
        📌 Payment Gateways (Adapting third-party payment APIs into a unified payment service).



### Behavioural
    Command-Design-Pattern : It is a behavioural design pattern that encapsulates a request or operation as
    an object. This allows you to:

    1. Decoulple the sender from the receiver.
    2. Parametrized objects with operations.
    3. Queue or Log requests supports undoable opeartion.
    4. Felxiable and extensiable, as many command we can add. It will flowm OCP principle.
   
    It's basically use for whenver you have set of commands for execution, it will perform the operation
    based on commnand provide as input for execute.


    Obeserver-Design-Pattern : It is a behavioural design patter where an object called the subject 
    maintains a list of its dependents called observers and notify them of any state changes,
    usually by calling one of their methods. This pattern also known as publish-subscribe pattern.

    1. Decoupling between subjet and observers
    2. One-to-many-relationshion between subject and observers
    3. Dynamic Subscription for subject, subscripe and unsubcribe subject dynamically.



    Strategy-Design-Pattern : It is a behavioural design pattern that defines a family of alogorithm
    encapsulates them in to sepearte classes, and makes them interchangable. It allows the  alogorith to 
    be slected at runtime without modifying the client code.
    In this we want to the code flexible, maintainable and scalable

    Real-World Use Cases
        📌 Sorting Algorithms (QuickSort, MergeSort, BubbleSort).
        📌 Compression Techniques (ZIP, RAR, GZIP).
        📌 Payment Methods (PayPal, Credit Card, Google Pay).
        📌 Authentication Strategies (OAuth, JWT, LDAP).
        📌 Logging Strategies (File, Console, Database Logging).






   
    


