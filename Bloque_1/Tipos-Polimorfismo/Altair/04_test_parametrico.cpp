// Test 4: polimorfismo parametrico — la misma plantilla MiVector<T> con tres
// tipos distintos (int, std::string, y una struct propia).
#include "test_utils.hpp"
#include "Contenedor.hpp"
#include "MiVector.hpp"
#include <string>

struct Alumno {
    std::string nombre;
    double calificacion = 0.0;
};

std::ostream& operator<<(std::ostream& os, const Alumno& a) {
    return os << a.nombre << " (" << a.calificacion << ")";
}

int main() {
    separador("Test 4: polimorfismo parametrico");

    MiVector<int> numeros;
    for (int v : {1, 1, 2, 3, 5, 8}) numeros.agregar(v);

    MiVector<std::string> ciudades;
    ciudades.agregar("CDMX");
    ciudades.agregar("Monterrey");
    ciudades.agregar("Guadalajara");

    MiVector<Alumno> alumnos;
    alumnos.agregar({"Ana", 9.5});
    alumnos.agregar({"Luis", 8.1});

    if (numeros.tamano() != 6 || ciudades.tamano() != 3 || alumnos.tamano() != 2) {
        fallo("tamano incorrecto en alguna de las tres instanciaciones");
        return 0;
    }

    std::cout << "MiVector<int>:         ";
    for (size_t i = 0; i < numeros.tamano(); i++) std::cout << numeros.obtener(i) << " ";
    std::cout << "\n";

    std::cout << "MiVector<string>:      ";
    for (size_t i = 0; i < ciudades.tamano(); i++) std::cout << ciudades.obtener(i) << " ";
    std::cout << "\n";

    std::cout << "MiVector<Alumno>:      ";
    for (size_t i = 0; i < alumnos.tamano(); i++) std::cout << alumnos.obtener(i) << " ";
    std::cout << "\n";
    ok();
    return 0;
}
