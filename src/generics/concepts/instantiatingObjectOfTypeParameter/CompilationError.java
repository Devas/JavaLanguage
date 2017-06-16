package generics.concepts.instantiatingObjectOfTypeParameter;

/**
 * Gives compiler error.
 * After type erasure, all that is known about T is that it is some subclass of Object.
 */
public class CompilationError<T> {
//    T build() {
//        return new T();
//    }
}
