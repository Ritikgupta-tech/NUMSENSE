package nums;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckNumberServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {  
        String numberStr = req.getParameter("number");
        String[] checks = req.getParameterValues("checkType");   
        int number = Integer.parseInt(numberStr);              
        Map<String, String> results = new HashMap<>();
        if (checks != null) {
            for (String check : checks) {
                switch (check) {
                    case "prime":
                        results.put("Prime", isPrime(number) ? "Yes" : "No");
                        break;
                    case "perfect":
                        results.put("Perfect", isPerfect(number) ? "Yes" : "No");
                        break;
                    case "armstrong":
                        results.put("Armstrong", isArmstrong(number) ? "Yes" : "No");
                        break;
                    case "strong":
                        results.put("Strong", isStrong(number) ? "Yes" : "No");
                        break;
                    case "spy":
                        results.put("Spy", isSpy(number) ? "Yes" : "No");
                        break;
                    case "pallindrome":
                        results.put("Pallindrome", isPalindrome(number) ? "Yes" : "No");
                        break;
                }
            }
        }
        req.setAttribute("number", number);
        req.setAttribute("results", results);
        RequestDispatcher dispatcher = req.getRequestDispatcher("output.jsp");
        if (results.isEmpty()) {
            results.put("No Results", "No checks were selected.");
        }
        dispatcher.forward(req, res); 
    }
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    private boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }
    private boolean isArmstrong(int num) {
        int sum = 0, temp = num, remainder, n = 0;
        while (temp != 0) {
            temp /= 10;
            n++;
        }
        temp = num;
        while (temp != 0) {
            remainder = temp % 10;
            sum += Math.pow(remainder, n);
            temp /= 10;
        }
        return sum == num;
    }
    private boolean isStrong(int num) {
        int sum = 0, temp = num, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }
    private int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
    private boolean isSpy(int num) {
        int sum = 0, product = 1, temp = num, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }
    private boolean isPalindrome(int num) {
        int reversed = 0, original = num, remainder;
        while (num != 0) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }
        return original == reversed;
    }
}
