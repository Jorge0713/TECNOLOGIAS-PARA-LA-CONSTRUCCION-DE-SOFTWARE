using System;
using Clases;

Guerrero guerrero1 = new Guerrero("Justin");
Mago mago1 = new Mago("Christopher");
System.Console.WriteLine("Duelo");
System.Console.WriteLine($"{mago1.nombre} vs {guerrero1.nombre}");

while (mago1.estadoVida && guerrero1.estadoVida)
{
    System.Console.WriteLine("1.Guerrero ataca a mago");
    System.Console.WriteLine("2.Mago ataca a guerrero");
    System.Console.WriteLine("3.Mago usa su habilidad");
    System.Console.WriteLine("Elija una opcion: ");

    String? opcion = Console.ReadLine();
    switch (opcion)
    {
        case "1":
            guerrero1.ataque(mago1);
            break;
        case "2":
            mago1.ataque(guerrero1);
            break;
        case "3":
            mago1.usarHabilidad();
            break;
        default:
            System.Console.WriteLine("opcion no valida");
            break;
    }
     if (mago1.estadoVida){
                System.Console.WriteLine("gana mago");
            }
            else
    {
        System.Console.WriteLine("gana guerrero");
    }
}