// Test 3: polimorfismo de subtipo — una referencia a Contenedor<T> ejecuta
// el metodo que en realidad implemento MiVector<T> (despacho dinamico).
#include "test_utils.hpp"
#include "Contenedor.hpp"
#include "MiVector.hpp"

int main() {
    separador("Test 3: polimorfismo de subtipo");
    MiVector<int> v{10, 20, 30};

    Contenedor<int>* base = &v;
    base->quitar(0);

    if (base->tamano() != 2) { fallo("quitar() via Contenedor<int>* no redujo el tamano"); return 0; }
    if (base->obtener(0) != 20) { fallo("quitar() via Contenedor<int>* no elimino el elemento correcto"); return 0; }

    std::cout << "base->quitar(0) elimino el primer elemento a traves del puntero base.\n";
    std::cout << "base->tamano()=" << base->tamano() << "  base->obtener(0)=" << base->obtener(0) << "\n";
    ok();
    return 0;
}
