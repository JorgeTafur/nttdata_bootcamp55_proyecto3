/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nttdata.proyecto3.api;

import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.Amount;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T16:30:02.664409900-05:00[America/Lima]")
@Validated
@Api(value = "cuentas", description = "the cuentas API")
public interface CuentasApi {

    default CuentasApiDelegate getDelegate() {
        return new CuentasApiDelegate() {};
    }

    /**
     * DELETE /cuentas/{id} : Eliminar cuenta por su ID
     *
     * @param id  (required)
     * @return Cuenta eliminada (status code 204)
     *         or Error en eliminar la cuenta (status code 200)
     */
    @ApiOperation(value = "Eliminar cuenta por su ID", nickname = "deleteAccountById", notes = "", tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Cuenta eliminada"),
        @ApiResponse(code = 200, message = "Error en eliminar la cuenta") })
    @DeleteMapping(
        value = "/cuentas/{id}"
    )
    default ResponseEntity<Void> deleteAccountById(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        return getDelegate().deleteAccountById(id);
    }


    /**
     * PUT /cuentas/{numeroCuenta}/depositar : Realizar un depósito en una cuenta bancaria
     *
     * @param numeroCuenta  (required)
     * @param amount Monto a depositar (required)
     * @return Depósito realizado exitosamente (status code 200)
     *         or Error en el depósito en la cuenta (status code 200)
     */
    @ApiOperation(value = "Realizar un depósito en una cuenta bancaria", nickname = "depositAccount", notes = "", response = AccountResponse.class, tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Depósito realizado exitosamente", response = AccountResponse.class),
        @ApiResponse(code = 200, message = "Error en el depósito en la cuenta") })
    @PutMapping(
        value = "/cuentas/{numeroCuenta}/depositar",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AccountResponse> depositAccount(@ApiParam(value = "",required=true) @PathVariable("numeroCuenta") String numeroCuenta,@ApiParam(value = "Monto a depositar" ,required=true )  @Valid @RequestBody Amount amount) {
        return getDelegate().depositAccount(numeroCuenta, amount);
    }


    /**
     * GET /cuentas/{id} : Obtener datos de una cuenta
     *
     * @param id  (required)
     * @return Cuenta obtenida exitosamente (status code 200)
     *         or Error en obtener datos de la cuenta (status code 200)
     */
    @ApiOperation(value = "Obtener datos de una cuenta", nickname = "getAccountById", notes = "", response = AccountResponse.class, tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Cuenta obtenida exitosamente", response = AccountResponse.class),
        @ApiResponse(code = 200, message = "Error en obtener datos de la cuenta") })
    @GetMapping(
        value = "/cuentas/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<AccountResponse> getAccountById(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        return getDelegate().getAccountById(id);
    }


    /**
     * GET /cuentas : Listar cuentas
     *
     * @return Lista de cuentas (status code 200)
     *         or Error en la obtención de cuentas (status code 200)
     */
    @ApiOperation(value = "Listar cuentas", nickname = "listAccounts", notes = "", response = AccountResponse.class, responseContainer = "List", tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lista de cuentas", response = AccountResponse.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Error en la obtención de cuentas") })
    @GetMapping(
        value = "/cuentas",
        produces = { "application/json" }
    )
    default ResponseEntity<List<AccountResponse>> listAccounts() {
        return getDelegate().listAccounts();
    }


    /**
     * POST /cuentas : Crear una cuenta
     *
     * @param accountRequest Registrar una cuenta (required)
     * @return Cuenta registrada exitosamente (status code 200)
     *         or Error en la creacion de cuenta (status code 200)
     */
    @ApiOperation(value = "Crear una cuenta", nickname = "registerAccount", notes = "", response = AccountResponse.class, tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Cuenta registrada exitosamente", response = AccountResponse.class),
        @ApiResponse(code = 200, message = "Error en la creacion de cuenta") })
    @PostMapping(
        value = "/cuentas",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AccountResponse> registerAccount(@ApiParam(value = "Registrar una cuenta" ,required=true )  @Valid @RequestBody AccountRequest accountRequest) {
        return getDelegate().registerAccount(accountRequest);
    }


    /**
     * PUT /cuentas/{numeroCuenta}/retirar : Realizar un retiro de una cuenta bancaria
     *
     * @param numeroCuenta  (required)
     * @param amount Monto a depositar (required)
     * @return Retiro realizado exitosamente (status code 200)
     *         or Error en el retiro en la cuenta (status code 200)
     */
    @ApiOperation(value = "Realizar un retiro de una cuenta bancaria", nickname = "withdrawAccount", notes = "", response = AccountResponse.class, tags={ "cuenta", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Retiro realizado exitosamente", response = AccountResponse.class),
        @ApiResponse(code = 200, message = "Error en el retiro en la cuenta") })
    @PutMapping(
        value = "/cuentas/{numeroCuenta}/retirar",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AccountResponse> withdrawAccount(@ApiParam(value = "",required=true) @PathVariable("numeroCuenta") String numeroCuenta,@ApiParam(value = "Monto a depositar" ,required=true )  @Valid @RequestBody Amount amount) {
        return getDelegate().withdrawAccount(numeroCuenta, amount);
    }

}
