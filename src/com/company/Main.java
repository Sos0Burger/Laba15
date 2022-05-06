package com.company;

public class Main {

    public static void main(String[] args) {
	tShirt ts = new tShirt(Size.S, 453.3, "Синий");
    Skirt sk = new Skirt(Size.XS, 964.2, "Желтый");
    Tie tie = new Tie(Size.S, 143.2, "Розовый");
    Pants pants = new Pants(Size.XS, 1252.2, "Коричневый");
    Cloth[] list = new Cloth[] {ts, sk, tie, pants};
    Atelier.dressUpMen(list);
    System.out.println("\n \n");
    Atelier.dressUpWoman(list);
    }
}
enum Size{
    XXS(46){
        @Override
        public String GetDescription(){
            return "Детский размер";
        }
    },
    XS(32), S(34), M(36), L(40);
    int euroSize;
    Size(int euroSize){
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String GetDescription(){
        return "Взрослый размер";
    }
}
interface ImenClothes{
    void dressUpMen();
}
interface IwomanClothes{
    void dressUpWoman();
}
abstract class Cloth{
    Size size;
    double price;
    String color;
    Cloth(Size size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    abstract void getInfo();
}
class tShirt extends Cloth implements ImenClothes, IwomanClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    tShirt(Size size, double price, String color){
        super(size,price,color);
    }

    @Override
    void getInfo(){
        System.out.println("Футболка, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Pants extends Cloth implements ImenClothes, IwomanClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    Pants(Size size, double price, String color){
        super(size,price,color);
    }

    @Override
    void getInfo(){
        System.out.println("Штаны, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Skirt extends Cloth implements IwomanClothes{
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    Skirt(Size size, double price, String color){
        super(size,price,color);
    }
    @Override
    void getInfo(){
        System.out.println("Юбка, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Tie extends Cloth implements ImenClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    Tie(Size size, double price, String color){
        super(size,price,color);
    }
    @Override
    void getInfo(){
        System.out.println("Галстук, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Atelier{
    static void dressUpMen(Cloth[] list){
        for(Cloth c: list ){
            if (c instanceof ImenClothes){
                c.getInfo();
            }
        }
    }
    static void dressUpWoman(Cloth[] list){
        for(Cloth c: list ){
            if (c instanceof IwomanClothes){
                c.getInfo();
            }
        }
    }
}
