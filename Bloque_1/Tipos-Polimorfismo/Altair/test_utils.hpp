#pragma once
// Utilidades compartidas por los 5 tests de C++.
#include <iostream>
#include <string>

inline void separador(const std::string& titulo) {
    std::cout << "\n========== " << titulo << " ==========\n";
}

inline std::string estadoTexto(bool vacio) {
    return vacio ? "vacío" : "lleno";
}

inline void ok() { std::cout << "##POLI:OK##\n"; }

inline void fallo(const std::string& motivo) {
    std::cout << "##POLI:FALLO:" << motivo << "##\n";
}
