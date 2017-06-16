package bestpractices.AvoidAbstractInConstructor;

/**
 * When designing an abstract class, why should you avoid calling abstract methods inside its constructor?
 *
 * Now we’ve introduced accessmodifiers.point.a subtle bug:
 * Widget.cachedWidth and Widget.cachedHeight will always be zero for SquareWidget instances!
 * This is because the this.size = size assignment occurs after the Widget constructor runs.
 *
 * Avoid calling abstract methods in your abstract classes’ constructors, as it restricts how those abstract methods
 * can be implemented.
 */
public class AvoidAbstractInConstructor {

    public static void main(String[] args) {
        Widget widget = new SquareWidget(10);
        System.out.println(widget);
    }

}

abstract class Widget {

    private final int cachedWidth;
    private final int cachedHeight;

    public Widget() {
        this.cachedWidth = width();
        this.cachedHeight = height();
    }

    protected abstract int width();

    protected abstract int height();

    @Override
    public String toString() {
        return "Widget{" +
                "cachedWidth=" + cachedWidth +
                ", cachedHeight=" + cachedHeight +
                '}';
    }
}

class SquareWidget extends Widget {

    private final int size;

    public SquareWidget(int size) {
        this.size = size;
    }

    @Override
    protected int width() {
        return size;
    }

    @Override
    protected int height() {
        return size;
    }

}