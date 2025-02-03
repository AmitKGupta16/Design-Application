The @ControllerAdvice annotation in Spring Boot is part of Spring MVC, and it provides a way to apply centralized
exception handling, data binding, and model attribute enrichment across multiple controllers. Here's a detailed,
step-by-step explanation of how @ControllerAdvice works internally in Spring Boot:

1. Component Scanning
   @ControllerAdvice is a specialized form of @Component, meaning Spring automatically detects it during component
   scanning and registers it as a Spring-managed bean.

Internals:
When the Spring context starts, it scans for classes annotated with @ControllerAdvice in the base package or
subpackages.
These classes are registered as beans in the application context with proxy objects if necessary.

2. DispatcherServlet's Role
   The DispatcherServlet in Spring MVC is responsible for handling incoming HTTP requests. It processes requests by
   invoking the appropriate controller methods and applying exception handling, data binding, and model attributes
   configured by @ControllerAdvice.

Workflow:
Request Handling: DispatcherServlet identifies the controller method that should handle the request.
Advice Invocation: Before and after the controller method execution, any relevant logic defined in @ControllerAdvice is
applied.

3. Exception Handling with @ExceptionHandler
   When a controller throws an exception, the @ControllerAdvice-annotated class intercepts it via methods annotated with
   @ExceptionHandler.

Internal Mechanics:
Annotation Scanning:
At startup, Spring scans all methods annotated with @ExceptionHandler and associates them with the exception types they
handle.
Handler Mapping:
When an exception is thrown, Spring looks for a matching @ExceptionHandler method based on the exception type hierarchy.
The lookup happens in the following order:
First, the controller itself is checked for @ExceptionHandler.
If not found, @ControllerAdvice-annotated classes are checked.
Method Execution:
If a matching method is found, it is invoked to handle the exception.
The returned object is processed (e.g., converted to JSON for REST controllers).
Example Internal Flow:
A NullPointerException is thrown in a controller.
Spring checks the controller for an @ExceptionHandler(NullPointerException.class) method.
If none exists, it checks all @ControllerAdvice classes for such a method.
The matched method is invoked, and its result is sent back to the client.

4. Model Attribute Handling with @ModelAttribute
   @ModelAttribute methods in @ControllerAdvice allow you to add attributes to the model for all controller methods.

Internal Mechanics:
Annotation Scanning:
During startup, Spring scans for methods annotated with @ModelAttribute in @ControllerAdvice classes.
Interceptor Setup:
These methods are registered as interceptors to add attributes to the ModelAndView object.
Execution:
Before a controller method executes, all global @ModelAttribute methods are invoked, and their results are added to the
model.
Attribute Resolution:
The ModelAndViewContainer collects all attributes added by @ModelAttribute methods, making them accessible in views.

5. Data Binding Customization with @InitBinder
   @InitBinder in @ControllerAdvice allows global customization of data binding (e.g., how request parameters are
   converted to objects).

Internal Mechanics:
Annotation Scanning:
During initialization, Spring looks for methods annotated with @InitBinder in @ControllerAdvice classes.
Binding Factory:
Spring registers these methods as global WebDataBinder initializers.
Execution:
Before binding request parameters to controller method arguments, Spring invokes @InitBinder methods to configure the
WebDataBinder (e.g., custom editors, validation logic).

6. Scope and Targeting
   By default, @ControllerAdvice applies globally to all controllers. However, you can restrict its scope using
   attributes like:

basePackages: Apply advice to controllers in specific packages.
assignableTypes: Apply advice to specific controller classes.
annotations: Apply advice to controllers annotated with specific annotations.
Internal Mechanics:
Matching Controllers:
During startup, Spring matches @ControllerAdvice classes with the specified basePackages, assignableTypes, or
annotations.
Scoped Application:
Only controllers that match the specified criteria are affected by the advice logic.
Example:
java
Copy
Edit
@ControllerAdvice(basePackages = "com.example.controllers")
public class MyControllerAdvice {
// Applies only to controllers in the specified package
}

7. Proxy and AOP Behavior
   @ControllerAdvice works using Spring AOP (Aspect-Oriented Programming) principles:

When an exception is thrown or a request is processed, Spring creates a proxy object for the advice class.
The proxy intercepts method invocations (e.g., handling exceptions or adding model attributes) and executes the
corresponding logic.

8. Exception Resolution Workflow
   Spring uses the ExceptionHandlerExceptionResolver to process exceptions thrown by controllers. The workflow is as
   follows:

The exception resolver checks if any @ExceptionHandler method in the controller or @ControllerAdvice matches the thrown
exception.
The matching method is invoked, and its return value is used to generate the response.
Key Classes Involved:
ExceptionHandlerExceptionResolver: Resolves exceptions using @ExceptionHandler.
ModelAndView: Used to pass data and views back to the client.
HandlerMethod: Represents the method to be invoked.
Key Spring Internals
AnnotationUtils: Used to detect annotations like @ExceptionHandler and @ModelAttribute.
HandlerMethodArgumentResolver: Resolves method arguments for advice methods.
HandlerExceptionResolverComposite: Manages multiple exception resolvers, including ExceptionHandlerExceptionResolver.
Flow Summary
Spring scans and registers @ControllerAdvice classes at startup.
@ExceptionHandler, @ModelAttribute, and @InitBinder methods are mapped globally.
During request handling:
Exception handling: Matches and invokes @ExceptionHandler.
Model attributes: Executes @ModelAttribute to enrich data.
Data binding: Applies @InitBinder configurations.
This internal mechanism ensures that cross-cutting concerns like exception handling and model preparation are managed
efficiently, simplifying controller logic. Let me know if you want an even deeper dive into any specific aspect!