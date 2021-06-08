# Mutantes para Magneto

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men, la idea es detectar si un humano es mutante o no basándose en su sencuencia de ADN.

Se recibe como parámetro un array de Strings que representan cada fila de una tabla de (N x N) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Un humano es mutante, si se encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

## Comenzando 🚀

Proyecto desplegado en HEROKU

### HTTP POST → api/v1/mutant
```
https://magneto-mercadolibre.herokuapp.com/api/v1/mutant
```
```
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
En caso de verificar un mutante, debería retorna un HTTP 200-OK, en caso contrario un 403-Forbidden

### HTTP GET → api/v1/stats
```
https://magneto-mercadolibre.herokuapp.com/api/v1/stats
```
```
{
  “count_mutant_dna”:40, 
  “count_human_dna”:100:
  “ratio”:0.4
  }
```
consulta las estadísticas de las verificaciones de ADN:
