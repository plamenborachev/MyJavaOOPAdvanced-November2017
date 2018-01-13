package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        ShapeImpl rectangle = new Rectangle();
        ShapeImpl circle = new Circle();
        ShapeImpl square = new Square();

        GraphicEditor ge = new GraphicEditor();

        ge.drawShape(rectangle);
        ge.drawShape(circle);
        ge.drawShape(square);
    }
}
