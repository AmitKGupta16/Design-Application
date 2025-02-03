The @Transactional annotation in Spring is a powerful abstraction for managing transactions in a declarative way.
Internally, it leverages Spring's AOP (Aspect-Oriented Programming) mechanism and the TransactionManager to begin,
commit, or roll back transactions as required.

Here’s an in-depth explanation of how @Transactional works internally:

1. Declarative vs Programmatic Transactions
   Programmatic Transactions: Involve explicitly managing transactions in the code using APIs like TransactionTemplate
   or PlatformTransactionManager. This approach can clutter the business logic.
   Declarative Transactions (@Transactional): Allow transactions to be managed automatically via annotations, reducing
   boilerplate code.
   The @Transactional annotation simplifies transaction management by allowing developers to declare transactional
   behavior at the class or method level.

2. Key Components Involved
   Several key Spring components work together to enable the functionality of @Transactional:

Proxy Mechanism:

Spring creates a proxy (either JDK dynamic proxy or CGLIB proxy) for the class or bean where @Transactional is used.
The proxy intercepts method calls and manages transactional behavior before delegating the call to the target method.
PlatformTransactionManager:

Manages the lifecycle of transactions (begin, commit, rollback).
Common implementations:
DataSourceTransactionManager (JDBC transactions).
JpaTransactionManager (JPA-based transactions).
HibernateTransactionManager (Hibernate transactions).
TransactionInterceptor:

An AOP advice that intercepts method calls and applies transactional behavior.
TransactionSynchronizationManager:

Maintains the transactional context (e.g., current transaction status, resources) and synchronization hooks.
TransactionAttributeSource:

Parses and evaluates metadata on methods or classes annotated with @Transactional.

3. Lifecycle of a Transaction with @Transactional

   Step 1: Proxy Creation
   When a bean is annotated with @Transactional, Spring wraps it in a proxy during context initialization.
   If the bean implements an interface, Spring creates a JDK dynamic proxy.
   If the bean does not implement an interface, Spring uses CGLIB to create a subclass proxy.

   Step 2: Method Interception
   When a method annotated with @Transactional is called:
   The proxy intercepts the method call.
   The TransactionInterceptor determines whether the method requires a transaction.

   The TransactionAttributeSource retrieves transactional metadata (like propagation, isolation, and rollback rules).
   Step 3: Transaction Management
   Transaction Start:

   If a transaction is required, the TransactionManager begins a new transaction or participates in an existing one (
   depending on propagation settings).
   The TransactionSynchronizationManager binds the transaction to the current thread.
   Method Execution:

The actual method is invoked after the transaction has been started.
Transaction Completion:

If the method executes successfully:
The transaction is committed.
If an exception is thrown:
Spring checks the rollback rules:
By default, transactions are rolled back for unchecked exceptions (subclasses of RuntimeException or Error).
Transactions are not rolled back for checked exceptions unless explicitly configured.

4. Transaction Attributes
   The behavior of @Transactional is controlled by attributes like propagation, isolation, timeout, and rollback rules.

Key Attributes:
Propagation: Defines how the transaction participates in existing transactions.

REQUIRED (default): Joins the existing transaction or creates a new one if none exists.
REQUIRES_NEW: Suspends any existing transaction and starts a new one.
NESTED: Creates a nested transaction if an existing transaction exists.
Others: MANDATORY, SUPPORTS, NOT_SUPPORTED, NEVER.
Isolation: Defines the isolation level for the transaction (e.g., READ_COMMITTED, SERIALIZABLE).

Timeout: Specifies the maximum duration (in seconds) a transaction can run before being rolled back.

Rollback Rules:

Default: Rollback for RuntimeException and Error.
Customization: You can specify exceptions for rollback using rollbackFor or noRollbackFor.

5. Internal Flow of @Transactional
   Intercept Method Call:

The proxy intercepts the method and checks if @Transactional is present.
Retrieve Transaction Attributes:

The TransactionInterceptor uses the TransactionAttributeSource to retrieve metadata (propagation, isolation, rollback
rules, etc.).
Begin Transaction:

If a new transaction is required:
TransactionManager.beginTransaction() is called.
Resources (e.g., database connections) are bound to the thread.
Method Execution:

The target method is invoked.
Any exceptions thrown are caught to determine rollback behavior.
Commit or Rollback:

If the method completes successfully, TransactionManager.commit() is called.
If an exception is thrown:
The rollback rules are evaluated.
If rollback is required, TransactionManager.rollback() is called.
Transaction Cleanup:

The TransactionSynchronizationManager unbinds resources from the thread and performs cleanup.

6. Transaction Propagation Example
   Code Example:
   @Service
   public class UserService {

   @Transactional
   public void createUser() {
   // Start a transaction
   saveUser(); // Inserts user into the database
   sendEmail(); // Sends a welcome email
   // Commit transaction
   }

   public void saveUser() {
   // Perform database operations
   }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void sendEmail() {
   // Start a new transaction
   // Perform email sending logic
   // Commit the transaction
   }
   }
   Workflow:
   createUser() starts a transaction.
   saveUser() operates within the same transaction.
   sendEmail() starts a new transaction because of Propagation.REQUIRES_NEW.
7. Exception Handling and Rollback Rules
   Rollback for Unchecked Exceptions:
   @Transactional
   public void process() {
   throw new RuntimeException("Unchecked Exception"); // Rolls back
   }
   No Rollback for Checked Exceptions:
   java
   Copy
   Edit
   @Transactional
   public void process() throws Exception {
   throw new Exception("Checked Exception"); // Does NOT roll back by default
   }
   Custom Rollback Rules:
   java
   Copy
   Edit
   @Transactional(rollbackFor = Exception.class)
   public void process() throws Exception {
   throw new Exception("Checked Exception"); // Rolls back
   }
8. Limitations of @Transactional
   Proxy Limitation:

If a @Transactional method is called internally from another method in the same class, the proxy does not intercept it.
Solution: Move the method to a different class.
Only Public Methods:

Spring applies @Transactional only to public methods because it uses proxies.
Non-Transactional Resources:

@Transactional cannot manage non-transactional resources (e.g., file I/O).

9. Key Spring Internals
   TransactionAspectSupport:
   Core class that processes transactional logic.
   AbstractPlatformTransactionManager:
   Abstract implementation for PlatformTransactionManager.
   TransactionSynchronizationManager:
   Manages transaction resources and synchronization.