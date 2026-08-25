using System.Collections.Concurrent;
namespace Clases;

public class Guerrero : Personaje
{
    public Guerrero(string nombre) : base(nombre){
        
    }

    public override void ataque(Personaje objetivo)
    {
        System.Console.WriteLine($"{nombre} ataca con la espada a {objetivo.nombre}");
        objetivo.recibirDano(30);
    }
}