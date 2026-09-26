using Harry.Alien;

namespace Harry.Fabrica;

public static class FabricaAlien
{
    public static IAlien CrearDesdeMuestra(MuestraADN muestra)
    {
        return new CreadorAlien(muestra.Nombre, muestra.Descripcion, muestra.Habilidad);

    }
}