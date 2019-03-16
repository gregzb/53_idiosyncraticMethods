/**
 Test list features.
 */
public class UserOfList {
    public static void main( String[] args ) {
        List_inArraySlots<Object> list = new List_inArraySlots<Object>( new Object[]{
                3.14, "piazza", 6.28, "pi", 256, Double.POSITIVE_INFINITY, "tau", "pizza", 1e4, Double.NEGATIVE_INFINITY
        });

        System.out.println(Accumulator.catElementsStartingWith(list, "pi"));
        System.out.println(Accumulator.finites(list));
    }
}
