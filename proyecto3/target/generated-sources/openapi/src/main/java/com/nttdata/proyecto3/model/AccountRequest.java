package com.nttdata.proyecto3.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public class AccountRequest   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("numeroCuenta")
  private String numeroCuenta;

  @JsonProperty("saldo")
  private Double saldo;

  @JsonProperty("tipoCuenta")
  private String tipoCuenta;

  @JsonProperty("clienteId")
  private String clienteId;

  public AccountRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID único de la cuenta
   * @return id
  */
  @ApiModelProperty(value = "ID único de la cuenta")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AccountRequest numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }

  /**
   * Numero de la cuenta
   * @return numeroCuenta
  */
  @ApiModelProperty(value = "Numero de la cuenta")


  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public AccountRequest saldo(Double saldo) {
    this.saldo = saldo;
    return this;
  }

  /**
   * Saldo de la cuenta
   * @return saldo
  */
  @ApiModelProperty(value = "Saldo de la cuenta")


  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public AccountRequest tipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

  /**
   * Tipo de la cuenta (AHORROS, CORRIENTE)
   * @return tipoCuenta
  */
  @ApiModelProperty(value = "Tipo de la cuenta (AHORROS, CORRIENTE)")


  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public AccountRequest clienteId(String clienteId) {
    this.clienteId = clienteId;
    return this;
  }

  /**
   * ID del cliente de la cuenta
   * @return clienteId
  */
  @ApiModelProperty(value = "ID del cliente de la cuenta")


  public String getClienteId() {
    return clienteId;
  }

  public void setClienteId(String clienteId) {
    this.clienteId = clienteId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRequest accountRequest = (AccountRequest) o;
    return Objects.equals(this.id, accountRequest.id) &&
        Objects.equals(this.numeroCuenta, accountRequest.numeroCuenta) &&
        Objects.equals(this.saldo, accountRequest.saldo) &&
        Objects.equals(this.tipoCuenta, accountRequest.tipoCuenta) &&
        Objects.equals(this.clienteId, accountRequest.clienteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numeroCuenta, saldo, tipoCuenta, clienteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    clienteId: ").append(toIndentedString(clienteId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

