//Suscripciones para un club deportivo

type Plan = "basico" | "intermedio" | "pro"

class Cliente {

    constructor(
        public nombre: string,
        public correo: string,
        public edad: number,
        public plan: Plan
    ) { }

    validarUsuario() {
        if (this.nombre.length< 2) {
            console.log("Nombre invalido");
            return false;
        }
        if (this.edad <16){
            console.log("Debes ser mayo de 15")
            return false;
        }
        if (!this.correo.includes('@')) {
            console.log('El correo ${ this.correo } no es un correo valido')
        }
        return true

    }
    guardarEnBD(){
        if (this.validarUsuario()){
            console.log(`Insertando {this.nombre}`)
            console.log(`INSERT INTO clientes(nombre, email, edad, plan) VALUES (${this.nombre}, ${this.correo},${this.edad}, ${this.plan})`)
        }
    }

    calcularPrecio() : number{
        const precios: Record<string,number > = {"basico" : 299, "intemedio" : 499, "pro" : 999}
        const precio = precios[this.plan]
        return precio
    }
    generarFactura(): string{
        const folio = `Britania - ${Date.now()}`
        const factura = `Cliente: ${this.nombre} | Plan: ${this.plan} | Total: ${total}`;
    }
    enviarCorreo(){
        console.log(`Bienvenido ${this.nombre} has sido registrado con el plan ${this.plan}`);
        console.log(this.generarFactura());
    }
    

    registrarSuscripcion(): boolean{
        if(this.validarUsuario()){
            this.guardarEnBD()
            this.enviarCorreo()
            return true;
        }
        return false;
    }

}


const angel = new Cliente('angel rojas', 'angelrojas@gmail.com', 35, 'intermedio')

angel.registrarSuscripcion();

