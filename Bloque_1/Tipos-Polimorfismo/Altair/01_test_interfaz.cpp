// Test 1: la interfaz — Contenedor<T> abstracta, MiVector<T> concreta.
// No agrega nada todavia: solo confirma que la implementacion existe y que
// un contenedor recien creado esta vacio.
#include "test_utils.hpp"
#include "Contenedor.hpp"
#include "MiVector.hpp"

int main() {
    separador("Test 1: la interfaz");
    MiVector<int> v;
    if (!v.vacio()) { fallo("un MiVector recien creado debe estar vacio"); return 0; }
    if (v.tamano() != 0) { fallo("un MiVector recien creado debe tener tamano 0"); return 0; }
    std::cout << "Su contenedor esta " << estadoTexto(v.vacio())
              << " y su tamano es " << v.tamano() << ".\n";
    std::cout << "Test pasado correctamente.\n";
    ok();
    return 0;
}
