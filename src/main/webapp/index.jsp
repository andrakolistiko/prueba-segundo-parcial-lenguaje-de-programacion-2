<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        body {
            background-color: #6f42c1; /* Color morado claro */
            color: lightpink; /* Texto blanco para contraste */
        }
        .list-group-item a {
            color: black; /* Color negro para los enlaces */
        }
        .list-group-item a:hover {
            color: #e0e0e0; /* Color gris claro al pasar el mouse */
        }
    </style>
    <title>Prueba Segundo Parcial</title>
</head>
<body>
<h1>NUMEROS PRIMOS</h1>
<form action="primo" method="get">
    <label for="start">inicio:</label>
    <input type="number" id="start" name="start" required>
    <br>
    <label for="end">fin:</label>
    <input type="number" id="end" name="end" required>
    <br>
    <input type="submit" value="Calcular">
</form>


<!--
<h1>Resultado</h1>
<p>rango: ${primeNumbers}</p>
<p>cantidad: ${count}</p>
-->
</body>
</html>
