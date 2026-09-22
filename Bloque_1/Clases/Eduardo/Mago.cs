using System.Reflection.Metadata;
namespace Clases;

public class Mago : Personaje,IHabilidadEspecial
{
    public Mago(string nombre) : base (nombre){}
    public override void ataque(Personaje objetivo)
    {
        System.Console.WriteLine($"{nombre} lanzo una bola de fuego a {objetivo.nombre}");
        objetivo.recibirDano(15);
    }
    public void usarHabilidad()
    {
        puntosVida+=30;
        if (puntosVida >= 100) return;
        System.Console.WriteLine($"{nombre} regenero 30 puntos de vida, su vida actual es {puntosVida}");
    }
}