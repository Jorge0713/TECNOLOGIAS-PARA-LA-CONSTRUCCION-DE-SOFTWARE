package Miguel;
public class Esqueleto extends MobHostil{
    public Esqueleto(){
        super("Esqueleto", 20);
    }
    @Override
    public void atacar(){
        System.out.println("El Esqueleto te persigue y te ataca con su arco.");
    }

}