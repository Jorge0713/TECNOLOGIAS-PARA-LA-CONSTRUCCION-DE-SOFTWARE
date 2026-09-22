// Test 5: polimorfismo ad-hoc — operator[] y operator() sobre el mismo dato,
// con dos sintaxis distintas.
#include "test_utils.hpp"
#include "Contenedor.hpp"
#include "MiVector.hpp"

int main() {
    separador("Test 5: polimorfismo ad-hoc");
    MiVector<int> v{100, 200, 300};

    if (v[0] != 100) { fallo("operator[] no devolvio el valor esperado"); return 0; }
    if (v(1) != 200) { fallo("operator() no devolvio el valor esperado"); return 0; }

    std::cout << "v[0]=" << v[0] << "   v(1)=" << v(1) << "\n";
    std::cout << "Misma posicion, dos formas de acceder: corchetes y llamada.\n";
    ok();
    return 0;
}
