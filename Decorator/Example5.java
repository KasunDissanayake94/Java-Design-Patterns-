/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.decorator;

/**
 *
 * @author Kasun Dissanayake
 */
interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
    
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
    
}
//Create abstract decorator class implementing the Shape interface.
abstract class ShapeDecorator implements Shape{
    protected Shape decoShape;
    
    public ShapeDecorator(Shape decoShape){
        this.decoShape = decoShape;
        
    }    
    @Override
    public void draw(){
        decoShape.draw();
    }
    
}
//Create concrete decorator class extending the ShapeDecorator class.
class RedBorderDecorator extends ShapeDecorator{
    
    public RedBorderDecorator(Shape decoShape) {
        super(decoShape);
    }
    @Override
    public void draw(){
        decoShape.draw();
        setBorderRed(decoShape);
    }

    private void setBorderRed(Shape decShape) {
        System.out.println("Border Color: Red");
    }
    
}
public class Example5 {
    public static void main(String[] args) {
        //normal Circle draw function
        Circle circle = new Circle();
        System.out.println("\nNormal Circle");
        circle.draw();
        
        Shape redCircle = new RedBorderDecorator(new Circle());
        Shape redRectangle = new RedBorderDecorator(new Rectangle());
        
        System.out.println("\nCircle of red border");
        redCircle.draw();
        
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
        
        
    }
    
}
