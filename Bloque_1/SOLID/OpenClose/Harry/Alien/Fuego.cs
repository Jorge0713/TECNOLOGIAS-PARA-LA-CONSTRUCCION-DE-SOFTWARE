namespace Harry.Alien;


public class Fuego: IAlien
{
    public virtual string Nombre => "Fuego"; 
    public virtual string Descripcion => "Pyronita | Ser compuesto orr plasma y rocas volcanicas"; 
    public virtual string UsarHabilidad()
    {
        System.Console.WriteLine($"{Nombre} lanza bolas de fuego");
    }
}