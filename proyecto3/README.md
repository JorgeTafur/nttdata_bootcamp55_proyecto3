# nttdata_bootcamp55_proyecto3

reemplazar accesos a base de datos mysql por credenciales propias

    application.properties
        spring.datasource.username=root
        spring.datasource.password=root

crear base de datos mysql. Se considera el puerto por defecto

    CREATE database banco_xyz;

crear base de datos mongodb. Se considera el puerto por defecto

    database: banco_xyz
    collection: transactions

al ejecutar el programa se crearan las tablas y colecciones automaticamente.

para generar el api y modelo, ejecutar comando

    mvn clean install

probar en postman en rutas de ejemplo:

# CLIENTE

GET: http://localhost:8080/api/clientes

GET: http://localhost:8080/api/clientes/1

POST: http://localhost:8080/api/clientes

    {
        "nombre": "Jorge",
        "apellido": "Tafur",
        "dni": "74582556",
        "email": "jorge@gmail.com"
    }

PUT:http://localhost:8080/api/clientes/1

    {
        "nombre": "Arturo",
        "apellido": "Pastor",
        "dni": "74582555",
        "email": "arturo@gmail.com"
    }

DELETE:http://localhost:8080/api/clientes/1



# CUENTAS

GET: http://localhost:8080/api/cuentas

GET: http://localhost:8080/api/cuentas/67089ef8e4a1f10ed759e102

POST: http://localhost:8080/api/cuentas

    {
        "saldo": 200.00,
        "tipoCuenta": "CORRIENTE",
        "clienteId": "1"
    }

PUT: http://localhost:8080/api/cuentas/9595676855/depositar

    {
        "monto": 100.00
    }

PUT: http://localhost:8080/api/cuentas/9595676855/retirar

    {
        "monto": 100.00
    }

DELETE: http://localhost:8080/api/cuentas/67089c268ad45e711555adc6

# TRANSACCIONES

GET: http://localhost:8080/api/transacciones/historial

POST: http://localhost:8080/api/transacciones/deposito

    {
        "cuentaDestino": "0280100958",
        "monto": 50.00
    }

POST: http://localhost:8080/api/transacciones/retiro

    {
        "cuentaOrigen": "0280100958",
        "monto": 50.00
    }

POST: http://localhost:8080/api/transacciones/transferencia

    {
        "cuentaOrigen": "2403395952",
        "cuentaDestino": "9595676855",
        "monto": 50.00
    }

Se decidió omitir el tipo de transaccion en el post ya que se considera redundante al estar definido en el endpoint.
La fecha es automática de igual modo.


# Reportes

    mvn clean test
    mvn jacoco:report

# Checkstyle

Pendiente levantar las observaciones

    mvn checkstyle:check