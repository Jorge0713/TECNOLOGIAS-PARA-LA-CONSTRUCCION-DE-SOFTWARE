// Test 2: construccion — agregar() y obtener() recorriendo el vector.
#include "test_utils.hpp"
#include "Contenedor.hpp"
#include "MiVector.hpp"

int main() {
    separador("Test 2: construccion");
    MiVector<int> v;
    int esperado[] = {1, 1, 2, 3, 5, 8};
    for (int x : esperado) v.agregar(x);

    if (v.tamano() != 6) { fallo("tamano incorrecto tras 6 agregar()"); return 0; }
    for (size_t i = 0; i < 6; ++i) {
        if (v.obtener(i) != esperado[i]) { fallo("obtener() no coincide con lo agregado"); return 0; }
        std::cout << "  nodo " << i << ": " << v.obtener(i) << "\n";
    }
    std::cout << "Vector construido con " << v.tamano() << " elementos.\n";
    ok();
    return 0;
}
