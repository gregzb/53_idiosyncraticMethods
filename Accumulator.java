import java.io.DataOutput;

/**
 * Represent accumulating data from the elements in a
 * List_inArraySlots that are of a particular type.
 */

public class Accumulator {


    /**
     * 0. A list of elements of a given type can be represented using an array of that type.
     * float[] numbers = new float[25];
     * numbers[0] = 1.0;
     * numbers[1] = 0.25;
     * numbers[2] = -5.0;
     * etc
     *
     * 1. A list of elements of disparate types can be implemented without polymorphism two ways, at least. Such programs share a program structure like __________ (~4–8 lines of pseudo-code).
     * float[] floatNums = new float[10];
     * int[] intNums = new int[10];
     * int[] types = new types[10];
     * if (types[i] == 0) floatNums[i]
     * else intNums[i]
     *
     *
     * Stumbling block
     * 2. This structure constitutes a maintenance nightmare:
     * Disparate types in a list would each require their own array and accessing or using those values
     * would require a conditional and additional array to keep track of which type is at which index.
     * Adding new types also becomes more difficult.
     *
     * 3. Polymorphism provides programmers with a workaround for the stumbling block: implement a list of elements of disparate types by ___________ (~20–40 words).
     * A the type of a list being a super class would allow for disparate types sharing any common
     * elements to be put in the same list.
     *
     * 4. Java features support applying a method to every element when all of the types have an implementation of that method.
     * if (instance instanceOf Class) {
     *     ((Class)instance).applyMethod();
     * }
     */


    /*
     3.
     Java protects a programmer against applying a method to elements in list when some elements of the list might omit support for a particular operation.

     This protection is implemented by the __compiler__ (Java compiler? JVM?). The following attempt to violate the restriction is expected to result in the error __not a method__.

     code: temp += list.get(i).isInfinite();

     error: java: cannot find symbol
     */

    /*
    4.
    A programmer should expect to be able to work around the stumbling block because the __JVM__ (Java compiler? JVM?) knows the type of an element.

Java's __instanceOf__ operator identifies the type of an element to the __compiler__ (Java compiler? JVM?)
     */

    /*
    5.
    Use of the operator alone is insufficient because the __compiler__ (Java compiler? JVM?) continues to stumble over the previous stumbling block of protection against mis-applying a method.

code: if (list.get(i) instanceof Double)
            temp += list.get(i).isInfinite();

predicted error message: method doesnt exist

[resulting error message]: java: cannot find symbol
     */

    /*
    6.
    Java provides a __cast__ facility that a programmer uses to tell the __compiler__ (Java compiler? JVM?) that they are using a subclass's method on an object for which a reference is stored in a super-type variable.

[code that illustrates the use of the operator]

But use of that facility alone is insufficient because the ___java__ (Java compiler? JVM?) stumbles over _elements that cannot be cast to a certain another type, but are attempted to be cast anyway._ (20–40 words).

predicted error message: String cant be cast to Double

java.lang.ClassCastException: java.base/java.lang.String cannot be cast to java.base/java.lang.Double
     */

    /*
    7.
    A programmer can combine use of the operator and the facility to apply a method to exactly those elements in the list that support the method.

if (list.get(i) instanceof Double)
            temp += ((Double)list.get(i)).isInfinite();
     */

    /**
     * @return the concatenation of all the Strings
     * in the \list that begin with \prefix,
     * each followed by a space.
     */
//    public static String catElementsStartingWith(List_inArraySlots list, String prefix) {
//        return (String) list.filter(item -> item instanceof String && ((String) item).startsWith(prefix))
//                .reduce((accumulator, item) -> (((String) accumulator) + item + " "), "");
//    }
    public static String catElementsStartingWith(List_inArraySlots list, String prefix) {
        return (String) list.filter(item -> item instanceof String && ((String) item).startsWith(prefix))
                .reduce((accumulator, item) -> ((String) accumulator) + item + " ", "");
    }


    /**
     * @return a list of each of the Double elements
     * from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(List_inArraySlots list) {
        return list.filter(item -> item instanceof Double && !((Double) item).isInfinite());
    }
}
