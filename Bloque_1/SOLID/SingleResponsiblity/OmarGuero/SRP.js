"use strict";
//Suscripciones para un club deportivo
Object.defineProperty(exports, "__esModule", { value: true });
class Cliente {
    nombre;
    correo;
    edad;
    plan;
    constructor(nombre, correo, edad, plan) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.plan = plan;
    }
    validarUsuario() {
        if (this.nombre.length < 2) {
            console.log("Nombre invalido");
            return false;
        }
        if (this.edad < 16) {
            console.log("Debes ser mayo de 15");
            return false;
        }
        if (!this.correo.includes('@')) {
            console.log('El correo ${ this.correo } no es un correo valido');
        }
        return true;
    }
    guardarEnBD() {
        if (this.validarUsuario()) {
            console.log(`Insertando {this.nombre}`);
            console.log(`INSERT INTO clientes(nombre, email, edad, plan) VALUES (${this.nombre}, ${this.correo},${this.edad}, ${this.plan})`);
        }
    }
    calcularPrecio() {
        const precios = { "basico": 299, "intermedio": 499, "pro": 999 };
        const precio = precios[this.plan];
        return precio;
    }
    generarFactura() {
        const folio = `Britania - ${Date.now()}`;
        const total = this.calcularPrecio();
        const factura = `Cliente: ${this.nombre} | Plan: ${this.plan} | Total: ${total}`;
        return factura;
    }
    enviarCorreo() {
        console.log(`Bienvenido ${this.nombre} has sido registrado con el plan ${this.plan}`);
        console.log(this.generarFactura());
    }
    registrarSuscripcion() {
        if (this.validarUsuario()) {
            this.guardarEnBD();
            this.enviarCorreo();
            return true;
        }
        return false;
    }
}
const angel = new Cliente('angel rojas', 'angelrojas@gmail.com', 35, 'intermedio');
angel.registrarSuscripcion();
//# sourceMappingURL=SRP.js.map