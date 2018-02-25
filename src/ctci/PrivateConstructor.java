package ctci;

public class PrivateConstructor {
    /**
     * Private Constructor
     */
    private PrivateConstructor() {
    }

    /**
     * Static Nested class
     */
    static class A{
        void foo() {
            new PrivateConstructor();
        }
    }

    /**
     * Inner class
     */
    class B {

    }
}
