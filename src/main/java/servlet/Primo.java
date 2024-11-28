package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/primo")
public class Primo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros de rango
        String startParam = request.getParameter("start");
        String endParam = request.getParameter("end");

        // Validar y parsear parámetros
        int start = 0;
        int end = 0;
        try {
            start = Integer.parseInt(startParam);
            end = Integer.parseInt(endParam);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor ingrese valores numéricos válidos.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        // Validar rango
        if (start > end) {
            request.setAttribute("error", "El inicio del rango debe ser menor o igual que el final del rango.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        // Calcular los números primos en el rango
        List<Integer> primeNumbers = getPrimeNumbers(start, end);

        // Establecer los atributos de la solicitud
        request.setAttribute("primeNumbers", primeNumbers);
        request.setAttribute("count", primeNumbers.size());

        // Redireccionar a result.jsp para mostrar los resultados
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private List<Integer> getPrimeNumbers(int start, int end) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
