package week9;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int l, int w){
        length = l;
        width = w;
    }
    public Rectangle(int side){
        length = side;
        width = side;
    }
    public int getArea(){
        return length*width;
    }
    public int getWidth(){
    return width;
    }
    public int getLength(){
        return length;
    }
    public int perimeter(){
        return 2*length + 2*width;
    }
    public boolean isSquare(){
        return length == width;
    }

    public String toString(){
        return "rectangle with width of " + width + " and length of " + length;
     }

     public boolean equals(Object obj){
        if (obj==this){
            return true;
        }
        if (obj instanceof Rectangle){
            return this.length==((Rectangle)obj).length && this.width==((Rectangle)obj).width;
        }else {
            return false;
        }



    }
    

}
