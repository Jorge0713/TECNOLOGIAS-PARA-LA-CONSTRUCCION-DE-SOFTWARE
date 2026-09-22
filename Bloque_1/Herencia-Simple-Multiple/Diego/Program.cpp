#include <iostream>
using namespace std;

class Animal
{
public:
    string nombre;

    Animal(string nombre) : nombre(nombre) {}

    void virtual andar()
    {
        cout << nombre << " esta andando\n";
    }

private:
};

class Perro : public Animal
{
public:
    Perro(string nombre) : Animal(nombre) {}
    void ladrar()
    {
        cout << nombre << " esta ladrando \n";
    }
    void andar()
    {
        cout << nombre << " esta corriendo\n";
    }
};

class Volador : virtual public Animal
{
public:
    Volador(string nombre) : Animal(nombre) {}
    void virtual andar()
    {
        cout << nombre << " esta volando " << endl;
    }
};

class Nadador : virtual public Animal
{
public:
    Nadador(string nombre) : Animal(nombre) {}
    void virtual andar()
    {
        cout << nombre << " esta nadando " << endl;
    }
};

class Pato : public Volador, public Nadador
{
public:
    Pato(string nombre):Animal(nombre), Nadador(nombre), Volador(nombre){}
    void andar(){
        cout << nombre << "esta nadando \n";
    }
    void graznar()
    {
        cout << nombre << "esta graznando\n";
    }
};

int main()
{
    Perro perro1("Pako");
    perro1.ladrar();
    perro1.andar();

    Pato pato1("Justin");
    pato1.andar();
    
    Volador volador("vane");
    Nadador nadador("Alexa");

    volador.andar();
    nadador.andar();
    return 0;
}