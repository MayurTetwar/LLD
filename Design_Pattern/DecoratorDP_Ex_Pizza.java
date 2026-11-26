package Design_Pattern;

interface Pizza{
    double cost();
    String desc();
}
class Margherita implements Pizza{
    public double cost(){return 200;}
    public String desc(){return "Margherita";}
}
class Farmhouse implements Pizza{
    public double cost(){return 300;}
    public String desc(){return "Farmhouse";}
}

abstract class DecoratorPizza implements Pizza{
    Pizza pizza;
    DecoratorPizza(Pizza pizza){
        this.pizza=pizza;
    }
}
class ExtraCheese extends DecoratorPizza{
    public ExtraCheese(Pizza p) {
        super(p);
    }
    public double cost(){return pizza.cost()+40;}
    public String desc(){return pizza.desc()+" with ExtraCheese";}
}
class Olives extends DecoratorPizza{
    public Olives(Pizza p) {
        super(p);
    }
    public double cost(){return pizza.cost()+25;}
    public String desc(){return pizza.desc()+" with Olives";}
}
class Jalapeno extends DecoratorPizza{
    public Jalapeno(Pizza p) {
        super(p);
    }
    public double cost(){return pizza.cost()+20;}
    public String desc(){return pizza.desc()+" with Jalapeno";}
}
class DecoratorDP_Ex_Pizza{
    public static void main(String[] args) {
        
        Pizza pizza = new Jalapeno(new ExtraCheese(new ExtraCheese(new Farmhouse())));
        System.out.println(pizza.cost());
        System.out.println(pizza.desc());

    }
}